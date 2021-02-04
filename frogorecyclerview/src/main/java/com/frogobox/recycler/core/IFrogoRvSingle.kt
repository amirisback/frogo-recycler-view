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

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingle<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingle<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingle<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingle<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingle<T>

    fun addData(listData: List<T>): FrogoRvSingle<T>

    fun addCustomView(customViewInt: Int): FrogoRvSingle<T>

    fun addEmptyView(emptyViewInt: Int?): FrogoRvSingle<T>

    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoRvSingle<T>

    fun build(): FrogoRvSingle<T>

}