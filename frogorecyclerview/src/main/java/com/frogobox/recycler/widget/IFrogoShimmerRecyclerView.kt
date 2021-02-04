package com.frogobox.recycler.widget

import com.frogobox.recycler.core.shimmer.FrogoSrvSingle
import com.frogobox.recycler.core.shimmer.FrogoSrvSingleRecycler
import com.frogobox.recycler.core.shimmer.FrogoSrvSingleShimmer

/*
 * Created by Faisal Amir on 02/06/2020
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
 
interface IFrogoShimmerRecyclerView {

    // Setup SrvSingleton
    fun <T> injector(): FrogoSrvSingle<T>

    // Setup SrvSingletonShimmer
    fun defineShimmerView(): FrogoSrvSingleShimmer

    // Setup SrvSingletonRecycler
    fun <T> defineRecyclerView(): FrogoSrvSingleRecycler<T>

    // Start Shimmer Animation
    fun startShimmer()

    // Stop Shimmer Animation
    fun stopShimmer()

}