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
interface IFrogoRvMultiSingle<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvMultiSingle<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvMultiSingle<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvMultiSingle<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvMultiSingle<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvMultiSingle<T>

    fun addData(listData: List<T>): FrogoRvMultiSingle<T>

    fun addCustomView(listCustomViewInt: List<Int>): FrogoRvMultiSingle<T>

    fun addOptionHolder(listOptionHolder: List<Int>): FrogoRvMultiSingle<T>
    
    fun addEmptyView(emptyViewInt: Int?): FrogoRvMultiSingle<T>

    fun addCallback(frogoViewAdapterMultiCallback: IFrogoViewAdapterMulti<T>): FrogoRvMultiSingle<T>

    fun build(): FrogoRvMultiSingle<T>
    
}