package com.imranrana.students.features.course_info.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imranrana.students.R

class ClassDaysAdapter(private val list: List<String>): RecyclerView.Adapter<ClassDaysViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassDaysViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_class_days,parent,false)
        return ClassDaysViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassDaysViewHolder, position: Int) {
        holder.tvClassDays.text = list[position]
    }

    override fun getItemCount(): Int {
       return list.size
    }
}