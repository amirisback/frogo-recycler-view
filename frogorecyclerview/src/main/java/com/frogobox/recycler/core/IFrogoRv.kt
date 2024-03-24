package com.frogobox.recycler.core


/**
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

interface IFrogoRv<T> : IFrogoRvSingleton<T> {

    // Adding Data with object ViewHolder
    fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoSingleRv<T>

    // Adding Custom View for RecyclerView
    fun addCustomView(customViewInt: Int): FrogoSingleRv<T>

    // Adding Empty View layout if data is Empty
    fun addEmptyView(emptyViewInt: Int? = null): FrogoSingleRv<T>

    // Adding Callback for adapter
    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSingleRv<T>

}