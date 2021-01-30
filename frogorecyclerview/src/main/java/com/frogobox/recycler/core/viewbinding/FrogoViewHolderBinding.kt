package com.frogobox.recycler.core.viewbinding

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
class FrogoViewHolderBinding<T, V : ViewBinding>(private val viewBinding: V, private val frogoViewHolderBindingCallback: FrogoViewHolderBindingCallback<T, V>
) : FrogoRecyclerViewHolderBinding<T, V>(viewBinding) {

    override fun initComponent(data: T) {
        frogoViewHolderBindingCallback.setupInitComponent(viewBinding, data)
    }

}