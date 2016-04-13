package app.com.smileyfever;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import android.content.SharedPreferences;
/**
 * Created by Cosmin on 3/15/2016.
 */
public class Congratulations extends AppCompatActivity {

    private SharedPreferences gamePrefs;
    public static final String GAME_PREFS = "SmileyHunter";
    Button back;
    TextView scoreField;
    int level;
    ImageView statbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.congratulations);
        statbar = (ImageView) findViewById(R.id.imageView4);
        gamePrefs = getSharedPreferences(GAME_PREFS, 0);

        scoreField = (TextView) findViewById(R.id.textView4);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                scoreField.setText(String.valueOf(MainGame.finalScore));
            }
        });

        back = (Button) findViewById(R.id.button5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setHighScore();
                        startActivity(new Intent(Congratulations.this, Menu.class));
                    }
                });
            }
        });

        if(savedInstanceState!=null){
            int exScore = savedInstanceState.getInt("score");
            scoreField.setText("Score: "+exScore);
        }
        else{
            Bundle extras = getIntent().getExtras();
            if(extras !=null)
            {
                int passedLevel = extras.getInt("level", -1);
                if(passedLevel>=0) level = passedLevel;
            }
        }

        if(MainGame.finalScore > 0 && MainGame.finalScore < 500) {
            statbar.setImageResource(R.drawable.bar1);
        }
        else if(MainGame.finalScore >= 500 && MainGame.finalScore < 1000){
            statbar.setImageResource(R.drawable.bar2);
        }
        else if(MainGame.finalScore >= 1000 && MainGame.finalScore < 1500){
            statbar.setImageResource(R.drawable.bar3);
        }
        else if(MainGame.finalScore >= 1500 && MainGame.finalScore <= 2000){
            statbar.setImageResource(R.drawable.bar4);
        }
        else statbar.setImageResource(R.drawable.nobar);
    }

    public int getScore(){
        return MainGame.finalScore;
    }

    private void setHighScore(){
        int exScore = getScore();
        if(exScore>0){
            SharedPreferences.Editor scoreEdit = gamePrefs.edit();
            DateFormat dateForm = new SimpleDateFormat("dd MMMM yyyy");
            String dateOutput = dateForm.format(new Date());
            String scores = gamePrefs.getString("highScores", "");


            if(scores.length()>0){
                List<Score> scoreStrings = new ArrayList<Score>();
                String[] exScores = scores.split("\\|");
                for(String eSc : exScores){
                    String[] parts = eSc.split(" - ");
                    scoreStrings.add(new Score(parts[0], Integer.parseInt(parts[1])));
                }
                Score newScore = new Score(dateOutput, exScore);
                scoreStrings.add(newScore);
                Collections.sort(scoreStrings);
                StringBuilder scoreBuild = new StringBuilder("");
                for(int s=0; s<scoreStrings.size(); s++){
                    if(s>=10) break;//get only 10 scores
                    if(s>0) scoreBuild.append("|");//pipe separate the score strings
                    scoreBuild.append(scoreStrings.get(s).getScoreText());
                }//write to prefs
                scoreEdit.putString("highScores", scoreBuild.toString());
                scoreEdit.commit();
            }
            else{
                scoreEdit.putString("highScores", ""+dateOutput+" - "+exScore);
                scoreEdit.commit();
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        int exScore = getScore();
        savedInstanceState.putInt("score", exScore);
        super.onSaveInstanceState(savedInstanceState);
    }

}
