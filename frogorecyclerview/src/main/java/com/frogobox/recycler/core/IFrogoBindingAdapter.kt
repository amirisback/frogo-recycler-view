package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

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
 * com.frogobox.recycler.callback
 * 
 */
interface IFrogoBindingAdapter<T, VB : ViewBinding> : FrogoDiffUtilCallback<T> {

    // Setup View Binding
    fun setViewBinding(parent: ViewGroup): VB

    // Setup Init Component on ViewHolder
    fun setupInitComponent(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )

    // Setup item clicked
    fun onItemClicked(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )

    // Setup item long clicked
    fun onItemLongClicked(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
    }

}