package com.frogobox.recycler.boilerplate.singleton

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.boilerplate.viewbinding.FrogoViewAdapterBindingCallback

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
interface FrogoRvSingletonViewBindingInterface<T, V: ViewBinding> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonViewBinding<T, V>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonViewBinding<T, V>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonViewBinding<T, V>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonViewBinding<T, V>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonViewBinding<T, V>

    fun setupLayoutManager()

    fun addData(listData: List<T>): FrogoRvSingletonViewBinding<T, V>

    fun addCustomView(customViewBinding: V): FrogoRvSingletonViewBinding<T, V>


    fun addCallback(frogoViewAdapterBindingCallback: FrogoViewAdapterBindingCallback<T, V>): FrogoRvSingletonViewBinding<T, V>

    fun build(): FrogoRvSingletonViewBinding<T, V>

}