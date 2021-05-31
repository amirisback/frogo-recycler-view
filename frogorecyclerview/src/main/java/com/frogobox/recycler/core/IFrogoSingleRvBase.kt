package com.frogobox.recycler.core

import com.frogobox.recycler.widget.FrogoRecyclerView

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
    fun baseCreateLayoutLinearVertical(dividerItem: Boolean)

    // Create Linear Vertical Layout Manager From End
    fun baseCreateLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    )

    // Create Linear Horizontal Layout Manager
    fun baseCreateLayoutLinearHorizontal(dividerItem: Boolean)

    // Create Linear Horizontal Layout Manager From End
    fun baseCreateLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    )

    // Create Staggered Grid Layout Manager
    fun baseCreateLayoutStaggeredGrid(spanCount: Int)

    // Create Grid Layout Manager
    fun baseCreateLayoutGrid(spanCount: Int)

    // Setup Layout Manager
    fun setupLayoutManager(frogoRV: FrogoRecyclerView)
    
}