package com.docdoku.simple_form_application.data.api

import com.docdoku.simple_form_application.model.Dog
import io.reactivex.Single

interface IDogApi {
    fun createDog(dog: Dog): Single<Dog>
}