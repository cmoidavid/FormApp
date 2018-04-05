package com.docdoku.simple_form_application

import android.content.Context
import com.docdoku.simple_form_application.di.component.ApplicationComponent
import com.docdoku.simple_form_application.di.component.DaggerTestApplicationComponent
import com.docdoku.simple_form_application.di.component.TestApplicationComponent
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestComponentRule(private val mContext: Context) : TestRule {

    private var mTestComponent: TestApplicationComponent? = null

    private fun setupDaggerTestComponentInApplication() {
        val application = mContext.applicationContext as MyApplication;
        mTestComponent = DaggerTestApplicationComponent.builder().build()
        application.applicationComponent = mTestComponent as ApplicationComponent
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    setupDaggerTestComponentInApplication()
                    base.evaluate()
                } finally {
                    mTestComponent = null
                }
            }
        }
    }
}