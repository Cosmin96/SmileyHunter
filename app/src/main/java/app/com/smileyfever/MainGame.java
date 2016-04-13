package app.com.smileyfever;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * Created by Cosmin on 3/1/2016.
 */


public class MainGame extends AppCompatActivity {


    public int time = 100;
    public int score = 0;
    public TextView scoreText,timeText;
    Thread t;
    public Button press;
    Button back;
    Button start;
    Random r = new Random();
    private List<Integer> levels = new ArrayList<>();
    int currentIndex = 0;
    static int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeLayout(R.layout.level1);
        back = (Button) findViewById(R.id.button5);
        start = (Button) findViewById(R.id.button6);

        for(int i = 1; i<=20; i++){
            levels.add(i);
        }
        Collections.shuffle(levels);

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
                        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
                            t.interrupt();
                            this.finish();
                        }
                        return super.onKeyDown(keyCode, event);
    }

    //Function that changes the levels and assures mechanics of the game
    private void changeLayout(int layoutID) {
        setContentView(layoutID);
        timeText = (TextView) findViewById(R.id.textView5);
        scoreText = (TextView) findViewById(R.id.textView4);
        press = (Button) findViewById(R.id.button4);

        t=new Thread() {
            @Override
            public void run () {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                timeText.setText(String.valueOf(time));
                                scoreText.setText(String.valueOf(score));
                            }
                        });
                        if (time != 0) {
                            time--;
                        }
                    }
                }
                catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        };

        t.start();

        press.bringToFront();
        press.setVisibility(View.VISIBLE);
        press.setBackgroundColor(Color.TRANSPARENT);
        press.setTextColor(Color.TRANSPARENT);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t.interrupt();

                        score += time;
                        time = 100;

                        switch (levels.get(currentIndex)) {
                            case 1:
                                changeLayout(R.layout.level1);
                                break;
                            case 2:
                                changeLayout(R.layout.level2);
                                break;
                            case 3:
                                changeLayout(R.layout.level3);
                                break;
                            case 4:
                                changeLayout(R.layout.level4);
                                break;
                            case 5:
                                changeLayout(R.layout.level5);
                                break;
                            case 6:
                                changeLayout(R.layout.level6);
                                break;
                            case 7:
                                changeLayout(R.layout.level7);
                                break;
                            case 8:
                                changeLayout(R.layout.level8);
                                break;
                            case 9:
                                changeLayout(R.layout.level9);
                                break;
                            case 10:
                                changeLayout(R.layout.level10);
                                break;
                            case 11:
                                changeLayout(R.layout.level11);
                                break;
                            case 12:
                                changeLayout(R.layout.level12);
                                break;
                            case 13:
                                changeLayout(R.layout.level13);
                                break;
                            case 14:
                                changeLayout(R.layout.level14);
                                break;
                            case 15:
                                changeLayout(R.layout.level15);
                                break;
                            case 16:
                                changeLayout(R.layout.level16);
                                break;
                            case 17:
                                changeLayout(R.layout.level17);
                                break;
                            case 18:
                                changeLayout(R.layout.level18);
                                break;
                            case 19:
                                changeLayout(R.layout.level19);
                                break;
                            case 20:
                                changeLayout(R.layout.level20);
                                break;
                        }

                        if(currentIndex < 19){
                            currentIndex++;
                        }
                        else {
                            calculateScore();
                            System.out.println("Final Score is:" + finalScore);
                            startActivity(new Intent(MainGame.this, Congratulations.class));
                        }
                    }
                });
            }
        });
    }

    public int calculateScore(){
        finalScore = score;
        return finalScore;
    }
}








