package com.docdoku.simple_form_application.data.db

import com.docdoku.simple_form_application.model.Dog
import io.reactivex.Single

interface IDogDbHelper {
    fun insertDog(dog: Dog): Single<Int>
}