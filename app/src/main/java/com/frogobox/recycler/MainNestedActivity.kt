package com.frogobox.recycler

import android.os.Bundle
import android.os.StrictMode
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.dev.FrogoOuterAdapter
import com.frogobox.recycler.sample.OuterAdapter
import kotlinx.android.synthetic.main.activity_main_nested.*
import java.util.*

class MainNestedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nested)

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

        val layoutManager = LinearLayoutManager(this)
        val adapter = OuterAdapter(object : FrogoRecyclerViewListener<Int> {
            override fun onItemClicked(data: Int) {
                Toast.makeText(this@MainNestedActivity, "click $data", Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClicked(data: Int) {
                Toast.makeText(this@MainNestedActivity, "long click $data", Toast.LENGTH_SHORT)
                    .show()
            }

        })
        adapter.setupData(setupDataNested())
        rv_nested.layoutManager = layoutManager
        rv_nested.setHasFixedSize(true)
        rv_nested.adapter = adapter
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