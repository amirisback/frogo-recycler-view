package com.frogobox.apprecycler.sample.kotlin.usingadapter.simple

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.recycler.core.FrogoRecyclerViewAdapter
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.frogobox.apprecycler.model.ExampleModel
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.uikit.R

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

        private val tvExampleItem = view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title)

        override fun initComponent(
            data: ExampleModel,
            position: Int,
            notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
        ) {
            tvExampleItem.text = data.name
        }
    }

}