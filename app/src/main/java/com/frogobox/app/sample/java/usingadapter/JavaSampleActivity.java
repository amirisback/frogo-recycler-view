package com.frogobox.app.sample.java.usingadapter;

import android.os.Bundle;
import android.widget.Toast;

import com.frogobox.app.core.BaseActivity;
import com.frogobox.app.model.ExampleModel;
import com.frogobox.recycler.R;
import com.frogobox.recycler.core.FrogoRecyclerViewListener;
import com.frogobox.app.databinding.ActivityFrogoRvListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaSampleActivity extends BaseActivity<ActivityFrogoRvListBinding> {

    @NotNull
    @Override
    public ActivityFrogoRvListBinding setupViewBinding() {
        return ActivityFrogoRvListBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdapter();
        setupDetailActivity("Java With Adapter");
    }

    private ArrayList<ExampleModel> listData() {
        ArrayList<ExampleModel> exampleModels = new ArrayList<>();
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
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

        getBinding().frogoRecyclerView.setAdapter(adapter);
        getBinding().frogoRecyclerView.isViewLinearVertical(false);
    }


}
