package com.frogobox.recycler.core

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/*
 * Created by faisalamir on 24/07/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoBuilderRvBinding<T, VB : ViewBinding> {

    // Setup data FrogoRecyclerView
    fun setupData(): List<T>

    // Setup Layout Manager of FrogoRecyclerView
    fun setupLayoutManager(context: Context): RecyclerView.LayoutManager

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
    )

}