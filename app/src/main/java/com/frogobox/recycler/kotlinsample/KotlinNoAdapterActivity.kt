package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.frogobox.frogodesignkit.databinding.FrogoRvListType1Binding
import com.frogobox.recycler.R
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.core.IFrogoBindingAdapter
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant

class KotlinNoAdapterActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvListBinding.root)
//        setupFrogoRecyclerView()
        setupFrogoRecyclerBinding()
        setupDetailActivity("Kotlin No Adapter")
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
//        listString.add(ExampleModel("VIEWBINDING ANJING"))
//        listString.add(ExampleModel(Constant.FULL_NAME))
//        listString.add(ExampleModel(Constant.FULL_NAME))
//        listString.add(ExampleModel(Constant.FULL_NAME))
        return listString
    }

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object :
            IFrogoViewAdapter<ExampleModel> {
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

        activityFrogoRvListBinding.frogoRecyclerView.injector<ExampleModel>()
            .addData(listData())
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false,false,true)
            .build()
    }


    private fun setupFrogoRecyclerBinding() {

        val adapterCallback = object : IFrogoBindingAdapter<ExampleModel, FrogoRvListType1Binding> {
            override fun setupInitComponent(view: FrogoRvListType1Binding, data: ExampleModel) {
                view.frogoRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
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


        activityFrogoRvListBinding.frogoRecyclerView.injectorBinding<ExampleModel, FrogoRvListType1Binding>()
            .addData(listData())
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false,false,true)
            .build()


    }

}
