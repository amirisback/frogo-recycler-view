package com.frogobox.recycler.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.*
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.adapter.callback.FrogoViewAdapterMultiCallback
import com.frogobox.recycler.core.viewmulti.FrogoRvSingletonMulti
import com.frogobox.recycler.core.viewrclass.FrogoRvSingletonRclass
import com.frogobox.recycler.core.viewbinding.FrogoRvSingletonViewBinding
import com.frogobox.recycler.core.viewmulti.FrogoViewAdapterMulti
import com.frogobox.recycler.core.viewmulti.FrogoViewHolderMultiCallback
import com.frogobox.recycler.util.FrogoRvConstant


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * frogo-recycler-view-adapter
 * Copyright (C) 30/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter.view
 *
 */
class FrogoRecyclerView : RecyclerView,
    IFrogoRecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @Deprecated(FrogoRvConstant.Deprecated.isViewLinearVertical)
    override fun isViewLinearVertical(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewLinearHorizontal)
    override fun isViewLinearHorizontal(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewStaggeredGrid)
    override fun isViewStaggeredGrid(spanCount: Int) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewGrid)
    override fun isViewGrid(spanCount: Int) {
        layoutManager = GridLayoutManager(context, spanCount)
    }

    @Deprecated(FrogoRvConstant.Deprecated.injectAdapter)
    override fun <T> injectAdapterMultiType(
        listData: List<T>?,
        multiCustomView: List<Int>,
        multiOptionHolder: List<Int>,
        emptyView: Int?,
        frogoViewAdapterMultiCallback: FrogoViewAdapterMultiCallback<T>
    ) {

        val frogoMultiViewAdapter = FrogoViewAdapterMulti(object : FrogoViewHolderMultiCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoViewAdapterMultiCallback.setupFirstInitComponent(view, data)
            }
        }, object : FrogoViewHolderMultiCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoViewAdapterMultiCallback.setupSecondInitComponent(view, data)
            }
        })

        frogoMultiViewAdapter.setupRequirement(
            listData,
            multiCustomView,
            multiOptionHolder,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoViewAdapterMultiCallback.onFirstItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoViewAdapterMultiCallback.onFirstItemLongClicked(data)
                }
            },
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoViewAdapterMultiCallback.onSecondItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoViewAdapterMultiCallback.onSecondItemLongClicked(data)
                }
            }
        )
        frogoMultiViewAdapter.setupEmptyView(emptyView)
        adapter = frogoMultiViewAdapter

    }

    override fun <T> injector(): FrogoRvSingletonRclass<T> =
        FrogoRvSingletonRclass<T>().initSingleton(this)

    override fun <T> injectorMulti(): FrogoRvSingletonMulti<T> =
        FrogoRvSingletonMulti<T>().initSingleton(this)

    override fun <T, V : ViewBinding> injectorViewBinding(): FrogoRvSingletonViewBinding<T, V> =
        FrogoRvSingletonViewBinding<T, V>()
            .initSingleton(this)
}