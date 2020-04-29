package com.frogobox.recycler.boilerplate.singleton

import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.FrogoRecyclerView
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.viewbinding.FrogoViewAdapterBinding
import com.frogobox.recycler.boilerplate.viewbinding.FrogoViewAdapterBindingCallback
import com.frogobox.recycler.boilerplate.viewbinding.FrogoViewHolderBindingCallback
import com.frogobox.recycler.util.FrogoRvConstant

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
 * com.frogobox.recycler.boilerplate
 * 
 */
class FrogoRvSingletonViewBinding<T, V : ViewBinding> : FrogoRvSingletonViewBindingInterface<T, V> {

    private lateinit var customViewBinding: V

    private lateinit var frogoViewAdapterBindingCallback: FrogoViewAdapterBindingCallback<T, V>
    private lateinit var frogoViewAdapterBinding: FrogoViewAdapterBinding<T, V>

    private lateinit var mFrogoRecyclerView: FrogoRecyclerView
    private var layoutSpanCount = 0
    private var optionLayoutManager = ""
    private var optionDividerItem = false
    private var listData: List<T>? = null
    private var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoRvSingletonViewBinding<T, V> {
        mFrogoRecyclerView = frogoRecyclerView
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoRvSingletonViewBinding<T, V> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_LINEAR_VERTICAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoRvSingletonViewBinding<T, V> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_LINEAR_HORIZONTAL
        optionDividerItem = dividerItem
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoRvSingletonViewBinding<T, V> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_STAGGERED_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoRvSingletonViewBinding<T, V> {
        optionLayoutManager =
            FrogoRvConstant.LAYOUT_GRID
        layoutSpanCount = spanCount
        Log.d("injector-layoutManager", optionLayoutManager)
        Log.d("injector-divider", optionDividerItem.toString())
        return this
    }

    override fun setupLayoutManager() {

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

    override fun addData(listData: List<T>): FrogoRvSingletonViewBinding<T, V> {
        this.listData = listData
        Log.d("injector-listData", this.listData.toString())
        return this
    }

    override fun addCustomView(customViewBinding: V): FrogoRvSingletonViewBinding<T, V> {
        this.customViewBinding = customViewBinding
        Log.d("injector-customView", this.customViewBinding.toString())
        return this
    }

    override fun addCallback(
        frogoViewAdapterBindingCallback: FrogoViewAdapterBindingCallback<T, V>
    ): FrogoRvSingletonViewBinding<T, V> {
        this.frogoViewAdapterBindingCallback = frogoViewAdapterBindingCallback
        Log.d("injector-adaptCallback", this.frogoViewAdapterBindingCallback.toString())
        return this
    }

    private fun createAdapter(): FrogoRvSingletonViewBinding<T, V> {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_VIEW_BINDING
        frogoViewAdapterBinding =
            FrogoViewAdapterBinding(object :
                FrogoViewHolderBindingCallback<T, V> {
                override fun setupInitComponent(viewBinding: V, data: T) {
                    frogoViewAdapterBindingCallback.setupInitComponent(viewBinding, data)
                }
            })

        frogoViewAdapterBinding.setupRequirement(customViewBinding, listData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoViewAdapterBindingCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoViewAdapterBindingCallback.onItemLongClicked(data)
                }
            })

        return this
    }

    private fun <T> setupInnerAdapter() {
        Log.d("injector-optionAdapter", optionAdapter)
        mFrogoRecyclerView.adapter = frogoViewAdapterBinding
    }

    override fun build(): FrogoRvSingletonViewBinding<T, V> {
        createAdapter()
        setupLayoutManager()
        setupInnerAdapter<T>()
        return this
    }


}