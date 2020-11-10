package com.imranrana.students.features.student_list.presenter

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import com.imranrana.students.features.student_list.model.Student
import com.imranrana.students.features.student_list.model.StudentModelImpl
import com.imranrana.students.features.student_list.model.StudentsJsonResponse
import com.imranrana.students.features.student_list.view.StudentListView

class StudentPresenterModelImpl(
    private val token: String,
): StudentPresenterModel {
    private val studentModelImpl = StudentModelImpl()
    override fun getStudentList(studentListView: StudentListView) {
        studentListView.progressBar(Utils.VISIBLE)
        studentModelImpl.getStudentList(token, object : ApiResponseCallback<StudentsJsonResponse> {
            override fun success(data: StudentsJsonResponse) {
                studentListView.progressBar(Utils.GONE)
                studentListView.studentListView(data.studentList)
            }

            override fun error(throwable: Throwable) {
                studentListView.progressBar(Utils.GONE)
                studentListView.error(throwable)
            }
        })
    }
}