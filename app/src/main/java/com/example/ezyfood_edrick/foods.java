package com.example.ezyfood_edrick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class foods extends AppCompatActivity {
    private database[] foods = {
            new database("Nasi Goreng", 20000, R.drawable.nasgor),
            new database("Burger", 23000, R.drawable.burger),
            new database("Sandwich", 18000, R.drawable.sandwich)
    };
    private Button myorder_btn_foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        GridView gridView = (GridView)findViewById(R.id.drinks_grid);
        databaseAdapter databasesAdapter = new databaseAdapter(this, foods);
        gridView.setAdapter(databasesAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                database databases = foods[i];
                Intent intent = new Intent(foods.this, order.class);
                Bundle extra = new Bundle();
                extra.putString("image", String.valueOf(databases.getImage()));
                extra.putString("name", databases.getName());
                extra.putString("price", String.valueOf(databases.getPrice()));
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
        myorder_btn_foods = (Button) findViewById(R.id.myorder_btn_foods);
        myorder_btn_foods.setOnClickListener(new View.OnClickListener() {
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