package com.example.ezyfood_edrick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class topup extends AppCompatActivity {
    private Button topup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        calculate();

        topup_btn = (Button) findViewById(R.id.topup_btn);
        topup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topupbalance();
            }
        });
    }

    public void topupbalance() {
        EditText editText = (EditText) findViewById(R.id.howmuch);
        MainActivity.balance += Integer.parseInt(editText.getText().toString());
    }

    public void calculate(){
        TextView textView = (TextView)findViewById(R.id.textBalance);
        textView.setText("Total Balance : Rp." + MainActivity.balance);
    }
}