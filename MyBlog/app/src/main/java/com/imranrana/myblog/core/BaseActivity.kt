package com.imranrana.myblog.core

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


abstract class BaseActivity: AppCompatActivity() {
    abstract fun setLayout(): Int
    abstract fun setToolBar(): Toolbar
    abstract val isHomeButtonEnabled: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        setLayoutActionBar(setToolBar(),isHomeButtonEnabled)
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        onBackPressed()
        return true
    }

    private fun setLayoutActionBar(toolbar: Toolbar,isHomeButtonEnabled: Boolean) {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(isHomeButtonEnabled)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeButtonEnabled)
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}