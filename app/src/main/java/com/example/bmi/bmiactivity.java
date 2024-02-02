package com.example.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageView;
    String mbmi;
    float intbmai;

    String heigh;
    String weigh;
    float intheight,intweight;
    RelativeLayout mbackground;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

        ActionBar actionBar1 = getSupportActionBar();
        if (actionBar1 != null) {
            actionBar1.setTitle("Result");
        }
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));

        ActionBar actionBar2 = getSupportActionBar();
        if (actionBar2 != null) {
            actionBar2.setBackgroundDrawable(colorDrawable);
        }



        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageView=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        heigh=intent.getStringExtra("height");
        weigh=intent.getStringExtra("weight");

        intheight=Float.parseFloat(heigh);
        intweight=Float.parseFloat((weigh));

        intheight=intheight/100;
        intbmai=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmai);

        if(intbmai<16)
        {
            mbmicategory.setText("servere Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.crosss);
        } else if (intbmai<16.9 && intbmai>16) {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if (intbmai<18.4 && intbmai>17) {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }
        else if (intbmai<25 && intbmai>18.4) {
            mbmicategory.setText("normal");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageView.setImageResource(R.drawable.ok);
        }
        else if (intbmai<29.4 && intbmai>25) {
            mbmicategory.setText("overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
       }
        else
        {
            mbmicategory.setText("obese class 1");
            mbackground.setBackgroundColor(Color.RED);
            mimageView.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mrecalculatebmi=findViewById(R.id.recalculatebmi);

        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}