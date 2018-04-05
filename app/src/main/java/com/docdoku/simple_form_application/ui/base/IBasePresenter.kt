package com.docdoku.simple_form_application.ui.base

interface IBasePresenter<in IBaseView> {
    fun onAttach(view: IBaseView)
    fun onDetach()
}