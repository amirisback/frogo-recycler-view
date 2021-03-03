package com.frogobox.recycler.dev

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.core.FrogoRecyclerViewAdapter
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.IFrogoViewHolder

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
class FrogoOuterAdapter<T> : FrogoRecyclerViewAdapter<T>() {

    private val listPosition = HashMap<Int, Int>()
    private var sharedPool = RecyclerView.RecycledViewPool()

    private var nestedLayoutRestId: Int = 0
    private var nestedViewListener: FrogoRecyclerViewListener<T>? = null
    private val nestedListData = mutableListOf<T>()

    private var nestedCallback : IFrogoViewHolder<T>? = null

    fun setupNestedRequirement(customViewId: Int, data: List<T>?, listener: FrogoRecyclerViewListener<T>?) {
        this.nestedLayoutRestId = customViewId
        this.nestedViewListener = listener
        data?.let { nestedListData.addAll(it) }
    }

    fun setupNestedCallback(callback: IFrogoViewHolder<T>?) {
        this.nestedCallback = callback
    }

    override fun onViewRecycled(holder: FrogoRecyclerViewHolder<T>) {
        val position = holder.adapterPosition
        val cellViewHolder = holder as FrogoOuterHolder<T>
        val firstVisiblePosition = cellViewHolder.getLinearLayoutManager().findFirstVisibleItemPosition()
        listPosition[position] = firstVisiblePosition
        super.onViewRecycled(holder)
    }

    override fun getItemCount(): Int {
        return listDataNested.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrogoRecyclerViewHolder<T> {
        val innerRv = RecyclerView(parent.context)

        // inflate inner item, find innerRecyclerView by ID…
        val innerLLM = LinearLayoutManager(parent.context, LinearLayoutManager.HORIZONTAL, false)
        innerLLM.initialPrefetchItemCount = 7 // depends on screen size
        innerRv.apply {
            setHasFixedSize(true)
            layoutManager = innerLLM
            setRecycledViewPool(sharedPool)
        }
        return FrogoOuterHolder(innerRv)
    }


    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        when (holder.itemViewType) {
            else -> {
                val cellViewHolder = holder as FrogoOuterHolder<T>
                this.nestedCallback?.let { cellViewHolder.setupCallback(it) }
                cellViewHolder.setupRequirement(nestedLayoutRestId, nestedListData, nestedViewListener)
                val p = if (listPosition.containsKey(position) && listPosition[position]!! >= 0) {
                    listPosition[position]!!
                } else {
                    0
                }
                cellViewHolder.getLinearLayoutManager().scrollToPositionWithOffset(p, 0)
            }
        }
    }


}