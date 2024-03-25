package com.frogobox.recycler.core

import androidx.viewbinding.ViewBinding


/**
 * Created by faisalamir on 11/12/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface FrogoRecyclerBindingListener<T, VB : ViewBinding> : FrogoDiffUtilCallback<T> {

    // on itemview set on click listener
    fun onItemClicked(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )

    // on itemview set on long click listener
    fun onItemLongClicked(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )


}