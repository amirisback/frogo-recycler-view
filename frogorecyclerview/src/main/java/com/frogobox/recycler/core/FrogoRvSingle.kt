package com.frogobox.recycler.core

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

    private var emptyViewId: Int = R.layout.frogo_container_empty_view

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView
    private lateinit var frogoAdapterCallback: IFrogoViewAdapter<T>
    private lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    private val listDataFH = mutableListOf<FrogoHolder<T>>()
    private val listData = mutableListOf<T>()

    private var customViewId: Int = 0
    private var layoutSpanCount = 0

    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingle<T> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoViewAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvSingle<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(listData: List<T>): FrogoRvSingle<T> {
        this.listData.addAll(listData)
        Log.d("injector-listData", this.listData.toString())
        return this
    }

    override fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoRvSingle<T> {
        this.listDataFH.addAll(listDataFH)
        frogoViewAdapter.setupMultiHolder()
        Log.d("injector-listData", this.listDataFH.toString())
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoRvSingle<T> {
        this.customViewId = customViewInt
        Log.d("injector-customView", this.customViewId.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoRvSingle<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewId.toString())
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoRvSingle<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        Log.d("injector-adaptCallback", this.frogoAdapterCallback.toString())
        return this
    }

    private fun setupLayoutManager() {

        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

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

    private fun createAdapter() {

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

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoRvSingle<T> {
        createAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}