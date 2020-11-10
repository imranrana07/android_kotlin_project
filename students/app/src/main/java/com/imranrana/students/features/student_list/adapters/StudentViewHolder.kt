package com.imranrana.students.features.student_list.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_students.view.*

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivStudent = itemView.iv_student
    val tvStudentName = itemView.tv_studentName
    val tvStudentEmail = itemView.tv_studentEmail
    val tvInstitution = itemView.tv_institution
}
