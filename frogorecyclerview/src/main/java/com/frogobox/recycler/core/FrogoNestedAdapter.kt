package com.frogobox.recycler.core


import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
class FrogoNestedAdapter<T> : FrogoRecyclerViewAdapter<T>() {

    private var frogoNestedHolderCallback: IFrogoNestedHolder<T>? = null

    fun setCallback(callback: IFrogoNestedHolder<T>) {
        frogoNestedHolderCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrogoRecyclerViewHolder<T> {
        val innerRv = RecyclerView(parent.context)

        // inflate inner item, find innerRecyclerView by ID
        val innerLLM = LinearLayoutManager(parent.context, LinearLayoutManager.HORIZONTAL, false)
        innerLLM.initialPrefetchItemCount = 7 // depends on screen size
        innerRv.apply {
            setHasFixedSize(true)
            layoutManager = innerLLM
            setRecycledViewPool(sharedPool)
        }
        return FrogoNestedHolder(innerRv, frogoNestedHolderCallback)
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        val nestedHolder = holder as FrogoNestedHolder<T>
        val p = if (listPosition.containsKey(position) && listPosition[position]!! >= 0) {
            listPosition[position]!!
        } else {
            0
        }
        nestedHolder.bindNestedItem(listDataNested[position])
        nestedHolder.getLinearLayoutManager().scrollToPositionWithOffset(p, 0)
    }

}