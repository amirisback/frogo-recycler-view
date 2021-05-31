package com.frogobox.recycler.core

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.frogolog.FLog
import com.frogobox.recycler.R
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 27/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler
 *
 */
open class FrogoSingleRv<T> : IFrogoSingleRv<T> {

    protected lateinit var mFrogoRecyclerView: FrogoRecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoViewAdapter<T>
    protected lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    protected var emptyViewId: Int = R.layout.frogo_container_empty_view

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()
    protected var optionAdapter = ""
    protected var customViewId: Int = 0
    
    protected var layoutSpanCount = 0
    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionReverseLayout = false
    protected var optionStackFromEnd = false
    
    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRv<T> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoViewAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRv<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")

        return this
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T> {

        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")
        FLog.d("injector-reverseLayout : $optionReverseLayout")
        FLog.d("injector-stackFromEnd : $optionStackFromEnd")

        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRv<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")

        return this
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T> {

        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL_REVERSE
        optionDividerItem = dividerItem
        optionReverseLayout = reverseLayout
        optionStackFromEnd = stackFromEnd

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-divider : $optionDividerItem")
        FLog.d("injector-reverseLayout : $optionReverseLayout")
        FLog.d("injector-stackFromEnd : $optionStackFromEnd")

        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRv<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSingleRv<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

        return this
    }


    override fun addData(listData: List<T>): FrogoSingleRv<T> {
        this.listData.addAll(listData)
        FLog.d("injector-listData : ${this.listData.size}")
        return this
    }

    override fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoSingleRv<T> {
        this.listDataFH.addAll(listDataFH)
        frogoViewAdapter.setupMultiHolder()
        FLog.d("injector-listData : ${this.listDataFH.size}")
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSingleRv<T> {
        this.customViewId = customViewInt
        FLog.d("injector-customView : $customViewId")
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSingleRv<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        FLog.d("injector-emptyView : $emptyViewId")
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSingleRv<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        FLog.d("injector-adaptCallback : $frogoAdapterCallback")
        return this
    }

    private fun setupLayoutManager(frogoRV: FrogoRecyclerView) {

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

    protected open fun createAdapter() {

        if (frogoViewAdapter.hasMultiHolder) {
            optionAdapter = FrogoRvConstant.FROGO_ADAPTER_MULTI
            frogoViewAdapter.setupRequirement(listDataFH)
            frogoViewAdapter.setupEmptyView(emptyViewId)

        } else {
            optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
            frogoViewAdapter.setCallback(object : IFrogoViewHolder<T> {
                override fun setupInitComponent(view: View, data: T) {
                    frogoAdapterCallback.setupInitComponent(view, data)
                }
            })

            frogoViewAdapter.setupRequirement(customViewId, listData,
                object :
                    FrogoRecyclerViewListener<T> {
                    override fun onItemClicked(data: T) {
                        frogoAdapterCallback.onItemClicked(data)
                    }

                    override fun onItemLongClicked(data: T) {
                        frogoAdapterCallback.onItemLongClicked(data)
                    }
                })
            frogoViewAdapter.setupEmptyView(emptyViewId)

        }
    }

    protected open fun setupInnerAdapter() {
        FLog.d("injector-optionAdapter : $optionAdapter")
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoSingleRv<T> {
        createAdapter()
        setupLayoutManager(mFrogoRecyclerView)
        setupInnerAdapter()
        return this
    }

}