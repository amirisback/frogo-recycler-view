package com.frogobox.recycler.core.viewshimmer

import com.frogobox.recycler.core.viewrclass.IFrogoViewAdapter
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir on 04/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */
 
interface IFrogoSrvSingleRecycler<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSrvSingleRecycler<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingleRecycler<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingleRecycler<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingleRecycler<T>

    fun createLayoutGrid(spanCount: Int): FrogoSrvSingleRecycler<T>

    fun addData(listData: List<T>): FrogoSrvSingleRecycler<T>

    fun addCustomView(customViewInt: Int): FrogoSrvSingleRecycler<T>

    fun addEmptyView(emptyViewInt: Int?): FrogoSrvSingleRecycler<T>

    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSrvSingleRecycler<T>

    fun build(): FrogoSrvSingleRecycler<T>
    
}