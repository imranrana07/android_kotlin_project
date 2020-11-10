package com.imranrana.students.features.student_details.view

import com.imranrana.students.features.student_details.model.StudentDetails

interface StudentDetailsView {
    fun progressBar(visibility: Int)
    fun studentDetails(studentDetails: StudentDetails)
    fun errors(throwable: Throwable)
}