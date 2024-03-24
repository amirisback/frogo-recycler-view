package com.frogobox.recycler.core

import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.JustifyContent

/**
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 27/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.util
 *
 */

interface IFrogoRvSingleton<T> {

    // Init FrogoRecyclerView
    fun initSingleton(frogoRecyclerView: RecyclerView): IFrogoRvSingleton<T>

    // Create Linear Vertical Layout Manager
    fun createLayoutLinearVertical(dividerItem: Boolean = false): IFrogoRvSingleton<T>

    // Create Linear Vertical Layout Manager From End
    fun createLayoutLinearVertical(
        dividerItem: Boolean = false,
        reverseLayout: Boolean = false,
        stackFromEnd: Boolean = false
    ): IFrogoRvSingleton<T>

    // Create Linear Horizontal Layout Manager
    fun createLayoutLinearHorizontal(dividerItem: Boolean = false): IFrogoRvSingleton<T>

    // Create Linear Horizontal Layout Manager From End
    fun createLayoutLinearHorizontal(
        dividerItem: Boolean = false,
        reverseLayout: Boolean = false,
        stackFromEnd: Boolean = false
    ): IFrogoRvSingleton<T>

    // Create Staggered Grid Layout Manager
    fun createLayoutStaggeredGrid(spanCount: Int = 1): IFrogoRvSingleton<T>

    // Create Grid Layout Manager
    fun createLayoutGrid(spanCount: Int = 1): IFrogoRvSingleton<T>

    // Create FlexBox Layout Manager
    fun createLayoutFlexBox(
        flexDirection: Int = FlexDirection.ROW,
        justifyContent: Int = JustifyContent.FLEX_START
    ): IFrogoRvSingleton<T>

    // Adding Data for RecyclerView
    fun addData(listData: List<T>): IFrogoRvSingleton<T>

    // Build this FrogoRecyclerView
    fun build(): IFrogoRvSingleton<T>

    // Notify Data List
    fun frogoNotifyData(): MutableList<T>

    // Notify Data Set Changed
    fun frogoNotifyDataSetChanged()

    // Notify Data Item Changed
    fun frogoNotifyItemChanged(data: T, position: Int, payload: Any)

    // Notify Data Item Changed
    fun frogoNotifyItemChanged(data: T, position: Int)

    // Notify Data Item Inserted
    fun frogoNotifyItemInserted(data: T, position: Int)

    // Notify Data Item Moved
    fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int)

    // Notify Data Item Range Changed
    fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any)

    // Notify Data Item Range Changed
    fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int)

    // Notify Data Item Range Inserted
    fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int)

    // Notify Data Item Range Removed
    fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int)

    // Notify Data Item Removed
    fun frogoNotifyItemRemoved(position: Int)

}