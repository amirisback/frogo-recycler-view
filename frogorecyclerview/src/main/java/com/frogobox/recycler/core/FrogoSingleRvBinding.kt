package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/*
 * Created by Faisal Amir
 * =========================================
 * RecyclerViewAdapter
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
open class FrogoSingleRvBinding<T, VB : ViewBinding> : FrogoSingleRvBase<T>(),
    IFrogoSingleRvBinding<T, VB> {

    protected lateinit var frogoRecycleView: RecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoBindingAdapter<T, VB>
    protected lateinit var frogoBindingAdapter: FrogoBindingAdapter<T, VB>

    protected var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: RecyclerView): FrogoSingleRvBinding<T, VB> {
        frogoRecycleView = frogoRecyclerView
        frogoBindingAdapter = FrogoBindingAdapter()
        return this
    }

    override fun createLayoutLinearVertical(dividerItem: Boolean): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutLinearVertical(dividerItem)
        return this
    }

    override fun createLayoutLinearVertical(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutLinearVertical(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutLinearHorizontal(dividerItem: Boolean): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutLinearHorizontal(dividerItem)
        return this
    }

    override fun createLayoutLinearHorizontal(
        dividerItem: Boolean,
        reverseLayout: Boolean,
        stackFromEnd: Boolean
    ): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutLinearHorizontal(dividerItem, reverseLayout, stackFromEnd)
        return this
    }

    override fun createLayoutStaggeredGrid(spanCount: Int): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutStaggeredGrid(spanCount)
        return this
    }

    override fun createLayoutGrid(spanCount: Int): FrogoSingleRvBinding<T, VB> {
        baseCreateLayoutGrid(spanCount)
        return this
    }

    override fun addData(listData: List<T>): FrogoSingleRvBinding<T, VB> {
        this.listData.addAll(listData)
        return this
    }


    override fun addCallback(frogoViewAdapterCallback: IFrogoBindingAdapter<T, VB>): FrogoSingleRvBinding<T, VB> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        return this
    }

    protected open fun createAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        frogoBindingAdapter.setCallback(object : IFrogoBindingHolder<T, VB> {
            override fun setupInitComponent(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<T>
            ) {
                frogoAdapterCallback.setupInitComponent(binding, data, position, notifyListener)
            }

            override fun setViewBinding(parent: ViewGroup): VB {
                return frogoAdapterCallback.setViewBinding(parent)
            }
        })

        frogoBindingAdapter.setupRequirement(
            listData,
            object : FrogoRecyclerBindingListener<T, VB> {
                override fun onItemClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    frogoAdapterCallback.onItemClicked(binding, data, position, notifyListener)
                }

                override fun onItemLongClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    frogoAdapterCallback.onItemLongClicked(binding, data, position, notifyListener)
                }
            })
    }

    protected open fun setupInnerAdapter() {
        frogoRecycleView.adapter = frogoBindingAdapter
    }

    override fun build(): FrogoSingleRvBinding<T, VB> {
        createAdapter()
        setupLayoutManager(frogoRecycleView)
        setupInnerAdapter()
        return this
    }

    override fun frogoNotifyData(): MutableList<T> {
        return frogoBindingAdapter.innerFrogoNotifyData()
    }

    override fun frogoNotifyDataSetChanged() {
        frogoBindingAdapter.innerFrogoNotifyDataSetChanged()
    }

    override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        frogoBindingAdapter.innerFrogoNotifyItemChanged(data, position, payload)
    }

    override fun frogoNotifyItemChanged(data: T, position: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemChanged(data, position)
    }

    override fun frogoNotifyItemInserted(data: T, position: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemInserted(data, position)
    }

    override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemMoved(data, fromPosition, toPosition)
    }

    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        frogoBindingAdapter.innerFrogoNotifyItemRangeChanged(data, positionStart, payload)
    }

    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemRangeChanged(data, positionStart)
    }

    override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemRangeInserted(data, positionStart)
    }

    override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun frogoNotifyItemRemoved(position: Int) {
        frogoBindingAdapter.innerFrogoNotifyItemRemoved(position)
    }

}