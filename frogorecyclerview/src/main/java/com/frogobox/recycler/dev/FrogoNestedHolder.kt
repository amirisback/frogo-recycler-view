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
class FrogoNestedHolder<T>(
    private val recyclerView: RecyclerView,
    private val frogoNestedHolderCallback: IFrogoNestedHolder<T>?
) : FrogoRecyclerViewHolder<T>(recyclerView) {

    fun getLinearLayoutManager(): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindView(
        customViewId: Int,
        list: MutableList<T>,
        listener: FrogoRecyclerViewListener<T>,
        callback: IFrogoViewHolder<T>
    ) {
        val mAdapter = FrogoViewAdapter<T>()
        mAdapter.setCallback(callback)
        mAdapter.setupRequirement(customViewId, list, listener)
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled = false

        //optional
        FrogoStartSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun initComponent(data: T) {
        frogoNestedHolderCallback?.setupInitComponent(recyclerView, data)
    }
}

