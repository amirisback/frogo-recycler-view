package com.frogobox.recycler.core.viewrclass

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.util.FrogoRvConstant
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
class FrogoRvSingletonRclass<T> :
    IFrogoRvSingletonRclass<T> {

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var customViewInt: Int = 0

    private lateinit var frogoAdapterCallback: FrogoViewAdapterCallback<T>
    private lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var listData: List<T>? = null
    private var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonRclass<T> {
        mFrogoRecyclerView = frogoRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonRclass<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonRclass<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonRclass<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvSingletonRclass<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(listData: List<T>): FrogoRvSingletonRclass<T> {
        this.listData = listData
        Log.d("injector-listData", this.listData.toString())
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoRvSingletonRclass<T> {
        this.customViewInt = customViewInt
        Log.d("injector-customView", this.customViewInt.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoRvSingletonRclass<T> {
        if (emptyViewInt != null) this.emptyViewInt = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewInt.toString())
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: FrogoViewAdapterCallback<T>): FrogoRvSingletonRclass<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        Log.d("injector-adaptCallback", this.frogoAdapterCallback.toString())
        return this
    }

    private fun setupLayoutManager() {

        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
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
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
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
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoRecyclerView.layoutManager =
                StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoRecyclerView.layoutManager =
                GridLayoutManager(mFrogoRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        frogoViewAdapter =
            FrogoViewAdapter(object :
                FrogoViewHolderCallback<T> {
                override fun setupInitComponent(view: View, data: T) {
                    frogoAdapterCallback.setupInitComponent(view, data)
                }
            })

        frogoViewAdapter.setupRequirement(customViewInt, listData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoAdapterCallback.onItemLongClicked(data)
                }
            })

        frogoViewAdapter.setupEmptyView(emptyViewInt)

    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoRvSingletonRclass<T> {
        createAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}