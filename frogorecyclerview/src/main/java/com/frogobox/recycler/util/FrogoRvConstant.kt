package com.frogobox.recycler.util

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.util
 * 
 */
object FrogoRvConstant {

    const val OPTION_HOLDER_FIRST = 0
    const val OPTION_HOLDER_SECOND = 1

    const val LAYOUT_LINEAR_VERTICAL = "LAYOUT_LINEAR_VERTICAL"
    const val LAYOUT_LINEAR_HORIZONTAL = "LAYOUT_LINEAR_HORIZONTAL"
    const val LAYOUT_STAGGERED_GRID = "LAYOUT_STAGGERED_GRID"
    const val LAYOUT_GRID = "LAYOUT_GRID"

    const val FROGO_ADAPTER = "FROGO_ADAPTER"
    const val FROGO_MULTI_ADAPTER = "FROGO_MULTI_ADAPTER"

    object Deprecated {

        private const val BASE_MESSAGE = "We are going to replace with "
        private const val INSIDE_INJECTOR = "inside injector() singleton"

        const val isViewLinearVertical = "$BASE_MESSAGE createLayoutLinearVertical $INSIDE_INJECTOR"
        const val isViewLinearHorizontal = "$BASE_MESSAGE createLayoutLinearHorizontal $INSIDE_INJECTOR"
        const val isViewStaggeredGrid = "$BASE_MESSAGE createLayoutStaggeredGrid $INSIDE_INJECTOR"
        const val isViewGrid = "$BASE_MESSAGE createLayoutGrid $INSIDE_INJECTOR"
        const val injectAdapter = "$BASE_MESSAGE injector method"

    }

}