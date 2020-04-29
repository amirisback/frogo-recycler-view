package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.recycler.R
import com.frogobox.recycler.base.BaseActivity
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoViewAdapterMultiCallback
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant
import com.frogobox.recycler.util.FrogoRvConstant

class KotlinNoAdapterMultiVewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvSampleBinding.root)
        setupFrogoRecyclerView()
        setupDetailActivity("Kotlin No Adapter - Multi View")
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        return listString
    }

    private fun listOption(): MutableList<Int> {
        val listOption = mutableListOf<Int>()
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST)
        return listOption
    }

    private fun listLayout(): MutableList<Int> {
        val listLayout = mutableListOf<Int>()
        listLayout.add(R.layout.frogo_rv_list_type_1)
        listLayout.add(R.layout.frogo_rv_list_type_2)
        return listLayout
    }

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object : FrogoViewAdapterMultiCallback<ExampleModel> {
            override fun setupFirstInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_type_1_tv_title).text = data.name
            }

            override fun setupSecondInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_type_2_tv_title).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_type_2_tv_subtitle).text = data.name
            }

            override fun onFirstItemClicked(data: ExampleModel) {
                showToast(data.name + " First")
            }

            override fun onFirstItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 1")
            }

            override fun onSecondItemClicked(data: ExampleModel) {
                showToast(data.name + " Second")
            }

            override fun onSecondItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 2")
            }
        }

        activityFrogoRvSampleBinding.frogoRecyclerView
            .injectorMulti<ExampleModel>()
            .addData(listData())
            .addCustomView(listLayout())
            .addOptionHolder(listOption())
            .addCallback(adapterCallback)
            .addEmptyView(null)
            .createLayoutLinearVertical(false)
            .build()
    }


}
