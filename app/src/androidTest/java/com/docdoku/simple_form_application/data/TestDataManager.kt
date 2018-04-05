package com.docdoku.simple_form_application.data

import com.docdoku.simple_form_application.model.Dog
import io.reactivex.Single

class TestDataManager : FakeDataManager() {
    override fun createDog(dog: Dog): Single<Dog> {
        return Single.create {
            if (dog.name.length != 3) {
                Thread.sleep(500)
                it.onError(Exception("User not authorized"))
            } else {
                Thread.sleep(2000)
                it.onSuccess(dog)
            }
        }
    }
}