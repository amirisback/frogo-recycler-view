package com.frogobox.recycler.kotlinsample.usingadapter

import android.os.Bundle
import android.widget.Toast
import com.frogobox.recycler.R
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.core.FrogoRecyclerViewListener
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant

class KotlinSampleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvListBinding.root)
        setupAdapter()
        setupDetailActivity("Kotlin With Adapter")
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
            object :
                FrogoRecyclerViewListener<ExampleModel> {
                override fun onItemClicked(data: ExampleModel) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClicked(data: ExampleModel) {
                    Toast.makeText(this@KotlinSampleActivity, data.name, Toast.LENGTH_SHORT).show()
                }
            }
        )
        adapter.setupEmptyView(R.layout.frogo_container_empty_view) // With Custom View
        activityFrogoRvListBinding.frogoRecyclerView.adapter = adapter
        activityFrogoRvListBinding.frogoRecyclerView.isViewLinearVertical(false)
    }

}