package com.frogobox.recycler.core.multi

import com.frogobox.recycler.core.FrogoHolder
import com.frogobox.recycler.widget.FrogoRecyclerView

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
 * com.frogobox.recycler.singleton
 * 
 */
interface IFrogoRvMultiSingle<T> {

    fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvMultiSingle<T>

    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvMultiSingle<T>

    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvMultiSingle<T>

    fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvMultiSingle<T>

    fun createLayoutGrid(spanCount: Int): FrogoRvMultiSingle<T>

    fun addData(data: List<FrogoHolder<T>>): FrogoRvMultiSingle<T>
    
    fun addEmptyView(emptyViewInt: Int?): FrogoRvMultiSingle<T>

    fun build(): FrogoRvMultiSingle<T>
    
}