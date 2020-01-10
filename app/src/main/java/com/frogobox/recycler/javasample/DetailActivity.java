package com.frogobox.recycler.javasample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.frogobox.recycler.R;
import com.frogobox.recycler.javasample.adapter.DetailViewAdapter;
import com.frogobox.recycler.javasample.adapter.DetailViewListener;
import com.frogobox.recycler.model.ExampleModel;
import com.frogobox.recycler.view.FrogoRecyclerView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements DetailViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupAdapter();
    }

    private ArrayList<ExampleModel> listData() {
        ArrayList<ExampleModel> exampleModels = new ArrayList<>();
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        exampleModels.add(new ExampleModel("Amir Is Back"));
        return exampleModels;
    }

    private void setupAdapter() {
        DetailViewAdapter adapter = new DetailViewAdapter();
        adapter.setupRequirement(this, listData(), R.layout.example_list_item);
        FrogoRecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.isViewLinearVertical(false);
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
