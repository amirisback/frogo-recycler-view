package com.frogobox.recycler.base.viewbinding

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.base.parent.ParentFrogoRecyclerViewAdapter
import com.frogobox.recycler.util.FrogoRvViewBinding

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
 * com.frogobox.recycler.base
 * 
 */
abstract class FrogoRecylcerViewAdapterBinding<T> : ParentFrogoRecyclerViewAdapter<T>() {

    private var mLayoutRecyclerViewBinding: ViewBinding? = null
    private var mLayoutCustomViewBinding: ViewBinding? = null
    private var mLayoutEmptyViewBinding: ViewBinding? = null

    private fun verifyViewBinding() {
        if (mListData.isNotEmpty()) {
            mLayoutRecyclerViewBinding = mLayoutCustomViewBinding
        } else {
            mLayoutRecyclerViewBinding = mLayoutEmptyViewBinding
        }
    }

    private fun layoutHandle() {
        if (mLayoutCustomViewBinding != null) {
            verifyViewBinding()
        }
    }

    private fun emptyViewHandle() {
        layoutHandle()
        notifyDataSetChanged()
    }

    fun setupEmptyView(emptyView: ViewBinding?, context: Context) {
        hasEmptyView = true
        if (emptyView != null) {
            mLayoutEmptyViewBinding = emptyView
        } else {
            mLayoutEmptyViewBinding = FrogoRvViewBinding.frogoRvEmptyView(context)
        }
        emptyViewHandle()
    }

    fun setupRequirement(
        customViewBinding: ViewBinding,
        listData: List<T>?,
        listener: FrogoRecyclerViewListener<T>?
    ) {
        if (listener != null) {
            mFrogoRecyclerViewListener = listener
        }

        mListData.clear()
        if (listData != null) {
            mListData.addAll(listData)
        }

        mLayoutCustomViewBinding = customViewBinding
        emptyViewHandle()
    }

    fun viewLayout(): ViewBinding {
        return mLayoutRecyclerViewBinding!!
    }


}