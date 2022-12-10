package com.example.calculatrice;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView inputText, outputText;
    private String input, output, newOutput;
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bMinus, bMulti, bDivide,
            bClear, bCE, bInverse, bCarre, bRacine, bDelete, bpoint, bEqual, bSign, bPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);
        b0 = findViewById(R.id.btn0_btn);
        b1 = findViewById(R.id.btn1_btn);
        b2 = findViewById(R.id.btn2_btn);
        b3 = findViewById(R.id.btn3_btn);
        b4 = findViewById(R.id.btn4_btn);
        b5 = findViewById(R.id.btn5_btn);
        b6 = findViewById(R.id.btn6_btn);
        b7 = findViewById(R.id.btn7_btn);
        b8 = findViewById(R.id.btn8_btn);
        b9 = findViewById(R.id.btn9_btn);
        bAdd = findViewById(R.id.ADDITION_btn);
        bMinus = findViewById(R.id.minus_btn);
        bMulti = findViewById(R.id.multi_btn);
        bDivide = findViewById(R.id.division_btn);
        bClear = findViewById(R.id.clear_btn);
        bCE = findViewById(R.id.CE_btn);
        bInverse = findViewById(R.id.inverse_btn);
        bCarre = findViewById(R.id.carre_btn);
        bRacine = findViewById(R.id.square_btn);
        bDelete = findViewById(R.id.delete_btn);
        bpoint = findViewById(R.id.virgule_btn);
        bEqual = findViewById(R.id.equal_btn);
        bSign = findViewById(R.id.sign_btn);
        bPercent = findViewById(R.id.percent_btn);

    }

    public void onButtonClicked(View view)
    {
        Button button = (Button)view;
        String data = button.getText().toString();
        switch (data)
        {
            case"C":
                input = null;
                output = null;
                outputText.setText("");
                break;
            case"+":
                input+="+";
                solve();
                break;
            case"*":
                input+="*";
                solve();
                break;
            case"-":
                input+="-";
                solve();
                break;
            case"/":
                input+="/";
                solve();
                break;
            case"1/X":
                Double z = 1/Double.parseDouble(inputText.getText().toString()) ;
                outputText.setText(String.valueOf(z));
                break;
            case"sqr":
                Double a = Math.sqrt(Double.parseDouble(inputText.getText().toString())) ;
                outputText.setText(String.valueOf(a));
                break;
            case"=":
                solve();
                break;
            case"%":
                input+="%";
                Double d = Double.parseDouble(inputText.getText().toString()) / 100;
                outputText.setText(String.valueOf(d));
                break;

            default :
                if(input == null)
                {
                    input = "";
                }
                if(data.equals("+") || data.equals("/") || data.equals("-"))
                {
                    solve();
                }
                input+= data;

        }
        inputText.setText(input);

    }

    private void solve()
    {
        //somme
        if(input.split("\\+").length == 2)
        {
            String numbers[] = input.split("\\+");
            try{
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }catch(Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }
        }
        // multiplication
        if(input.split("\\*").length == 2)
        {
            String numbers[] = input.split("\\*");
            try{
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }catch(Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }
        }

        //Division
        if(input.split("\\/").length == 2)
        {
            String numbers[] = input.split("\\/");
            try{
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }catch(Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }
        }

        //puissance
        if(input.split("\\^").length == 2)
        {
            String numbers[] = input.split("\\^");
            try{
                double d = Math.pow(Double.parseDouble(numbers[0]) , Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            }catch(Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }
        }

        //soustraction
        if(input.split("\\-").length == 2)
        {
            String numbers[] = input.split("\\-");
            try{
                if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1]))
                {
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                    input = d + "";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                    input = d + "";
                }

            }catch(Exception e)
            {
                outputText.setError(e.getMessage().toString());
            }
        }


    }
    private String cutDecimal(String number)
    {
        String n [] = number.split("\\.");
        if(n.length > 1)
        {
            if(n[1].equals("0"))
            {
                number = n[0];
            }
        }
        return number;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calculatrice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(MainActivity.this,MainActivity.class));
                break;
            case R.id.item2:
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
                break;
            case R.id.item3:
                startActivity(new Intent(MainActivity.this,MainActivity3.class));
                break;
            case R.id.item4:
                startActivity(new Intent(MainActivity.this,MainActivity4.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }



}