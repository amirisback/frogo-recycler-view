package com.frogobox.recycler.core.viewshimmer

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
 
interface IFrogoSrvSingleShimmer {

    fun initSingleton(frogoShimmerRecyclerView: FrogoRecyclerView): FrogoSrvSingleShimmer

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingleShimmer

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingleShimmer

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingleShimmer

    fun createLayoutGrid(spanCount: Int): FrogoSrvSingleShimmer

    fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingleShimmer

    fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingleShimmer

    fun build(): FrogoSrvSingleShimmer

}