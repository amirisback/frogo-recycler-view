package com.frogobox.recycler.core

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.frogolog.FLog
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
open class FrogoSingleRvBase<T> : IFrogoSingleRvBase<T> {

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected var layoutSpanCount = 0
    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionReverseLayout = false
    protected var optionStackFromEnd = false

    override fun baseCreateLayoutLinearVertical(dividerItem: Boolean) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")

    }

    override fun baseCreateLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {

        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")
        FLog.d("injector-reverseLayout : $optionReverseLayout")
        FLog.d("injector-stackFromEnd : $optionStackFromEnd")

    }

    override fun baseCreateLayoutLinearHorizontal(dividerItem: Boolean) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")


    }

    override fun baseCreateLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ) {

        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")
        FLog.d("injector-reverseLayout : $optionReverseLayout")
        FLog.d("injector-stackFromEnd : $optionStackFromEnd")


    }

    override fun baseCreateLayoutStaggeredGrid(spanCount: Int) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

    }

    override fun baseCreateLayoutGrid(spanCount: Int) {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

    }

    override fun setupLayoutManager(frogoRV: FrogoRecyclerView) {

        if (listData.isNotEmpty() || listDataFH.isNotEmpty()) {

            when (optionLayoutManager) {
                FrogoRvConstant.LAYOUT_LINEAR_VERTICAL -> {
                    frogoRV.layoutManager = LinearLayoutManager(
                        frogoRV.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    if (optionDividerItem) {
                        frogoRV.addItemDecoration(
                            DividerItemDecoration(
                                frogoRV.context,
                                LinearLayoutManager.VERTICAL
                            )
                        )
                    }
                }

                FrogoRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE -> {
                    frogoRV.layoutManager = LinearLayoutManager(
                        frogoRV.context
                    ).apply {
                        orientation = LinearLayoutManager.VERTICAL
                        stackFromEnd = optionStackFromEnd
                        reverseLayout = optionReverseLayout
                    }
                    if (optionDividerItem) {
                        frogoRV.addItemDecoration(
                            DividerItemDecoration(
                                frogoRV.context,
                                LinearLayoutManager.HORIZONTAL
                            )
                        )
                    }
                }

                FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL -> {
                    frogoRV.layoutManager = LinearLayoutManager(
                        frogoRV.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    if (optionDividerItem) {
                        frogoRV.addItemDecoration(
                            DividerItemDecoration(
                                frogoRV.context,
                                LinearLayoutManager.HORIZONTAL
                            )
                        )
                    }
                }

                FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE -> {
                    frogoRV.layoutManager = LinearLayoutManager(
                        frogoRV.context
                    ).apply {
                        orientation = LinearLayoutManager.HORIZONTAL
                        stackFromEnd = optionStackFromEnd
                        reverseLayout = optionReverseLayout
                    }
                    if (optionDividerItem) {
                        frogoRV.addItemDecoration(
                            DividerItemDecoration(
                                frogoRV.context,
                                LinearLayoutManager.HORIZONTAL
                            )
                        )
                    }
                }

                FrogoRvConstant.LAYOUT_GRID -> {
                    frogoRV.layoutManager =
                        GridLayoutManager(frogoRV.context, layoutSpanCount)
                }

                FrogoRvConstant.LAYOUT_STAGGERED_GRID -> {
                    frogoRV.layoutManager =
                        StaggeredGridLayoutManager(
                            layoutSpanCount,
                            StaggeredGridLayoutManager.VERTICAL
                        )
                }

                else -> {
                    frogoRV.layoutManager =
                        LinearLayoutManager(frogoRV.context, LinearLayoutManager.VERTICAL, false)
                    if (optionDividerItem) {
                        frogoRV.addItemDecoration(
                            DividerItemDecoration(
                                frogoRV.context,
                                LinearLayoutManager.VERTICAL
                            )
                        )
                    }
                }
            }
        }
    }

}