package com.imranrana.students.features.student_details.presenter

import com.imranrana.students.features.student_details.view.StudentDetailsView

interface StudentDetailsPresenterModel {
    fun getStudentDetails(studentDetailsView: StudentDetailsView)
}