package com.imranrana.students.features.student_details.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StudentDetails(
        @SerializedName("data")
        val studentDetails: List<Datas>,
        val message: String,
        val status: Boolean
):Serializable{
    data class Datas(
            val biography: String,
            val email: String,
            val id: Int,
            val image: String,
            val institution: String,
            val name: String,
            val phone: String
    )
}