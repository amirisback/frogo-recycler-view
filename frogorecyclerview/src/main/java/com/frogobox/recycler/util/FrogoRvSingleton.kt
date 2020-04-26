package com.frogobox.recycler.util

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.listener.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.adapter.FrogoViewAdapter
import com.frogobox.recycler.boilerplate.adapter.FrogoViewMultiAdapter
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoMultiAdapterCallback
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback

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

    var emptyView: Int = R.layout.frogo_rv_empty_view
    var listData: List<T>? = null
    var layoutSpanCount = 0
    var optionLayoutManager = ""
    var optionDividerItem = false
    var optionAdapter = ""

    var customView: Int = 0
    lateinit var frogoAdapterCallback: FrogoAdapterCallback<T>
    lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    lateinit var multiCustomView: List<Int>
    lateinit var multiOptionHolder: List<Int>
    lateinit var frogoMultiAdapterCallback: FrogoMultiAdapterCallback<T>
    lateinit var frogoViewMultiAdapter: FrogoViewMultiAdapter<T>

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
        customView = layoutId
        Log.d("injector-customView", customView.toString())
        return this
    }

    override fun addCallback(callback: FrogoAdapterCallback<T>): FrogoRvSingleton<T> {
        frogoAdapterCallback = callback
        return this
    }

    override fun createAdapter(): FrogoRvSingleton<T> {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER
        frogoViewAdapter = FrogoViewAdapter(object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        frogoViewAdapter.setupRequirement(customView, listData,
            object : FrogoRecyclerViewListener<T> {
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

    override fun addMultiCustomView(multiLayoutId: List<Int>): FrogoRvSingleton<T> {
        multiCustomView = multiLayoutId
        return this
    }

    override fun addMultiOptionHolder(optionHolder: List<Int>): FrogoRvSingleton<T> {
        multiOptionHolder = optionHolder
        return this
    }

    override fun addMultiCallback(callback: FrogoMultiAdapterCallback<T>): FrogoRvSingleton<T> {
        frogoMultiAdapterCallback = callback
        return this
    }

    override fun createMultiAdapter(): FrogoRvSingleton<T> {
        optionAdapter = FrogoRvConstant.FROGO_MULTI_ADAPTER
        frogoViewMultiAdapter = FrogoViewMultiAdapter(object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoMultiAdapterCallback.setupFirstInitComponent(view, data)
            }
        }, object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoMultiAdapterCallback.setupSecondInitComponent(view, data)
            }
        })

        frogoViewMultiAdapter.setupRequirement(
            listData,
            multiCustomView,
            multiOptionHolder,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoMultiAdapterCallback.onFirstItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoMultiAdapterCallback.onFirstItemLongClicked(data)
                }
            },
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoMultiAdapterCallback.onSecondItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoMultiAdapterCallback.onSecondItemLongClicked(data)
                }
            }
        )
        frogoViewMultiAdapter.setupEmptyView(emptyView)

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

        if (optionAdapter.equals(FrogoRvConstant.FROGO_ADAPTER)) {
            frogoRecyclerView.adapter = frogoViewAdapter
        } else if (optionAdapter.equals(FrogoRvConstant.FROGO_MULTI_ADAPTER)) {
            frogoRecyclerView.adapter = frogoViewMultiAdapter
        }

    }

    override fun build(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingleton<T> {
        setupLayoutManager<T>(frogoRecyclerView)
        setupInnerAdapter<T>(frogoRecyclerView)
        return this
    }

}