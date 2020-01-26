package com.example.numbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView ftv;
    LinearLayout laoutback;
   static boolean startflag=true;
    static int mainpitchcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        laoutback=findViewById(R.id.layoutback);
        ftv=findViewById(R.id.ftv);



    }//onCreate() ...

    public void startimg(View view){    //처음 화면 터치시 배경 바꾸기
        if(startflag){
            startflag=false;
            Intent intent= new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
            ftv.setVisibility(ImageView.INVISIBLE);
        }
    }
//    public void textnum(View v){
//        ImageView view=(ImageView) v;
//        firstball.setText(view.getTag().toString());
//        System.out.println("-----------------------------------------------");
//    }

}
