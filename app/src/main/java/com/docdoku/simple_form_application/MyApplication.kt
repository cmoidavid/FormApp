package com.docdoku.simple_form_application

import android.app.Application
import com.docdoku.simple_form_application.di.component.ApplicationComponent
import com.docdoku.simple_form_application.di.component.DaggerApplicationComponent
import com.jakewharton.threetenabp.AndroidThreeTen

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .build()
        applicationComponent.inject(this)
        AndroidThreeTen.init(this)
    }
}