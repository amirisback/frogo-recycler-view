package com.frogobox.recycler

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.frogobox.recycler.base.BaseActivity
import com.frogobox.recycler.boilerplate.viewrclass.FrogoViewAdapterCallback
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant

class MainDevActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainDevBinding.root)
        setupFrogoShimmerRecyclerView()
        setupButtonShimmer()
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        return listString
    }

    private fun setupFrogoShimmerRecyclerView() {

        val adapterCallback = object :
            FrogoViewAdapterCallback<ExampleModel> {
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.name
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

        activityMainDevBinding.rvShimmer.injector<ExampleModel>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addShimmerViewPlaceHolder(R.layout.frogo_rv_list_type_1)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupShimmer(state: Boolean) {
        if (state) {
            activityMainDevBinding.rvShimmer.startShimmer()
        } else {
            activityMainDevBinding.rvShimmer.stopShimmer()
        }
    }

    private fun setupButtonShimmer() {
        var bool = false
        activityMainDevBinding.buttonShimmer.setOnClickListener {
            bool = !bool
            setupShimmer(bool)
        }
    }

}