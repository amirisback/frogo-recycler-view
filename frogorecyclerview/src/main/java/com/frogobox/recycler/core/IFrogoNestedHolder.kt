package com.frogobox.recycler.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/*
 * Created by Amir on 03/03/2021
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFrogoNestedHolder<T> {

    // Setup Nested Custom View
    fun nestedCustomView() : Int

    // Setup Nested Listener
    fun nestedListener() : FrogoRecyclerViewListener<T>

    // Setup Nested Callback
    fun nestedCallback() : IFrogoViewHolder<T>

}