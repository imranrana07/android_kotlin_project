package com.imranrana.recyclerviewassignment.view.college_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imranrana.recyclerviewassignment.R
import com.imranrana.recyclerviewassignment.core.ClickListener
import com.imranrana.recyclerviewassignment.model.College


class CollegeAdapter(private val list: ArrayList<College>,private val clickListener: ClickListener): RecyclerView.Adapter<CollegeViewHolder>(){
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_college,parent,false)
        return CollegeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        val college = list[position]
        holder.collegeName.text = college.name
        Glide.with(context).load(college.imageUrl).placeholder(R.drawable.email).into(holder.imageView)
        holder.districtValue.text = college.district
        holder.chiefValue.text = college.chief

        if (college.email.isNotEmpty()){
            holder.email.text = college.email
        }else {
            holder.emailIcon.visibility = View.GONE
            holder.email.visibility = View.GONE
        }

        if(college.phoneNo.isNotEmpty()){
            holder.phone.text = college.phoneNo
        }else {
            holder.phoneIcon.visibility = View.GONE
            holder.phone.visibility = View.GONE
        }

        holder.rating.rating = college.rating
        itemClickListen(holder,position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun itemClickListen(holder: CollegeViewHolder, position: Int){
        holder.imageView.setOnClickListener{
            clickListener.onItemClickListener(position)
        }

        holder.collegeName.setOnClickListener{
            clickListener.onItemClickListener(position)
        }
    }
}