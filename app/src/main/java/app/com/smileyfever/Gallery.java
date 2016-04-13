package app.com.smileyfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Cosmin on 4/11/2016.
 */

public class Gallery extends AppCompatActivity {

    ImageView happy;
    ImageButton left,right;
    TextView current;
    int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        happy = (ImageView)findViewById(R.id.imageView5);
        left = (ImageButton)findViewById(R.id.imageButton2);
        right = (ImageButton)findViewById(R.id.imageButton);
        current = (TextView)findViewById(R.id.textView13);
        imageChange();


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x--;
                if(x == 0){
                    x = 20;
                }
                imageChange();
                System.out.println(x);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if(x == 21){
                    x = 1;
                }
                imageChange();
                System.out.println(x);
            }
        });
    }

    public void imageChange(){
        current.setText("Current happy face: " + x);
        switch(x) {
            case 1:
                happy.setImageResource(R.drawable.happy1);
                break;
            case 2:
                happy.setImageResource(R.drawable.happy2);
                break;
            case 3:
                happy.setImageResource(R.drawable.happy3);
                break;
            case 4:
                happy.setImageResource(R.drawable.happy4);
                break;
            case 5:
                happy.setImageResource(R.drawable.happy5);
                break;
            case 6:
                happy.setImageResource(R.drawable.happy6);
                break;
            case 7:
                happy.setImageResource(R.drawable.happy7);
                break;
            case 8:
                happy.setImageResource(R.drawable.happy8);
                break;
            case 9:
                happy.setImageResource(R.drawable.happy9);
                break;
            case 10:
                happy.setImageResource(R.drawable.happy10);
                break;
            case 11:
                happy.setImageResource(R.drawable.happy11);
                break;
            case 12:
                happy.setImageResource(R.drawable.happy12);
                break;
            case 13:
                happy.setImageResource(R.drawable.happy13);
                break;
            case 14:
                happy.setImageResource(R.drawable.happy14);
                break;
            case 15:
                happy.setImageResource(R.drawable.happy15);
                break;
            case 16:
                happy.setImageResource(R.drawable.happy16);
                break;
            case 17:
                happy.setImageResource(R.drawable.happy17);
                break;
            case 18:
                happy.setImageResource(R.drawable.happy18);
                break;
            case 19:
                happy.setImageResource(R.drawable.happy19);
                break;
            case 20:
                happy.setImageResource(R.drawable.happy20);
                break;
        }
    }

}

