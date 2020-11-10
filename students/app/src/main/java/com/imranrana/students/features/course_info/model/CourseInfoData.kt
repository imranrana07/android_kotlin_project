package com.imranrana.students.features.course_info.model

import java.io.Serializable

data class CourseInfoData(
    val data: Data,
    val message: String,
    val status: Boolean
): Serializable{
    data class Data(
            val class_days: List<String>,
            val class_duration: String,
            val duration: String,
            val fee: String,
            val name: String,
            val number_of_class: Int,
            val url: String
    )
}