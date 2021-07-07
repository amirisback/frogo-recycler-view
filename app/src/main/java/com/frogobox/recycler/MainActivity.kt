package com.frogobox.recycler

import android.content.Intent
import android.os.Bundle
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.databinding.ActivityMainBinding
import com.frogobox.recycler.javasample.JavaNoAdapterActivity
import com.frogobox.recycler.javasample.JavaNoAdapterMultiViewActivity
import com.frogobox.recycler.javasample.usingadapter.JavaSampleActivity
import com.frogobox.recycler.kotlinsample.KotlinNoAdapterActivity
import com.frogobox.recycler.kotlinsample.KotlinNoAdapterMultiVewActivity
import com.frogobox.recycler.kotlinsample.KotlinProgressActivity
import com.frogobox.recycler.kotlinsample.KotlinShimmerActivity
import com.frogobox.recycler.kotlinsample.usingadapter.KotlinNestedActivity
import com.frogobox.recycler.kotlinsample.usingadapter.KotlinSampleActivity
import com.frogobox.recycler.kotlinsample.usingadapter.KotlinSimpleNestedActivity

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
