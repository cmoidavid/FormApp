package com.docdoku.simple_form_application.ui.main

interface IMainView {
    fun showDatePickerDialog()
    fun showFoundDateError()
    fun showCreationSuccessful()
    fun showCreationError()
    fun showFoundDate(foundDate: String)
    fun showAgeInputError()
    fun abort()
}