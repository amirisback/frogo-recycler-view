package com.frogobox.recycler.ext

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.*


/*
 * Created by faisalamir on 12/04/22
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */

fun <T> RecyclerView.injector(): FrogoSingleRv<T> {
    return FrogoSingleRv<T>().initSingleton(this)
}

fun <T, VB : ViewBinding> RecyclerView.injectorBinding(): FrogoSingleRvBinding<T, VB> {
    return FrogoSingleRvBinding<T, VB>().initSingleton(this)
}

fun <T> RecyclerView.builder(listener: IFrogoBuilderRv<T>) {
    return FrogoBuilderRv<T>().initBuilder(this).builder(listener)
}

fun <T, VB : ViewBinding> RecyclerView.builderBinding(listener: IFrogoBuilderRvBinding<T, VB>) {
    return FrogoBuilderRvBinding<T, VB>().initBuilder(this).builder(listener)
}