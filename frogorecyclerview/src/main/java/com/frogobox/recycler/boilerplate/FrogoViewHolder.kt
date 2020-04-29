package com.frogobox.recycler.boilerplate

import android.view.View
import com.frogobox.recycler.base.FrogoRecyclerViewHolder
import com.frogobox.recycler.boilerplate.callback.FrogoViewHolderCallback

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
 * com.frogobox.recycler
 * 
 */
class FrogoViewHolder<T>(view: View, private val frogoViewHolderCallback: FrogoViewHolderCallback<T>) :
    FrogoRecyclerViewHolder<T>(view) {

    override fun initComponent(data: T) {
        frogoViewHolderCallback.setupInitComponent(itemView, data)
    }

}