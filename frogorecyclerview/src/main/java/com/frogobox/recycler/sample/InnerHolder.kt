package com.frogobox.recycler.sample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener

/*
 * Created by Amir on 03/03/2021
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
class InnerHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    fun bindViews(data: T, listener: FrogoRecyclerViewListener<T>) {

        val textView: TextView = itemView.findViewById(R.id.text)
        textView.text = data.toString()

        itemView.setOnClickListener {
            listener.onItemClicked(data)
        }
        itemView.setOnLongClickListener {
            listener.onItemLongClicked(data)
            true
        }
    }

}