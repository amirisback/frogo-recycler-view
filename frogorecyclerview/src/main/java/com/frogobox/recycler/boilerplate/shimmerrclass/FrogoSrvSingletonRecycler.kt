package com.frogobox.recycler.boilerplate.shimmerrclass

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.R
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapter
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewHolderCallback
import com.frogobox.recycler.util.FrogoRvConstant
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir on 04/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoSrvSingletonRecycler<T> : FrogoSrvSingletonRecyclerInterface<T> {

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView
    private lateinit var rvFrogoAdapterCallback: FrogoViewAdapterCallback<T>
    private lateinit var rvFrogoViewAdapter: FrogoViewAdapter<T>

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var rvCustomViewInt: Int = 0
    private var rvListData: List<T>? = null

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSrvSingletonRecycler<T> {
        mFrogoRecyclerView = frogoRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingletonRecycler<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingletonRecycler<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingletonRecycler<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSrvSingletonRecycler<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(listData: List<T>): FrogoSrvSingletonRecycler<T> {
        rvListData = listData
        Log.d("injector-listData", rvListData.toString())
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSrvSingletonRecycler<T> {
        rvCustomViewInt = customViewInt
        Log.d("injector-customView", rvCustomViewInt.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSrvSingletonRecycler<T> {
        if (emptyViewInt != null) this.emptyViewInt = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewInt.toString())
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: FrogoViewAdapterCallback<T>): FrogoSrvSingletonRecycler<T> {
        rvFrogoAdapterCallback = frogoViewAdapterCallback
        Log.d("injector-adaptCallback", rvFrogoAdapterCallback.toString())
        return this
    }

    private fun setupLayoutManager() {
        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            mFrogoRecyclerView.layoutManager = LinearLayoutManager(mFrogoRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoRecyclerView.context, LinearLayoutManager.VERTICAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            mFrogoRecyclerView.layoutManager = LinearLayoutManager(mFrogoRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            if (optionDividerItem) {
                mFrogoRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoRecyclerView.context, LinearLayoutManager.HORIZONTAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoRecyclerView.layoutManager = GridLayoutManager(mFrogoRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        rvFrogoViewAdapter = FrogoViewAdapter(object : FrogoViewHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                rvFrogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        rvFrogoViewAdapter.setupRequirement(rvCustomViewInt, rvListData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    rvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    rvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        rvFrogoViewAdapter.setupEmptyView(emptyViewInt)

    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoRecyclerView.adapter = rvFrogoViewAdapter
    }

    override fun build(): FrogoSrvSingletonRecycler<T> {
        createRvAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}