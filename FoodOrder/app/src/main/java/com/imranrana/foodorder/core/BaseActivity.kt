package com.imranrana.foodorder.core

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
abstract class BaseActivity :AppCompatActivity() {
    abstract fun setLayoutId(): Int
    abstract fun setToolbar(): Toolbar
    abstract val isHomeUpButtonEnable: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        setActionBar(setToolbar(), isHomeUpButtonEnable)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId ==  android.R.id.home){
            onBackPressed()
             true
        }else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnable: Boolean){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnable)
        supportActionBar?.setHomeButtonEnabled(isHomeUpButtonEnable)
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
    /*


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }*/
}

