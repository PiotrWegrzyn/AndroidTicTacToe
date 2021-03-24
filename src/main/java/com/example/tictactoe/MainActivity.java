package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Boolean bMove = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickedSqr( View v)
    {
        Button btn = (Button)v;
        if(btn.getText().equals("."))
        {
            if(bMove)
            {
                btn.setText("X");
                btn.setTextColor(Color.RED);

            }
            else
            {
                btn.setText("O");
                btn.setTextColor(Color.BLUE);

            }
            bMove = !bMove;
        }

    }

    public void end(View v)
    {
        finish();
    }

    private void setBtn(int id)
    {
        Button btn = (Button)findViewById(id);
        btn.setTextColor(Color.BLACK);
        btn.setText(".");

    }

    public void onReset(View v)
    {
        setBtn(R.id.button3);
        setBtn(R.id.button4);
        setBtn(R.id.button6);
        setBtn(R.id.button7);
        setBtn(R.id.button8);
        setBtn(R.id.button9);
        setBtn(R.id.button10);
        setBtn(R.id.button11);
        setBtn(R.id.button12);

    }



}