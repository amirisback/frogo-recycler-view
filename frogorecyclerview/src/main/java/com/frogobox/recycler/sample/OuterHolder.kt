package com.frogobox.recycler.sample

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.FrogoStartSnapHelper

/*
 * Created by Amir on 03/03/2021
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class OuterHolder (val rv: RecyclerView, listener: FrogoRecyclerViewListener<Int>) : RecyclerView.ViewHolder(rv) {

    private var mAdapter = InnerAdapter(listener)

    fun getLinearLayoutManager(): LinearLayoutManager {
        return rv.layoutManager as LinearLayoutManager
    }

    fun setData(list: MutableList<Int>) {
        mAdapter.setupData(list)
    }

    init {
        rv.apply {
            adapter = mAdapter

            // this is needed if you are working with CollapsingToolbarLayout, I am adding this here just in case I forget.
            isNestedScrollingEnabled = false
        }

        //optional
        FrogoStartSnapHelper().attachToRecyclerView(rv)
    }
}