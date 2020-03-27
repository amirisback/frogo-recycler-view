package com.frogobox.recycler.view

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 31/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.recycler.view
 *
 */

interface FrogoLayoutView {

    // Setup linear vertical recycler view
    fun isViewLinearVertical(dividerItem: Boolean) {}

    // Setup linear horizontal recycler view
    fun isViewLinearHorizontal(dividerItem: Boolean) {}

    // Setup staggered grid recycler view
    fun isViewStaggeredGrid(spanCount: Int) {}

    // Setup grid recycler view
    fun isViewGrid(spanCount: Int) {}

}