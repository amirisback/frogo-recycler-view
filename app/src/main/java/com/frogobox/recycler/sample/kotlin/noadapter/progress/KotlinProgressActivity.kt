package com.frogobox.recycler.sample.kotlin.noadapter.progress

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
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.recycler.databinding.ActivityKotlinProgressBinding

class KotlinProgressActivity : BaseActivity<ActivityKotlinProgressBinding>() {

    override fun setupViewBinding(): ActivityKotlinProgressBinding {
        return ActivityKotlinProgressBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("Kotlin FrogoProgressRecyclerView Sample")
        setupNewsApi()
        setupButtonProgress()
    }

    private fun setupFrogoProgressRecyclerView(data: List<Article>) {

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

        binding.rvProgress.defineRecyclerView<Article>()
            .addData(data)
            .addCustomView(R.layout.frogo_rv_list_type_1)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

    private fun setupProgress(state: Boolean) {
        binding.apply {
            if (state) {
                rvProgress.showProgress()
            } else {
                rvProgress.hideProgress()
            }
        }
    }

    private fun setupButtonProgress() {
        var bool = false
        binding.buttonProgress.setOnClickListener {
            bool = !bool
            setupProgress(bool)
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
                    data.articles?.let { setupFrogoProgressRecyclerView(it) }
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
                        binding.rvProgress.showProgress()
                    }
                }

                override fun onHideProgress() {
                    // Your Progress Hide
                    Log.d("RxJavaHide", "Hide Progress")
                    runOnUiThread {
                        // Stuff that updates the UI
                        binding.rvProgress.hideProgress()
                    }

                }

            })
    }

}