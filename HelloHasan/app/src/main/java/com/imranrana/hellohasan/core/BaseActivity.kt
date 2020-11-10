package com.imranrana.hellohasan.core

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setLayout(): Int
    abstract fun setLayoutActionBar(): Toolbar
    abstract val isHomeButtonEnabled: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        setActionBar(setLayoutActionBar(), isHomeButtonEnabled)
    }

    private fun setActionBar(toolbar: Toolbar, isHomeButtonEnabled: Boolean){
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(isHomeButtonEnabled)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeButtonEnabled)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId ==  android.R.id.home){
            onBackPressed()
            true
        }else {
            super.onOptionsItemSelected(item)
        }
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

//    fun setToolBarTitle
}