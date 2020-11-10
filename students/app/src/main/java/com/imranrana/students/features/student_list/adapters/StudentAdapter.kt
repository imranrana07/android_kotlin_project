package com.imranrana.students.features.student_list.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imranrana.students.R
import com.imranrana.students.core.ClickListener
import com.imranrana.students.core.Utils
import com.imranrana.students.features.student_list.model.Student

class StudentAdapter(private val list: MutableList<Student>,private val clickListener: ClickListener<Int>): RecyclerView.Adapter<StudentViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_students,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       val student = list[position]
        Glide.with(context).load(student.image).into(holder.ivStudent)
        holder.tvStudentName.text = student.name
        holder.tvStudentEmail.text = student.email
        holder.tvInstitution.text = student.institution

        holder.itemView.setOnClickListener{
            clickListener.itemClick(Utils.studentId)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}