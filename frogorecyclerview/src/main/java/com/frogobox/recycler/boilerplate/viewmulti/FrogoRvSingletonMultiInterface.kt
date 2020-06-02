package com.frogobox.recycler.boilerplate.viewmulti

import com.frogobox.recycler.widget.FrogoRecyclerView
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoViewAdapterMultiCallback

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.boilerplate.singleton
 * 
 */
interface FrogoRvSingletonMultiInterface<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonMulti<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonMulti<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonMulti<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonMulti<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonMulti<T>

    fun setupLayoutManager()

    fun addData(listData: List<T>): FrogoRvSingletonMulti<T>

    fun addCustomView(listCustomViewInt: List<Int>): FrogoRvSingletonMulti<T>

    fun addOptionHolder(listOptionHolder: List<Int>): FrogoRvSingletonMulti<T>
    
    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingletonMulti<T>

    fun addCallback(frogoViewAdapterMultiCallback: FrogoViewAdapterMultiCallback<T>): FrogoRvSingletonMulti<T>

    fun build(): FrogoRvSingletonMulti<T>
    
}