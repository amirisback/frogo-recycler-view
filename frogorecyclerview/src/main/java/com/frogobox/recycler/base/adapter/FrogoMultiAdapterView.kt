package com.frogobox.recycler.base.adapter

import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.base.listener.FrogoRecyclerViewListener

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 14/01/2020.
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
interface FrogoMultiAdapterView<T> {

    // Setup adapter requirement
    fun setupRequirement(
        dataList: List<T>?,
        layoutItemList: List<Int>,
        optionHolder: List<Int>,
        firstViewListener: FrogoRecyclerViewListener<T>?,
        secondViewListener: FrogoRecyclerViewListener<T>?
    )

    // Setup empty view for layout
    fun setupEmptyView(emptyView: Int?)

    // Setup view layout
    fun viewLayout(parent: ViewGroup, position: Int): View

}