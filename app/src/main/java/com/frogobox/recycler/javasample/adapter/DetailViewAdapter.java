package com.frogobox.recycler.javasample.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.frogobox.recycler.R;
import com.frogobox.recycler.adapter.FrogoRecyclerViewAdapter;
import com.frogobox.recycler.adapter.FrogoRecyclerViewHolder;
import com.frogobox.recycler.model.ExampleModel;

import org.jetbrains.annotations.NotNull;


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogorecyclerviewadapter.javasample
 */
public class DetailViewAdapter extends FrogoRecyclerViewAdapter<ExampleModel> {
    @NonNull
    @Override
    public FrogoRecyclerViewHolder<ExampleModel> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailViewHolder(parent);
    }

    class DetailViewHolder extends FrogoRecyclerViewHolder<ExampleModel> {

        private TextView tvExample = itemView.findViewById(R.id.tv_example_item);

        public DetailViewHolder(@NotNull View view) {
            super(view);
        }

        @Override
        public void initComponent(ExampleModel data) {
            super.initComponent(data);

            tvExample.setText(data.getName());

        }
    }

}
