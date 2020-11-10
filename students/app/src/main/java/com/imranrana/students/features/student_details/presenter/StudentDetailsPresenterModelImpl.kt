package com.imranrana.students.features.student_details.presenter

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import com.imranrana.students.features.student_details.model.StudentDetailModel
import com.imranrana.students.features.student_details.model.StudentDetailModelImpl
import com.imranrana.students.features.student_details.model.StudentDetails
import com.imranrana.students.features.student_details.view.StudentDetailsView
import okhttp3.internal.Util

class StudentDetailsPresenterModelImpl(
        private val studentId: Int,
        private val token: String
): StudentDetailsPresenterModel {
    private val studentDetailModelImpl = StudentDetailModelImpl()
    override fun getStudentDetails(studentDetailsView: StudentDetailsView) {
        studentDetailsView.progressBar(Utils.VISIBLE)
        studentDetailModelImpl.getDetails(studentId, token, object : ApiResponseCallback <StudentDetails>{
            override fun success(data: StudentDetails) {
                studentDetailsView.progressBar(Utils.GONE)
                studentDetailsView.studentDetails(data)
            }

            override fun error(throwable: Throwable) {
                studentDetailsView.progressBar(Utils.GONE)
                studentDetailsView.errors(throwable)
            }

        })
    }

}