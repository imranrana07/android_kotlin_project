package com.imranrana.recyclerviewassignment.view

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.imranrana.recyclerviewassignment.R
import com.imranrana.recyclerviewassignment.core.BaseActivity
import com.imranrana.recyclerviewassignment.model.College
import com.imranrana.recyclerviewassignment.model.CollegeModelImpl
import kotlinx.android.synthetic.main.activity_college_details.*
import kotlinx.android.synthetic.main.toolbar.*

class CollegeDetailsActivity : BaseActivity() {

    override fun setLayout(): Int = R.layout.activity_college_details
    override val isHomeUpButtonEnabled: Boolean get() = true
    override fun setToolbar(): Toolbar {
        toolbar.visibility = View.GONE
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val college = intent.getSerializableExtra("college")
        setValues(college as College)
    }

    private fun setValues(collegeDetails: College){
        Glide.with(this).load(collegeDetails.imageUrl).placeholder(R.drawable.email).into(iv_college_cda)
        tv_chiefName_cda.text = collegeDetails.chief
        tv_chiefPhoneNoValue_cda.text = collegeDetails.phoneNo
    }
}