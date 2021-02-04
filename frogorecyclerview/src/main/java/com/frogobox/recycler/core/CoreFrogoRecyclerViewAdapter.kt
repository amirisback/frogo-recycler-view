package com.frogobox.recycler.core

import androidx.recyclerview.widget.RecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base
 * 
 */
abstract class CoreFrogoRecyclerViewAdapter<T> :
    RecyclerView.Adapter<FrogoRecyclerViewHolder<T>>() {

    protected var viewListener: FrogoRecyclerViewListener<T>? = null
    protected var hasEmptyView = false

    protected val listData = mutableListOf<T>()
    protected var listCount = 0

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (listData.size == 0) {
                1
            } else {
                listData.size
            }
            listCount
        } else {
            listData.size
        }
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        if (hasEmptyView) {
            if (listData.size != 0) {
                holder.bindItem(listData[position], viewListener)
            }
        } else {
            holder.bindItem(listData[position], viewListener)
        }
    }


}