package com.frogobox.recycler.sample

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.frogobox.recycler.core.FrogoStartSnapHelper
import java.util.*
import kotlin.collections.HashMap

//https://developer.android.com/topic/performance/vitals/render#recyclerview_nested_recyclerviews

class OuterAdapter(private val mItemClickListener: InnerAdapter.OnItemClickListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mList: ArrayList<ArrayList<Int>>? = null
    private val listPosition = HashMap<Int, Int>()
    private var sharedPool = RecycledViewPool()

    fun updateList(list: ArrayList<ArrayList<Int>>?) {
        mList = list
    }

    private inner class CellViewHolder(val rv: RecyclerView, listener: InnerAdapter.OnItemClickListener?) : RecyclerView.ViewHolder(rv) {

        private var mAdapter: InnerAdapter = InnerAdapter().apply {
            setOnItemClickListener(listener)
        }

        fun getLinearLayoutManager(): LinearLayoutManager {
            return rv.layoutManager as LinearLayoutManager
        }

        fun setData(list: ArrayList<Int>?) {
            mAdapter.updateList(list)
        }

        init {
            rv.apply {
                adapter = mAdapter

                // this is needed if you are working with CollapsingToolbarLayout, I am adding this here just in case I forget.
                isNestedScrollingEnabled = false
            }

            //optional
            FrogoStartSnapHelper().attachToRecyclerView(rv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val innerRv = RecyclerView(parent.context)

        // inflate inner item, find innerRecyclerView by ID…
        val innerLLM = LinearLayoutManager(parent.context, LinearLayoutManager.HORIZONTAL, false)
        innerLLM.initialPrefetchItemCount = 7 // depends on screen size
        innerRv.apply {
            setHasFixedSize(true)
            layoutManager = innerLLM
            setRecycledViewPool(sharedPool)
        }
        return CellViewHolder(innerRv, mItemClickListener)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder.itemViewType) {
            else -> {
                val cellViewHolder = viewHolder as CellViewHolder
                cellViewHolder.setData(mList!![position])
                val p = if (listPosition.containsKey(position) && listPosition[position]!! >= 0) {
                    listPosition[position]!!
                } else {
                    0
                }
                cellViewHolder.getLinearLayoutManager().scrollToPositionWithOffset(p, 0)
            }
        }
    }

    override fun onViewRecycled(viewHolder: RecyclerView.ViewHolder) {
        val position = viewHolder.adapterPosition
        val cellViewHolder = viewHolder as CellViewHolder
        val firstVisiblePosition = cellViewHolder.getLinearLayoutManager().findFirstVisibleItemPosition()
        listPosition[position] = firstVisiblePosition
        super.onViewRecycled(viewHolder)
    }


    override fun getItemCount(): Int {
        if (mList.isNullOrEmpty()) {
            return 0
        }
        return mList!!.size
    }
}