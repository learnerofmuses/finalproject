package com.example.android.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class fpMainActivity extends AppCompatActivity {


    private Button button1, button2, button3, button4, start_over, rules;

    Random rand;

    int score = 0;
    //set String type for the color of each button
    String bColor1, bColor2, bColor3, bColor4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fp_main);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        start_over = findViewById(R.id.start_over);
        rules = findViewById(R.id.rules);


        rand = new Random();
        int temp;

        temp = rand.nextInt(3) + 1;

        if (temp == 1) {
            bColor1 = "yellow";
        } else if (temp == 2) {
            bColor1 = "green";
        } else if (temp == 3) {
            bColor1 = "magenta";
        }

        temp = rand.nextInt(3) + 1;

        if (temp == 1) {
            bColor2 = "yellow";
        } else if (temp == 2) {
            bColor2 = "green";
        } else if (temp == 3) {
            bColor2 = "magenta";
        }

        temp = rand.nextInt(3) + 1;

        if (temp == 1) {
            bColor3 = "yellow";
        } else if (temp == 2) {
            bColor3 = "green";
        } else if (temp == 3) {
            bColor3 = "magenta";
        }

        temp = rand.nextInt(3) + 1;

        if (temp == 1) {
            bColor4 = "yellow";
        } else if (temp == 2) {
            bColor4 = "green";
        } else if (temp == 3) {
            bColor4 = "magenta";
        }

        //here we call the colors method and apply each color to each button
        colors(button1, bColor1);
        colors(button2, bColor2);
        colors(button3, bColor3);
        colors(button4, bColor4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bColor1 = transitColors(bColor1);
                colors(button1, bColor1);

                bColor2 = transitColors(bColor2);
                colors(button2, bColor2);

                winner();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bColor1 = transitColors(bColor1);
                colors(button1, bColor1);

                bColor2 = transitColors(bColor2);
                colors(button2, bColor2);

                bColor3 = transitColors(bColor3);
                colors(button3, bColor3);

                winner();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bColor2 = transitColors(bColor2);
                colors(button2, bColor2);

                bColor4 = transitColors(bColor4);
                colors(button4, bColor4);


                bColor3 = transitColors(bColor3);
                colors(button3, bColor3);

                winner();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bColor4 = transitColors(bColor4);
                colors(button4, bColor4);

                bColor3 = transitColors(bColor3);
                colors(button3, bColor3);

                winner();
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rulesActivity();
            }
        });
    }
    public void rulesActivity(){
        Intent intent = new Intent(this, rulesMain2Activity.class);
        startActivity(intent);

        start_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), fpMainActivity.class);
                startActivity(intent);
                finish();
               /* startActivity(intent);
                   finish();*/
            }
        });
    }

    public void startOverActivity() {
        Intent intent = new Intent(this, fpMainActivity.class);
        finish();
        startActivity(intent);
    }

    public void winner(){

        score++;
        if(bColor1.equals("green") && bColor2.equals("green") && bColor3.equals("green") && bColor4.equals("green")){
            Toast.makeText(fpMainActivity.this, "It took you " + score + " turns to win", Toast.LENGTH_LONG).show();

            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
        }
    }


    //background color of button set
    public void colors(Button button, String color){
        if(color.equals("yellow")){
            button.setBackgroundColor(Color.YELLOW);
        }else if(color.equals("green")){
            button.setBackgroundColor(Color.GREEN);
        }else if(color.equals("magenta")){
            button.setBackgroundColor(Color.MAGENTA);
        }
    }

    public String transitColors(String color){
        if(color.equals("yellow")){
            color = "green";
        }else if(color.equals("green")){
            color = "magenta";
        }else if(color.equals("magenta")){
            color = "yellow";
        }
        return color;
    }
}
