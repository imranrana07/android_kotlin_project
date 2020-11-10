package com.imranrana.secondassignment.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.imranrana.secondassignment.R

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setActionBar(title: String, homeEnabled: Boolean){
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(homeEnabled)
    }

    fun showLongToast(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }

    fun showShortToast(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }


}