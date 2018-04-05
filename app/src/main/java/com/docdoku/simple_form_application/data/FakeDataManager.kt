package com.docdoku.simple_form_application.data

import com.docdoku.simple_form_application.model.Dog
import io.reactivex.Completable
import io.reactivex.Single

class FakeDataManager : IDataManager {

    private val remoteDogs = mutableListOf<Dog>() // This would be the dogs stored in a back-end server
    private val dogs = mutableListOf<Dog>() // This would be the dogs stored locally in database

    override fun login(username: String, password: String): Completable {
        return Completable.create {
            Thread.sleep(3000)
        }
    }

    override fun createDog(dog: Dog): Single<Dog> {
        return Single.create {
            if (dog.name.startsWith("A")) {
                Thread.sleep(500)
                it.onError(Exception("User not authorized"))
            } else {
                Thread.sleep(2000)
                remoteDogs.add(dog)
                it.onSuccess(dog)
            }
        }
    }

    override fun insertDog(dog: Dog): Single<Int> {
        return Single.create {
            Thread.sleep(300)
            dogs.add(dog)
            it.onSuccess(1)
        }
    }
}