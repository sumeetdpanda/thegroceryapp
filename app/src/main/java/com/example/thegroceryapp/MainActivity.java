package com.example.thegroceryapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ItemModel> itemList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        itemList = new ArrayList<>();

        ItemModel item1 = new ItemModel(R.drawable.fruit, "Fruits", "Fresh fruits from the garden");
        ItemModel item2 = new ItemModel(R.drawable.vegetables, "Vegetables", "Delicious Vegetables");
        ItemModel item3 = new ItemModel(R.drawable.bread, "Bakery", "Bread, Wheat and Beans");
        ItemModel item4 = new ItemModel(R.drawable.beverage, "Beverages", "Juice, Tea, Coffee and Soda");
        ItemModel item5 = new ItemModel(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt");
        ItemModel item6 = new ItemModel(R.drawable.popcorn, "Snacks", "Popcorn, Donut and Drinks");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        adapter = new ItemAdapter(itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}