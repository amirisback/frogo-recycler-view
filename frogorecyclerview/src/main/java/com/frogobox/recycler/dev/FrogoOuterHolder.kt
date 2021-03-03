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
class FrogoOuterHolder<T>(val rv: RecyclerView) : FrogoRecyclerViewHolder<T>(rv) {

    val mAdapter = FrogoViewAdapter<T>()

    fun setupCallback(callback: IFrogoViewHolder<T>) {
        mAdapter.setCallback(callback)
    }

    fun setupRequirement(customViewId: Int, data: List<T>?, listener: FrogoRecyclerViewListener<T>?) {
        mAdapter.setupRequirement(customViewId, data, listener)
    }

    fun getLinearLayoutManager(): LinearLayoutManager {
        return rv.layoutManager as LinearLayoutManager
    }

    override fun initComponent(data: T) {

        rv.apply {
            adapter = mAdapter
            isNestedScrollingEnabled = false
        }
        FrogoStartSnapHelper().attachToRecyclerView(rv)
    }
}

