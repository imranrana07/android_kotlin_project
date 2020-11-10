package com.imranrana.students.core

interface ApiResponseCallback<T> {
    fun success(data: T)
    fun error(throwable: Throwable)
}