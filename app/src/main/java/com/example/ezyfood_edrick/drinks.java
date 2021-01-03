package com.example.ezyfood_edrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class drinks extends AppCompatActivity {
    private database[] drinks = {
            new database("Air Mineral", 5000, R.drawable.airmineral),
            new database("Jus Apel", 10000, R.drawable.jusapel),
            new database("Jus Mangga", 11000, R.drawable.jusmangga),
            new database("Jus Alpukat", 12000, R.drawable.jusalpukat),
            new database("Coca - Cola", 8000, R.drawable.cola),
    };
    private Button myorder_btn_drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        GridView gridView = (GridView)findViewById(R.id.drinks_grid);
        databaseAdapter databasesAdapter = new databaseAdapter(this, drinks);
        gridView.setAdapter(databasesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                database databases = drinks[i];
                Intent intent = new Intent(drinks.this, order.class);
                Bundle extra = new Bundle();
                extra.putString("image", String.valueOf(databases.getImage()));
                extra.putString("name", databases.getName());
                extra.putString("price", String.valueOf(databases.getPrice()));
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
        myorder_btn_drinks = (Button) findViewById(R.id.myorder_btn_drinks);
        myorder_btn_drinks.setOnClickListener(new View.OnClickListener() {
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