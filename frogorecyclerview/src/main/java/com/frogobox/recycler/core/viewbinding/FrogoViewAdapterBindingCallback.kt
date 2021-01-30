package com.frogobox.recycler.core.viewbinding

import android.view.View
import androidx.viewbinding.ViewBinding

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
interface FrogoViewAdapterBindingCallback<T, V: ViewBinding> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(viewBinding: V, data: T)

    // Setup item clicked
    fun onItemClicked(data: T)

    // Setup item long clicked
    fun onItemLongClicked(data: T)

}