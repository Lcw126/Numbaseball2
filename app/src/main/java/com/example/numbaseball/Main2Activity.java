package com.example.numbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import static com.example.numbaseball.MainActivity.ftv;
import static com.example.numbaseball.MainActivity.mainpitchcount;
import static com.example.numbaseball.MainActivity.startflag;

public class Main2Activity extends AppCompatActivity {


    TextView firstball,secondball, thridball;
    int com100, com10, com1;
    int user100, user10, user1;
    ImageView bs[]=new ImageView[3];
    ImageView ss[]=new ImageView[3];
    LinearLayout lays[]=new LinearLayout[3];
    TextView throwcount, tvfinish;
    int pitchcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //두번째 페이지 멤버 변수들
        firstball=findViewById(R.id.firstball);
        secondball=findViewById(R.id.secondball);
        thridball=findViewById(R.id.thridball);
        throwcount=findViewById(R.id.throwcount);
        tvfinish=findViewById(R.id.tvfinish);
        Random rnd= new Random();

        while(true) {
            com100=rnd.nextInt(10); //0~9
            com10=rnd.nextInt(10); //0~9
            com1=rnd.nextInt(10); //0~9

            if(com100 != com10 && com100 !=com1 && com10 != com1) break;
        }//while


    }

   public void textnum(View v){
       ImageView view=(ImageView) v;
       if(firstball.getText().equals("")) firstball.setText(view.getTag().toString());
       else if(secondball.getText().equals("")) secondball.setText(view.getTag().toString());
       else if(thridball.getText().equals("")) thridball.setText(view.getTag().toString());

    }

    public void pitch(View v){
        pitchcount++;
        for(int i=0;i<3;i++){
            ss[i]=findViewById(R.id.s1+i);
            bs[i]=findViewById(R.id.b1+i);
            ss[i].setImageResource(R.drawable.ballstrikebase);
            bs[i].setImageResource(R.drawable.ballstrikebase);
        }


        throwcount.setText(pitchcount+"구");
        try{

            String s=firstball.getText().toString();
            user100=Integer.parseInt(s);


            s=secondball.getText().toString();
            user10=Integer.parseInt(s);


            s=thridball.getText().toString();
            user1=Integer.parseInt(s);
        }catch(Exception e){ }



        int strike=0, ball=0;

        if(user100==com100) strike++;
        else if(user100 == com10 || user100 == com1)ball++;
        if(user10==com10) strike++;
        else if(user10 == com100 || user10 == com1)ball++;
        if(user1==com1) strike++;
        else if(user1 == com100 || user1 == com10)ball++;

        for(int i=0;i<strike;i++){
            ss[i]=findViewById(R.id.s1+i);
            ss[i].setImageResource(R.drawable.strike);
        }
        for(int i=0;i<ball;i++){
            bs[i]=findViewById(R.id.b1+i);
            bs[i].setImageResource(R.drawable.ball);
        }


        if(strike == 3) {
//            startflag=true;
//            ftv.setVisibility(ImageView.VISIBLE);

            tvfinish.setVisibility(View.VISIBLE);
            tvfinish.setText("기록 : "+pitchcount+"구");
            //finish();

        }

        System.out.println("정답은"+com100+" "+com10+" "+com1+" ");
    }

    public void erase(View v){
        firstball.setText("");
        secondball.setText("");
        thridball.setText("");
    }
}
