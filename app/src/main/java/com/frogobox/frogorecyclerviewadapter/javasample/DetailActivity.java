package com.frogobox.frogorecyclerviewadapter.javasample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.frogobox.frogorecyclerviewadapter.R;
import com.frogobox.frogorecyclerviewadapter.mdoel.ExampleModel;
import com.frogobox.frogoviewadapter.FrogoRecyclerViewListener;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements FrogoRecyclerViewListener<ExampleModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupAdapter();
    }

    private ArrayList<ExampleModel> listData(){
        ArrayList<ExampleModel> exampleModels = new ArrayList<>();
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        return exampleModels;
    }

    private void setupAdapter(){
        DetailViewAdapter adapter = new DetailViewAdapter();
        adapter.setupRequirement(this, listData(), R.layout.example_list_item);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClicked(ExampleModel data) {
        Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClicked(ExampleModel data) {
        Toast.makeText(this, data.getName(), Toast.LENGTH_LONG).show();
    }
    
}
