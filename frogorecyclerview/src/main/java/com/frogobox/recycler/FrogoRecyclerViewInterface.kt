package com.frogobox.recycler

import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoMultiAdapterCallback
import com.frogobox.recycler.util.FrogoRvSingleton

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

interface FrogoRecyclerViewInterface {

    // Setup linear vertical recycler view
    fun isViewLinearVertical(dividerItem: Boolean)

    // Setup linear horizontal recycler view
    fun isViewLinearHorizontal(dividerItem: Boolean)

    // Setup staggered grid recycler view
    fun isViewStaggeredGrid(spanCount: Int)

    // Setup grid recycler view
    fun isViewGrid(spanCount: Int)

    // Setup Adapter
    fun <T> injectAdapter(
        customView: Int,
        listData: List<T>?,
        emptyView: Int?,
        frogoAdapterCallback: FrogoAdapterCallback<T>
    )

    // Setup Multi Adapter
    fun <T> injectMultiAdapter(
        listData: List<T>?,
        multiCustomView: List<Int>,
        multiOptionHolder: List<Int>,
        emptyView: Int?,
        callback: FrogoMultiAdapterCallback<T>
    )

    // Setup Singleton
    fun <T> injector(): FrogoRvSingleton<T>

}