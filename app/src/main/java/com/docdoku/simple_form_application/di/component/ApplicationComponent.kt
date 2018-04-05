package com.docdoku.simple_form_application.di.component

import com.docdoku.simple_form_application.MyApplication
import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.di.module.ApplicationModule
import com.docdoku.simple_form_application.di.module.NetModule
import com.docdoku.simple_form_application.di.scope.ApplicationScope
import com.docdoku.simple_form_application.utils.logger.ILogger
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class, NetModule::class])
interface ApplicationComponent {
    fun inject(app: MyApplication)
    fun getDataManager(): IDataManager
    fun getLogger(): ILogger
}