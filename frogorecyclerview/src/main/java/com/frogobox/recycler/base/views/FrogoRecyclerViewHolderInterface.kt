package com.frogobox.recycler.base.views

import com.frogobox.recycler.base.FrogoRecyclerViewListener

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
interface FrogoRecyclerViewHolderInterface<T> {

    // bind item data
    fun bindItem(data: T?, listener: FrogoRecyclerViewListener<T>?)

    // setup on item view clicked
    fun onItemViewClicked(data: T?, listener: FrogoRecyclerViewListener<T>?)

    // Initiation all component
    fun initComponent(data: T)

}