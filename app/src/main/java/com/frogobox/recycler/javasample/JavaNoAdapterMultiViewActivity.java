package com.frogobox.recycler.javasample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.frogobox.recycler.widget.FrogoRecyclerView;
import com.frogobox.recycler.R;
import com.frogobox.recycler.core.BaseActivity;
import com.frogobox.recycler.adapter.callback.IFrogoViewAdapterMulti;
import com.frogobox.recycler.model.ExampleModel;
import com.frogobox.recycler.util.Constant;
import com.frogobox.recycler.core.FrogoRvConstant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaNoAdapterMultiViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activityFrogoRvListBinding.getRoot());
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
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST);
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND);
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND);
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
        FrogoRecyclerView frogoRecyclerView = activityFrogoRvListBinding.frogoRecyclerView;

    }


}
