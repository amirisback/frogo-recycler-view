package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.util.Constant
import com.frogobox.recycler.R
import com.frogobox.recycler.adapter.FrogoRecyclerViewListener
import com.frogobox.recycler.model.ExampleModel
import kotlinx.android.synthetic.main.activity_frogo_rv_sample.*

class KotlinSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frogo_rv_sample)
        setupAdapter()
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        return listString
    }

    private fun setupAdapter() {
        val adapter =
            KotlinSampleViewAdapter()
        adapter.setupRequirement(
            R.layout.frogo_rv_list_type_1,
            listData(),
            object : FrogoRecyclerViewListener<ExampleModel> {
                override fun onItemClicked(data: ExampleModel) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(data: ExampleModel) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setupEmptyView(R.layout.example_empty_view) // With Custom View
        frogo_recycler_view.adapter = adapter
        frogo_recycler_view.isViewLinearVertical(false)
    }

}