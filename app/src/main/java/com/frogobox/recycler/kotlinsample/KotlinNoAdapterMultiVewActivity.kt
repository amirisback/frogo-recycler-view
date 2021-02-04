package com.frogobox.recycler.kotlinsample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.recycler.R
import com.frogobox.recycler.core.*
import com.frogobox.recycler.core.FrogoHolder
import com.frogobox.recycler.model.ExampleModel
import com.frogobox.recycler.util.Constant

class KotlinNoAdapterMultiVewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFrogoRvGridBinding.root)
        setupFrogoRecyclerView()
        setupDetailActivity("Kotlin No Adapter - Multi View")
    }

    private fun firstCallback(): IFrogoViewHolder<ExampleModel> {
        return object : IFrogoViewHolder<ExampleModel> {
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_1_tv_title).text = data.name
                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(view.findViewById(R.id.frogo_rv_grid_type_1_frogo_dummy_content_description))
            }
        }
    }

    private fun secondCallback(): IFrogoViewHolder<ExampleModel> {
        return object : IFrogoViewHolder<ExampleModel>{
            override fun setupInitComponent(view: View, data: ExampleModel) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_title).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_subtitle).text = data.name
                view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_desc).text = FrogoRvConstant.DUMMY_LOREM_IPSUM

                Glide.with(view.context).load(FrogoRvConstant.LINK_PHOTO_GITHUB).into(view.findViewById<ImageView>(R.id.frogo_rv_grid_type_3_frogo_dummy_content_description))
            }
        }
    }

    private fun firstListenerType(): FrogoRecyclerViewListener<ExampleModel>{
        return object : FrogoRecyclerViewListener<ExampleModel>{
            override fun onItemClicked(data: ExampleModel) {
                showToast(data.name + " First")
            }

            override fun onItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 1")
            }
        }
    }

    private fun secondListenerType() : FrogoRecyclerViewListener<ExampleModel>{
        return object : FrogoRecyclerViewListener<ExampleModel>{
            override fun onItemClicked(data: ExampleModel) {
                showToast(data.name + " Second")
            }

            override fun onItemLongClicked(data: ExampleModel) {
                showToast("LAYOUT TYPE 2")
            }
        }
    }

    private fun data() : MutableList<FrogoHolder<ExampleModel>> {
        val data =  mutableListOf<FrogoHolder<ExampleModel>>()
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_3, FrogoRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()))
        data.add(FrogoHolder(ExampleModel(Constant.FULL_NAME), R.layout.frogo_rv_grid_type_1, FrogoRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()))
        return data
    }

    private fun setupFrogoRecyclerView() {
        activityFrogoRvGridBinding.frogoRecyclerView
            .injectors<ExampleModel>()
            .addData(data())
            .createLayoutStaggeredGrid(2)
            .build()
    }

}