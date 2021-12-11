package com.frogobox.recycler.core

import android.util.Log
import android.view.View
import android.view.ViewGroup

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 14/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.content
 * 
 */
class FrogoViewAdapter<T> : FrogoRecyclerViewAdapter<T>() {

    private var frogoViewHolderCallback: IFrogoViewHolder<T>? = null

    fun setCallback(callback: IFrogoViewHolder<T>) {
        frogoViewHolderCallback = callback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<T> {
        return if (hasMultiHolder) {
            if (frogoHolder.isNotEmpty()) {
                FrogoViewHolder(viewLayout(parent, frogoHolder[viewType].layoutResId), frogoHolder[viewType].callback)
            } else {
                FrogoViewHolder(viewLayout(parent, emptyLayoutResId), object : IFrogoViewHolder<T>{
                    override fun setupInitComponent(
                        view: View,
                        data: T,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<T>
                    ) {}
                })
            }
        } else {
            FrogoViewHolder(viewLayout(parent), frogoViewHolderCallback)
        }
    }
}