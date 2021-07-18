package com.frogobox.recycler.core

import androidx.viewbinding.ViewBinding

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
class FrogoBindingHolder<T, VB : ViewBinding>(
    private val binding: VB,
    private val frogoViewHolderCallback: IFrogoBindingHolder<T, VB>?
) :
    FrogoRecyclerBindingHolder<T, VB>(binding) {

    override fun initComponent(data: T) {
        frogoViewHolderCallback?.setupInitComponent(binding, data)
    }

}