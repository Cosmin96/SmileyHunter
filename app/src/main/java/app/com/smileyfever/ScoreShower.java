package app.com.smileyfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;


/**
 * Created by Cosmin on 3/18/2016.
 */
public class ScoreShower extends AppCompatActivity {

    TextView scoreboard;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        clear = (Button) findViewById(R.id.button7);
        scoreboard = (TextView) findViewById(R.id.textView9);

        final SharedPreferences scorePrefs = getSharedPreferences(Congratulations.GAME_PREFS, 0);
        String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");
        StringBuilder scoreBuild = new StringBuilder("");
        for(String score : savedScores){
            scoreBuild.append(score+"\n");
        }
        scoreboard.setText(scoreBuild.toString());

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePrefs.edit().clear().commit();
                MainGame.finalScore = 0;
                startActivity(new Intent(ScoreShower.this,Menu.class));
            }
        });


    }
}


