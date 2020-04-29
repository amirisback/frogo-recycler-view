package com.frogobox.recycler.base.viewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.base.parent.FrogoRecyclerViewListener
import com.frogobox.recycler.base.parent.ParentFrogoRecyclerViewAdapter

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
abstract class FrogoRecyclerViewAdapterBinding<T, V : ViewBinding> :
    ParentFrogoRecyclerViewAdapter<T>() {

    private lateinit var mLayoutRecyclerViewBinding: V
    private lateinit var mLayoutCustomViewBinding: V

    private fun verifyViewBinding() {
        if (mListData.isNotEmpty()) {
            mLayoutRecyclerViewBinding = mLayoutCustomViewBinding
        }
    }

    fun setupRequirement(
        customViewBinding: V,
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
        verifyViewBinding()
        notifyDataSetChanged()
    }

    fun viewLayout(parent: ViewGroup): V {
        return mLayoutRecyclerViewBinding
    }


}