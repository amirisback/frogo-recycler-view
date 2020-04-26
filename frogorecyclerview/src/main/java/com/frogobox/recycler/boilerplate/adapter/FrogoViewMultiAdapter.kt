package com.frogobox.recycler.boilerplate.adapter

import android.view.ViewGroup
import com.frogobox.recycler.base.adapter.FrogoRecyclerViewMultiAdapter
import com.frogobox.recycler.base.holder.FrogoRecyclerViewHolder
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolder
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolderFirst
import com.frogobox.recycler.boilerplate.holder.FrogoViewHolderSecond
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback
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
 * com.frogobox.recycler.boilerplate.adapter
 * 
 */
class FrogoViewMultiAdapter<T>(
    private val frogoHolderCallbackFirst: FrogoHolderCallback<T>,
    private val frogoHolderCallbackSecond: FrogoHolderCallback<T>
) :
    FrogoRecyclerViewMultiAdapter<T>() {

    private fun firstFrogoViewHolder(parent: ViewGroup): FrogoViewHolderFirst<T> {
        return FrogoViewHolderFirst(viewLayout(parent, OPTION_HOLDER_FIRST), frogoHolderCallbackFirst)
    }

    private fun secondFrogoViewHolder(parent: ViewGroup): FrogoViewHolderSecond<T> {
        return FrogoViewHolderSecond(viewLayout(parent, OPTION_HOLDER_SECOND), frogoHolderCallbackSecond)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<T> {

        return when (viewType) {
            OPTION_HOLDER_FIRST -> {
                firstFrogoViewHolder(parent)
            }

            OPTION_HOLDER_SECOND -> {
                secondFrogoViewHolder(parent)
            }

            else -> {
                firstFrogoViewHolder(parent)
            }
        }

    }

}