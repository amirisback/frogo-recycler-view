package com.frogobox.recycler.boilerplate.viewrclass

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
interface FrogoRvSingletonRclassInterface<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonRclass<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonRclass<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonRclass<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonRclass<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonRclass<T>

    fun setupLayoutManager()

    fun addData(listData: List<T>): FrogoRvSingletonRclass<T>

    fun addCustomView(customViewInt: Int): FrogoRvSingletonRclass<T>

    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingletonRclass<T>

    fun addCallback(frogoViewAdapterCallback: FrogoViewAdapterCallback<T>): FrogoRvSingletonRclass<T>

    fun build(): FrogoRvSingletonRclass<T>

}