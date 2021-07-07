package com.frogobox.recycler

import android.os.Bundle
import com.frogobox.recycler.core.BaseActivity
import com.frogobox.recycler.databinding.ActivityMainDevBinding

class MainDevActivity : BaseActivity<ActivityMainDevBinding>() {

    override fun setupViewBinding(): ActivityMainDevBinding {
        return ActivityMainDevBinding.inflate(layoutInflater)
    }

}