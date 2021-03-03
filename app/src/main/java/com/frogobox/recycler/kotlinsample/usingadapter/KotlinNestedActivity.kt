package com.frogobox.recycler.kotlinsample.usingadapter

import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recycler.R
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.core.IFrogoNestedHolder
import com.frogobox.recycler.core.IFrogoViewHolder
import com.frogobox.recycler.dev.FrogoNestedAdapter

class KotlinNestedActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvGridBinding.root)

        turnOnStrictMode()
        setupRecyclerView()
    }

    private fun setupData(): MutableList<Int> {
        val subList1 = mutableListOf<Int>()
        for (i in 0..49) {
            subList1.add(i)
        }
        return subList1
    }

    private fun setupDataNested(): MutableList<MutableList<Int>> {
        val list = mutableListOf<MutableList<Int>>()
        for (i in 0..10) {
            list.add(setupData())
        }
        return list
    }

    private fun setupRecyclerView() {

        val mLinearLayoutManager = LinearLayoutManager(this)
        val mAdapter = FrogoNestedAdapter<Int>()
        mAdapter.setCallback(object : IFrogoNestedHolder<Int>{
            override fun nestedCustomView(): Int {
                return R.layout.cell_nested_list
            }

            override fun nestedListener(): FrogoRecyclerViewListener<Int> {
                return object : FrogoRecyclerViewListener<Int> {
                    override fun onItemClicked(data: Int) {
                        Toast.makeText(this@KotlinNestedActivity, "click $data", Toast.LENGTH_SHORT).show()
                    }

                    override fun onItemLongClicked(data: Int) {
                        Toast.makeText(this@KotlinNestedActivity, "long click $data", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun nestedCallback(): IFrogoViewHolder<Int> {
                return object : IFrogoViewHolder<Int> {
                    override fun setupInitComponent(view: View, data: Int) {
                        val tv = view.findViewById<TextView>(R.id.text)
                        tv.text = data.toString()
                    }
                }
            }
        })
        mAdapter.setupNestedView()
        mAdapter.setupDataNested(setupDataNested())
        activityFrogoRvGridBinding.frogoRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }


    private fun turnOnStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder().detectAll()
                .penaltyLog().penaltyFlashScreen().build()
        )
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder().detectAll()
                .penaltyLog().build()
        )
    }
}