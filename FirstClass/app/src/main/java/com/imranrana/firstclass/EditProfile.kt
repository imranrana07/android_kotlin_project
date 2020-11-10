package com.imranrana.firstclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import com.imranrana.firstclass.R
import kotlinx.android.synthetic.main.activity_edit_profile.*
import java.security.Key

class EditProfile : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit Profile"
        btn_submit.setOnClickListener(this)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            return true
        }
        return false
    }

    override fun onClick(view: View?) {

        if (view?.id == R.id.btn_submit) {
            if (ifInfoValid()) {
                val intent = Intent(this, Profile::class.java)
                val bundle = bundleOf(
                    Pair("name", nameEt.text.toString()),
                    Pair("age", ageEt.text.toString()),
                    Pair("phone", phoneEt.text.toString()),
                    Pair("weight", weightEt.text.toString())
                )
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private fun ifInfoValid(): Boolean{
        if (nameEt.text.toString().isEmpty()){
            nameEt.error = "Field required"
            return false
        }
        if (ageEt.text.toString().isEmpty()){
            ageEt.error = "Field required"
            return false
        }
        if (phoneEt.text.toString().isEmpty()){
            phoneEt.error = "Field required"
            return false
        }
        if (weightEt.text.toString().isEmpty()){
            weightEt.error = "Field required"
            return false
        }



        return true
    }
}