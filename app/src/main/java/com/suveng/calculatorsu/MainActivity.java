package com.suveng.calculatorsu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public List<Item> items= new ArrayList<>();

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_show);
        findViewById(R.id.btn_num0).setOnClickListener(this);
        findViewById(R.id.btn_num1).setOnClickListener(this);
        findViewById(R.id.btn_num2).setOnClickListener(this);
        findViewById(R.id.btn_num3).setOnClickListener(this);
        findViewById(R.id.btn_num4).setOnClickListener(this);
        findViewById(R.id.btn_num5).setOnClickListener(this);
        findViewById(R.id.btn_num6).setOnClickListener(this);
        findViewById(R.id.btn_num7).setOnClickListener(this);
        findViewById(R.id.btn_num8).setOnClickListener(this);
        findViewById(R.id.btn_num9).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_division).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_num0:
                textView.append("0");

                break;
            case R.id.btn_num1:
                textView.append("1");

                break;
            case R.id.btn_num2:
                textView.append("2");

                break;
            case R.id.btn_num3:
                textView.append("3");

                break;
            case R.id.btn_num4:
                textView.append("4");

                break;
            case R.id.btn_num5:
                textView.append("5");

                break;
            case R.id.btn_num6:
                textView.append("6");

                break;
            case R.id.btn_num7:
                textView.append("7");

                break;
            case R.id.btn_num8:
                textView.append("8");

                break;
            case R.id.btn_num9:
                textView.append("9");

                break;
            case R.id.btn_clear:
                textView.setText("");
                items.clear();
                break;
            case R.id.btn_minus:
                items.add(new Item(Double.parseDouble(textView.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.MINUS));
                textView.setText("");
                break;
            case R.id.btn_plus:
                items.add(new Item(Double.parseDouble(textView.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.PLUS));
                textView.setText("");
                break;
            case R.id.btn_multiple:
                items.add(new Item(Double.parseDouble(textView.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.MULTIPLE));
                textView.setText("");
                break;
            case R.id.btn_division:
                items.add(new Item(Double.parseDouble(textView.getText().toString()),Types.NUM));
                checkAndCompute();
                items.add(new Item(0,Types.DIVISION));
                textView.setText("");
                break;
            case R.id.btn_equal:
                items.add(new Item(Double.parseDouble(textView.getText().toString()),Types.NUM));
                checkAndCompute();
                textView.setText(String.valueOf(items.get(0).value));
                items.clear();
                break;
        }
    }
    private void checkAndCompute(){
        if (items.size()>=3){
            double a =items.get(0).value;
            double b=items.get(2).value;
            int opt = items.get(1).type;

            items.clear();

            switch (opt){
                case Types.PLUS:
                    items.add(new Item(a+b,Types.NUM));
                    break;
                case Types.MINUS:
                    items.add(new Item(a-b,Types.NUM));

                    break;
                case Types.MULTIPLE:
                    items.add(new Item(a*b,Types.NUM));

                    break;
                case Types.DIVISION:
                    items.add(new Item(a/b,Types.NUM));

                    break;

            }
        }

    }

}
