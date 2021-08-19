package com.frogobox.app.sample.kotlin.noadapter.simple

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.app.core.BaseActivity
import com.frogobox.frogodesignkit.databinding.FrogoRvListType1Binding
import com.frogobox.recycler.R
import com.frogobox.recycler.core.*
import com.frogobox.recycler.databinding.ActivityBaseBinding
import com.frogobox.app.model.ExampleModel
import com.frogobox.app.util.Constant

class KotlinNoAdapterActivity : BaseActivity<ActivityBaseBinding>() {

    private val dataInjectorRClass = Constant.dummyData("Injector R class")
    private val dataInjectorBinding = Constant.dummyData("Injector Binding")
    private val dataBuilderRClass = Constant.dummyData("Builder R class")
    private val dataBuilderBinding = Constant.dummyData("Builder Binding")

    override fun setupViewBinding(): ActivityBaseBinding {
        return ActivityBaseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("Kotlin No Adapter")
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnBinding.setOnClickListener {
                setupRvInjectorBinding()
            }
            btnR.setOnClickListener {
                setupRvInjector()
            }
            btnRBuilder.setOnClickListener {
                setupRvBuilder()
            }
            btnBindingBuilder.setOnClickListener {
                setupRvBuilderBinding()
            }
        }
        setupRvBuilder()
    }


    private fun setupRvInjector() {

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

        binding.frogoRecyclerView.injector<ExampleModel>()
            .addData(dataInjectorRClass)
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupRvInjectorBinding() {

        val adapterCallback = object : IFrogoBindingAdapter<ExampleModel, FrogoRvListType1Binding> {
            override fun setupInitComponent(binding: FrogoRvListType1Binding, data: ExampleModel) {
                binding.frogoRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
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

        binding.frogoRecyclerView.injectorBinding<ExampleModel, FrogoRvListType1Binding>()
            .addData(dataInjectorBinding)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupRvBuilder() {
        binding.frogoRecyclerView.builder(object : IFrogoBuilderRv<ExampleModel> {
            override fun setupData(): List<ExampleModel> {
                // Setup data FrogoRecyclerView
                return dataBuilderRClass
            }

            override fun setupCustomView(): Int {
                // Setup Custom View
                return R.layout.frogo_rv_list_type_1
            }

            override fun setupEmptyView(): Int? {
                // Setup Empty View
                return null
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of FrogoRecyclerView
                return FrogoLayoutManager.linearLayoutVertical(context)
            }

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
        })
    }

    private fun setupRvBuilderBinding() {
        binding.frogoRecyclerView.builderBinding(object :
            IFrogoBuilderRvBinding<ExampleModel, FrogoRvListType1Binding> {
            override fun setupData(): List<ExampleModel> {
                // Setup data FrogoRecyclerView
                return dataBuilderBinding
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                // Setup Layout Manager of FrogoRecyclerView
                return FrogoLayoutManager.linearLayoutVertical(context)
            }

            override fun setupInitComponent(binding: FrogoRvListType1Binding, data: ExampleModel) {
                binding.frogoRvListType1TvTitle.text = data.name
            }

            override fun setViewBinding(parent: ViewGroup): FrogoRvListType1Binding {
                return FrogoRvListType1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun onItemClicked(data: ExampleModel) {
                // setup item clicked on frogo recycler view
                showToast(data.name)
            }

            override fun onItemLongClicked(data: ExampleModel) {
                // setup item long clicked on frogo recycler view
                showToast(data.name)
            }

        })
    }

}
