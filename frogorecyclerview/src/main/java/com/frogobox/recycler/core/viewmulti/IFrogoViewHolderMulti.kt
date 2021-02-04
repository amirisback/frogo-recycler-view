package com.frogobox.recycler.core.viewmulti

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
 * com.frogobox.recycler.multiview
 * 
 */
interface IFrogoViewHolderMulti<T> {

    // Setup Init Component on ViewHolder
    fun setupInitComponent(view: View, data: T)

}