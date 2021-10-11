package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity<emiCalBtn> extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    Button emiCalcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principle = findViewById(R.id.enter_principle);
        final EditText interest =  findViewById(R.id.enter_rate);
        final EditText year = findViewById(R.id.enter_year);

        emiCalcBtn = (Button) findViewById(R.id.button_calculate);
        emiCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_p = principle.getText().toString();
                String str_i = interest.getText().toString();
                String str_y = year.getText().toString();

                if(TextUtils.isEmpty(str_p)){
                    Toast.makeText(MainActivity.this, "Please input Principle Amount...", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(str_i)){
                    Toast.makeText(MainActivity.this, "Please input Interest Rate...", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(str_y)){
                    Toast.makeText(MainActivity.this, "Please input Time Period...", Toast.LENGTH_SHORT).show();
                }else{
                    float p = Float.parseFloat(str_p);
                    float i = Float.parseFloat(str_i);
                    float y = Float.parseFloat(str_y);
                    float Principle = calPrinciple(p);
                    float Rate = calInterest(i);
                    float Month = calMonth(y);
                    float emi = calEmi(Principle, Rate, Month);
                    DecimalFormat decimalFormat = new DecimalFormat("$.00");


                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    String message = decimalFormat.format(emi);
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                }



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