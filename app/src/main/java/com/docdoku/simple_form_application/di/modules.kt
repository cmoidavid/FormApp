package com.docdoku.simple_form_application.di

import com.docdoku.simple_form_application.data.FakeDataManager
import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.ui.main.MainPresenter
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

// Koin module
val myModule: Module = applicationContext {
    // get() will resolve DataManager instance, factory means a new instance each time we ask about the MainPresenter
    factory { MainPresenter(get()) }
    // bean is for singleton
    bean { FakeDataManager() as IDataManager }
}