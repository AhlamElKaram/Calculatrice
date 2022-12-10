package com.example.calculatrice;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.SeekBar;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {
    private TextView tv_c;
    private TextView tv_f;
    private Double c;
    private Double f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        tv_c = findViewById(R.id.celsius);
        tv_f = findViewById(R.id.fren);

        SeekBar seekBar = findViewById(R.id.seekBar2);
        seekBar.setMax(400);
        seekBar.setProgress(200);

        c = (double) (seekBar.getProgress() - 200);
        f = c * 1.38 + 32;

        tv_c.setText(String.format(Locale.getDefault(),"%.1f C°",c));
        tv_f.setText(String.format(Locale.getDefault(),"%.1f F°",f));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                c = (double) (i - 200);
                f = c * 1.38 + 32;

                tv_c.setText(String.format(Locale.getDefault(),"%.1f C°",c));
                tv_f.setText(String.format(Locale.getDefault(),"%.1f F°",f));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(MainActivity4.this,MainActivity.class));
                break;
            case R.id.item2:
                startActivity(new Intent(MainActivity4.this,MainActivity2.class));
                break;
            case R.id.item3:
                startActivity(new Intent(MainActivity4.this,MainActivity3.class));
                break;
            case R.id.item4:
                startActivity(new Intent(MainActivity4.this,MainActivity4.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
