package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.BaseActivity
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant
import kotlinx.android.synthetic.main.activity_frogo_rv_sample.*

class KotlinNoAdapterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frogo_rv_sample)
        setupFrogoRecyclerView()
        setupDetailActivity("Kotlin No Adapter")
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        return listString
    }

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object : FrogoAdapterCallback<ExampleModel> {
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.tv_example_item).text = data.name
            }

            override fun onItemClicked(data: ExampleModel) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(data: ExampleModel) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }
        }

        frogo_recycler_view.injector<ExampleModel>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .createAdapter()
            .build(frogo_recycler_view)
    }

}
