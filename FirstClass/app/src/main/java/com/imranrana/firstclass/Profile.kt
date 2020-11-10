package com.imranrana.firstclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"
        val getBundleInfo = intent?.extras

        nameTvValue.text = getBundleInfo?.getString("name")
        ageTvValue.text = getBundleInfo?.getString("age")
        phoneTvValue.text = getBundleInfo?.getString("phone")
        weightTvValue.text = getBundleInfo?.getString("weight")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}