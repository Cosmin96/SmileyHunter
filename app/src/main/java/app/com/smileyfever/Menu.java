package app.com.smileyfever;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    ImageView smiley;
    Button playbtn;
    Button scorebtn;
    Button statbtn;
    Button secret;
    Button helpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        smiley = (ImageView) findViewById(R.id.imageView);
        smiley.setImageResource(R.drawable.menu);

        playbtn = (Button) findViewById(R.id.button);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, MainGame.class));
            }
        });

        scorebtn = (Button) findViewById(R.id.button2);
        scorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ScoreShower.class));
            }
        });

        statbtn = (Button) findViewById(R.id.button3);
        statbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Gallery.class));
            }
        });

        helpbtn = (Button) findViewById(R.id.help);
        helpbtn.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        Menu.this);

                // Set Alert Dialog Title
                builder.setTitle("How to Play");

                // Set an Icon for this Alert Dialog
                builder.setIcon(R.drawable.smiley);

                // Set Alert Dialog Message
                builder.setMessage(
                        "In SmileyHunter, the goal is to find the happy face in each level. You play for 20 levels and then your score is calculated at the end and saved in the highscore board. Be aware that you have limited time for each level. Remember, finding the correct face will make you proceed to the next level. We hope you have fun!")

                        // Neautral button functionality
                        .setNeutralButton("GOT IT!",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int arg0) {
                                        Toast.makeText(
                                                Menu.this,
                                                "Press PLAY to begin",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });

                // Create the Alert Dialog
                AlertDialog alertdialog = builder.create();

                // Show Alert Dialog
                alertdialog.show();
            }
        });
    }
}
