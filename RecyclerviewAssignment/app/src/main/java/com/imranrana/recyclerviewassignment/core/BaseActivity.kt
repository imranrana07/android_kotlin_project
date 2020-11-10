package com.imranrana.recyclerviewassignment.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setLayout(): Int
    abstract fun setToolbar(): Toolbar
    abstract val isHomeUpButtonEnabled: Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        setActionBar(setToolbar(),isHomeUpButtonEnabled)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setActionBar(toolbar: Toolbar, isHomeUpButtonEnabled: Boolean){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeUpButtonEnabled)
        supportActionBar?.setHomeButtonEnabled(isHomeUpButtonEnabled)
    }

    fun showToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}