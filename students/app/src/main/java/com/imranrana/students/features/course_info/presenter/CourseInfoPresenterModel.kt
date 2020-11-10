package com.imranrana.students.features.course_info.presenter

import com.imranrana.students.features.course_info.view.CourseInfoView

interface CourseInfoPresenterModel {
    fun getCourseInfo(courseInfoView: CourseInfoView)
}