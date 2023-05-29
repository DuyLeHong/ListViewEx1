package com.duyle.listviewex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvFood = findViewById(R.id.lv_food);

        ArrayList<String> arrFood = new ArrayList<>();
        arrFood.add("Pizza");
        arrFood.add("Xúc xích");
        arrFood.add("Cơm trộn");
        arrFood.add("Gà quay");
        arrFood.add("Gà rán");
        arrFood.add("Bún bò");

        ArrayAdapter<String> adapterFood = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, arrFood);

        lvFood.setAdapter(adapterFood);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrFood.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnAddFood = findViewById(R.id.btn_add_food);
        Button btnRemoveFood = findViewById(R.id.btn_remove_food);

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrFood.add("Món mới");
                adapterFood.notifyDataSetChanged();
            }
        });

        btnRemoveFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrFood.size() > 0)
                    arrFood.remove(arrFood.size() - 1);
                else {
                    Toast.makeText(MainActivity.this, "Khong xoa duoc do het mon an!", Toast.LENGTH_SHORT).show();
                }

                adapterFood.notifyDataSetChanged();
            }
        });

        Button btnChonNN = findViewById(R.id.btn_chon_nn);
        btnChonNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityChonNgonNgu.class);

                startActivity(intent);
            }
        });

    }
}