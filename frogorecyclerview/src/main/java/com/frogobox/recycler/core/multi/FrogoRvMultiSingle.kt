package com.frogobox.recycler.core.multi

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.widget.FrogoRecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoHolder
import com.frogobox.recycler.core.FrogoRvConstant
import com.frogobox.recycler.core.FrogoViewAdapter

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.singleton
 * 
 */
class FrogoRvMultiSingle<T> :
    IFrogoRvMultiSingle<T> {

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view

    private lateinit var frogoViewAdapter: FrogoViewAdapter<T>
    private lateinit var listFrogoHolder: List<FrogoHolder<T>>
    private lateinit var mFrogoRecyclerView: FrogoRecyclerView

    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""


    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvMultiSingle<T> {
        mFrogoRecyclerView = frogoRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvMultiSingle<T> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvMultiSingle<T> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvMultiSingle<T> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvMultiSingle<T> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(data: List<FrogoHolder<T>>): FrogoRvMultiSingle<T> {
        this.listFrogoHolder = data
        Log.d("injector-listData", this.listFrogoHolder.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoRvMultiSingle<T> {
        if (emptyViewInt != null) this.emptyViewInt = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewInt.toString())
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
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_MULTI
        frogoViewAdapter = FrogoViewAdapter()
        frogoViewAdapter.setupMultiHolder()
        frogoViewAdapter.setupRequirement(listFrogoHolder)
        frogoViewAdapter.setupEmptyView(emptyViewInt)
    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoRvMultiSingle<T> {
        createAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }


}