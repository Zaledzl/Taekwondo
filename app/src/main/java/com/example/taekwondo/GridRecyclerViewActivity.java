package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.taekwondo.recyclerview.GridAdapter;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvgrid = findViewById(R.id.rv_grid);
        mRvgrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        mRvgrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"Click:"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
