package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import game.Board;
import game.Mark;

public class MainActivity extends AppCompatActivity {
    Board board = new Board();
    private Boolean bMove = false;
    int[][] button_map = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_map[0][0] = R.id.button00;
        button_map[0][1] = R.id.button01;
        button_map[0][2] = R.id.button02;
        button_map[1][0] = R.id.button10;
        button_map[1][1] = R.id.button11;
        button_map[1][2] = R.id.button12;
        button_map[2][0] = R.id.button20;
        button_map[2][1] = R.id.button21;
        button_map[2][2] = R.id.button22;
    }

    public void clickedSqr( View v)
    {
        Button btn = (Button)v;

        if(btn.getText().equals(".") && !board.isGameOver() && board.anyMovesAvailable())
        {
            btn.setText("X");
            btn.setTextColor(Color.RED);

            for(int i=0; i<button_map.length; i++) {
                for(int j=0; j<button_map[i].length; j++) {

                    if(button_map[i][j] == btn.getId()){
                        board.placeMark(i, j);
                    }
                }
            }

            if(!board.isGameOver() && board.anyMovesAvailable()){
                int[] move = MiniMaxCombined.getBestMove(board);
                int row = move[0];
                int col = move[1];
                board.placeMark(row, col);

                Button btn2 = (Button)findViewById(button_map[row][col]);
                btn2.setText("O");
                btn2.setTextColor(Color.BLUE);
            }

            if(board.isGameOver()){
                Mark winner = board.getWinningMark();
                TextView tv = (TextView)findViewById(R.id.resultTextView);

                if(winner.getMark() == 'X'){
                    tv.setText("YOU WIN!");
                }
                else if(winner.getMark() == 'O'){
                    tv.setText("YOU LOOSE!");
                }
                else{
                    tv.setText("TIE!");
                }
            }




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
        board = new Board();
        TextView tv = (TextView)findViewById(R.id.resultTextView);
        tv.setText("");
        for(int i=0; i<button_map.length; i++) {
            for(int j=0; j<button_map[i].length; j++) {
                setBtn(button_map[i][j]);
            }
        }

    }

}