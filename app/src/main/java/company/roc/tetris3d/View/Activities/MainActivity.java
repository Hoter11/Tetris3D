package company.roc.tetris3d.View.Activities;

/*
    NOTES A COMENTAR AL ACABAR JOC:

        - SEGUIT EL TUTORIAL PER A EL FRAMEWORK DEL JOC: http://www.kilobolt.com/unit-4-android-game-development.html


 */


import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import company.roc.tetris3d.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        Button btnRank = (Button) findViewById(R.id.btnRank);
        Button btnConf = (Button) findViewById(R.id.btnConf);
        Button btnShop = (Button) findViewById(R.id.btnShop);

        buttonEffect(btnPlay);
        buttonEffect(btnRank);
        buttonEffect(btnConf);
        buttonEffect(btnShop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(i);
            }
        });
        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RankActivity.class);
                startActivity(i);
            }
        });
        btnConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ConfigActivity.class);
                startActivity(i);
            }
        });
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ShopActivity.class);
                startActivity(i);
            }
        });

    }



    //BUTTON EFFECT
    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0x80ffffff, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
}
