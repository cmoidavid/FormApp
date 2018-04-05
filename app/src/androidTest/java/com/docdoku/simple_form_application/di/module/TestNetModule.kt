package com.docdoku.simple_form_application.di.module

import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.data.TestDataManager
import com.docdoku.simple_form_application.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class TestNetModule {

    @Provides
    @ApplicationScope
    fun provideDataManager(): IDataManager {
        return TestDataManager()
    }
}