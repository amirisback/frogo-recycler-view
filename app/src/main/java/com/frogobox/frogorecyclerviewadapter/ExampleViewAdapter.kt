package com.frogobox.frogorecyclerviewadapter

import android.view.View
import android.view.ViewGroup
import com.frogobox.frogoviewadapter.FrogoRecyclerViewAdapter
import com.frogobox.frogoviewadapter.FrogoRecyclerViewHolder
import kotlinx.android.synthetic.main.example_list_item.view.*

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
class ExampleViewAdapter : FrogoRecyclerViewAdapter<String>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<String> {
        return ExampleViewHolder(viewLayout(parent))
    }

    inner class ExampleViewHolder(view: View) : FrogoRecyclerViewHolder<String>(view) {

        private val tvExampleItem = view.tv_example_item

        override fun initComponent(data: String) {
            super.initComponent(data)

            tvExampleItem.text = data

        }
    }

}