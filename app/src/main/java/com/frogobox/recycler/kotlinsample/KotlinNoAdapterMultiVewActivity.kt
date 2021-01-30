package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.recycler.R
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.adapter.callback.FrogoViewAdapterMultiCallback
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant
import com.frogobox.recycler.util.FrogoRvConstant

class KotlinNoAdapterMultiVewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvGridBinding.root)
        setupFrogoRecyclerView()
        setupDetailActivity("Kotlin No Adapter - Multi View")
    }

    private fun listData(): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
        listString.add(ExampleModel(Constant.FULL_NAME))
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
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_SECOND)
        listOption.add(FrogoRvConstant.OPTION_HOLDER_FIRST)
        return listOption
    }

    private fun listLayout(): MutableList<Int> {
        val listLayout = mutableListOf<Int>()
        listLayout.add(R.layout.frogo_rv_grid_type_1)
        listLayout.add(R.layout.frogo_rv_grid_type_3)
        return listLayout
    }

    private fun setupFrogoRecyclerView() {

        val adapterCallback = object : FrogoViewAdapterMultiCallback<ExampleModel> {
            override fun setupFirstInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_1_tv_title).text = data.name
                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB)
                    .into(view.findViewById<ImageView>(R.id.frogo_rv_grid_type_1_frogo_dummy_content_description))
            }

            override fun setupSecondInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_title).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_subtitle).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_desc).text =
                    FrogoRvConstant.DUMMY_LOREM_IPSUM

                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB)
                    .into(view.findViewById<ImageView>(R.id.frogo_rv_grid_type_3_frogo_dummy_content_description))
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

        activityFrogoRvGridBinding.frogoRecyclerView
            .injectorMulti<ExampleModel>()
            .addData(listData())
            .addCustomView(listLayout())
            .addOptionHolder(listOption())
            .addCallback(adapterCallback)
            .addEmptyView(null)
            .createLayoutStaggeredGrid(2)
            .build()
    }


}
