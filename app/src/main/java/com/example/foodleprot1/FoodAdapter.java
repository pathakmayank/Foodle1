package com.example.foodleprot1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Tag;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context mContext;
    private  ArrayList<ModelFood> mList;
    ItemClicked activity;

    public interface ItemClicked{
        void onItemClicked(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFood;
        TextView tvFoodName, tvFoodPrice;


        public ViewHolder(@NonNull final View itemView){
            super(itemView);

            ivFood = itemView.findViewById(R.id.ivFood);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = itemView.findViewById(R.id.tvFoodPrice);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(mList.indexOf(itemView.getTag()));

                }
            });

        }
    }


    public FoodAdapter(Context context, ArrayList<ModelFood> list){
        mContext = context;
        mList = list;
        activity = (ItemClicked) context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.fooditems, parent, false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Log.d(TAG,"onBindViewHolder: called.");
        holder.itemView.setTag(mList.get(position));
        ModelFood foodItem = mList.get(position);

        ImageView image = holder.ivFood;
        TextView name, price;

        name = holder.tvFoodName;
        price = holder.tvFoodPrice;

        image.setImageResource(foodItem.getImage());
        name.setText(foodItem.getName());
        price.setText(foodItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
