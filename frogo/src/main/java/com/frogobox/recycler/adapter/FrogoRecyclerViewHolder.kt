package com.frogobox.recycler.adapter

import android.view.View
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
abstract class FrogoRecyclerViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    open fun bindItem(data: T, listener: FrogoRecyclerViewListener<T>?){
        onItemViewClicked(data, listener)
        initComponent(data)
    }

    protected fun onItemViewClicked(data: T, listener: FrogoRecyclerViewListener<T>?){
        itemView.setOnClickListener {
            listener?.onItemClicked(data)
        }
        itemView.setOnLongClickListener {
            listener?.onItemLongClicked(data)
            true
        }
    }

    open fun initComponent(data: T){
        // component view
    }

}