package com.frogobox.recycler.core.viewshimmer

import com.frogobox.recycler.core.viewrclass.IFrogoViewAdapter
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir on 03/06/2020
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

interface IFrogoSrvSingle<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView, frogoShimmerRecyclerView: FrogoRecyclerView): FrogoSrvSingle<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingle<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingle<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingle<T>

    fun createLayoutGrid(spanCount: Int): FrogoSrvSingle<T>

    fun addData(listData: List<T>): FrogoSrvSingle<T>

    fun addCustomView(customViewInt: Int): FrogoSrvSingle<T>

    fun addEmptyView(emptyViewInt: Int?): FrogoSrvSingle<T>

    fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSrvSingle<T>

    fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingle<T>

    fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingle<T>

    fun build(): FrogoSrvSingle<T>
    
}