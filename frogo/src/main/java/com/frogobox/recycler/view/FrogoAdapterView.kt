package com.frogobox.recycler.view

import com.frogobox.recycler.adapter.FrogoRecyclerViewListener

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
interface FrogoAdapterView<T> {

    fun setupRequirement(viewListener: FrogoRecyclerViewListener<T>?, dataList: List<T>?, layoutItem: Int?)
    fun setupEmptyView(emptyView: Int?)

}