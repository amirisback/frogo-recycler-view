package com.frogobox.app

import android.content.Intent
import android.os.Bundle
import com.frogobox.app.core.BaseActivity
import com.frogobox.app.sample.java.noadapter.multiview.JavaNoAdapterMultiViewActivity
import com.frogobox.app.sample.java.noadapter.simple.JavaNoAdapterActivity
import com.frogobox.app.sample.java.usingadapter.JavaSampleActivity
import com.frogobox.recycler.databinding.ActivityMainBinding
import com.frogobox.app.sample.kotlin.noadapter.simple.KotlinNoAdapterActivity
import com.frogobox.app.sample.kotlin.noadapter.multiview.KotlinNoAdapterMultiVewActivity
import com.frogobox.app.sample.kotlin.noadapter.progress.KotlinProgressActivity
import com.frogobox.app.sample.kotlin.noadapter.shimmer.KotlinShimmerActivity
import com.frogobox.app.sample.kotlin.usingadapter.nested.KotlinNestedActivity
import com.frogobox.app.sample.kotlin.usingadapter.simple.KotlinSampleActivity
import com.frogobox.app.sample.kotlin.usingadapter.nested.KotlinSimpleNestedActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButton()
    }

    private fun setupButton() {

        binding.apply {
            btnWithData.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinSampleActivity::class.java))
            }

            btnEmptyData.setOnClickListener {
                startActivity(Intent(this@MainActivity, JavaSampleActivity::class.java))
            }

            btnJavaNoAdapter.setOnClickListener {
                startActivity(Intent(this@MainActivity, JavaNoAdapterActivity::class.java))
            }

            btnKotlinNoAdapter.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinNoAdapterActivity::class.java))
            }

            btnKotlinMultiview.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinNoAdapterMultiVewActivity::class.java))
            }

            btnJavaMultiview.setOnClickListener {
                startActivity(Intent(this@MainActivity, JavaNoAdapterMultiViewActivity::class.java))
            }

            btnKotlinShimmer.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinShimmerActivity::class.java))
            }

            btnKotlinProgress.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinProgressActivity::class.java))
            }

            btnNestedSimple.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinSimpleNestedActivity::class.java))
            }

            btnNested.setOnClickListener {
                startActivity(Intent(this@MainActivity, KotlinNestedActivity::class.java))
            }
        }

    }

}
