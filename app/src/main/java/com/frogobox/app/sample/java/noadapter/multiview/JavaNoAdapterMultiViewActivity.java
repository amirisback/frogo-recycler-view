package com.frogobox.app.sample.java.noadapter.multiview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.frogobox.app.core.BaseActivity;
import com.frogobox.app.model.ExampleModel;
import com.frogobox.app.util.Constant;
import com.frogobox.recycler.core.FrogoHolder;
import com.frogobox.recycler.core.FrogoRecyclerViewListener;
import com.frogobox.recycler.core.IFrogoViewHolder;
import com.frogobox.recycler.R;
import com.frogobox.recycler.core.FrogoRvConstant;
import com.frogobox.app.databinding.ActivityFrogoRvGridBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaNoAdapterMultiViewActivity extends BaseActivity<ActivityFrogoRvGridBinding> {

    @NotNull
    @Override
    public ActivityFrogoRvGridBinding setupViewBinding() {
        return ActivityFrogoRvGridBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFrogoRecyclerView();
        setupDetailActivity("Java No Adapter - Multi View");
    }

    private static IFrogoViewHolder<ExampleModel> firstCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.frogo_rv_grid_type_1_tv_title);
            ImageView photo = view.findViewById(R.id.frogo_rv_grid_type_1_iv_poster);
            title.setText(data.getName());
            Glide.with(view.getContext()).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private static IFrogoViewHolder<ExampleModel> secondCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.frogo_rv_grid_type_3_tv_title);
            TextView subTitle = view.findViewById(R.id.frogo_rv_grid_type_3_tv_subtitle);
            TextView desc = view.findViewById(R.id.frogo_rv_grid_type_3_tv_desc);
            ImageView photo = view.findViewById(R.id.frogo_rv_grid_type_3_iv_poster);
            title.setText(data.getName());
            subTitle.setText(data.getName());
            desc.setText(FrogoRvConstant.DUMMY_LOREM_IPSUM);
            Glide.with(view.getContext()).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private FrogoRecyclerViewListener<ExampleModel> firstListenerType() {
        return new FrogoRecyclerViewListener<ExampleModel>() {
            @Override
            public void onItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " First");
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                showToast("LAYOUT TYPE 1");
            }
        };
    }

    private FrogoRecyclerViewListener<ExampleModel> secondListenerType() {
        return new FrogoRecyclerViewListener<ExampleModel>() {
            @Override
            public void onItemLongClicked(ExampleModel data) {
                showToast(data.getName() + " Second");
            }

            @Override
            public void onItemClicked(ExampleModel data) {
                showToast("LAYOUT TYPE 2");
            }
        };
    }

    private ArrayList<FrogoHolder<Object>> data() {
        ArrayList<FrogoHolder<Object>> data = new ArrayList<>();
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new FrogoHolder(new ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        return data;
    }

    private void setupFrogoRecyclerView() {
        getBinding().frogoRecyclerView.injector()
                .addDataFH(data())
                .createLayoutStaggeredGrid(2)
                .build();
    }


}
