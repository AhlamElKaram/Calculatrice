package com.example.calculatrice;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.zip.InflaterInputStream;

    public class MainActivity2  extends Activity {

        private TextView expration_text;
        private TextView number_text;
        private double number1;
        private double number2;
        private String znak;
        private boolean last_znak;
        private DecimalFormat df = new DecimalFormat("#.########");

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);

            expration_text = findViewById(R.id.text_exp);
            number_text = findViewById(R.id.text_number);
            last_znak = false;

            if (savedInstanceState != null) {
                expration_text.setText((savedInstanceState.getString("expration")));
                number_text.setText((savedInstanceState.getString("number")));
                znak = savedInstanceState.getString("znak");
                number1 = savedInstanceState.getDouble("number1");
            }

        }

        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);

            outState.putString("expration", expration_text.getText().toString());
            outState.putString("number", number_text.getText().toString());
            outState.putString("znak", znak);
            outState.putDouble("number1", number1);
        }

        public void click1(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "1";
            else
                result += "1";
            number_text.setText(result);
            last_znak = false;
        }

        public void click2(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "2";
            else
                result += "2";
            number_text.setText(result);
            last_znak = false;
        }

        public void click3(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "3";
            else
                result += "3";
            number_text.setText(result);
            last_znak = false;
        }

        public void click4(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "4";
            else
                result += "4";
            number_text.setText(result);
            last_znak = false;
        }

        public void click5(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "5";
            else
                result += "5";
            number_text.setText(result);
            last_znak = false;
        }

        public void click6(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "6";
            else
                result += "6";
            number_text.setText(result);
            last_znak = false;
        }

        public void click7(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "7";
            else
                result += "7";
            number_text.setText(result);
            last_znak = false;
        }

        public void click8(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "8";
            else
                result += "8";
            number_text.setText(result);
            last_znak = false;
        }

        public void click9(View view) {
            String result = number_text.getText().toString();
            if (result.equals("0"))
                result = "9";
            else
                result += "9";
            number_text.setText(result);
            last_znak = false;
        }

        public void click0(View view) {
            String result = number_text.getText().toString();
            if (!result.equals("0"))
                result += "0";
            number_text.setText(result);
            last_znak = false;
        }

        public void click_plusminus(View view) {
            String result = number_text.getText().toString();
            if (result.charAt(0) == '-')
                result = result.substring(1, result.length());
            else if (Double.parseDouble(result) == 0)
                result = result;
            else
                result = "-" + result;
            number_text.setText(result);
            last_znak = false;
        }

        public void click_point(View view) {
            String result = number_text.getText().toString();
            if (!result.contains("."))
                result += ".";
            number_text.setText(result);
            last_znak = false;
        }

        public void clear(View view) {
            number_text.setText("0");
        }

        public void allclear(View view) {
            expration_text.setText("");
            number_text.setText("0");
            number1 = 0;
            number2 = 0;
        }

        public void division(View view) {
            if (last_znak == true) {
                String e_text = expration_text.getText().toString();
                String res = e_text.substring(0, e_text.length() - 1) + "/";
                expration_text.setText(res);
                number_text.setText("0");
                last_znak = true;
                znak = "/";
                return;
            }
            last_znak = true;
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                number1 = Double.parseDouble(n_text);
                znak = "/";
                String res = n_text + "/";
                expration_text.setText(res);
                number_text.setText("0");
                return;
            }

            if (e_text.endsWith("=")) {
                String res = n_text + "/";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "/";
                return;
            }

            double r = calculate();

            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(df.format(r)) + "/";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "/";
            number1 = r;
            return;
        }

        public void multiplication(View view) {
            if (last_znak == true) {
                String e_text = expration_text.getText().toString();
                String res = e_text.substring(0, e_text.length() - 1) + "*";
                expration_text.setText(res);
                number_text.setText("0");
                last_znak = true;
                znak = "*";
                return;
            }
            last_znak = true;
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                number1 = Double.parseDouble(n_text);
                znak = "*";
                String res = n_text + "*";
                expration_text.setText(res);
                number_text.setText("0");
                return;
            }

            if (e_text.endsWith("=")) {
                String res = n_text + "*";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "*";
                return;
            }

            double r = calculate();

            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(df.format(r)) + "*";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "*";
            number1 = r;
            return;
        }

        public void subtract(View view) {
            if (last_znak == true) {
                String e_text = expration_text.getText().toString();
                String res = e_text.substring(0, e_text.length() - 1) + "-";
                expration_text.setText(res);
                number_text.setText("0");
                last_znak = true;
                znak = "-";
                return;
            }
            last_znak = true;
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                number1 = Double.parseDouble(n_text);
                znak = "-";
                String res = n_text + "-";
                expration_text.setText(res);
                number_text.setText("0");
                return;
            }

            if (e_text.endsWith("=")) {
                String res = n_text + "-";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "-";
                return;
            }

            double r = calculate();

            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(df.format(r)) + "-";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "-";
            number1 = r;
            return;
        }

        public void addition(View view) {
            if (last_znak == true) {
                String e_text = expration_text.getText().toString();
                String res = e_text.substring(0, e_text.length() - 1) + "+";
                expration_text.setText(res);
                number_text.setText("0");
                last_znak = true;
                znak = "+";
                return;
            }
            last_znak = true;
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                number1 = Double.parseDouble(n_text);
                znak = "+";
                String res = n_text + "+";
                expration_text.setText(res);
                number_text.setText("0");
                return;
            }

            if (e_text.endsWith("=")) {
                String res = n_text + "+";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "+";
                return;
            }

            double r = calculate();

            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(df.format(r)) + "+";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "+";
            number1 = r;
            return;
        }

        public void equal(View view) {
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);

            System.out.println("exp = " + e_text);
            System.out.println("num = " + n_text);

            if (e_text.equals("")) {
                String res = n_text + "=";
                expration_text.setText(res);
                number_text.setText(n_text);
                return;
            }

            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                String res = n_text + "=";
                expration_text.setText(res);
                number_text.setText(n_text);
                number1 = number2;
                return;
            }
            double r = calculate();
            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(df.format(number1)) + znak + String.valueOf(number2) + "=";
            expration_text.setText(res);
            System.out.println("r = " + r);
            number_text.setText(String.valueOf(df.format(r)));
        }
        public double calculate() {
            double r = 0;
            System.out.println(number1);
            System.out.println(znak);
            System.out.println(number2);
            switch (znak) {
                case "+":
                    r = number1 + number2;
                    break;
                case "-":
                    r = number1 - number2;
                    break;
                case "*":
                    r = number1 * number2;
                    break;
                case "/":
                    if (number2 == 0) {
                        expration_text.setText("Error");
                        number_text.setText("0");
                        return 0;
                    }
                    r = number1 / number2;
                    break;
                case "^":
                    r = Math.pow(number1, number2);
                    break;
            }

            System.out.println("r = " + r);
            last_znak = false;

            if (r == Double.POSITIVE_INFINITY) {
                expration_text.setText(String.valueOf(r));
                number_text.setText("0");
            }

            return r;
        }

        public void log(View view) {
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (number2 < 1) {
                expration_text.setText("Error");
                number_text.setText("0");
                return;
            }
            String r = "log(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.log10(number2)));
            last_znak = false;
        }

        public void ln(View view) {
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (number2 < 1) {
                expration_text.setText("Error");
                number_text.setText("0");
                return;
            }
            String r = "ln(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.log(number2)));
            last_znak = false;
        }

        public void tg(View view) {
            String n_text = number_text.getText().toString();
            number2 = Math.toRadians(Double.parseDouble(n_text));

            String r = "tg(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.tan(number2)));
            last_znak = false;
        }

        public void cos(View view) {
            String n_text = number_text.getText().toString();
            number2 = Math.toRadians(Double.parseDouble(n_text));

            String r = "cos(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.cos(number2)));
            last_znak = false;
        }

        public void sin(View view) {
            String n_text = number_text.getText().toString();
            number2 = Math.toRadians(Double.parseDouble(n_text));

            String r = "sin(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.sin(number2)));
            last_znak = false;
        }

        public void perc(View view) {
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);

            String r = n_text + "%";
            expration_text.setText(r);
            number_text.setText(String.valueOf(number2 / 100));
            last_znak = false;
        }

        public void sqrt(View view) {
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (number2 < 1) {
                expration_text.setText("Error");
                number_text.setText("0");
                return;
            }
            String r = "√(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(Math.sqrt(number2)));
            last_znak = false;
        }

        public void function(View view) {
            if (last_znak == true) {
                String e_text = expration_text.getText().toString();
                String res = e_text.substring(0, e_text.length() - 1) + "^";
                expration_text.setText(res);
                number_text.setText("0");
                last_znak = true;
                znak = "^";
                return;
            }
            last_znak = true;
            String e_text = expration_text.getText().toString();
            String n_text = number_text.getText().toString();
            number2 = Double.parseDouble(n_text);
            if (e_text.equals("") || e_text.contains("=") || e_text.equals("Error") || e_text.contains("log") || e_text.contains("ln") || e_text.contains("sin")
                    || e_text.contains("cos") || e_text.contains("tg") || e_text.contains("√") || e_text.contains("sqr") || e_text.contains("Infinity")) {
                number1 = Double.parseDouble(n_text);
                znak = "^";
                String res = n_text + "^";
                expration_text.setText(res);
                number_text.setText("0");
                return;
            }

            if (e_text.endsWith("=")) {
                String res = n_text + "^";
                expration_text.setText(res);
                number_text.setText("0");
                znak = "^";
                return;
            }

            double r = calculate();

            if (expration_text.getText().equals("Error") || r == Double.POSITIVE_INFINITY)
                return;

            String res = String.valueOf(r) + "^";
            expration_text.setText(res);
            number_text.setText("0");
            znak = "^";
            number1 = r;
            return;
        }

        public void function_ocarrée(View view) {
            String n_text = number_text.getText().toString();
            BigDecimal number2 = new BigDecimal(n_text);

            String r = "sqr(" + n_text + ")";
            expration_text.setText(r);
            number_text.setText(String.valueOf(df.format(number2.pow(2))));
            last_znak = false;
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
                    startActivity(new Intent(MainActivity2.this,MainActivity.class));
                    break;
                case R.id.item2:
                    startActivity(new Intent(MainActivity2.this,MainActivity2.class));
                    break;
                case R.id.item3:
                    startActivity(new Intent(MainActivity2.this,MainActivity3.class));
                    break;
                case R.id.item4:
                    startActivity(new Intent(MainActivity2.this,MainActivity4.class));
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }


    }

