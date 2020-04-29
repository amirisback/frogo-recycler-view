package com.frogobox.recycler.boilerplate.viewbinding

import androidx.viewbinding.ViewBinding

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.boilerplate.callback
 * 
 */
interface FrogoViewHolderBindingCallback<T, V : ViewBinding> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(viewBinding: V, data: T)

}