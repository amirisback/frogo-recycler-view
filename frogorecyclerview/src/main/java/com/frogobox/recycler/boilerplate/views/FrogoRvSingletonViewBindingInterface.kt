package com.frogobox.recycler.boilerplate.views

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.boilerplate.FrogoRvSingletonViewBinding
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
interface FrogoRvSingletonViewBindingInterface<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonViewBinding<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonViewBinding<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonViewBinding<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonViewBinding<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvSingletonViewBinding<T>

    fun <T> setupLayoutManager()

    fun addData(listData: List<T>): FrogoRvSingletonViewBinding<T>

    fun addCustomView(customViewBinding: ViewBinding): FrogoRvSingletonViewBinding<T>

    fun addEmptyView(emptyViewBinding: ViewBinding?): FrogoRvSingletonViewBinding<T>

    fun addCallback(frogoViewAdapterBindingCallback: FrogoViewAdapterBindingCallback<T>): FrogoRvSingletonViewBinding<T>

    fun build(): FrogoRvSingletonViewBinding<T>

}