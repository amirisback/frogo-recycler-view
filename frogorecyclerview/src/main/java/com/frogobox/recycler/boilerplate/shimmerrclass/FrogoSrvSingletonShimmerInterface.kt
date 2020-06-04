package com.frogobox.recycler.boilerplate.shimmerrclass

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
 
interface FrogoSrvSingletonShimmerInterface {

    fun initSingleton(frogoShimmerRecyclerView: FrogoRecyclerView): FrogoSrvSingletonShimmer

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingletonShimmer

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingletonShimmer

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingletonShimmer

    fun createLayoutGrid(spanCount: Int): FrogoSrvSingletonShimmer

    fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingletonShimmer

    fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingletonShimmer

    fun build(): FrogoSrvSingletonShimmer

}