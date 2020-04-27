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
        setContentView(R.layout.activity_main)
        setupButton()
    }

    private fun setupButton() {
        btn_with_data.setOnClickListener {
            startActivity(Intent(this, KotlinSampleActivity::class.java))
        }

        btn_empty_data.setOnClickListener {
            startActivity(Intent(this, JavaSampleActivity::class.java))
        }

        btn_java_no_adapter.setOnClickListener {
            startActivity(Intent(this, JavaNoAdapterActivity::class.java))
        }

        btn_kotlin_no_adapter.setOnClickListener {
            startActivity(Intent(this, KotlinNoAdapterActivity::class.java))
        }

        btn_kotlin_multiview.setOnClickListener {
            startActivity(Intent(this, KotlinNoAdapterMultiVewActivity::class.java))
        }

        btn_java_multiview.setOnClickListener {
            startActivity(Intent(this, JavaNoAdapterMultiViewActivity::class.java))
        }

    }

}
