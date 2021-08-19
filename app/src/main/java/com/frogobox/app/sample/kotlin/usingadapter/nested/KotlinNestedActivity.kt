package com.frogobox.app.sample.kotlin.usingadapter.nested

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.frogobox.app.core.BaseActivity
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant
import com.frogobox.frogonewsapi.util.NewsUrl
import com.frogobox.recycler.R
import com.frogobox.recycler.core.*
import com.frogobox.recycler.databinding.ActivityFrogoRvGridBinding

class KotlinNestedActivity : BaseActivity<ActivityFrogoRvGridBinding>() {

    override fun setupViewBinding(): ActivityFrogoRvGridBinding {
        return ActivityFrogoRvGridBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("Nested RecyclerView")
        setupNewsApi()
    }

    private fun setupNewsApi() {
        val consumeNewsApi = ConsumeNewsApi(NewsUrl.NEWS_API_KEY)
        consumeNewsApi.usingChuckInterceptor(this)
        consumeNewsApi.getTopHeadline( // Adding Base Parameter on main function
            null,
            null,
            null,
            NewsConstant.COUNTRY_ID,
            null,
            null,
            object : NewsResultCallback<ArticleResponse> {
                override fun getResultData(data: ArticleResponse) {
                    // Your Ui or data
                    val listData = mutableListOf<Article>()
                    data.articles?.let { listData.addAll(it) }
                    setupRecyclerView(setupDataNested(listData))
                }

                override fun failedResult(statusCode: Int, errorMessage: String?) {
                    // Your failed to do
                    errorMessage?.let { showToast(it) }
                }

                override fun onShowProgress() {
                    // Your Progress Show
                    Log.d("RxJavaShow", "Show Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                    }
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                    }

                }

            })
    }

    private fun setupDataNested(data: MutableList<Article>): MutableList<MutableList<Article>> {
        val list = mutableListOf<MutableList<Article>>()
        for (i in 0..10) {
            list.add(data)
        }
        return list
    }

    private fun setupRecyclerView(data: MutableList<MutableList<Article>>) {

        val mLinearLayoutManager = LinearLayoutManager(this)
        val mAdapter = FrogoNestedAdapter<Article>()
        mAdapter.setCallback(object : IFrogoNestedHolder<Article> {
            override fun nestedCustomView(): Int {
                return R.layout.frogo_rv_grid_type_3
            }

            override fun nestedListener(): FrogoRecyclerViewListener<Article> {
                return object : FrogoRecyclerViewListener<Article> {
                    override fun onItemClicked(data: Article) {
                        showToast("Click : $data")
                    }

                    override fun onItemLongClicked(data: Article) {
                        showToast("Long Click : $data")
                    }
                }
            }

            override fun nestedCallback(): IFrogoViewHolder<Article> {
                return object : IFrogoViewHolder<Article> {
                    override fun setupInitComponent(view: View, data: Article) {
                        val iv = view.findViewById<ImageView>(R.id.frogo_rv_grid_type_3_iv_poster)
                        val tv_title =
                            view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_title)
                        val tv_sub =
                            view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_subtitle)
                        val tv_desc = view.findViewById<TextView>(R.id.frogo_rv_grid_type_3_tv_desc)

                        Glide.with(view.context).load(data.urlToImage).into(iv)
                        tv_title.text = data.title
                        tv_sub.text = data.author
                        tv_desc.text = data.description
                    }
                }
            }
        })
        mAdapter.setupNestedView()
        mAdapter.setupDataNested(data)
        binding.frogoRecyclerView.apply {
            layoutManager = mLinearLayoutManager
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }


}