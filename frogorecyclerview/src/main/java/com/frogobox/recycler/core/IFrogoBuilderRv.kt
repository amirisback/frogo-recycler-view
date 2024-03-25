package com.frogobox.recycler.core

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by faisalamir on 23/07/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface IFrogoBuilderRv<T> : FrogoDiffUtilCallback<T> {

    // Setup data FrogoRecyclerView
    fun setupData(): List<T>

    // Setup Custom View
    fun setupCustomView(): Int

    // Setup Empty View
    fun setupEmptyView(): Int?

    // Setup Layout Manager of FrogoRecyclerView
    fun setupLayoutManager(context: Context): RecyclerView.LayoutManager

    // Setup Init Component on ViewHolder
    fun setupInitComponent(
        view: View,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )

    // Setup root item clicked
    fun onItemClicked(
        view: View,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    )

    // Setup root item long clicked
    fun onItemLongClicked(
        view: View,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) {
    }

}