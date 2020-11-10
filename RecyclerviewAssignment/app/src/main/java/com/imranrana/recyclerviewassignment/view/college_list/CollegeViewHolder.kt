package com.imranrana.recyclerviewassignment.view.college_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_college.view.*

class CollegeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val collegeName = itemView.tv_collegeName!!
    val imageView = itemView.imageView!!
    val rating = itemView.rating!!
    val districtValue = itemView.tv_districtValue!!
    val chiefValue = itemView.tv_chiefValue!!
    val email = itemView.tv_email!!
    val emailIcon = itemView.tv_emailIcon!!
    val phone = itemView.tv_phone!!
    val phoneIcon = itemView.tv_phoneIcon!!
}
