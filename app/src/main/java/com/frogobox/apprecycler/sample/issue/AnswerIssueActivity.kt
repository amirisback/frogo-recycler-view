package com.frogobox.apprecycler.sample.issue

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.apprecycler.core.BaseActivity
import com.frogobox.apprecycler.databinding.ActivityAnswerIssueBinding
import com.frogobox.apprecycler.databinding.ItemAnswerIssueBinding
import com.frogobox.apprecycler.model.ExampleModel
import com.frogobox.apprecycler.util.Constant
import com.frogobox.recycler.core.FrogoLayoutManager
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoBuilderRvBinding

class AnswerIssueActivity : BaseActivity<ActivityAnswerIssueBinding>() {

    private val dataBuilderBinding = Constant.dummyData("Builder Binding")

    override fun setupViewBinding(): ActivityAnswerIssueBinding {
        return ActivityAnswerIssueBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRV()
    }

    private fun setupRV() {
        binding.frogoRv.builderBinding(object :
            IFrogoBuilderRvBinding<ExampleModel, ItemAnswerIssueBinding> {
            override fun setupData(): List<ExampleModel> {
                return dataBuilderBinding
            }

            override fun setupLayoutManager(context: Context): RecyclerView.LayoutManager {
                return FrogoLayoutManager.linearLayoutVertical(context)
            }

            override fun setViewBinding(parent: ViewGroup): ItemAnswerIssueBinding {
                return ItemAnswerIssueBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }

            override fun areContentsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun setupInitComponent(
                binding: ItemAnswerIssueBinding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {
                binding.restaurantName.text = data.name
                binding.openingHours.text = data.name
            }

            override fun onItemClicked(
                binding: ItemAnswerIssueBinding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {

            }

            override fun onItemLongClicked(
                binding: ItemAnswerIssueBinding,
                data: ExampleModel,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<ExampleModel>
            ) {

            }
        })
    }

}