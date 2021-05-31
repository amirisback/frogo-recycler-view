package com.frogobox.recycler.core

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
interface IFrogoSingleRv<T> {

    // Init FrogoRecyclerView
    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRv<T>
    
    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRv<T>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRv<T>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRv<T>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): FrogoSingleRv<T>
    
    // Adding Data for RecyclerView
    fun addData(listData: List<T>): FrogoSingleRv<T>

    // Adding Data with object ViewHolder
    fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoSingleRv<T>

    // Adding Custom View for RecyclerView
    fun addCustomView(customViewInt: Int): FrogoSingleRv<T>

    // Adding Empty View layout if data is Empty
    fun addEmptyView(emptyViewInt: Int?): FrogoSingleRv<T>

    // Adding Callback for adapter
    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSingleRv<T>

    // Build this FrogoRecyclerView
    fun build(): FrogoSingleRv<T>

}