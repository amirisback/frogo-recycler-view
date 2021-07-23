package com.frogobox.recycler.widget

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.FrogoBuilderRvListener
import com.frogobox.recycler.core.FrogoSingleRvBinding
import com.frogobox.recycler.core.FrogoSingleRv

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 31/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.recycler.view
 *
 */

interface IFrogoRecyclerView {

    // Setup linear vertical recycler view
    fun isViewLinearVertical(dividerItem: Boolean)

    // Setup linear horizontal recycler view
    fun isViewLinearHorizontal(dividerItem: Boolean)

    // Setup staggered grid recycler view
    fun isViewStaggeredGrid(spanCount: Int)

    // Setup grid recycler view
    fun isViewGrid(spanCount: Int)

    // Setup SingletonRclass
    fun <T> injector(): FrogoSingleRv<T>

    // Setup Singleton ViewBinding Class
    fun <T, VB : ViewBinding> injectorBinding(): FrogoSingleRvBinding<T, VB>

    // Setup Builder
    fun <T> builder(listener: FrogoBuilderRvListener<T>)

}