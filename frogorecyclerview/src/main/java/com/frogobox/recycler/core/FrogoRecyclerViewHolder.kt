package com.frogobox.recycler.core

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

abstract class FrogoRecyclerViewHolder<T>(view: View) : CoreFrogoRecyclerViewHolder<T>(view) {

    abstract fun initComponent(
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) // component view

    open fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    open fun bindItem(
        data: T?,
        position: Int,
        viewListener: FrogoRecyclerViewListener<T>?,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
        if (data != null) {
            onItemViewClicked(data, position, viewListener, notifyListener)
            initComponent(data, position, notifyListener)
        }
    }

    open fun onItemViewClicked(
        data: T?,
        position: Int,
        viewListener: FrogoRecyclerViewListener<T>?,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
        itemView.setOnClickListener {
            if (data != null) {
                viewListener?.onItemClicked(itemView, data, position, notifyListener)
            }
        }
        itemView.setOnLongClickListener {
            if (data != null) {
                viewListener?.onItemLongClicked(itemView, data, position, notifyListener)
            }
            true
        }
    }

}