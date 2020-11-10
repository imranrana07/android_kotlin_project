package com.imranrana.students.features.student_list.model

import com.imranrana.students.core.ApiResponseCallback

interface StudentModel {
    fun getStudentList(token: String,apiResponseCallback: ApiResponseCallback<StudentsJsonResponse>)
}