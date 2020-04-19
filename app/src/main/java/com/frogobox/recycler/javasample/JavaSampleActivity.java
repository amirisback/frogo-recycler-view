package com.frogobox.recycler.javasample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.frogobox.recycler.FrogoRecyclerView;
import com.frogobox.recycler.R;
import com.frogobox.recycler.adapter.FrogoRecyclerViewListener;
import com.frogobox.recycler.model.ExampleModel;

import java.util.ArrayList;

public class JavaSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogo_rv_sample);
        setupAdapter();
    }

    private ArrayList<ExampleModel> listData() {
        ArrayList<ExampleModel> exampleModels = new ArrayList<>();
//        exampleModels.add(new ExampleModel(Constant.NICK_NAME));
//        exampleModels.add(new ExampleModel(Constant.NICK_NAME));
//        exampleModels.add(new ExampleModel(Constant.NICK_NAME));
//        exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        return exampleModels;
    }

    private void setupAdapter() {
        JavaSampleViewAdapter adapter = new JavaSampleViewAdapter();
        adapter.setupRequirement(R.layout.frogo_rv_list_type_1, listData(), new FrogoRecyclerViewListener<ExampleModel>() {
            @Override
            public void onItemClicked(ExampleModel data) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClicked(ExampleModel data) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_LONG).show();
            }
        });
        adapter.setupEmptyView(null); // Without Custom View
        FrogoRecyclerView recyclerView = findViewById(R.id.frogo_recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.isViewLinearVertical(false);
    }

}
