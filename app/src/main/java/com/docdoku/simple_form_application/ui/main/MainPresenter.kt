package com.docdoku.simple_form_application.ui.main

import com.docdoku.simple_form_application.data.FakeDataManager
import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.model.Dog
import com.docdoku.simple_form_application.utils.logger.ILogger
import com.docdoku.simple_form_application.utils.logger.Logger
import com.docdoku.simple_form_application.utils.rx.ISchedulerProvider
import com.docdoku.simple_form_application.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeParseException

class MainPresenter : IMainPresenter {

    private var mView: IMainView? = null
    private val disposables = CompositeDisposable()
    private val dataManager: IDataManager = FakeDataManager()
    private val mSchedulerProvider: ISchedulerProvider = SchedulerProvider()
    private val mLogger: ILogger = Logger()


    override fun onFoundDateClicked() {
        mView?.showDatePickerDialog()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onFoundDateSet(foundDate: LocalDate) {
        if (foundDate.isAfter(LocalDate.now())) {
            mView?.showFoundDateError()
        } else {
            mView?.showFoundDate(foundDate.toString())
        }
    }

    override fun onFormSubmitted(name: String, description: String, foundDateAsString: String, age: String) {
        try {
            val foundDate = LocalDate.parse(foundDateAsString)
            if (foundDate.isAfter(LocalDate.now())) {
                mView?.showFoundDateError()
            } else {
                val dog = Dog(name, description, age.toInt(), foundDate)
                disposables.add(
                        dataManager.createDog(dog)
                                .flatMap { dog ->
                                    dataManager.insertDog(dog)
                                }
                                .subscribeOn(mSchedulerProvider.io())
                                .observeOn(mSchedulerProvider.ui())
                                .subscribe({ dog ->
                                    mLogger.d("TAG", "Dogs in db ${dataManager.getDogs()}")
                                    mLogger.d("TAG", "Dogs remotely ${dataManager.getRemoteDogs()}")
                                    mView?.showCreationSuccessful()
                                }, { error ->
                                    mView?.showCreationError()
                                })
                )

            }
        } catch (e: DateTimeParseException) {
            mView?.showFoundDateError()
        } catch (e: NumberFormatException) {
            mView?.showAgeInputError()
        }
    }

    override fun onCancel() {
        mView?.abort()

    }

    override fun onAttach(view: IMainView) {
        mView = view
    }

    override fun onDetach() {
        disposables.clear()
        mView = null
    }
}