package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity<emiCalBtn> extends AppCompatActivity {
    Button emiCalcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principle = findViewById(R.id.enter_principle);
        final EditText interest =  findViewById(R.id.enter_rate);
        final EditText year = findViewById(R.id.enter_year);
        final TextView result =  findViewById(R.id.result);

        emiCalcBtn = (Button) findViewById(R.id.button_calculate);
        emiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_p = principle.getText().toString();
                String str_i = interest.getText().toString();
                String str_y = year.getText().toString();

                float p = Float.parseFloat(str_p);
                float i = Float.parseFloat(str_i);
                float y = Float.parseFloat(str_y);
                float Principle = calPrinciple(p);
                float Rate = calInterest(i);
                float Month = calMonth(y);
                float emi = calEmi(Principle, Rate, Month);

                result.setText(new DecimalFormat("$##.##").format(emi));
            }
        });

    }


    public float calPrinciple(float p){
        return (p);
    }
    public float calInterest(float i){
        return (i /12 /100);
    }
    public float calMonth(float n){
        return (n *12);
    }

    public float calEmi(float p, float i, float n){
        return (float) (( p * i * Math.pow((1+i), n)) / (Math.pow((1+i), n)-1));
    }


}