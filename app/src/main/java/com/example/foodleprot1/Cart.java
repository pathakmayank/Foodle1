package com.example.foodleprot1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    //RecyclerView recyclerView;
    //CartAdapter adapter;
    //RecyclerView.LayoutManager rvLiLayoutManager;
    Button btncheckOut;

    //ArrayList<ModelCart> cartlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //recyclerView = findViewById(R.id.rv2);
        btncheckOut = findViewById(R.id.btnCheckout);

        btncheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this, com.example.foodleprot1.checkout.class);
                startActivity(intent);
            }
        });


        /*cartlist = new ArrayList<>();
        cartlist.add(new ModelCart(R.drawable.tea, "Tea", "Rs 8"));
        cartlist.add(new ModelCart(R.drawable.tea, "Tea", "Rs 8"));
        cartlist.add(new ModelCart(R.drawable.tea, "Tea", "Rs 8"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLiLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLiLayoutManager);

        adapter = new CartAdapter(this,cartlist);
        recyclerView.setAdapter(adapter);*/
    }
}
