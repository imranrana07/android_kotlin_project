package com.imranrana.students.features.student_list.presenter

import com.imranrana.students.features.student_list.view.StudentListView

interface StudentPresenterModel {
    fun getStudentList(studentListView: StudentListView)
}