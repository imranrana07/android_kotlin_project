package com.imranrana.students.features.student_list.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.imranrana.students.R
import com.imranrana.students.core.BaseActivity
import com.imranrana.students.core.ClickListener
import com.imranrana.students.core.sharedpreference.SharedPreferenceModel
import com.imranrana.students.core.sharedpreference.SharedPreferenceModelImpl
import com.imranrana.students.features.student_details.view.StudentDetailsActivity
import com.imranrana.students.features.student_list.adapters.StudentAdapter
import com.imranrana.students.features.student_list.model.Student
import com.imranrana.students.features.student_list.presenter.StudentPresenterModel
import com.imranrana.students.features.student_list.presenter.StudentPresenterModelImpl
import kotlinx.android.synthetic.main.activity_student_list.*
import kotlinx.android.synthetic.main.tool_bar.*

class StudentListActivity : BaseActivity(),StudentListView,ClickListener<Int> {
    lateinit var studentPresenterModelImpl: StudentPresenterModelImpl
    lateinit var sharedPreferenceModelImpl:SharedPreferenceModelImpl
    override fun setLayout(): Int = R.layout.activity_student_list
    override val isHomeDisplayEnabled: Boolean get() = true
    override fun setToolbar(): Toolbar {
        tool_bar.title = "Students"
        return tool_bar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentPresenterModelImpl = StudentPresenterModelImpl(token())
        studentPresenterModelImpl.getStudentList(this)
    }

    override fun progressBar(visibilityStatus: Int) {
        progressBar.visibility = visibilityStatus
    }

    override fun studentListView(studentList: MutableList<Student>) {
        adapterInit(studentList)
    }

    override fun error(throwable: Throwable) {
        throwable.message?.let { showToast(it) }
    }

    private fun adapterInit(list:MutableList<Student>){
        val adapter = StudentAdapter(list,this)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    private fun token(): String {
        sharedPreferenceModelImpl = SharedPreferenceModelImpl(this)
        return sharedPreferenceModelImpl.getString(SharedPreferenceModel.TOKEN)!!
    }

    override fun itemClick(data: Int) {
        startActivity(Intent(this,StudentDetailsActivity::class.java))
    }
}