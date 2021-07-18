package com.frogobox.recycler.widget

import com.frogobox.recycler.core.FrogoSingleRv

/*
 * Created by faisalamir on 09/05/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoProgressRecyclerView {

    // Setup RvSingletonRecycler
    fun <T> defineRecyclerView(): FrogoSingleRv<T>

    // Show Progress View
    fun showProgress()

    // Hide Progress View
    fun hideProgress()

}