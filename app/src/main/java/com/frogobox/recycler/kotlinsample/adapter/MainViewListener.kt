package com.frogobox.recycler.kotlinsample.adapter

import com.frogobox.recycler.adapter.FrogoRecyclerViewListener
import com.frogobox.recycler.model.ExampleModel

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
 * com.frogobox.recycler.kotlinsample
 *
 */
interface MainViewListener : FrogoRecyclerViewListener<ExampleModel> {

    override fun onItemClicked(data: ExampleModel) {
        onItemClickedMain(data)
    }

    override fun onItemLongClicked(data: ExampleModel) {
        onItemLongClickedMain(data)
    }

    fun onItemClickedMain(data: ExampleModel)

    fun onItemLongClickedMain(data: ExampleModel)

}