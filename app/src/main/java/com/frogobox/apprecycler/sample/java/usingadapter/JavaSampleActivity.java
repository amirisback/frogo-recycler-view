package com.frogobox.apprecycler.sample.java.usingadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.frogobox.apprecycler.core.BaseActivity;
import com.frogobox.apprecycler.model.ExampleModel;
import com.frogobox.recycler.R;
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener;
import com.frogobox.recycler.core.FrogoRecyclerViewListener;
import com.frogobox.apprecycler.databinding.ActivityFrogoRvListBinding;

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
            public void onItemLongClicked(@NonNull View view, ExampleModel data, int position, @NonNull FrogoRecyclerNotifyListener<ExampleModel> notifyListener) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClicked(@NonNull View view, ExampleModel data, int position, @NonNull FrogoRecyclerNotifyListener<ExampleModel> notifyListener) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setupEmptyView(null); // Without Custom View

        getBinding().frogoRecyclerView.setAdapter(adapter);
        getBinding().frogoRecyclerView.isViewLinearVertical(false);
    }


}
