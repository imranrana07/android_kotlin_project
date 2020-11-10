package com.imranrana.students.features.student_list.model

import com.google.gson.annotations.SerializedName

data class StudentsJsonResponse(
        @SerializedName("data")
        val studentList: MutableList<Student>,
        val message: String,
        val status: Boolean
)