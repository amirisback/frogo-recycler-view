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
interface IFrogoRvSingle<T> {

    // Init FrogoRecyclerView
    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingle<T>

    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingle<T>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoRvSingle<T>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingle<T>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoRvSingle<T>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingle<T>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): FrogoRvSingle<T>

    // Adding Data for RecyclerView
    fun addData(listData: List<T>): FrogoRvSingle<T>

    // Adding Data with object ViewHolder
    fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoRvSingle<T>

    // Adding Custom View for RecyclerView
    fun addCustomView(customViewInt: Int): FrogoRvSingle<T>

    // Adding Empty View layout if data is Empty
    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingle<T>

    // Adding Callback for adapter
    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoRvSingle<T>

    // Build this FrogoRecyclerView
    fun build(): FrogoRvSingle<T>

}