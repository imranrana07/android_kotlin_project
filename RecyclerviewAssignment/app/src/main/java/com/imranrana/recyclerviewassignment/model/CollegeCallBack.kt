package com.imranrana.recyclerviewassignment.model

import java.util.ArrayList

interface CollegeCallBack {
    fun success(collegeList: ArrayList<College>)
    fun error(throwable: Throwable)
}