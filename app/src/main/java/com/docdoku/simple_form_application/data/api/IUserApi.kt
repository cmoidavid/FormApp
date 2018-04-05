package com.docdoku.simple_form_application.data.api

import io.reactivex.Completable

interface IUserApi {
    fun login(username: String, password: String): Completable
}