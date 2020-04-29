package com.frogobox.recycler.util

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapter
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewHolderCallback

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
class FrogoRvSingleton<T> : FrogoRvSingletonInterface<T> {

    private var emptyView: Int = R.layout.frogo_rv_empty_view
    private var listData: List<T>? = null
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var customViewInt: Int = 0
    private lateinit var customView: View

    private lateinit var frogoAdapterCallback: FrogoViewAdapterCallback<T>
    private lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingleton<T> {
        mFrogoRecyclerView = frogoRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addEmptyView(layoutId: Int?): FrogoRvSingleton<T> {
        if (layoutId != null) emptyView = layoutId
        Log.d("injector-emptyView", emptyView.toString())
        return this
    }

    override fun addData(dataList: List<T>): FrogoRvSingleton<T> {
        listData = dataList
        Log.d("injector-listData", listData.toString())
        return this
    }

    override fun addCustomView(layoutId: Int): FrogoRvSingleton<T> {
        customViewInt = layoutId
        Log.d("injector-customView", customViewInt.toString())
        return this
    }

    fun addCustomView(view: View): FrogoRvSingleton<T> {
        customView = view
        Log.d("injector-customView", customView.toString())
        return this
    }

    override fun addCallback(callback: FrogoViewAdapterCallback<T>): FrogoRvSingleton<T> {
        frogoAdapterCallback = callback
        return this
    }

    private fun createAdapter(): FrogoRvSingleton<T> {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER
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

        frogoViewAdapter.setupEmptyView(emptyView)

        return this
    }

    private fun <T> setupLayoutManager(frogoRecyclerView: FrogoRecyclerView) {

        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            frogoRecyclerView.layoutManager =
                LinearLayoutManager(frogoRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                frogoRecyclerView.addItemDecoration(
                    DividerItemDecoration(
                        frogoRecyclerView.context,
                        LinearLayoutManager.VERTICAL
                    )
                )
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            frogoRecyclerView.layoutManager = LinearLayoutManager(
                frogoRecyclerView.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            if (optionDividerItem) {
                frogoRecyclerView.addItemDecoration(
                    DividerItemDecoration(
                        frogoRecyclerView.context,
                        LinearLayoutManager.HORIZONTAL
                    )
                )
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            frogoRecyclerView.layoutManager =
                StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            frogoRecyclerView.layoutManager =
                GridLayoutManager(frogoRecyclerView.context, layoutSpanCount)
        }

    }

    private fun <T> setupInnerAdapter(frogoRecyclerView: FrogoRecyclerView) {
        Log.d("injector-optionAdapter", optionAdapter)
        frogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoRvSingleton<T> {
        createAdapter()
        setupLayoutManager<T>(mFrogoRecyclerView)
        setupInnerAdapter<T>(mFrogoRecyclerView)
        return this
    }

}