package com.frogobox.recycler

import android.os.Bundle
import com.frogobox.recycler.base.BaseActivity

class MainDevActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainDevBinding.root)

        activityMainDevBinding.rvShimmer.startShimmer()

    }
}