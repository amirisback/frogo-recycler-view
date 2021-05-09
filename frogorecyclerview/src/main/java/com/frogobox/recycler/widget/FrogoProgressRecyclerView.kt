package com.frogobox.recycler.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRvSingle
import com.frogobox.recycler.widget.FrogoStyleComponent.setupComponentFrogoRecyclerView
import com.frogobox.recycler.databinding.WidgetFrogoProgressRecyclerviewBinding
import com.frogobox.recycler.widget.FrogoStyleComponent.setupComponentProgressBar

/*
 * Created by Faisal Amir on 17/02/2021
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class FrogoProgressRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes), IFrogoProgressRecyclerView {

    private lateinit var binding: WidgetFrogoProgressRecyclerviewBinding

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        binding =
            WidgetFrogoProgressRecyclerviewBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val styleArrayRecyclerView =
                context?.obtainStyledAttributes(it, R.styleable.frogo_recycler_view, 0, 0)
            val styleArrayProgressBar =
                context?.obtainStyledAttributes(it, R.styleable.frogo_progress_bar, 0, 0)

            // setup inner component
            binding.apply {
                styleArrayRecyclerView?.let { it1 ->
                    setupComponentFrogoRecyclerView(
                        it1,
                        widgetFprvRecyclerview
                    )
                }
                styleArrayProgressBar?.let { it1 ->
                    setupComponentProgressBar(
                        it1,
                        widgetFprvProgressbar
                    )
                }
            }

            styleArrayRecyclerView?.recycle()
        }
    }

    override fun <T> defineRecyclerView(): FrogoRvSingle<T> {
        return FrogoRvSingle<T>().initSingleton(binding.widgetFprvRecyclerview)
    }

    override fun showProgress() {
        binding.widgetFprvProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.widgetFprvProgressbar.visibility = View.GONE
    }
}