package com.frogobox.apprecycler.sample.kotlin.noadapter.progress

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.apprecycler.BuildConfig
import com.frogobox.apprecycler.core.BaseActivity
import com.frogobox.apprecycler.databinding.ActivityKotlinProgressBinding
import com.frogobox.coreapi.ConsumeApiResponse
import com.frogobox.coreutil.news.NewsConstant
import com.frogobox.coreutil.news.NewsUrl
import com.frogobox.coreutil.news.model.Article
import com.frogobox.coreutil.news.response.ArticleResponse
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.sdk.ext.progressViewHandle
import com.frogobox.ui.R

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
            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_1_tv_title).text = data.title
            }

            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // setup item clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // setup item long clicked on frogo recycler view
                data.title?.let { showToast(it) }
            }

            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
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
            rvProgress.progressViewHandle(state)
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
        ConsumeNewsApi(NewsUrl.API_KEY)
            .usingChuckInterceptor(BuildConfig.DEBUG, this)
            .apply {
                getTopHeadline( // Adding Base Parameter on main function
                    null,
                    null,
                    null,
                    NewsConstant.COUNTRY_ID,
                    null,
                    null,
                    object : ConsumeApiResponse<ArticleResponse> {
                        override fun onSuccess(data: ArticleResponse) {
                            // Your Ui or data
                            data.articles?.let { setupFrogoProgressRecyclerView(it) }
                        }

                        override fun onFailed(statusCode: Int, errorMessage: String) {
                            // Your failed to do
                            showToast(errorMessage)
                        }

                        override fun onFinish() {
                            // Your finish to do
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

}