package com.imranrana.students.features.course_info.model

import com.imranrana.students.core.ApiResponseCallback

interface CourseInfoModel {
    fun getCourseInfo(apiResponseCallback: ApiResponseCallback<CourseInfoData>)
}