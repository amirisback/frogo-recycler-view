package com.frogobox.recycler.ext

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.FrogoBindingAdapter
import com.frogobox.recycler.core.FrogoBuilderRv
import com.frogobox.recycler.core.FrogoBuilderRvBinding
import com.frogobox.recycler.core.FrogoSingleRv
import com.frogobox.recycler.core.FrogoSingleRvBinding
import com.frogobox.recycler.core.FrogoViewAdapter
import com.frogobox.recycler.core.IFrogoBuilderRv
import com.frogobox.recycler.core.IFrogoBuilderRvBinding


/**
 * Created by faisalamir on 12/04/22
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.
 * All rights reserved
 *
 */

fun <T> RecyclerView.injector(): FrogoSingleRv<T> {
    return FrogoSingleRv<T>().initSingleton(this)
}

fun <T, VB : ViewBinding> RecyclerView.injectorBinding(): FrogoSingleRvBinding<T, VB> {
    return FrogoSingleRvBinding<T, VB>().initSingleton(this)
}

fun <T> RecyclerView.builder(listener: IFrogoBuilderRv<T>) {
    return FrogoBuilderRv<T>().initBuilder(this).builder(listener)
}

fun <T, VB : ViewBinding> RecyclerView.builderBinding(listener: IFrogoBuilderRvBinding<T, VB>) {
    return FrogoBuilderRvBinding<T, VB>().initBuilder(this).builder(listener)
}

fun <T> RecyclerView.getAdapterExt(): FrogoViewAdapter<T> {
    return this.adapter as FrogoViewAdapter<T>
}

fun <T> RecyclerView.setupData(data: List<T>) {
    this.getAdapterExt<T>().setupData(data)
}

fun <T, VB : ViewBinding> RecyclerView.getAdapterBindingExt(): FrogoBindingAdapter<T, VB> {
    return this.adapter as FrogoBindingAdapter<T, VB>
}

fun <T, VB : ViewBinding> RecyclerView.setupDataBinding(data: List<T>) {
    this.getAdapterBindingExt<T, VB>().setupData(data)
}

fun RecyclerView.addOnBottomScrollListener(onBottomReached: () -> Unit = {}) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            (recyclerView.layoutManager as? LinearLayoutManager)?.let {
                if (dy >= 0) {
                    val visibleItemCount = it.childCount
                    val totalItemCount = it.itemCount
                    val pastVisibleItems = it.findFirstVisibleItemPosition()
                    if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                        onBottomReached()
                    }
                }
            }

            (recyclerView.layoutManager as? GridLayoutManager)?.let {
                if (dy >= 0) {
                    val visibleItemCount = it.childCount
                    val totalItemCount = it.itemCount
                    val pastVisibleItems = it.findFirstVisibleItemPosition()
                    if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                        onBottomReached()
                    }
                }
            }
        }
    })
}

fun RecyclerView.addOnTopScrollListener(onTopReached: () -> Unit = {}) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            (recyclerView.layoutManager as? LinearLayoutManager)?.let {
                if (dy <= 0) {

                    val visibleItemCount = it.childCount
                    val totalItemCount = it.itemCount
                    val pastVisibleItems = it.findFirstVisibleItemPosition()
                    if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                        onTopReached()
                    }
                }
            }
        }
    })
}
