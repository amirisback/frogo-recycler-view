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
class OuterHolder(
    private val rv: RecyclerView,
    private val listener: FrogoRecyclerViewListener<Int>
) : RecyclerView.ViewHolder(rv) {

    fun getLinearLayoutManager(): LinearLayoutManager {
        return rv.layoutManager as LinearLayoutManager
    }

    fun bindItem(list: MutableList<Int>) {
        val mAdapter = InnerAdapter(listener)
        mAdapter.setupData(list)

        rv.adapter = mAdapter
        rv.isNestedScrollingEnabled = false
        FrogoStartSnapHelper().attachToRecyclerView(rv)
    }

}