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
interface IFrogoSingleRvBase<T> {
    
    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRvBase<T>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBase<T>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRvBase<T>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBase<T>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRvBase<T>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int): FrogoSingleRvBase<T>
    
}