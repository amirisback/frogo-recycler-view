package com.frogobox.recycler.base.viewmulti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.viewmulti.FrogoViewHolderFirst
import com.frogobox.recycler.boilerplate.viewmulti.FrogoViewHolderSecond
import com.frogobox.recycler.util.FrogoRvConstant.OPTION_HOLDER_FIRST
import com.frogobox.recycler.util.FrogoRvConstant.OPTION_HOLDER_SECOND

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base.adapter
 * 
 */
abstract class FrogoRecyclerViewAdapterMulti<T> :
    RecyclerView.Adapter<FrogoRecyclerViewHolderMulti<T>>() {

    private val mFrogoViewHolderList = mutableListOf<FrogoRecyclerViewHolderMulti<T>>()
    private val mRecyclerViewDataList = mutableListOf<T>()
    private val mRecyclerViewLayoutList = mutableListOf<Int>()

    private var mLayoutRecyclerViewInt: Int = 0
    private var mLayoutCustomViewInt: Int = 0
    private var mLayoutEmptyViewInt: Int = R.layout.frogo_rv_empty_view

    private val mOptionHolder = mutableListOf<Int>()

    private var mFirstViewListener: FrogoRecyclerViewListener<T>? = null
    private var mSecondViewListener: FrogoRecyclerViewListener<T>? = null

    private var hasEmptyView = false
    private var listCount = 0

    private fun layoutHandle() {
        mLayoutRecyclerViewInt = if (mRecyclerViewDataList.isNotEmpty()) {
            mLayoutCustomViewInt
        } else {
            mLayoutEmptyViewInt
        }
    }

    private fun emptyViewHandle() {
        layoutHandle()
        notifyDataSetChanged()
    }

    fun setupRequirement(
        dataList: List<T>?,
        layoutItemList: List<Int>,
        optionHolder: List<Int>,
        firstViewListener: FrogoRecyclerViewListener<T>?,
        secondViewListener: FrogoRecyclerViewListener<T>?
    ) {
        mRecyclerViewLayoutList.addAll(layoutItemList)
        mOptionHolder.addAll(optionHolder)

        if (firstViewListener != null) {
            mFirstViewListener = firstViewListener
        }

        if (secondViewListener != null) {
            mSecondViewListener = secondViewListener
        }

        mRecyclerViewDataList.clear()
        if (dataList != null) {
            mRecyclerViewDataList.addAll(dataList)
        }

    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            mLayoutEmptyViewInt = emptyView
        }
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup, position: Int): View {
        mLayoutCustomViewInt = mRecyclerViewLayoutList[position]
        layoutHandle()
        return LayoutInflater.from(parent.context).inflate(mLayoutRecyclerViewInt, parent, false)
    }

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (mRecyclerViewDataList.size == 0) {
                1
            } else {
                mRecyclerViewDataList.size
            }
            listCount
        } else {
            mRecyclerViewDataList.size
        }
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolderMulti<T>, position: Int) {
        if (hasEmptyView) {
            if (mRecyclerViewDataList.size != 0) {
                when (holder) {
                    is FrogoViewHolderFirst -> holder.bindItem(
                        mRecyclerViewDataList[position],
                        mFirstViewListener
                    )
                    is FrogoViewHolderSecond -> holder.bindItem(
                        mRecyclerViewDataList[position],
                        mSecondViewListener
                    )
                }
            }
        } else {
            when (holder) {
                is FrogoViewHolderFirst -> holder.bindItem(
                    mRecyclerViewDataList[position],
                    mFirstViewListener
                )
                is FrogoViewHolderSecond -> holder.bindItem(
                    mRecyclerViewDataList[position],
                    mSecondViewListener
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (mOptionHolder.size != 0) {
            if (mOptionHolder[position] == OPTION_HOLDER_SECOND) OPTION_HOLDER_SECOND else OPTION_HOLDER_FIRST
        } else {
            super.getItemViewType(position)
        }

    }

}