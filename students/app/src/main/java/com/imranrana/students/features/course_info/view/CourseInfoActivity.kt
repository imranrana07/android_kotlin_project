package com.imranrana.students.features.course_info.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.imranrana.students.R
import com.imranrana.students.core.BaseActivity
import com.imranrana.students.features.course_info.adapter.ClassDaysAdapter
import com.imranrana.students.features.course_info.model.CourseInfoData
import com.imranrana.students.features.course_info.presenter.CourseInfoPresenterModelImpl
import com.imranrana.students.features.login.view.Login
import kotlinx.android.synthetic.main.activity_course_info.*
import kotlinx.android.synthetic.main.course_details_info.*
import kotlinx.android.synthetic.main.tool_bar.*

class CourseInfoActivity : BaseActivity(),CourseInfoView {
    private val courseInfoPresenterModelImpl = CourseInfoPresenterModelImpl()
    override fun setLayout(): Int = R.layout.activity_course_info
    override fun setToolbar(): Toolbar {
        tool_bar.title = "Course Info"
        return tool_bar
    }

    override val isHomeDisplayEnabled: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        courseInfoPresenterModelImpl.getCourseInfo(this)

        btn_proceed.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }

    override fun progressBar(visibilityStatus: Int) {
        progressBar.visibility = visibilityStatus
    }

    override fun courseInfo(courseInfoData: CourseInfoData) {
        showCourseInfo(courseInfoData)
    }

    override fun error(throwable: Throwable) {
        throwable.message?.let { showToast(it) }
    }

    private fun showCourseInfo(courseInfoData: CourseInfoData){
        val data = courseInfoData.data
        Glide.with(this).load("").placeholder(R.drawable.android_image).into(iv_courseInfo)
        tv_courseName.text = data.name
        tv_classDurationValue.text = data.class_duration
        tv_courseDuration.text = data.duration
        tv_noOfClassValue.text = data.number_of_class.toString()
        tv_feeValue.text = data.fee
        tv_websiteValue.text = data.url
        initAdapter(data.class_days)
    }

    private fun initAdapter(list:List<String>){
        val adapter = ClassDaysAdapter(list)
        val gridLayoutManager = GridLayoutManager(this,2)
        recyclerViewClassDays.layoutManager = gridLayoutManager
        recyclerViewClassDays.adapter = adapter
    }
}