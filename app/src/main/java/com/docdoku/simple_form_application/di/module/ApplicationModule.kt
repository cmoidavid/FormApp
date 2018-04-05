package com.docdoku.simple_form_application.di.module

import com.docdoku.simple_form_application.data.FakeDataManager
import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.di.scope.ApplicationScope
import com.docdoku.simple_form_application.utils.logger.ILogger
import com.docdoku.simple_form_application.utils.logger.Logger
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun provideLogger(): ILogger {
        return Logger()
    }
}