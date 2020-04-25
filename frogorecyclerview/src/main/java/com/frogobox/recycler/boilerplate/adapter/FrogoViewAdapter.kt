package com.frogobox.recycler.boilerplate.adapter

import android.view.ViewGroup
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolder
import com.frogobox.recycler.base.adapter.FrogoRecyclerViewAdapter
import com.frogobox.recycler.base.holder.FrogoRecyclerViewHolder
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback

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
        return FrogoViewHolder(
            viewLayout(parent),
            frogoHolderCallback
        )
    }

}