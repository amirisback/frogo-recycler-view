package com.frogobox.recycler.javasample.adapter;

import com.frogobox.recycler.adapter.FrogoRecyclerViewListener;
import com.frogobox.recycler.model.ExampleModel;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 10/01/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.recycler.javasample
 */
public interface DetailViewListener extends FrogoRecyclerViewListener<ExampleModel> {

    @Override
    void onItemClicked(ExampleModel data);

    @Override
    void onItemLongClicked(ExampleModel data);

}
