package com.frogobox.recycler.dev

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import kotlin.collections.HashMap

class OuterAdapter(private val mItemClickListener: FrogoRecyclerViewListener<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mList = mutableListOf<MutableList<Int>>()
    private val listPosition = HashMap<Int, Int>()
    private var sharedPool = RecycledViewPool()

    fun setupData(list: MutableList<MutableList<Int>>) {
        mList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val innerRv = RecyclerView(parent.context)

        // inflate inner item, find innerRecyclerView by ID
        val innerLLM = LinearLayoutManager(parent.context, LinearLayoutManager.HORIZONTAL, false)
        innerLLM.initialPrefetchItemCount = 7 // depends on screen size
        innerRv.apply {
            setHasFixedSize(true)
            layoutManager = innerLLM
            setRecycledViewPool(sharedPool)
        }
        return OuterHolder(innerRv, mItemClickListener)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder.itemViewType) {
            else -> {
                val cellViewHolder = viewHolder as OuterHolder
                cellViewHolder.bindItem(mList[position])
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
        val cellViewHolder = viewHolder as OuterHolder
        val firstVisiblePosition =
            cellViewHolder.getLinearLayoutManager().findFirstVisibleItemPosition()
        listPosition[position] = firstVisiblePosition
        super.onViewRecycled(viewHolder)
    }

    override fun getItemCount(): Int {
        if (mList.isNullOrEmpty()) {
            return 0
        }
        return mList.size
    }

}