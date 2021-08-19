package com.frogobox.apprecycler.sample.kotlin.noadapter.shimmer

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.frogobox.frogonewsapi.ConsumeNewsApi
import com.frogobox.frogonewsapi.callback.NewsResultCallback
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant
import com.frogobox.frogonewsapi.util.NewsUrl
import com.frogobox.recycler.R
import com.frogobox.apprecycler.core.BaseActivity
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.apprecycler.databinding.ActivityKotlinShimmerBinding

class KotlinShimmerActivity : BaseActivity<ActivityKotlinShimmerBinding>() {
    
    override fun setupViewBinding(): ActivityKotlinShimmerBinding {
        return ActivityKotlinShimmerBinding.inflate(layoutInflater)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("Kotlin FrogoShimmerRecyclerView Sample")
        setupShimmerLoading()
        setupNewsApi()
        setupButtonShimmer()
    }

    private fun setupFrogoShimmerRecyclerView(data: List<Article>) {

        val adapterCallback = object :
            IFrogoViewAdapter<Article> {
            override fun setupInitComponent(view: View, data: Article) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.title
            }

            override fun onItemClicked(data: Article) {
                // setup item clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(data: Article) {
                // setup item long clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }
        }

        binding.rvShimmer.defineRecyclerView<Article>()
            .addData(data)
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupShimmer(state: Boolean) {
        if (state) {
            binding.rvShimmer.startShimmer()
        } else {
            binding.rvShimmer.stopShimmer()
        }
    }

    private fun setupButtonShimmer() {
        var bool = false
        binding.buttonShimmer.setOnClickListener {
            bool = !bool
            setupShimmer(bool)
        }
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
                    data.articles?.let { setupFrogoShimmerRecyclerView(it) }
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
                        binding.rvShimmer.startShimmer()
                    }
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                        binding.rvShimmer.stopShimmer()
                    }

                }

            })
    }

    private fun setupShimmerLoading() {
        binding.rvShimmer.defineShimmerView()
            .addShimmerSumOfItemLoading(7)
            .addShimmerViewPlaceHolder(R.layout.frogo_rv_list_type_1)
            .createLayoutLinearVertical(false)
            .build()
    }

}