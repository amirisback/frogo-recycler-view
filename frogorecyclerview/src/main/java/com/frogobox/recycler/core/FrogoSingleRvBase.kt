package com.frogobox.recycler.core

/*
 * Created by faisalamir on 31/05/21
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
open class FrogoSingleRvBase<T> : IFrogoSingleRvBase<T> {

    protected val singleton = this
    
    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRvBase<T> {
        return singleton
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBase<T> {
        return singleton
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRvBase<T> {
        return singleton
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBase<T> {
        return singleton
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRvBase<T> {
        return singleton
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSingleRvBase<T> {
        return singleton
    }

}