package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.frogobox.frogolog.FLog
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
open class FrogoSingleRvBinding<T, VB : ViewBinding> : IFrogoSingleRvBinding<T, VB> {

    protected lateinit var mFrogoRecyclerView: FrogoRecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoBindingAdapter<T, VB>
    protected lateinit var frogoViewAdapter: FrogoBindingAdapter<T, VB>

    protected lateinit var emptyViewId: ViewBinding

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected lateinit var customViewId: VB
    protected var layoutSpanCount = 0

    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionAdapter = ""
    protected var optionReverseLayout = false
    protected var optionStackFromEnd = false

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRvBinding<T, VB> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoBindingAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRvBinding<T, VB> {
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
    ): FrogoSingleRvBinding<T, VB> {

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

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRvBinding<T, VB> {
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
    ): FrogoSingleRvBinding<T, VB> {

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

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRvBinding<T, VB> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSingleRvBinding<T, VB> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount

        FLog.d("injector-layoutManager : $optionLayoutManager")
        FLog.d("injector-spanCount : $layoutSpanCount")

        return this
    }

    override fun addData(listData: List<T>): FrogoSingleRvBinding<T, VB> {
        this.listData.addAll(listData)
        FLog.d("injector-listData : ${this.listData.size}")
        return this
    }


    override fun addCallback(frogoViewAdapterCallback: IFrogoBindingAdapter<T, VB>): FrogoSingleRvBinding<T, VB> {
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
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        frogoViewAdapter.setCallback(object : IFrogoBindingHolder<T, VB> {
            override fun setupInitComponent(view: VB, data: T) {
                frogoAdapterCallback.setupInitComponent(view, data)
            }

            override fun setViewBinding(parent: ViewGroup): VB {
                return frogoAdapterCallback.setViewBinding(parent)
            }
        })

        frogoViewAdapter.setupRequirement(listData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoAdapterCallback.onItemLongClicked(data)
                }
            })
    }

    protected open fun setupInnerAdapter() {
        FLog.d("injector-optionAdapter : $optionAdapter")
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoSingleRvBinding<T, VB> {
        createAdapter()
        setupLayoutManager(mFrogoRecyclerView)
        setupInnerAdapter()
        return this
    }

}