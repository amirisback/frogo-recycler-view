package com.frogobox.recycler.base.parent

import android.view.View
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
abstract class ParentFrogoRecyclerViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    fun bindItem(data: T?, listener: FrogoRecyclerViewListener<T>?) {
        if (data != null) {
            onItemViewClicked(data, listener)
        }
        if (data != null) {
            initComponent(data)
        }
    }

    fun onItemViewClicked(data: T?, listener: FrogoRecyclerViewListener<T>?) {
        itemView.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(data)
            }
        }
        itemView.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(data)
            }
            true
        }
    }

    abstract fun initComponent(data: T) // component view

}