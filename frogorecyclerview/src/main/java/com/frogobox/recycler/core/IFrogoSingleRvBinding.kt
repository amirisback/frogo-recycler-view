package com.frogobox.recycler.core

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 27/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.util
 * 
 */
interface IFrogoSingleRvBinding<T, VB : ViewBinding> {

    // Init FrogoRecyclerView
    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRvBinding<T, VB>

    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRvBinding<T, VB>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBinding<T, VB>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRvBinding<T, VB>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBinding<T, VB>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRvBinding<T, VB>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): FrogoSingleRvBinding<T, VB>

    // Adding Data for RecyclerView
    fun addData(listData: List<T>): FrogoSingleRvBinding<T, VB>

    // Adding Callback for adapter
    fun addCallback(frogoViewAdapterCallback: IFrogoBindingAdapter<T, VB>): FrogoSingleRvBinding<T, VB>

    // Build this FrogoRecyclerView
    fun build(): FrogoSingleRvBinding<T, VB>

}