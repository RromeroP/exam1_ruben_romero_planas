package com.example.exam_ruben_romero_planas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment first = new FirstFragment();
        SecondFragment second = new SecondFragment();
        ThirdFragment third = new ThirdFragment();

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.first_fragment, first, "First Fragment");
        transaction.add(R.id.second_fragment, second, "Second Fragment");
        transaction.add(R.id.third_fragment, third, "Third Fragment");


        transaction.commit();

    }

    public void changeText(View view) {
        EditText input = (EditText) findViewById(R.id.text_input);
        TextView text = (TextView) findViewById(R.id.textView);

        text.setText(input.getText());

        SeekBar size = (SeekBar) findViewById(R.id.size_seekbar);
        text.setTextSize(size.getProgress());
    }

    public void changeColor(View view) {
        SeekBar r = (SeekBar) findViewById(R.id.seekbar_r);
        int r_color = r.getProgress();

        SeekBar g = (SeekBar) findViewById(R.id.seekbar_g);
        int g_color = g.getProgress();

        SeekBar b = (SeekBar) findViewById(R.id.seekbar_b);
        int b_color = b.getProgress();


        TextView text = (TextView) findViewById(R.id.textView);

        text.setTextColor(Color.rgb(r_color, g_color, b_color));
    }
}