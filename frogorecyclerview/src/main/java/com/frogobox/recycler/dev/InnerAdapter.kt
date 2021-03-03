package com.frogobox.recycler.dev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R
import com.frogobox.recycler.core.FrogoRecyclerViewListener

class InnerAdapter<T>(private val listener: FrogoRecyclerViewListener<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mList = mutableListOf<T>()

    fun setupData(list: MutableList<T>) {
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InnerHolder<T>(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.frogo_list_nested_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val holders = holder as InnerHolder<T>
        holders.bindViews(mList[position], listener)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}