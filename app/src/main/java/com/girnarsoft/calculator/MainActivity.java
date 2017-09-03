package com.girnarsoft.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
* @Author
* Sawan Mehta
* sawan.mehta94@gmail.com
* +91-7027077488
* */


public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdot, badd, bsub, bmul, bdiv, beq, bclear;
    TextView output;
    View.OnClickListener onClickListener;
    float f1, f2;
    int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVars();
        initCLickListeners();
    }

    //initialise variables with elemnets of the view
    private void initVars() {
        operation = 5;
        f1 = 0;
        f2 = 0;
        b1 = (Button) findViewById(R.id.button16);
        b2 = (Button) findViewById(R.id.button17);
        b3 = (Button) findViewById(R.id.button18);
        b4 = (Button) findViewById(R.id.button12);
        b5 = (Button) findViewById(R.id.button13);
        b6 = (Button) findViewById(R.id.button14);
        b7 = (Button) findViewById(R.id.button8);
        b8 = (Button) findViewById(R.id.button9);
        b9 = (Button) findViewById(R.id.button10);
        b0 = (Button) findViewById(R.id.button20);
        bdot = (Button) findViewById(R.id.button21);
        badd = (Button) findViewById(R.id.button19);
        bsub = (Button) findViewById(R.id.button15);
        bmul = (Button) findViewById(R.id.button11);
        bdiv = (Button) findViewById(R.id.button3);
        beq = (Button) findViewById(R.id.button22);
        bclear = (Button) findViewById(R.id.button6);
        output = (TextView) findViewById(R.id.textView);
        onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calc(v);
            }
        };
    }

    //Code Optimisation to enable one click listener for all buttons
    private void initCLickListeners() {
        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
        b4.setOnClickListener(onClickListener);
        b5.setOnClickListener(onClickListener);
        b6.setOnClickListener(onClickListener);
        b7.setOnClickListener(onClickListener);
        b8.setOnClickListener(onClickListener);
        b9.setOnClickListener(onClickListener);
        b0.setOnClickListener(onClickListener);
        bdot.setOnClickListener(onClickListener);
        badd.setOnClickListener(onClickListener);
        bsub.setOnClickListener(onClickListener);
        bmul.setOnClickListener(onClickListener);
        bdiv.setOnClickListener(onClickListener);
        beq.setOnClickListener(onClickListener);
        bclear.setOnClickListener(onClickListener);
    }

    private void calc(View v) {
        switch (v.getId()) {
            case R.id.button16:
                //1 pressed
                setOutputText("1", true);
                break;
            case R.id.button17:
                //2 pressed
                setOutputText("2", true);
                break;
            case R.id.button18:
                //3 pressed
                setOutputText("3", true);
                break;
            case R.id.button12:
                //4 pressed
                setOutputText("4", true);
                break;
            case R.id.button13:
                //5 pressed
                setOutputText("5", true);
                break;
            case R.id.button14:
                //6 pressed
                setOutputText("6", true);
                break;
            case R.id.button8:
                //7 pressed
                setOutputText("7", true);
                break;
            case R.id.button9:
                //8 pressed
                setOutputText("8", true);
                break;
            case R.id.button10:
                //9 pressed
                setOutputText("9", true);
                break;
            case R.id.button20:
                //0 pressed
                setOutputText("0", true);
                break;
            case R.id.button21:
                //decimal pressed
                setOutputText(".", true);
                break;
            case R.id.button19:
                //addition
                if (operation != 5) {
                    recCalc(0);
                } else {
                    f1 = Float.parseFloat(output.getText().toString());
                    setOutputText("0", false);
                    operation = 0;
                }
                break;
            case R.id.button15:
                //substraction
                if (operation != 5) {
                    recCalc(1);
                } else {
                    f1 = Float.parseFloat(output.getText().toString());
                    setOutputText("0", false);
                    operation = 1;
                }
                break;
            case R.id.button11:
                //multiplication
                if (operation != 5) {
                    recCalc(2);
                } else {
                    f1 = Float.parseFloat(output.getText().toString());
                    setOutputText("0", false);
                    operation = 2;
                }
                break;
            case R.id.button3:
                //division
                if (operation != 5) {
                    recCalc(3);
                } else {
                    f1 = Float.parseFloat(output.getText().toString());
                    setOutputText("0", false);
                    operation = 3;
                }
                break;
            case R.id.button22:
                //output
                try {
                    f2 = Float.parseFloat(output.getText().toString());
                    setOutputText(finalCalc(f1, f2), false);
                } catch (Exception e) {
                    setOutputText("0", false);
                }
                operation = 5;
                f1 = 0;
                f2 = 0;
                break;
            case R.id.button6:
                //clear/AC
                operation = 5;
                f1 = 0;
                f2 = 0;
                setOutputText("0", false);
                break;
        }


    }

    //called on final calculation
    private String finalCalc(float f1, float f2) {
        switch (operation) {
            case 0:
                return Float.toString(f1 + f2);
            case 1:
                return Float.toString(f1 - f2);
            case 2:
                return Float.toString(f1 * f2);
            case 3:
                if (f2 != 0)
                    return Float.toString(f1 / f2);
        }
        return "0";
    }


    //called if Operation symbol is recursively pressed
    private void recCalc(int i) {
        float temp = Float.parseFloat(output.getText().toString());
        switch (i) {
            case 0:
                f1 = f1 + temp;
                break;
            case 1:
                f1 = f1 - temp;
                break;
            case 2:
                f1 = f1 * temp;
                break;
            case 3:
                if (temp != 0)
                    f1 = f1 / temp;
                else {
                    f1 = 0;
                }
                break;
        }
        operation = 5;
        output.setText(Float.toString(f1));
    }

    //Prints Output to TextView. Use append true to append or false to replace current text
    private void setOutputText(String s, boolean append) {
        if (append) {
            output.setText(output.getText() + s);
        } else {
            output.setText(s);

        }
    }
}
