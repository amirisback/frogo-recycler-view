package com.frogobox.recycler.core.multi

import android.view.ViewGroup
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.frogobox.recycler.core.FrogoRvConstant.OPTION_HOLDER_FIRST
import com.frogobox.recycler.core.FrogoRvConstant.OPTION_HOLDER_SECOND
import com.frogobox.recycler.core.FrogoViewHolder
import com.frogobox.recycler.core.IFrogoViewHolder

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
 * com.frogobox.recycler.adapter
 * 
 */
class FrogoViewAdapterMulti<T>(
    private val frogoViewHolderCallbackFirst: IFrogoViewHolder<T>,
    private val frogoViewHolderCallbackSecond: IFrogoViewHolder<T>
) :
    FrogoRecyclerViewAdapterMulti<T>() {

    private fun firstFrogoViewHolder(parent: ViewGroup): FrogoViewHolder<T> {
        return FrogoViewHolder(
            viewLayout(parent, OPTION_HOLDER_FIRST),
            frogoViewHolderCallbackFirst
        )
    }

    private fun secondFrogoViewHolder(parent: ViewGroup): FrogoViewHolder<T> {
        return FrogoViewHolder(
            viewLayout(parent, OPTION_HOLDER_SECOND),
            frogoViewHolderCallbackSecond
        )
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