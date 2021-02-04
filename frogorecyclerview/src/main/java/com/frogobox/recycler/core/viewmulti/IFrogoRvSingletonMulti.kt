package com.frogobox.recycler.core.viewmulti

import com.frogobox.recycler.widget.FrogoRecyclerView
import com.frogobox.recycler.adapter.callback.IFrogoViewAdapterMulti

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
 * com.frogobox.recycler.singleton
 * 
 */
interface IFrogoRvSingletonMulti<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonMulti<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonMulti<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonMulti<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonMulti<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonMulti<T>

    fun addData(listData: List<T>): FrogoRvSingletonMulti<T>

    fun addCustomView(listCustomViewInt: List<Int>): FrogoRvSingletonMulti<T>

    fun addOptionHolder(listOptionHolder: List<Int>): FrogoRvSingletonMulti<T>
    
    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingletonMulti<T>

    fun addCallback(frogoViewAdapterMultiCallback: IFrogoViewAdapterMulti<T>): FrogoRvSingletonMulti<T>

    fun build(): FrogoRvSingletonMulti<T>
    
}