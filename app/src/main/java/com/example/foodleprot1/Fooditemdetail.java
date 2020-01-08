package com.example.foodleprot1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fooditemdetail extends AppCompatActivity {
    ImageView ivFoodLarge;
    TextView tvFN, tvPrice;
    Button btnAddToCart,btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditemdetail);

        ivFoodLarge = findViewById(R.id.ivFoodLarge);
        tvFN = findViewById(R.id.tvFN);
        tvPrice = findViewById(R.id.tvPrice);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnProfile = findViewById(R.id.btnProfile);

        //String id21 = getIntent().getStringExtra("imageid");
         String idnum = getIntent().getStringExtra("imageid");
         String foodname = getIntent().getStringExtra("foodname");
         String  foodprice = getIntent().getStringExtra("foodprice");

        ivFoodLarge.setImageResource(Integer.parseInt(idnum));
        tvFN.setText(foodname);
        tvPrice.setText(foodprice);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocart = new Intent(Fooditemdetail.this, com.example.foodleprot1.Cart.class);
                //gotocart.putExtra("id", getIntent().getStringExtra("imageid"));
                //gotocart.putExtra("name", getIntent().getStringExtra("foodname"));
                //gotocart.putExtra("price", getIntent().getStringExtra("foodprice"));
                startActivity(gotocart);


                Toast.makeText(Fooditemdetail.this, "Item added to cart successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(Fooditemdetail.this, com.example.foodleprot1.Profile.class);
                startActivity(profile);


            }
        });

    }



}
