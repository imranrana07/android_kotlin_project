package com.imranrana.students.features.student_details.model

import com.imranrana.students.core.ApiResponseCallback

interface StudentDetailModel {
    fun getDetails(studentId: Int,token: String,apiResponseCallback: ApiResponseCallback<StudentDetails>)
}