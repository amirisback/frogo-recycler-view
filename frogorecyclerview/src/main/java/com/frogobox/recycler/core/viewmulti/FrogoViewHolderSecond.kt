package com.frogobox.recycler.core.viewmulti

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
 * com.frogobox.recycler.holder
 * 
 */
class FrogoViewHolderSecond<T>(
    view: View,
    private val frogoViewHolderMultiCallback: IFrogoViewHolderMulti<T>
) :
    FrogoRecyclerViewHolderMulti<T>(view) {

    override fun initComponent(data: T) {
        frogoViewHolderMultiCallback.setupInitComponent(itemView, data)
    }

}