package com.docdoku.simple_form_application.di.component

import com.docdoku.simple_form_application.MainActivityTest
import com.docdoku.simple_form_application.di.module.ApplicationModule
import com.docdoku.simple_form_application.di.module.TestNetModule
import com.docdoku.simple_form_application.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, TestNetModule::class])
interface TestApplicationComponent : ApplicationComponent {
    fun inject(test: MainActivityTest)
}