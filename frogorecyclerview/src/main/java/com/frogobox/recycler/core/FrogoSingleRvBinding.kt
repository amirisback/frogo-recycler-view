package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.frogobox.frogolog.FLog
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
open class FrogoSingleRvBinding<T, VB : ViewBinding> : FrogoSingleRvBase<T>(), IFrogoSingleRvBinding<T, VB> {

    protected lateinit var mFrogoRecyclerView: FrogoRecyclerView
    protected lateinit var frogoAdapterCallback: IFrogoBindingAdapter<T, VB>
    protected lateinit var frogoViewAdapter: FrogoBindingAdapter<T, VB>
    
    protected var optionAdapter = ""

    override fun initSingleton(frogoRecyclerView: FrogoRecyclerView): FrogoSingleRvBinding<T, VB> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoBindingAdapter()
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
        FLog.d("injector-listData : ${this.listData.size}")
        return this
    }


    override fun addCallback(frogoViewAdapterCallback: IFrogoBindingAdapter<T, VB>): FrogoSingleRvBinding<T, VB> {
        this.frogoAdapterCallback = frogoViewAdapterCallback
        FLog.d("injector-adaptCallback : $frogoAdapterCallback")
        return this
    }

    protected open fun createAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        frogoViewAdapter.setCallback(object : IFrogoBindingHolder<T, VB> {
            override fun setupInitComponent(binding: VB, data: T) {
                frogoAdapterCallback.setupInitComponent(binding, data)
            }

            override fun setViewBinding(parent: ViewGroup): VB {
                return frogoAdapterCallback.setViewBinding(parent)
            }
        })

        frogoViewAdapter.setupRequirement(listData,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoAdapterCallback.onItemLongClicked(data)
                }
            })
    }

    protected open fun setupInnerAdapter() {
        FLog.d("injector-optionAdapter : $optionAdapter")
        mFrogoRecyclerView.adapter = frogoViewAdapter
    }

    override fun build(): FrogoSingleRvBinding<T, VB> {
        createAdapter()
        setupLayoutManager(mFrogoRecyclerView)
        setupInnerAdapter()
        return this
    }

}