package com.frogobox.recycler.core

import android.view.View
import com.frogobox.frogolog.FLog
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
open class FrogoSingleRv<T> : FrogoSingleRvBase<T>(), IFrogoSingleRv<T> {

    protected lateinit var frogoRecycleView: FrogoRecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoViewAdapter<T>
    protected lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    protected var emptyViewId: Int = R.layout.frogo_container_empty_view

    protected var optionAdapter = ""
    protected var customViewId: Int = 0
    
    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRv<T> {
        frogoRecycleView = frogoRecyclerView
        frogoViewAdapter = FrogoViewAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRv<T> {
        baseCreateLayoutLinearVertical(dividerItem)
        return this
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T> {
        baseCreateLayoutLinearVertical(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRv<T> {
        baseCreateLayoutLinearHorizontal(dividerItem)
        return this
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRv<T> {
        baseCreateLayoutLinearHorizontal(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRv<T> {
        baseCreateLayoutStaggeredGrid(spanCount)
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSingleRv<T> {
        baseCreateLayoutGrid(spanCount)
        return this
    }

    override fun addData(listData: List<T>): FrogoSingleRv<T> {
        this.listData.addAll(listData)
        FLog.d("injector-listData : ${this.listData.size}")
        return this
    }

    override fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoSingleRv<T> {
        this.listDataFH.addAll(listDataFH)
        frogoViewAdapter.setupMultiHolder()
        FLog.d("injector-listData : ${this.listDataFH.size}")
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSingleRv<T> {
        this.customViewId = customViewInt
        FLog.d("injector-customView : $customViewId")
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSingleRv<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        FLog.d("injector-emptyView : $emptyViewId")
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSingleRv<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        FLog.d("injector-adaptCallback : $frogoAdapterCallback")
        return this
    }

    protected open fun createAdapter() {

        if (frogoViewAdapter.hasMultiHolder) {
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

    protected open fun setupInnerAdapter() {
        FLog.d("injector-optionAdapter : $optionAdapter")
        frogoRecycleView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoSingleRv<T> {
        createAdapter()
        setupLayoutManager(frogoRecycleView)
        setupInnerAdapter()
        return this
    }

}