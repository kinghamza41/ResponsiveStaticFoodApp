package com.example.responsivefoodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.responsivefoodapp.Adapters.RecipeAdapter;
import com.example.responsivefoodapp.Classes.RecyclerItemClickListener;
import com.example.responsivefoodapp.Models.RecipeModel;

import java.util.ArrayList;


public class MainInfoScreen extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info_screen);
        recyclerView = findViewById(R.id.recyclerview);
        ArrayList<RecipeModel> list = new ArrayList<>();
        list.add(new RecipeModel(R.drawable.food1, "Burger"));
        list.add(new RecipeModel(R.drawable.food3, "Fried Egg"));
        list.add(new RecipeModel(R.drawable.food4, "Fried Fish"));
        list.add(new RecipeModel(R.drawable.food5, "Lahori Chicken"));
        list.add(new RecipeModel(R.drawable.food6, "Biryani"));
        list.add(new RecipeModel(R.drawable.food1, "Cheese Burger"));
        RecipeAdapter adapter = new RecipeAdapter(list, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager1);

//        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 2);
//            recyclerView.setLayoutManager(layoutManager2);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainInfoScreen.this, ScrollingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainInfoScreen.this, "Second item is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainInfoScreen.this, "Third  item is clicked", Toast.LENGTH_SHORT).show();
                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {
                switch(position){
                case 0:
                    Toast.makeText(MainInfoScreen.this, "On Long Item Clicked", Toast.LENGTH_SHORT).show();
                break;
                    default:
                }
            }
        }));

    }
}