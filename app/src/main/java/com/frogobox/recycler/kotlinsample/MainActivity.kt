package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.R
import com.frogobox.recycler.adapter.FrogoRecyclerViewListener
import com.frogobox.recycler.kotlinsample.adapter.MainViewAdapter
import com.frogobox.recycler.model.ExampleModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel("Sample Data"))
        listString.add(ExampleModel("Sample Data"))
        listString.add(ExampleModel("Sample Data"))
        listString.add(ExampleModel("Sample Data"))
        return listString
    }

    private fun setupAdapter() {
        val adapter =
            MainViewAdapter()
        adapter.setupRequirement(
            R.layout.example_list_item,
            listData(),
            object : FrogoRecyclerViewListener<ExampleModel> {
                override fun onItemClicked(data: ExampleModel) {
                    Toast.makeText(this@MainActivity, data.name, Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(data: ExampleModel) {
                    Toast.makeText(this@MainActivity, data.name, Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setupEmptyView(R.layout.example_empty_view) // With Custom View
        recycler_view.adapter = adapter
        recycler_view.isViewLinearVertical(false)
    }

}