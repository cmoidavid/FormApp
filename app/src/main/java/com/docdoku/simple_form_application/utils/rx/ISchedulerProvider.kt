package com.docdoku.simple_form_application.utils.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {
    fun ui(): Scheduler

    fun io(): Scheduler
}