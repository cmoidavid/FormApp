package com.docdoku.simple_form_application.ui.main

import com.docdoku.simple_form_application.data.FakeDataManager
import com.docdoku.simple_form_application.data.IDataManager
import com.docdoku.simple_form_application.model.Dog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeParseException

class MainPresenter : IMainPresenter {

    private var mView: IMainView? = null
    private val disposables = CompositeDisposable()
    private val dataManager: IDataManager = FakeDataManager()


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
                        dataManager.createDog(dog).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({ dog ->
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