package com.frogobox.recycler.dev

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.core.*

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
class FrogoOuterHolder (val rv: RecyclerView) : RecyclerView.ViewHolder(rv) {

    fun getLinearLayoutManager(): LinearLayoutManager {
        return rv.layoutManager as LinearLayoutManager
    }

    fun bindView(customViewId: Int, list: MutableList<Int>, listener: FrogoRecyclerViewListener<Int>, callback: IFrogoViewHolder<Int>) {
        val mAdapter = FrogoViewAdapter<Int>()
        mAdapter.setCallback(callback)
        mAdapter.setupRequirement(customViewId, list, listener)
        rv.adapter = mAdapter
        rv.isNestedScrollingEnabled = false

        //optional
        FrogoStartSnapHelper().attachToRecyclerView(rv)
    }

}

