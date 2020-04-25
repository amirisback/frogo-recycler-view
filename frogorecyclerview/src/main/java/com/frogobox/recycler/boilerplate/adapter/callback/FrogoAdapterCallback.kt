package com.frogobox.recycler.boilerplate.adapter.callback

import android.view.View

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 14/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.callback
 * 
 */
interface FrogoAdapterCallback<T> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(view: View, data: T)

    // Setup item clicked
    fun onItemClicked(data: T)

    // Setup item long clicked
    fun onItemLongClicked(data: T)

}