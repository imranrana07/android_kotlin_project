package com.imranrana.students.features.course_info.view

import com.imranrana.students.features.course_info.model.CourseInfoData

interface CourseInfoView {
    fun progressBar(visibilityStatus: Int)
    fun courseInfo(courseInfoData: CourseInfoData)
    fun error(throwable: Throwable)
}