package com.imranrana.students.features.student_details.view

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.imranrana.students.R
import com.imranrana.students.core.BaseActivity
import com.imranrana.students.core.Utils
import com.imranrana.students.core.sharedpreference.SharedPreferenceModel
import com.imranrana.students.core.sharedpreference.SharedPreferenceModelImpl
import com.imranrana.students.features.student_details.model.StudentDetails
import com.imranrana.students.features.student_details.presenter.StudentDetailsPresenterModelImpl
import kotlinx.android.synthetic.main.activity_student_details.*
import kotlinx.android.synthetic.main.tool_bar.*


class StudentDetailsActivity : BaseActivity(),StudentDetailsView {
    lateinit var studentDetailsPresenterModelImpl: StudentDetailsPresenterModelImpl
    lateinit var sharedPreferenceModelImpl: SharedPreferenceModelImpl
    override fun setLayout(): Int = R.layout.activity_student_details
    override fun setToolbar(): Toolbar {
        tool_bar.title = "Student details"
        return tool_bar
    }

    override val isHomeDisplayEnabled: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentDetailsPresenterModelImpl = StudentDetailsPresenterModelImpl(Utils.studentId, token())
        studentDetailsPresenterModelImpl.getStudentDetails(this)

        btn_studentBioCopy.setOnClickListener{
            bioCopyToClipBoard()
        }
    }

    override fun progressBar(visibility: Int) {
        progressBar.visibility = visibility
    }

    override fun studentDetails(studentDetails: StudentDetails) {
        initData(studentDetails)
    }

    override fun errors(throwable: Throwable) {
        throwable.message?.let { showToast(it) }
    }

    private fun token(): String {
        sharedPreferenceModelImpl = SharedPreferenceModelImpl(this)
        return sharedPreferenceModelImpl.getString(SharedPreferenceModel.TOKEN)!!
    }

    private fun initData(studentDetails: StudentDetails){
        val studentInfo = studentDetails.studentDetails[0]
        Glide.with(this).load(studentInfo.image).into(iv_student)
        tv_studentName.text = studentInfo.name
        tv_mobile.text = studentInfo.phone
        tv_institution.text = studentInfo.institution
        tv_studentEmail.text = studentInfo.email
        tv_studentBioValue.text = studentInfo.biography
    }

    private fun bioCopyToClipBoard(){
        val clipboard: ClipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("bio", tv_studentBioValue.text)
        clipboard.setPrimaryClip(clip)
        showToast("Copied")
    }
}