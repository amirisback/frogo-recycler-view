package com.frogobox.recycler.javasample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.frogobox.recycler.FrogoRecyclerView;
import com.frogobox.recycler.R;
import com.frogobox.recycler.base.BaseActivity;
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoMultiAdapterCallback;
import com.frogobox.recycler.model.ExampleModel;
import com.frogobox.recycler.util.Constant;
import com.frogobox.recycler.util.FrogoRvConstant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaNoAdapterMultiViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogo_rv_sample);
        setupFrogoRecyclerView();
        setupDetailActivity("Java No Adapter - Multi View");
    }

    private ArrayList<ExampleModel> listData() {
        ArrayList<ExampleModel> listString = new ArrayList<>();
        listString.add(new ExampleModel(Constant.FULL_NAME));
        listString.add(new ExampleModel(Constant.FULL_NAME));
        listString.add(new ExampleModel(Constant.FULL_NAME));
        listString.add(new ExampleModel(Constant.FULL_NAME));
        return listString;

    }

    private ArrayList<Integer> listOption() {
        ArrayList<Integer> listOption = new ArrayList<>();
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND);
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND);
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST);
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST);
        return listOption;
    }

    private ArrayList<Integer> listLayout() {
        ArrayList<Integer> listLayout = new ArrayList<>();
        listLayout.add(R.layout.frogo_rv_list_type_1);
        listLayout.add(R.layout.frogo_rv_list_type_2);
        return listLayout;
    }

    private void setupFrogoRecyclerView() {
        FrogoRecyclerView recyclerView = findViewById(R.id.frogo_recycler_view);

        FrogoMultiAdapterCallback frogoMultiAdapterCallback = new FrogoMultiAdapterCallback<ExampleModel>() {

            @Override
            public void setupFirstInitComponent(@NotNull View view, ExampleModel data) {
                TextView tvExampleItem = findViewById(R.id.tv_example_item);
                tvExampleItem.setText(data.getName());
            }

            @Override
            public void onFirstItemClicked(ExampleModel data) {
                showToast(data.getName() + " 1");
            }

            @Override
            public void onFirstItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " First");
            }

            @Override
            public void setupSecondInitComponent(@NotNull View view, ExampleModel data) {
                TextView tvExampleItem = findViewById(R.id.tv_example_item);
                tvExampleItem.setText(data.getName());
            }

            @Override
            public void onSecondItemClicked(ExampleModel data) {
                showToast(data.getName() + " 2");
            }

            @Override
            public void onSecondItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " Second");
            }
        };

        recyclerView.injector()
                .addData(listData())
                .addMultiCustomView(listLayout())
                .addMultiOptionHolder(listOption())
                .addMultiCallback(frogoMultiAdapterCallback)
                .createLayoutLinearVertical(false)
                .createMultiAdapter()
                .build(recyclerView);
    }


}
