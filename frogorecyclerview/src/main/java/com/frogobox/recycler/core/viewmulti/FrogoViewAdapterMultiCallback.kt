package com.frogobox.recycler.adapter.callback

import android.view.View

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
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
interface FrogoViewAdapterMultiCallback<T> {

    // Setup First Init Component on ViewHolder
    fun setupFirstInitComponent(view: View, data: T)

    // Setup Second Init Component on ViewHolder
    fun setupSecondInitComponent(view: View, data: T)

    // Setup first item clicked
    fun onFirstItemClicked(data: T)

    // Setup first item long clicked
    fun onFirstItemLongClicked(data: T)

    // Setup second item clicked
    fun onSecondItemClicked(data: T)

    // Setup second item long clicked
    fun onSecondItemLongClicked(data: T)

}