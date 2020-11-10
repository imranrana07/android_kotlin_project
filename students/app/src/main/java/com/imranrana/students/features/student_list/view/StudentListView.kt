package com.imranrana.students.features.student_list.view

import com.imranrana.students.features.student_list.model.Student

interface StudentListView {
    fun progressBar(visibilityStatus: Int)
    fun studentListView(studentList: MutableList<Student>)
    fun error(throwable: Throwable)
}