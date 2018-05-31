package com.docdoku.simple_form_application

import android.app.Application
import com.docdoku.simple_form_application.di.myModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        startKoin(this, listOf(myModule))
    }
}