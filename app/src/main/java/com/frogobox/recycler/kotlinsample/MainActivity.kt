package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.R
import com.frogobox.recycler.kotlinsample.adapter.MainViewAdapter
import com.frogobox.recycler.kotlinsample.adapter.MainViewListener
import com.frogobox.recycler.model.ExampleModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainViewListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        listString.add(ExampleModel("Amir Is Back"))
        return listString
    }

    private fun setupAdapter() {
        val adapter =
            MainViewAdapter()
        adapter.setupRequirement(
            this, listData(),
            R.layout.example_list_item
        )
        recycler_view.adapter = adapter
        recycler_view.isViewLinearVertical(false)
    }

    override fun onItemClickedMain(data: ExampleModel) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClickedMain(data: ExampleModel) {
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }

}