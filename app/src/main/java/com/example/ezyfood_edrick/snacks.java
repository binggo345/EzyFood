package com.example.ezyfood_edrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class snacks extends AppCompatActivity {
    private database[] snacks = {
            new database("Fries", 15000, R.drawable.fries),
            new database("Cookies", 12000, R.drawable.cookies),
            new database("Salad", 15000, R.drawable.salad)
    };
    private Button myorder_btn_snacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        GridView gridView = (GridView)findViewById(R.id.drinks_grid);
        databaseAdapter databasesAdapter = new databaseAdapter(this, snacks);
        gridView.setAdapter(databasesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                database databases = snacks[i];
                Intent intent = new Intent(snacks.this, order.class);
                Bundle extra = new Bundle();
                extra.putString("image", String.valueOf(databases.getImage()));
                extra.putString("name", databases.getName());
                extra.putString("price", String.valueOf(databases.getPrice()));
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
        myorder_btn_snacks = (Button) findViewById(R.id.myorder_btn_snacks);
        myorder_btn_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmyOrderclass();
            }
        });
    }

    public void openmyOrderclass(){
        Intent intent = new Intent(this, myOrder.class);
        startActivity(intent);
    }
}