package com.hostelinfo.savvy.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hostelinfo.savvy.R
import com.hostelinfo.savvy.base.BaseActivity

class MainActivity : BaseActivity() {
    private var fragment: Fragment? = null
    override fun uiHandle() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uiHandle()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Log.d("err===", data.toString())
        if (fragment == null)
            fragment = this.supportFragmentManager.findFragmentById(R.id.main_nav_host)
                ?.childFragmentManager?.fragments?.get(0)

        if (resultCode == Activity.RESULT_OK) {
            fragment?.onActivityResult(requestCode, resultCode, data)
        }
    }

}