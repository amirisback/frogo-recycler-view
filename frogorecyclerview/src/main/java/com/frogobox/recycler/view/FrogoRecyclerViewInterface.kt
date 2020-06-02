package com.frogobox.recycler.view

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoViewAdapterMultiCallback
import com.frogobox.recycler.boilerplate.singleton.FrogoRvSingletonMulti
import com.frogobox.recycler.boilerplate.singleton.FrogoRvSingletonRclass
import com.frogobox.recycler.boilerplate.singleton.FrogoRvSingletonViewBinding

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

    // Setup Inject Adapter with multi type view holder
    fun <T> injectAdapterMultiType(
        listData: List<T>?,
        multiCustomView: List<Int>,
        multiOptionHolder: List<Int>,
        emptyView: Int?,
        frogoViewAdapterMultiCallback: FrogoViewAdapterMultiCallback<T>
    )

    // Setup SingletonRclass
    fun <T> injector(): FrogoRvSingletonRclass<T>

    // Setup SingletonRclass
    fun <T> injectorMulti(): FrogoRvSingletonMulti<T>

    // Setup SingletonViewBinding
    fun <T, V : ViewBinding> injectorViewBinding(): FrogoRvSingletonViewBinding<T, V>

}