package com.docdoku.simple_form_application.di.module

import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.di.scope.ActivityScope
import com.docdoku.simple_form_application.ui.main.IMainPresenter
import com.docdoku.simple_form_application.ui.main.MainPresenter
import com.docdoku.simple_form_application.ui.utils.DatePickerFragment
import com.docdoku.simple_form_application.utils.logger.ILogger
import com.docdoku.simple_form_application.utils.rx.ISchedulerProvider
import com.docdoku.simple_form_application.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @ActivityScope
    fun provideSchedulerProvider(): ISchedulerProvider {
        return SchedulerProvider()
    }

    @Provides
    @ActivityScope
    fun provideMainPresenter(disposables: CompositeDisposable,
                             dataManager: IDataManager,
                             schedulerProvider: ISchedulerProvider,
                             logger: ILogger): IMainPresenter {
        return MainPresenter(disposables, dataManager, schedulerProvider, logger)
    }

    @Provides
    @ActivityScope
    fun provideDatePickerFragment(): DatePickerFragment {
        return DatePickerFragment()
    }

}