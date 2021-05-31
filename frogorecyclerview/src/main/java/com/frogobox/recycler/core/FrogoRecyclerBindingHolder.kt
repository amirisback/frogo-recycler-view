package com.frogobox.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
abstract class FrogoRecyclerBindingHolder<T, VB : ViewBinding>(private val view: VB) :
    RecyclerView.ViewHolder(view.root) {

    abstract fun initComponent(data: T) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(data: T?, listener: FrogoRecyclerViewListener<T>?) {
        if (data != null) {
            onItemViewClicked(data, listener)
            initComponent(data)
        }
    }

    private fun onItemViewClicked(data: T?, listener: FrogoRecyclerViewListener<T>?) {
        view.root.setOnClickListener {
            if (data != null) {
                listener?.onItemClicked(data)
            }
        }
        view.root.setOnLongClickListener {
            if (data != null) {
                listener?.onItemLongClicked(data)
            }
            true
        }
    }

}