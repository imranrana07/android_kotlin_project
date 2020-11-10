package com.imranrana.students.core

interface ClickListener<T> {
    fun itemClick(data: T)
}