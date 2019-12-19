package com.frogobox.frogorecyclerviewadapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.frogoviewadapter.FrogoRecyclerViewListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), FrogoRecyclerViewListener<String> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun listData(): MutableList<String> {
        val listString = mutableListOf<String>()
        listString.add("Example")
        listString.add("Example")
        listString.add("Example")
        listString.add("Example")
        return listString
    }

    private fun setupAdapter() {
        val adapter = ExampleViewAdapter()
        adapter.setupRequirement(this, listData(), R.layout.example_list_item)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClicked(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClicked(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
    }

}