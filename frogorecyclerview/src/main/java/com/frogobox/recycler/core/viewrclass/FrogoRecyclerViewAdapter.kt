package com.frogobox.recycler.core.viewrclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.CoreFrogoRecyclerViewAdapter

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
abstract class FrogoRecyclerViewAdapter<T> : CoreFrogoRecyclerViewAdapter<T>() {

    private var mLayoutRecyclerViewInt: Int = 0
    private var mLayoutCustomViewInt: Int = 0
    private var mLayoutEmptyViewInt: Int = R.layout.frogo_container_empty_view

    private fun layoutHandle() {
        if (mLayoutCustomViewInt != 0) {
            if (listData.isNotEmpty()) {
                mLayoutRecyclerViewInt = mLayoutCustomViewInt
            } else {
                mLayoutRecyclerViewInt = mLayoutEmptyViewInt
            }
        }
    }

    private fun emptyViewHandle() {
        layoutHandle()
        notifyDataSetChanged()
    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            mLayoutEmptyViewInt = emptyView
        }
        emptyViewHandle()
    }

    fun setupRequirement(
        customViewInt: Int,
        listData: List<T>?,
        listener: FrogoRecyclerViewListener<T>?
    ) {

        if (listener != null) {
            viewListener = listener
        }

        this.listData.clear()
        if (listData != null) {
            this.listData.addAll(listData)
        }

        mLayoutCustomViewInt = customViewInt
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(mLayoutRecyclerViewInt, parent, false)
    }

}