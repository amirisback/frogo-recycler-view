package com.frogobox.recycler.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoSingleRv
import com.frogobox.recycler.core.FrogoSingleSrv
import com.frogobox.recycler.widget.FrogoStyleComponent.setupComponentFrogoRecyclerView
import com.frogobox.recycler.databinding.WidgetFrogoShimmerRecyclerviewBinding

/**
 * Created by Faisal Amir on 02/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoShimmerRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes), IFrogoShimmerRecyclerView {

    private lateinit var binding: WidgetFrogoShimmerRecyclerviewBinding

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        binding =
            WidgetFrogoShimmerRecyclerviewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val styleArrayRecyclerView =
                context?.obtainStyledAttributes(it, R.styleable.frogo_recycler_view, 0, 0)

            // setup inner component
            binding.apply {
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentFrogoRecyclerView(
                        it1,
                        widgetFsrvRecyclerview
                    )
                }
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentFrogoRecyclerView(
                        it1,
                        widgetFsrvShimmerRecyclerview
                    )
                }
            }

            styleArrayRecyclerView?.recycle()
        }
    }

    override fun startShimmer() {
        binding.apply {
            widgetFsrvShimmer.visibility = View.VISIBLE
            widgetFsrvShimmer.startShimmer()
        }
    }

    override fun stopShimmer() {
        binding.apply {
            widgetFsrvShimmer.visibility = View.GONE
            widgetFsrvShimmer.stopShimmer()
        }
    }

    override fun defineShimmerView(): FrogoSingleSrv {
        return FrogoSingleSrv().initSingleton(binding.widgetFsrvShimmerRecyclerview) as FrogoSingleSrv
    }

    override fun <T> defineRecyclerView(): FrogoSingleRv<T> {
        return FrogoSingleRv<T>().initSingleton(binding.widgetFsrvRecyclerview)
    }

}