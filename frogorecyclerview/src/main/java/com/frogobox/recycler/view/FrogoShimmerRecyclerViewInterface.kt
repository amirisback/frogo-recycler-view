package com.frogobox.recycler.view

import com.frogobox.recycler.boilerplate.shimmerrclass.FrogoSrvSingleton
import com.frogobox.recycler.boilerplate.viewrclass.FrogoRvSingletonRclass

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
 
interface FrogoShimmerRecyclerViewInterface {

    // Setup SingletonSrv
    fun <T> injector(): FrogoSrvSingleton<T>

    // Start Shimmer Animation
    fun startShimmer()

    // Stop Shimmer Animation
    fun stopShimmer()

}