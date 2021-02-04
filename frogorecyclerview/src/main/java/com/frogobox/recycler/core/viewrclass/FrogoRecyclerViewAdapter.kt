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

    private var layoutRv: Int = 0
    private var customLayoutRestId: Int = 0
    private var emptyLayoutResId: Int = R.layout.frogo_container_empty_view

    private fun layoutHandle() {
        if (customLayoutRestId != 0) {
            layoutRv = if (listData.isNotEmpty()) {
                customLayoutRestId
            } else {
                emptyLayoutResId
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
            emptyLayoutResId = emptyView
        }
        emptyViewHandle()
    }

    fun setupRequirement(
        customViewId: Int,
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

        customLayoutRestId = customViewId
        emptyViewHandle()
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

}