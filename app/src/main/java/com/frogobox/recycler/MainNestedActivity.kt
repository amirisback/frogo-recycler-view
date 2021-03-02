package com.frogobox.recycler

import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recycler.core.InnerAdapter
import com.frogobox.recycler.core.OuterAdapter
import kotlinx.android.synthetic.main.activity_main_nested.*
import java.util.*

class MainNestedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nested)
        turnOnStrictMode()

        val subList1 = ArrayList<Int>()
        for (i in 0..49) {
            subList1.add(i)
        }
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0..49) {
            list.add(subList1)
        }

        rv_nested.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        rv_nested.layoutManager = layoutManager
        val adapter = OuterAdapter(object : InnerAdapter.OnItemClickListener {
            override fun onItemClick(view: View, data: Int) {
                Toast.makeText(this@MainNestedActivity, "click $data", Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(view: View, data: Int) {
                Toast.makeText(this@MainNestedActivity, "long click $data", Toast.LENGTH_SHORT).show()
            }
        })
        rv_nested.adapter = adapter
        adapter.updateList(list)
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