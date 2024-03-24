package com.frogobox.recycler.core

import android.view.View

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
interface FrogoRecyclerViewListener<T> : FrogoDiffUtilCallback<T> {

    // on itemview set on click listener
    fun onItemClicked(view: View, data: T, position: Int, notifyListener: FrogoRecyclerNotifyListener<T>)

    // on itemview set on long click listener
    fun onItemLongClicked(
        view: View,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {}

}