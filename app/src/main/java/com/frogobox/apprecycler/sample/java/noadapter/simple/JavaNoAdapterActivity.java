package com.frogobox.apprecycler.sample.java.noadapter.simple;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.frogobox.apprecycler.core.BaseActivity;
import com.frogobox.apprecycler.model.ExampleModel;
import com.frogobox.recycler.R;
import com.frogobox.recycler.core.IFrogoViewAdapter;
import com.frogobox.apprecycler.databinding.ActivityFrogoRvListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaNoAdapterActivity extends BaseActivity<ActivityFrogoRvListBinding> {

    @NotNull
    @Override
    public ActivityFrogoRvListBinding setupViewBinding() {
        return ActivityFrogoRvListBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFrogoRecyclerView();
        setupDetailActivity("Java No Adapter");
    }

    private ArrayList<ExampleModel> listData() {
        ArrayList<ExampleModel> exampleModels = new ArrayList<>();
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        // exampleModels.add(new ExampleModel(Constant.NICK_NAME));
        return exampleModels;
    }

    private void setupFrogoRecyclerView() {

        IFrogoViewAdapter frogoViewAdapterCallback = new IFrogoViewAdapter<ExampleModel>() {
            @Override
            public void setupInitComponent(@NotNull View view, ExampleModel data) {
                // Init component content item recyclerview
                TextView tvExample = view.findViewById(R.id.frogo_rv_list_type_1_tv_title);
                tvExample.setText(data.getName());
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                // setup item clicked on frogo recycler view
                showToast(data.getName());
            }

            @Override
            public void onItemLongClicked(ExampleModel data) {
                // setup item long clicked on frogo recycler view
                showToast(data.getName());
            }
        };

        getBinding().frogoRecyclerView.injector()
                .addData(listData())
                .addCustomView(R.layout.frogo_rv_list_type_1)
                .addEmptyView(null)
                .addCallback(frogoViewAdapterCallback)
                .createLayoutStaggeredGrid(2)
                .build();
    }

}