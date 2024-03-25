package com.frogobox.recycler.core

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

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

interface IFrogoLayoutManager {

    fun linearLayoutVertical(context: Context): RecyclerView.LayoutManager

    fun linearLayoutVertical(
        context: Context,
        reverseLayout: Boolean = false,
        stackFromEnd: Boolean = false
    ): RecyclerView.LayoutManager

    fun linearLayoutHorizontal(context: Context): RecyclerView.LayoutManager

    fun linearLayoutHorizontal(
        context: Context,
        reverseLayout: Boolean = false,
        stackFromEnd: Boolean = false
    ): RecyclerView.LayoutManager

    fun dividerItemVertical(context: Context): DividerItemDecoration

    fun dividerItemHorizontal(context: Context): DividerItemDecoration

    fun staggeredGridLayout(spanCount: Int = 1): StaggeredGridLayoutManager

    fun gridLayout(context: Context, spanCount: Int = 1): GridLayoutManager

    fun flexboxLayout(
        context: Context,
        flexDirection: Int = FlexDirection.ROW,
        justifyContent: Int = JustifyContent.FLEX_START
    ): FlexboxLayoutManager

}