package com.frogobox.recycler.core

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
    const val LAYOUT_LINEAR_VERTICAL_REVERSE = "LAYOUT_LINEAR_VERTICAL_REVERSE"
    const val LAYOUT_LINEAR_HORIZONTAL = "LAYOUT_LINEAR_HORIZONTAL"
    const val LAYOUT_LINEAR_HORIZONTAL_REVERSE = "LAYOUT_LINEAR_HORIZONTAL_REVERSE"
    const val LAYOUT_STAGGERED_GRID = "LAYOUT_STAGGERED_GRID"
    const val LAYOUT_GRID = "LAYOUT_GRID"

    const val FROGO_ADAPTER_R_CLASS = "FROGO_ADAPTER_R_CLASS"
    const val FROGO_ADAPTER_VIEW_BINDING = "FROGO_ADAPTER_VIEW_BINDING"
    const val FROGO_ADAPTER_MULTI = "FROGO_ADAPTER_MULTI"
    const val FROGO_RV_TAG = "FrogoRecyclerView"
    const val FROGO_RV_COMPOSE_TAG = "FrogoRecyclerCompose"

    const val DUMMY_LOREM_IPSUM =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "

    const val LINK_PHOTO_GITHUB =
        "https://avatars1.githubusercontent.com/u/24654871?s=460&u=a93f6b361640532acbe98b0c4ba60a83f50c768e&v=4"

    object Deprecated {

        private const val BASE_MESSAGE = "We are going to replace with "
        private const val INSIDE_INJECTOR = "inside injector() singleton"

        const val isViewLinearVertical = "$BASE_MESSAGE createLayoutLinearVertical $INSIDE_INJECTOR"
        const val isViewLinearHorizontal =
            "$BASE_MESSAGE createLayoutLinearHorizontal $INSIDE_INJECTOR"
        const val isViewStaggeredGrid = "$BASE_MESSAGE createLayoutStaggeredGrid $INSIDE_INJECTOR"
        const val isViewGrid = "$BASE_MESSAGE createLayoutGrid $INSIDE_INJECTOR"
        const val injectAdapter = "$BASE_MESSAGE injector method"

    }

}