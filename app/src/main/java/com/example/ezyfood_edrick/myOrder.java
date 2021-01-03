package com.example.ezyfood_edrick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class myOrder extends AppCompatActivity {
    private Button pay_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        GridView gridView = (GridView)findViewById(R.id.myorder_grid);
        myOrderAdapter myOrderAdapters = new myOrderAdapter(this, order.databasesOrder);
        gridView.setAdapter(myOrderAdapters);

        total();

        pay_btn = (Button) findViewById(R.id.pay_btn);
        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpay();
            }
        });
    }

    public void total(){
        TextView totalView = (TextView) findViewById(R.id.totalPrice);
        int sum = 0;
        for(int i = 0; i< order.databasesOrder.size(); i++){
            int totalprice = order.databasesOrder.get(i).getPrice() * order.databasesOrder.get(i).getQuantity();
            sum += totalprice;
        }
        MainActivity.balance -= sum;
        totalView.setText("Price : Rp." + sum);
    }

    public void openpay(){
        for(int i = 0;i< order.databasesOrder.size(); i++){
            order.databasesOrder.clear();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}