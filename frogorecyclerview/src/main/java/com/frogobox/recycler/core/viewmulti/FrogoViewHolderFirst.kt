package com.frogobox.recycler.core.viewmulti

import android.view.View
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.frogobox.recycler.core.IFrogoViewHolder

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
class FrogoViewHolderFirst<T>(
    view: View,
    private val frogoViewHolderCallback: IFrogoViewHolder<T>
) :
    FrogoRecyclerViewHolder<T>(view) {

    override fun initComponent(data: T) {
        frogoViewHolderCallback.setupInitComponent(itemView, data)
    }

}