package com.frogobox.recycler.boilerplate.viewbinding

import android.view.ViewGroup
import com.frogobox.recycler.base.parent.ParentFrogoRecyclerViewHolder
import com.frogobox.recycler.base.viewbinding.FrogoRecylcerViewAdapterBinding

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
class FrogoViewAdapterBinding<T>(
    private val frogoViewHolderBindingCallback: FrogoViewHolderBindingCallback<T>
) :
    FrogoRecylcerViewAdapterBinding<T>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParentFrogoRecyclerViewHolder<T> {
        return FrogoViewHolderBinding(viewLayout(), frogoViewHolderBindingCallback)
    }


}