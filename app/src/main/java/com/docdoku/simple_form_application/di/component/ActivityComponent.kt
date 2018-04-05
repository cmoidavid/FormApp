package com.docdoku.simple_form_application.di.component

import com.docdoku.simple_form_application.di.module.ActivityModule
import com.docdoku.simple_form_application.di.scope.ActivityScope
import com.docdoku.simple_form_application.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}