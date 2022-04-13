package com.example.baitaplonandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavLayout extends Activity {
    private RecyclerView rcvData;

    private FavAdapter favAdapter;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_layout);


        getData(MainActivity.foodArrayList);
        setBack();
    }
    private void setBack(){
        back = (ImageView) findViewById(R.id.backward);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavLayout.this,UserLayout.class);
                startActivity(intent);
            }
        });
    }

    public void getData(List<Food> foodArrayList){
        rcvData = findViewById(R.id.recyclerViewFav);
        favAdapter = new FavAdapter(this, foodArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rcvData.setLayoutManager(layoutManager);
        rcvData.setAdapter(favAdapter);
        favAdapter.notifyDataSetChanged();
    }

}
