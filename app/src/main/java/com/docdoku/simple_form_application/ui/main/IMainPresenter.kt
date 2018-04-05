package com.docdoku.simple_form_application.ui.main

import com.docdoku.simple_form_application.ui.base.IBasePresenter

interface IMainPresenter: IBasePresenter<IMainView> {
    fun onFoundDateClicked()
    fun onCancel()
    fun onFormSubmitted(name: String, description: String, foundDate: String, age: String)
}