package com.frogobox.recycler

import android.content.Intent
import android.os.Bundle
import com.frogobox.recycler.base.BaseActivity
import com.frogobox.recycler.javasample.JavaNoAdapterActivity
import com.frogobox.recycler.javasample.JavaNoAdapterMultiViewActivity
import com.frogobox.recycler.javasample.usingadapter.JavaSampleActivity
import com.frogobox.recycler.kotlinsample.KotlinNoAdapterActivity
import com.frogobox.recycler.kotlinsample.KotlinNoAdapterMultiVewActivity
import com.frogobox.recycler.kotlinsample.usingadapter.KotlinSampleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
        setupButton()
    }

    private fun setupButton() {
        activityMainBinding.btnWithData.setOnClickListener {
            startActivity(Intent(this, KotlinSampleActivity::class.java))
        }

        activityMainBinding.btnEmptyData.setOnClickListener {
            startActivity(Intent(this, JavaSampleActivity::class.java))
        }

        activityMainBinding.btnJavaNoAdapter.setOnClickListener {
            startActivity(Intent(this, JavaNoAdapterActivity::class.java))
        }

        activityMainBinding.btnKotlinNoAdapter.setOnClickListener {
            startActivity(Intent(this, KotlinNoAdapterActivity::class.java))
        }

        activityMainBinding.btnKotlinMultiview.setOnClickListener {
            startActivity(Intent(this, KotlinNoAdapterMultiVewActivity::class.java))
        }

        activityMainBinding.btnKotlinMultiview.setOnClickListener {
            startActivity(Intent(this, JavaNoAdapterMultiViewActivity::class.java))
        }

    }

}
