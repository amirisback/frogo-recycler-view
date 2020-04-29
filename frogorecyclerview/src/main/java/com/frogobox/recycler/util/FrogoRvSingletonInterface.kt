package com.frogobox.recycler.util

import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback

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
interface FrogoRvSingletonInterface<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingleton<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingleton<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingleton<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingleton<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingleton<T>

    fun addEmptyView(layoutId: Int?): FrogoRvSingleton<T>

    fun addData(dataList: List<T>): FrogoRvSingleton<T>

    fun addCustomView(layoutId: Int): FrogoRvSingleton<T>

    fun addCallback(callback: FrogoViewAdapterCallback<T>): FrogoRvSingleton<T>

    fun build(): FrogoRvSingleton<T>

}