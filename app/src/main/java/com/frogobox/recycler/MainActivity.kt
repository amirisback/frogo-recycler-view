package com.frogobox.recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frogobox.recycler.javasample.JavaSampleActivity
import com.frogobox.recycler.kotlinsample.KotlinSampleActivity
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
    }

}
