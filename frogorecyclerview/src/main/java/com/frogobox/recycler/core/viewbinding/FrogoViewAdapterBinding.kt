package com.frogobox.recycler.core.viewbinding

import android.view.ViewGroup
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
 * com.frogobox.recycler.boilerplate
 * 
 */
class FrogoViewAdapterBinding<T, V : ViewBinding>(
    private val frogoViewHolderBindingCallback: FrogoViewHolderBindingCallback<T, V>
) : FrogoRecyclerViewAdapterBinding<T, V>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoViewHolderBinding<T, V> {
        return FrogoViewHolderBinding(viewLayout(parent), frogoViewHolderBindingCallback)
    }



}