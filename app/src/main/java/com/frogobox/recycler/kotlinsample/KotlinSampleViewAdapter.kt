package com.frogobox.recycler.kotlinsample

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.adapter.FrogoRecyclerViewAdapter
import com.frogobox.recycler.base.holder.FrogoRecyclerViewHolder
import com.frogobox.recycler.model.ExampleModel

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogorecyclerviewadapter
 *
 */
class KotlinSampleViewAdapter : FrogoRecyclerViewAdapter<ExampleModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<ExampleModel> {
        return KotlinSampleViewHolder(viewLayout(parent))
    }

    inner class KotlinSampleViewHolder(view: View) : FrogoRecyclerViewHolder<ExampleModel>(view) {

        private val tvExampleItem = view.findViewById<TextView>(R.id.tv_example_item)

        override fun initComponent(data: ExampleModel) {
            tvExampleItem.text = data.name
        }
    }

}