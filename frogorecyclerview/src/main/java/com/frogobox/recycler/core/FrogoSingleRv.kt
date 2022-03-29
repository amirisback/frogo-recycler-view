package com.frogobox.recycler.core

import android.view.View
import com.frogobox.log.FLog
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRvConstant.FROGO_RV_TAG
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

    protected var emptyViewId: Int = R.layout.frogo_rv_container_empty_view

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
        FLog.d("$FROGO_RV_TAG - injector-listData : ${this.listData.size}")
        return this
    }

    override fun addDataFH(listDataFH: List<FrogoHolder<T>>): FrogoSingleRv<T> {
        this.listDataFH.addAll(listDataFH)
        frogoViewAdapter.setupMultiHolder()
        FLog.d("$FROGO_RV_TAG - injector-listData : ${this.listDataFH.size}")
        return this
    }

    override fun addCustomView(customViewInt: Int): FrogoSingleRv<T> {
        this.customViewId = customViewInt
        FLog.d("$FROGO_RV_TAG - injector-customView : $customViewId")
        return this
    }

    override fun addEmptyView(emptyViewInt: Int?): FrogoSingleRv<T> {
        if (emptyViewInt != null) this.emptyViewId = emptyViewInt
        FLog.d("$FROGO_RV_TAG - injector-emptyView : $emptyViewId")
        return this
    }

    override fun addCallback(frogoViewAdapterCallback: IFrogoViewAdapter<T>): FrogoSingleRv<T> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        FLog.d("$FROGO_RV_TAG - injector-adaptCallback : $frogoAdapterCallback")
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
                override fun setupInitComponent(
                    view: View,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    frogoAdapterCallback.setupInitComponent(view, data, position, notifyListener)
                }
            })

            frogoViewAdapter.setupRequirement(customViewId, listData,
                object :
                    FrogoRecyclerViewListener<T> {
                    override fun onItemClicked(
                        view: View,
                        data: T,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<T>
                    ) {
                        frogoAdapterCallback.onItemClicked(view, data, position, notifyListener)
                    }

                    override fun onItemLongClicked(
                        view: View,
                        data: T,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<T>
                    ) {
                        frogoAdapterCallback.onItemLongClicked(view, data, position, notifyListener)
                    }
                })
            frogoViewAdapter.setupEmptyView(emptyViewId)

        }
    }

    protected open fun setupInnerAdapter() {
        FLog.d("$FROGO_RV_TAG - injector-optionAdapter : $optionAdapter")
        frogoRecycleView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoSingleRv<T> {
        createAdapter()
        setupLayoutManager(frogoRecycleView)
        setupInnerAdapter()
        return this
    }

    override fun frogoNotifyData(): MutableList<T> {
        return frogoViewAdapter.innerFrogoNotifyData()
    }

    override fun frogoNotifyDataSetChanged() {
        frogoViewAdapter.innerFrogoNotifyDataSetChanged()
    }

    override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        frogoViewAdapter.innerFrogoNotifyItemChanged(data, position, payload)
    }

    override fun frogoNotifyItemChanged(data: T, position: Int) {
        frogoViewAdapter.innerFrogoNotifyItemChanged(data, position)
    }

    override fun frogoNotifyItemInserted(data: T, position: Int) {
        frogoViewAdapter.innerFrogoNotifyItemInserted(data, position)
    }

    override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        frogoViewAdapter.innerFrogoNotifyItemMoved(data, fromPosition, toPosition)
    }

    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        frogoViewAdapter.innerFrogoNotifyItemRangeChanged(data, positionStart, payload)
    }

    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        frogoViewAdapter.innerFrogoNotifyItemRangeChanged(data, positionStart)
    }

    override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        frogoViewAdapter.innerFrogoNotifyItemRangeInserted(data, positionStart)
    }

    override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        frogoViewAdapter.innerFrogoNotifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun frogoNotifyItemRemoved(position: Int) {
        frogoViewAdapter.innerFrogoNotifyItemRemoved(position)
    }

}