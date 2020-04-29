package com.frogobox.recycler.boilerplate.viewmulti

import android.view.View

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
 * com.frogobox.recycler.boilerplate.multiview
 * 
 */
interface FrogoViewHolderMultiCallback<T> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(view: View, data: T)

}