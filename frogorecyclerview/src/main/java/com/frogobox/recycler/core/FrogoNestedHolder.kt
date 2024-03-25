package com.frogobox.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
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

    fun bindNestedItem(data: MutableList<T>) {
        val mAdapter = FrogoViewAdapter<T>()
        mAdapter.setCallback(frogoNestedHolderCallback!!.nestedCallback())
        mAdapter.setupRequirement(
            frogoNestedHolderCallback.nestedCustomView(),
            data,
            frogoNestedHolderCallback.nestedListener()
        )
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled = false
        FrogoStartSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun initComponent(
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
    }
}

