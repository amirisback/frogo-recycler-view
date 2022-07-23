package com.frogobox.apprecycler.sample.kotlin

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.frogobox.api.news.ConsumeNewsApi
import com.frogobox.apprecycler.BuildConfig
import com.frogobox.apprecycler.R
import com.frogobox.apprecycler.core.BaseActivity
import com.frogobox.apprecycler.databinding.ActivityFrogoRvExtBinding
import com.frogobox.coreapi.ConsumeApiResponse
import com.frogobox.coreapi.news.NewsConstant
import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coreapi.news.model.Article
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.recycler.util.FLog
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.recycler.ext.injector
import com.frogobox.sdk.ext.glideLoad
import com.frogobox.sdk.ext.gone
import com.frogobox.sdk.ext.usingChuck
import com.frogobox.sdk.ext.visible

class FrogoRvExtActivity : BaseActivity<ActivityFrogoRvExtBinding>() {

    override fun setupViewBinding(): ActivityFrogoRvExtBinding {
        return ActivityFrogoRvExtBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDetailActivity("RecyclerView Extension")
        setupApi()
    }

    private fun setupApi() {
        ConsumeNewsApi(NewsUrl.API_KEY)
            .usingChuckInterceptor(BuildConfig.DEBUG, this.usingChuck())
            .apply {
                getTopHeadline(
                    null,
                    null,
                    NewsConstant.CATEGORY_ENTERTAIMENT,
                    NewsConstant.COUNTRY_ID,
                    null,
                    null,
                    object : ConsumeApiResponse<ArticleResponse> {
                        override fun onFailed(statusCode: Int, errorMessage: String) {

                        }

                        override fun onFinish() {

                        }

                        override fun onHideProgress() {
                            runOnUiThread { binding.progressCircular.gone() }
                        }

                        override fun onShowProgress() {
                            runOnUiThread { binding.progressCircular.visible() }
                        }

                        override fun onSuccess(data: ArticleResponse) {
                            runOnUiThread {
                                data.articles?.let { setupRecyclerView(it) }
                            }
                        }
                    }
                )
            }
    }

    private fun setupRecyclerView(listData: List<Article>) {

        val adapterCallback = object :
            IFrogoViewAdapter<Article> {
            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // Init component content item recyclerview
                view.findViewById<TextView>(R.id.frogo_rv_list_type_8_tv_title).text = data.title
                view.findViewById<TextView>(R.id.frogo_rv_list_type_8_tv_subtitle).text =
                    data.description
                view.findViewById<ImageView>(R.id.frogo_rv_list_type_8_civ_poster)
                    .glideLoad(data.urlToImage)
            }

            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // setup item clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
                data.title?.let { showToast(it) }
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                // setup item long clicked on frogo recycler view
                FLog.d("Clicked on Position : $position")
            }
        }

        binding.rv.injector<Article>()
            .addData(listData)
            .addCustomView(R.layout.frogo_rv_list_type_8)
            .addEmptyView(null)
            .addCallback(adapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }


}