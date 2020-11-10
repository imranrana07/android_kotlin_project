package com.imranrana.students.core

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat

abstract class BaseActivity: AppCompatActivity() {
    abstract fun setLayout(): Int
    abstract fun setToolbar(): Toolbar
    abstract val isHomeDisplayEnabled: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        setActionbar(setToolbar(),isHomeDisplayEnabled)
    }

    private fun setActionbar(toolbar: Toolbar, isHomeDisplayEnabled: Boolean){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeDisplayEnabled)
        supportActionBar?.setHomeButtonEnabled(isHomeDisplayEnabled)
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home){
            onBackPressed()
            true
        }else{
            super.onOptionsItemSelected(item)
        }
    }
}