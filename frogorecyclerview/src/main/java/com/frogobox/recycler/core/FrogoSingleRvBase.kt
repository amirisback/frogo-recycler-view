package com.frogobox.recycler.core

import com.frogobox.log.FLog
import com.frogobox.recycler.core.FrogoLayoutManager.dividerItemVertical
import com.frogobox.recycler.core.FrogoLayoutManager.gridLayout
import com.frogobox.recycler.core.FrogoLayoutManager.linearLayoutHorizontal
import com.frogobox.recycler.core.FrogoLayoutManager.linearLayoutVertical
import com.frogobox.recycler.core.FrogoLayoutManager.staggeredGridLayout
import com.frogobox.recycler.core.FrogoRvConstant.FROGO_RV_TAG
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
abstract class FrogoSingleRvBase<T> {

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected var layoutSpanCount = 0
    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionReverseLayout = false
    protected var optionStackFromEnd = false

    protected fun baseCreateLayoutLinearVertical(dividerItem: Boolean) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-divider : $optionDividerItem")
    }

    protected fun baseCreateLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-divider : $optionDividerItem")
        FLog.d("$FROGO_RV_TAG - injector-reverseLayout : $optionReverseLayout")
        FLog.d("$FROGO_RV_TAG - injector-stackFromEnd : $optionStackFromEnd")
    }

    protected fun baseCreateLayoutLinearHorizontal(dividerItem: Boolean) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-divider : $optionDividerItem")
    }

    protected fun baseCreateLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-divider : $optionDividerItem")
        FLog.d("$FROGO_RV_TAG - injector-reverseLayout : $optionReverseLayout")
        FLog.d("$FROGO_RV_TAG - injector-stackFromEnd : $optionStackFromEnd")
    }

    protected fun baseCreateLayoutStaggeredGrid(spanCount: Int) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-spanCount : $layoutSpanCount")
    }

    protected fun baseCreateLayoutGrid(spanCount: Int) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount

        FLog.d("$FROGO_RV_TAG - injector-layoutManager : $optionLayoutManager")
        FLog.d("$FROGO_RV_TAG - injector-spanCount : $layoutSpanCount")
    }

    protected fun setupLayoutManager(frogoRV: FrogoRecyclerView) {

        val context = frogoRV.context

        if (listData.isNotEmpty() || listDataFH.isNotEmpty()) {

            if (optionDividerItem) {
                frogoRV.addItemDecoration(dividerItemVertical(context))
            }

            frogoRV.layoutManager = when (optionLayoutManager) {
                FrogoRvConstant.LAYOUT_LINEAR_VERTICAL -> {
                    linearLayoutVertical(context)
                }

                FrogoRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE -> {
                    linearLayoutVertical(context, optionReverseLayout, optionStackFromEnd)
                }

                FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL -> {
                    linearLayoutHorizontal(context)
                }

                FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE -> {
                    linearLayoutHorizontal(context, optionReverseLayout, optionStackFromEnd)
                }

                FrogoRvConstant.LAYOUT_GRID -> {
                    gridLayout(context, layoutSpanCount)
                }

                FrogoRvConstant.LAYOUT_STAGGERED_GRID -> {
                    staggeredGridLayout(layoutSpanCount)
                }

                else -> {
                    linearLayoutVertical(context)
                }
            }
        }
    }

}