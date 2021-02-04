package com.frogobox.recycler.core.viewshimmer

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.viewrclass.FrogoViewAdapter
import com.frogobox.recycler.core.viewrclass.IFrogoViewAdapter
import com.frogobox.recycler.core.viewrclass.IFrogoViewHolder
import com.frogobox.recycler.core.FrogoRvConstant
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

class FrogoSrvSingleShimmer : IFrogoSrvSingleShimmer {

    private lateinit var mFrogoShimmerRecyclerView: FrogoRecyclerView
    private lateinit var srvFrogoAdapterCallback: IFrogoViewAdapter<String>
    private lateinit var srvFrogoViewAdapter: FrogoViewAdapter<String>

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var srvSumListItem: Int = 2
    private var srvCustomViewInt: Int = 0

    override fun initSingleton(frogoShimmerRecyclerView: FrogoRecyclerView): FrogoSrvSingleShimmer {
        mFrogoShimmerRecyclerView = frogoShimmerRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingleShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingleShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingleShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSrvSingleShimmer {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingleShimmer {
        srvCustomViewInt = customViewInt
        Log.d("injector-shimmerView", srvCustomViewInt.toString())
        return this
    }

    override fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingleShimmer {
        srvSumListItem = sumItem
        Log.d("injector-sumItem", srvSumListItem.toString())
        return this
    }

    private fun srvListData(): MutableList<String> {
        val listdata = mutableListOf<String>()
        for (i in 1..srvSumListItem) {
            listdata.add("place-holder-shimmer")
        }
        return listdata
    }

    private fun setupLayoutManager() {
        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            mFrogoShimmerRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoShimmerRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerRecyclerView.context, LinearLayoutManager.VERTICAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            mFrogoShimmerRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            if (optionDividerItem) {
                mFrogoShimmerRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerRecyclerView.context, LinearLayoutManager.HORIZONTAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoShimmerRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoShimmerRecyclerView.layoutManager = GridLayoutManager(mFrogoShimmerRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createShimmerRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        srvFrogoAdapterCallback = object : IFrogoViewAdapter<String>{
            override fun setupInitComponent(view: View, data: String) {}
            override fun onItemClicked(data: String) {}
            override fun onItemLongClicked(data: String) {}
        }

        srvFrogoViewAdapter = FrogoViewAdapter(object : IFrogoViewHolder<String> {
            override fun setupInitComponent(view: View, data: String) {
                srvFrogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        srvFrogoViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                FrogoRecyclerViewListener<String> {
                override fun onItemClicked(data: String) {
                    srvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: String) {
                    srvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        srvFrogoViewAdapter.setupEmptyView(emptyViewInt)
    }

    private fun setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoShimmerRecyclerView.adapter = srvFrogoViewAdapter
    }

    override fun build(): FrogoSrvSingleShimmer {
        createShimmerRvAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }

}