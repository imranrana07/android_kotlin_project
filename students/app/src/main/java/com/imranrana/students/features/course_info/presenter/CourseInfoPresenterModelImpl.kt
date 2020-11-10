package com.imranrana.students.features.course_info.presenter

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import com.imranrana.students.features.course_info.model.CourseInfoData
import com.imranrana.students.features.course_info.model.CourseInfoModelImpl
import com.imranrana.students.features.course_info.view.CourseInfoView

class CourseInfoPresenterModelImpl: CourseInfoPresenterModel {
    private val courseInfoModelImpl = CourseInfoModelImpl()
    override fun getCourseInfo(courseInfoView: CourseInfoView) {
        courseInfoView.progressBar(Utils.VISIBLE)
        courseInfoModelImpl.getCourseInfo(object : ApiResponseCallback<CourseInfoData>{
            override fun success(data: CourseInfoData) {
                courseInfoView.courseInfo(data)
                courseInfoView.progressBar(Utils.GONE)
            }

            override fun error(throwable: Throwable) {
                courseInfoView.progressBar(Utils.GONE)
                courseInfoView.error(throwable)
            }

        })
    }
}