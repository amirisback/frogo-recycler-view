package com.frogobox.recycler.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.base.views.FrogoRecyclerViewHolderInterface

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
abstract class FrogoRecyclerViewHolder<T>(view: View) : RecyclerView.ViewHolder(view),
    FrogoRecyclerViewHolderInterface<T> {

    override fun bindItem(data: T?, listener: FrogoRecyclerViewListener<T>?) {
        if (data != null) {
            onItemViewClicked(data, listener)
        }
        if (data != null) {
            initComponent(data)
        }
    }

    override fun onItemViewClicked(data: T?, listener: FrogoRecyclerViewListener<T>?) {
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

    abstract override fun initComponent(data: T) // component view

}