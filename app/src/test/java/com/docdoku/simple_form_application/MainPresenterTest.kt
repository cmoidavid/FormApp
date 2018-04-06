package com.docdoku.simple_form_application

import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.ui.main.IMainView
import com.docdoku.simple_form_application.ui.main.MainPresenter
import com.docdoku.simple_form_application.utils.logger.ILogger
import com.docdoku.simple_form_application.utils.rx.SchedulerProvider
import com.jakewharton.threetenabp.AndroidThreeTen
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MainPresenterTest {

    private lateinit var mPresenter: MainPresenter
    private lateinit var viewMock: IMainView

    @Before
    fun setUp() {
        viewMock = Mockito.mock(IMainView::class.java)
        val dataManagerMock = Mockito.mock(IDataManager::class.java)
        val schedulerProviderMock = Mockito.mock(SchedulerProvider::class.java)
        val loggerMock = Mockito.mock(ILogger::class.java)
        val disposablesMock = Mockito.mock(CompositeDisposable::class.java)
        mPresenter = MainPresenter(disposablesMock, dataManagerMock, schedulerProviderMock, loggerMock)
        mPresenter.onAttach(viewMock)
    }

    @Test
    fun onFormSubmitted_should_show_error_date() {
        mPresenter.onFormSubmitted("", "", "4000-01-01", "12")
        Mockito.verify(viewMock, Mockito.times(1))
                .showFoundDateError()
    }


}