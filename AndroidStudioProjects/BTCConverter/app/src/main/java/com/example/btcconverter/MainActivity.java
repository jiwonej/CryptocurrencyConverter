package com.example.btcconverter;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextWatcher tv1;
    private TextWatcher tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        num1 = (EditText) findViewById(R.id.editText);
        num2 = (EditText) findViewById(R.id.editText2);
        tv1 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = num1.getText().toString();
                if (!text.isEmpty()) {
                    double a = Double.parseDouble(text);
                    num2.removeTextChangedListener(tv2);
                    num2.setText(String.valueOf(a * 0.00010));
                    num2.addTextChangedListener(tv2);
                } else {
                    num2.getText().clear();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        tv2 = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = num2.getText().toString();
                if (!text.isEmpty()) {
                    double a = Double.parseDouble(num2.getText().toString());
                    num1.removeTextChangedListener(tv1);
                    num1.setText(String.valueOf(a * 9635.50));
                    num1.addTextChangedListener(tv1);
                } else {
                    num1.getText().clear();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        num1.addTextChangedListener(tv1);
        num2.addTextChangedListener(tv2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}