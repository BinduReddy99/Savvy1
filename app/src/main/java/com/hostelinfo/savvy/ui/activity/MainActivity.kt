package com.hostelinfo.savvy.ui.activity

import android.os.Bundle
import com.hostelinfo.savvy.R
import com.hostelinfo.savvy.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun uiHandle() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}