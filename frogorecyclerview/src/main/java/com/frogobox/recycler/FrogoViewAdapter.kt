package com.frogobox.recycler

import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.adapter.FrogoRecyclerViewAdapter
import com.frogobox.recycler.adapter.FrogoRecyclerViewHolder
import com.frogobox.recycler.callback.FrogoHolderCallback

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
 * com.frogobox.recycler.content
 * 
 */
class FrogoViewAdapter<T>(private val frogoHolderCallback: FrogoHolderCallback<T>) :
    FrogoRecyclerViewAdapter<T>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<T> {
        return KotlinSampleViewHolder(viewLayout(parent), frogoHolderCallback)
    }

    inner class KotlinSampleViewHolder(
        view: View,
        private val frogoHolderCallback: FrogoHolderCallback<T>
    ) :
        FrogoRecyclerViewHolder<T>(view) {

        override fun initComponent(data: T) {
            super.initComponent(data)
            frogoHolderCallback.setupInitComponent(itemView, data)
        }
    }

}