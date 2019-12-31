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

interface FrogoView {

    fun isViewLinearVertical(dividerItem: Boolean) {}
    fun isViewLinearHorizontal(dividerItem: Boolean) {}
    fun isViewStaggeredGrid(spanCount: Int) {}
    fun isViewGrid(spanCount: Int) {}

}