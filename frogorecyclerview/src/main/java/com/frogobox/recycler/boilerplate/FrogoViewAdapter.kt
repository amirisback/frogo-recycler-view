package com.frogobox.recycler.boilerplate

import android.view.ViewGroup
import com.frogobox.recycler.base.FrogoRecyclerViewAdapter
import com.frogobox.recycler.base.FrogoRecyclerViewHolder
import com.frogobox.recycler.boilerplate.callback.FrogoViewHolderCallback

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
class FrogoViewAdapter<T>(private val frogoViewHolderCallback: FrogoViewHolderCallback<T>) :
    FrogoRecyclerViewAdapter<T>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<T> {
        return FrogoViewHolder(
            viewLayout(parent),
            frogoViewHolderCallback
        )
    }

}