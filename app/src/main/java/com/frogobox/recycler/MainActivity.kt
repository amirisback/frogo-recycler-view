package com.frogobox.recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.recycler.javasample.JavaSampleActivity
import com.frogobox.recycler.javasample.JavaSampleNoAdapterActivity
import com.frogobox.recycler.kotlinsample.KotlinSampleActivity
import com.frogobox.recycler.kotlinsample.KotlinSampleNoAdapterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupButton()
    }

    private fun setupButton(){
        btn_with_data.setOnClickListener {
            startActivity(Intent(this, KotlinSampleActivity::class.java))
        }

        btn_empty_data.setOnClickListener {
            startActivity(Intent(this, JavaSampleActivity::class.java))
        }

        btn_java_no_adapter.setOnClickListener {
            startActivity(Intent(this, JavaSampleNoAdapterActivity::class.java))
        }

        btn_kotlin_no_adapter.setOnClickListener {
            startActivity(Intent(this, KotlinSampleNoAdapterActivity::class.java))
        }
    }

}
