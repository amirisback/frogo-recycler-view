package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
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

class FrogoBindingAdapter<T, VB : ViewBinding> : FrogoRecyclerBindingAdapter<T, VB>() {

    private var frogoViewHolderCallback: IFrogoBindingHolder<T, VB>? = null

    fun setCallback(callback: IFrogoBindingHolder<T, VB>) {
        frogoViewHolderCallback = callback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerBindingHolder<T, VB> {
        return FrogoBindingHolder(frogoViewHolderCallback!!.setViewBinding(parent), frogoViewHolderCallback)
    }
}