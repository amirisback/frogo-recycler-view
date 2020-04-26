package com.frogobox.recycler.boilerplate.holder

import android.view.View
import com.frogobox.recycler.base.holder.FrogoRecyclerViewHolder
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback

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
 * com.frogobox.recycler.boilerplate.holder
 * 
 */
class FrogoViewHolderSecond<T>(view: View, private val frogoHolderCallback: FrogoHolderCallback<T>) :
    FrogoRecyclerViewHolder<T>(view) {

    override fun initComponent(data: T) {
        frogoHolderCallback.setupInitComponent(itemView, data)
    }

}