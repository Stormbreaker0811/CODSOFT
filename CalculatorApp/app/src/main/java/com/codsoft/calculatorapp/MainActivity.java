package com.codsoft.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String input,output;
    private TextView inputText,outputText;
    private String ACTION;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,pointBtn,addBtn,subBtn,multiplyBtn,divideBtn
            ,powerBtn,percentBtn,equalsBtn,clearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI();
        btn0.setOnClickListener(view -> {
            input ="0";
            inputText.append(input);
        });
        btn1.setOnClickListener(view ->{
            input ="1";
            inputText.append(input);
        });
        btn2.setOnClickListener(view -> {
            input ="2";
            inputText.append(input);
        });
        btn3.setOnClickListener(view -> {
            input ="3";
            inputText.append(input);
        });
        btn4.setOnClickListener(view -> {
            input ="4";
            inputText.append(input);
        });
        btn5.setOnClickListener(view -> {
            input ="5";
            inputText.append(input);
        });
        btn6.setOnClickListener(view -> {
            input ="6";
            inputText.append(input);
        });
        btn7.setOnClickListener(view -> {
            input ="7";
            inputText.append(input);
        });
        btn8.setOnClickListener(view -> {
            input ="8";
            inputText.append(input);
        });
        btn9.setOnClickListener(view -> {
            input ="9";
            inputText.append(input);
        });
        clearAll.setOnClickListener(view -> {
            input = "";
            output = "";
            inputText.setText("");
            outputText.setText("");
        });
        addBtn.setOnClickListener(view -> {
            ACTION = "+";
            if(inputText.getText().toString().equals("")) {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            }else{
                input = "+";
                inputText.append(input);
            }
        });
        subBtn.setOnClickListener(view -> {
            ACTION = "-";
            if(inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else{
                input = "-";
                inputText.append(input);
            }
        });
        multiplyBtn.setOnClickListener(view -> {
            ACTION = "x";
            if (inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                input = "x";
                inputText.append(input);
            }
        });
        divideBtn.setOnClickListener(view -> {
            ACTION = "÷";
            if (inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                input = "÷";
                inputText.append(input);
            }
        });
        powerBtn.setOnClickListener(view -> {
            ACTION = "^";
            if (inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                input = "^";
                inputText.append(input);
            }
        });
        percentBtn.setOnClickListener(view -> {
            ACTION = "%";
            if (inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                input = "%";
                inputText.append(input);
            }
        });
        equalsBtn.setOnClickListener(view -> {
            if(inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                solve();
            }
        });
        pointBtn.setOnClickListener(view -> {
            if(inputText.getText().toString().equals("")){
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
            }else {
                input = ".";
                inputText.append(input);
            }
        });

    }

    private void solve() {
        switch(ACTION){
            case "+":
                try {
                    String[] addition = inputText.getText().toString().split("\\+");
                    double add = Double.parseDouble(addition[0]) + Double.parseDouble(addition[1]);
                    output = String.valueOf(add);
                    outputText.setText(output);
                }catch(Exception e){
                    Toast.makeText(this, "Addition Error!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "-":
                try {
                    String[] subtraction = inputText.getText().toString().split("-");
                    double sub = Double.parseDouble(subtraction[0]) - Double.parseDouble(subtraction[1]);
                    output = String.valueOf(sub);
                    outputText.setText(output);
                }catch(Exception e){
                    Toast.makeText(this, "Subtraction Error!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "x":
                try {
                    String[] multiply = inputText.getText().toString().split("x");
                    double mul = Double.parseDouble(multiply[0]) * Double.parseDouble(multiply[1]);
                    output = String.valueOf(mul);
                    outputText.setText(output);
                }catch(Exception e){
                    Toast.makeText(this, "Multiplication Error!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "÷":
                try {
                    String[] divide = inputText.getText().toString().split("÷");
                    double div = Double.parseDouble(divide[0]) / Double.parseDouble(divide[1]);
                    output = String.valueOf(div);
                    if(output.equals("Infinity")){
                        throw new Exception("Cannot Divide by Zero");
                    }
                    outputText.setText(output);
                }catch(Exception e){
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case "^":
                try {
                    String[] power = inputText.getText().toString().split("\\^");
                    double pow = Math.pow(Double.parseDouble(power[0]), Double.parseDouble(power[1]));
                    output = String.valueOf(pow);
                    outputText.setText(output);
                }catch(Exception e){
                    Toast.makeText(this, "Power Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "%":
                try {
                    String[] percent = inputText.getText().toString().split("%");
                    double per = Double.parseDouble(percent[0]) / 100;
                    output = String.valueOf(per);
                    outputText.setText(output);
                }catch (Exception e){
                    Toast.makeText(this, "Percent Error!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Toast.makeText(this, "Invalid Format", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initialiseUI() {
        inputText = findViewById(R.id.input_number);
        outputText = findViewById(R.id.output);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        pointBtn = findViewById(R.id.point_btn);
        addBtn = findViewById(R.id.addition_btn);
        subBtn = findViewById(R.id.subtraction_btn);
        multiplyBtn = findViewById(R.id.multiply_btn);
        divideBtn = findViewById(R.id.divide_btn);
        percentBtn = findViewById(R.id.percent_btn);
        powerBtn = findViewById(R.id.power_btn);
        equalsBtn = findViewById(R.id.equals_btn);
        clearAll = findViewById(R.id.clear_btn);
    }
}