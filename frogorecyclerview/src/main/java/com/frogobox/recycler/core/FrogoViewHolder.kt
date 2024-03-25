package com.frogobox.recycler.core

import android.view.View

/**
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
 * com.frogobox.recycler
 *
 */

class FrogoViewHolder<T>(view: View, private val frogoViewHolderCallback: IFrogoViewHolder<T>?) :
    FrogoRecyclerViewHolder<T>(view) {

    override fun initComponent(
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
        frogoViewHolderCallback?.setupInitComponent(itemView, data, position, notifyListener)
    }

}