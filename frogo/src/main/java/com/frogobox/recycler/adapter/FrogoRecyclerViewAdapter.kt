package com.frogobox.recycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
abstract class FrogoRecyclerViewAdapter<T> : RecyclerView.Adapter<FrogoRecyclerViewHolder<T>>() {

    private var mViewListener: FrogoRecyclerViewListener<T>? = null

    private val mRecyclerViewDataList = mutableListOf<T>()
    private var mRecyclerViewLayout: Int = 0

    private var mEmptyView: Int = R.layout.empty_view_frogo
    private var hasEmptyView = false
    private var listCount = 0

    fun setupRequirement(
        viewListener: FrogoRecyclerViewListener<T>?,
        dataList: List<T>?,
        layoutItem: Int?
    ) {

        if (viewListener != null) {
            mViewListener = viewListener
        }

        if (dataList != null) {
            if (dataList.isNotEmpty()) {
                mRecyclerViewDataList.clear()
                if (dataList != null) {
                    mRecyclerViewDataList.addAll(dataList)
                }
                if (layoutItem != null) {
                    mRecyclerViewLayout = layoutItem
                }
            } else {
                mRecyclerViewLayout = mEmptyView
            }
        }

        notifyDataSetChanged()
    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            mEmptyView = emptyView
        }
        mRecyclerViewLayout = mEmptyView
        notifyDataSetChanged()
    }

    protected fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(mRecyclerViewLayout, parent, false)
    }

    override fun getItemCount(): Int {
        if (hasEmptyView) {
            if (mRecyclerViewDataList.size == 0) {
                listCount = 1
            } else {
                listCount = mRecyclerViewDataList.size
            }
            return listCount
        } else {
            return mRecyclerViewDataList.size
        }
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        if (hasEmptyView) {
            if (mRecyclerViewDataList.size != 0) {
                holder.bindItem(mRecyclerViewDataList[position], mViewListener)
            }
        } else {
            holder.bindItem(mRecyclerViewDataList[position], mViewListener)
        }
    }

}