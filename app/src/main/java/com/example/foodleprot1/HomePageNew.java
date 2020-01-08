package com.example.foodleprot1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomePageNew extends AppCompatActivity implements FoodAdapter.ItemClicked {
    RecyclerView recyclerView;
    FoodAdapter adapter;
    RecyclerView.LayoutManager rvLiLayoutManager;
    FloatingActionButton cartFromMenu;
    //ImageView ivSignOut;

    //RecyclerView.Adapter myAdapter;
    //RecyclerView.LayoutManager layoutManager;
    //LinearLayout btnToMenu;
    ArrayList<ModelFood> foodsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_new);
        cartFromMenu = findViewById(R.id.cartFromMenu);
        recyclerView = findViewById(R.id.rv1);
       // ivSignOut = findViewById(R.id.ivSignOut);
        foodsList = new ArrayList<>();

        foodsList.add(new ModelFood(R.drawable.cb1, "Chole Bhature", "Rs 30"));
        foodsList.add(new ModelFood(R.drawable.burgernew, "Cheese Burger", "Rs 25"));
        foodsList.add(new ModelFood(R.drawable.vegnoodles, "Veg Noodles", "Rs 25"));
        foodsList.add(new ModelFood(R.drawable.pattiee, "Veg Patties", "Rs 15"));
        foodsList.add(new ModelFood(R.drawable.maggi, "Veg Maggi", "Rs 25"));
        foodsList.add(new ModelFood(R.drawable.samosa, "Samosa", "Rs 10"));
        foodsList.add(new ModelFood(R.drawable.minipizza, "Mini Veg Pizza", "Rs 45"));
        foodsList.add(new ModelFood(R.drawable.cholesamosa, "Chole Samosa", "Rs 15"));
        foodsList.add(new ModelFood(R.drawable.tea, "Tea", "Rs 8"));
        foodsList.add(new ModelFood(R.drawable.coffee, "Coffee", "Rs 11"));
        foodsList.add(new ModelFood(R.drawable.cholechawal, "Chole Chawal", "Rs 25"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        adapter = new FoodAdapter(this,foodsList);
        recyclerView.setAdapter(adapter);


        cartFromMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocart = new Intent(HomePageNew.this, com.example.foodleprot1.Cart.class);
                startActivity(gotocart);

            }
        });
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(HomePageNew.this, com.example.foodleprot1.Fooditemdetail.class);
        intent.putExtra("imageid", Integer.toString(foodsList.get(position).getImage()));
        intent.putExtra("foodname", foodsList.get(position).getName());
        intent.putExtra("foodprice", foodsList.get(position).getPrice());
        startActivity(intent);
    }
}
