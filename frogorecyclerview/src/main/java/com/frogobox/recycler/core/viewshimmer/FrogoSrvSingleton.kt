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
import com.frogobox.recycler.util.FrogoRvConstant
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by Faisal Amir on 02/06/2020
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

class FrogoSrvSingleton<T> :
    IFrogoSrvSingleton<T> {

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView
    private lateinit var rvFrogoAdapterCallback: IFrogoViewAdapter<T>
    private lateinit var rvFrogoViewAdapter: FrogoViewAdapter<T>

    private lateinit var mFrogoShimmerRecyclerView: FrogoRecyclerView
    private lateinit var srvFrogoAdapterCallback: IFrogoViewAdapter<String>
    private lateinit var srvFrogoViewAdapter: FrogoViewAdapter<String>

    private var emptyViewInt: Int = R.layout.frogo_container_empty_view
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var optionAdapter = ""

    private var rvCustomViewInt: Int = 0
    private var rvListData: List<T>? = null

    private var srvSumListItem: Int = 2
    private var srvCustomViewInt: Int = 0

    private fun srvListData(): MutableList<String> {
        val listdata = mutableListOf<String>()
        for (i in 1..srvSumListItem) {
            listdata.add("place-holder-shimmer")
        }
        return listdata
    }

    override fun initSingleton(
        frogoRecyclerView: FrogoRecyclerView,
        frogoShimmerRecyclerView: FrogoRecyclerView
    ): FrogoSrvSingleton<T> {
        mFrogoRecyclerView = frogoRecyclerView
        mFrogoShimmerRecyclerView = frogoShimmerRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSrvSingleton<T> {
        optionLayoutManager = FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun addData(listData: List<T>): FrogoSrvSingleton<T> {
        rvListData = listData
        Log.d("injector-listData", rvListData.toString())
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSrvSingleton<T> {
        rvCustomViewInt = customViewInt
        Log.d("injector-customView", rvCustomViewInt.toString())
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSrvSingleton<T> {
        if (emptyViewInt != null) this.emptyViewInt = emptyViewInt
        Log.d("injector-emptyView", this.emptyViewInt.toString())
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSrvSingleton<T> {
        rvFrogoAdapterCallback = frogoViewAdapterCallback
        Log.d("injector-adaptCallback", rvFrogoAdapterCallback.toString())
        return this
    }

    override fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSrvSingleton<T> {
        srvCustomViewInt = customViewInt
        Log.d("injector-shimmerView", srvCustomViewInt.toString())
        return this
    }

    override fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSrvSingleton<T> {
        srvSumListItem = sumItem
        Log.d("injector-sumItem", srvSumListItem.toString())
        return this
    }

    private fun setupLayoutManager() {
        Log.d("injector-option", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        Log.d("injector-spanCount", layoutSpanCount.toString())

        if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_VERTICAL)) {
            mFrogoRecyclerView.layoutManager = LinearLayoutManager(mFrogoRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            mFrogoShimmerRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerRecyclerView.context, LinearLayoutManager.VERTICAL, false)
            if (optionDividerItem) {
                mFrogoRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoRecyclerView.context, LinearLayoutManager.VERTICAL))
                mFrogoShimmerRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerRecyclerView.context, LinearLayoutManager.VERTICAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL)) {
            mFrogoRecyclerView.layoutManager = LinearLayoutManager(mFrogoRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            mFrogoShimmerRecyclerView.layoutManager = LinearLayoutManager(mFrogoShimmerRecyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            if (optionDividerItem) {
                mFrogoRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoRecyclerView.context, LinearLayoutManager.HORIZONTAL))
                mFrogoShimmerRecyclerView.addItemDecoration(DividerItemDecoration(mFrogoShimmerRecyclerView.context, LinearLayoutManager.HORIZONTAL))
            }
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_STAGGERED_GRID)) {
            mFrogoRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
            mFrogoShimmerRecyclerView.layoutManager = StaggeredGridLayoutManager(layoutSpanCount, StaggeredGridLayoutManager.VERTICAL)
        } else if (optionLayoutManager.equals(FrogoRvConstant.LAYOUT_GRID)) {
            mFrogoRecyclerView.layoutManager = GridLayoutManager(mFrogoRecyclerView.context, layoutSpanCount)
            mFrogoShimmerRecyclerView.layoutManager = GridLayoutManager(mFrogoShimmerRecyclerView.context, layoutSpanCount)
        }

    }

    private fun createRvAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        rvFrogoViewAdapter = FrogoViewAdapter(object : IFrogoViewHolder<T> {
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
        mFrogoRecyclerView.adapter = rvFrogoViewAdapter
        mFrogoShimmerRecyclerView.adapter = srvFrogoViewAdapter
    }

    override fun build(): FrogoSrvSingleton<T> {
        createRvAdapter()
        createShimmerRvAdapter()
        setupLayoutManager()
        setupInnerAdapter()
        return this
    }
}