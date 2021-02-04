package com.frogobox.recycler.core

/*
 * Created by Faisal Amir on 04/02/2021
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
data class FrogoHolder<T>(
    val data: T,
    val layoutResId: Int,
    val option: Int,
    val callback: IFrogoViewHolder<T>,
    val listener: FrogoRecyclerViewListener<T>

)