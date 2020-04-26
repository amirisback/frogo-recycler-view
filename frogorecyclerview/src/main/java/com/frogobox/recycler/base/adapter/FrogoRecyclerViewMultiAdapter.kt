package com.frogobox.recycler.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.holder.FrogoRecyclerViewHolder
import com.frogobox.recycler.base.listener.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolderFirst
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolderSecond
import com.frogobox.recycler.util.Constant.OPTION_HOLDER_FIRST
import com.frogobox.recycler.util.Constant.OPTION_HOLDER_SECOND

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
abstract class FrogoRecyclerViewMultiAdapter<T> :
    RecyclerView.Adapter<FrogoRecyclerViewHolder<T>>(),
    FrogoMultiAdapterView<T> {

    private val mFrogoViewHolderList = mutableListOf<FrogoRecyclerViewHolder<T>>()
    private val mRecyclerViewDataList = mutableListOf<T>()
    private val mRecyclerViewLayoutList = mutableListOf<Int>()

    private val mOptionHolder = mutableListOf<Int>()

    private var mFirstViewListener: FrogoRecyclerViewListener<T>? = null
    private var mSecondViewListener: FrogoRecyclerViewListener<T>? = null

    private var mRecyclerViewLayout: Int = 0
    private var mLayoutItem: Int = 0
    private var mEmptyView: Int = R.layout.frogo_rv_empty_view

    private var hasEmptyView = false
    private var listCount = 0

    private fun layoutHandle() {
        mRecyclerViewLayout = if (mRecyclerViewDataList.isNotEmpty()) {
            mLayoutItem
        } else {
            mEmptyView
        }
        notifyDataSetChanged()
    }

    override fun setupRequirement(
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

        layoutHandle()
    }

    override fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            mEmptyView = emptyView
        }
        layoutHandle()
    }

    override fun viewLayout(parent: ViewGroup, position: Int): View {
        mLayoutItem = mRecyclerViewLayoutList[position]
        return LayoutInflater.from(parent.context).inflate(mRecyclerViewLayout, parent, false)
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

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
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
        return if (mOptionHolder[position] == OPTION_HOLDER_FIRST) OPTION_HOLDER_FIRST else OPTION_HOLDER_SECOND
    }

}