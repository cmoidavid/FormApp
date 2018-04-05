package com.docdoku.simple_form_application.utils.logger

import android.util.Log

class Logger : ILogger {
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}