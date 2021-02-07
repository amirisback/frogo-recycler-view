package com.frogobox.recycler.core

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.frogolog.FrogoLog
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
class FrogoRvSingle<T> : IFrogoRvSingle<T> {

    protected lateinit var mFrogoRecyclerView: FrogoRecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoViewAdapter<T>
    protected lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    protected var emptyViewId: Int = R.layout.frogo_container_empty_view

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()

    protected var customViewId: Int = 0
    protected var layoutSpanCount = 0

    protected var optionLayoutManager = ""
    protected var optionDividerItem = false
    protected var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingle<T> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoViewAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem

        FrogoLog.d("injector-layoutManager : $optionLayoutManager")
        FrogoLog.d("injector-divider : $optionDividerItem")

        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem

        FrogoLog.d("injector-layoutManager : $optionLayoutManager")
        FrogoLog.d("injector-divider : $optionDividerItem")
        
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        
        FrogoLog.d("injector-layoutManager : $optionLayoutManager")
        FrogoLog.d("injector-spanCount : $layoutSpanCount")
        
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        
        FrogoLog.d("injector-layoutManager : $optionLayoutManager")
        FrogoLog.d("injector-spanCount : $layoutSpanCount")
        
        return this
    }

    override fun addData(listData: List<T>): FrogoRvSingle<T> {
        this.listData.addAll(listData)
        FrogoLog.d("injector-listData : ${this.listData.size}")
        return this
    }

    override fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoRvSingle<T> {
        this.listDataFH.addAll(listDataFH)
        frogoViewAdapter.setupMultiHolder()
        FrogoLog.d("injector-listData : ${this.listDataFH.size}")
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoRvSingle<T> {
        this.customViewId = customViewInt
        FrogoLog.d("injector-customView : $customViewId")
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoRvSingle<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        FrogoLog.d("injector-emptyView : $emptyViewId")
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoRvSingle<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        FrogoLog.d("injector-adaptCallback : $frogoAdapterCallback")
        return this
    }

    protected fun setupLayoutManager() {

        if (listData.isNotEmpty() || listDataFH.isNotEmpty()) {
            if (optionLayoutManager == FrogoRvConstant.LAYOUT_LINEAR_VERTICAL) {
                mFrogoRecyclerView.layoutManager = LinearLayoutManager(
                    mFrogoRecyclerView.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                if (optionDividerItem) {
                    mFrogoRecyclerView.addItemDecoration(
                        DividerItemDecoration(
                            mFrogoRecyclerView.context,
                            LinearLayoutManager.VERTICAL
                        )
                    )
                }
            } else if (optionLayoutManager == FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL) {
                mFrogoRecyclerView.layoutManager = LinearLayoutManager(
                    mFrogoRecyclerView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                if (optionDividerItem) {
                    mFrogoRecyclerView.addItemDecoration(
                        DividerItemDecoration(
                            mFrogoRecyclerView.context,
                            LinearLayoutManager.HORIZONTAL
                        )
                    )
                }
            } else if (optionLayoutManager == FrogoRvConstant.LAYOUT_STAGGERED_GRID) {
                mFrogoRecyclerView.layoutManager =
                    StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
            } else if (optionLayoutManager == FrogoRvConstant.LAYOUT_GRID) {
                mFrogoRecyclerView.layoutManager =
                    GridLayoutManager(mFrogoRecyclerView.context, layoutSpanCount)
            }
        } else {
            mFrogoRecyclerView.layoutManager =
                LinearLayoutManager(mFrogoRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoRecyclerView.addItemDecoration(
                    DividerItemDecoration(
                        mFrogoRecyclerView.context,
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
        }

    }

    protected fun createAdapter() {

        if (frogoViewAdapter.hasMultiHolder){
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

    protected fun setupInnerAdapter() {
        FrogoLog.d("injector-optionAdapter : $optionAdapter")
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoRvSingle<T> {
        createAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}