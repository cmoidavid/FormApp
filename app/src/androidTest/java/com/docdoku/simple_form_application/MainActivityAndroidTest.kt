package com.docdoku.simple_form_application

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.view.View
import android.view.ViewGroup
import com.docdoku.simple_form_application.ui.main.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import java.util.concurrent.TimeUnit


class MainActivityAndroidTest {

    val component = TestComponentRule(InstrumentationRegistry.getTargetContext())
    val main = ActivityTestRule(MainActivity::class.java, false, false)
    // TestComponentRule needs to go first so we make sure the ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @JvmField
    @Rule
    var chain: TestRule = RuleChain.outerRule(component).around(main)

    @Before
    fun setUp() {
    }

    @Test
    fun mainActivityTest() {
        main.launchActivity(null)
        val textInputEditText = onView(
                allOf<View>(withId(R.id.et_dog_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_name),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
                allOf<View>(withId(R.id.et_dog_name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_name),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText2.perform(replaceText("Toutou"), closeSoftKeyboard())

        val textInputEditText3 = onView(
                allOf<View>(withId(R.id.et_dog_name), withText("Toutou"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_name),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText3.perform(pressImeActionButton())

        val textInputEditText4 = onView(
                allOf<View>(withId(R.id.et_dog_description),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_description),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText4.perform(replaceText("Le bon chienchien à sa mémère"), closeSoftKeyboard())

        val textInputEditText5 = onView(
                allOf<View>(withId(R.id.et_dog_description), withText("Le bon chienchien à sa mémère"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_description),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText5.perform(pressImeActionButton())

        val textInputEditText6 = onView(
                allOf<View>(withId(R.id.et_dog_age),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_age),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText6.perform(replaceText("12"), closeSoftKeyboard())

        val textInputEditText7 = onView(
                allOf<View>(withId(R.id.et_dog_age), withText("12"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_age),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText7.perform(pressImeActionButton())

        val textInputEditText8 = onView(
                allOf<View>(withId(R.id.et_dog_found_date),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.til_dog_found_date),
                                        0),
                                0),
                        isDisplayed()))
        textInputEditText8.perform(click())

        val appCompatImageButton = onView(
                allOf<View>(withClassName(`is`<String>("android.support.v7.widget.AppCompatImageButton")), withContentDescription("Previous month"),
                        childAtPosition(
                                allOf<View>(withClassName(`is`<String>("android.widget.DayPickerView")),
                                        childAtPosition(
                                                withClassName(`is`<String>("com.android.internal.widget.DialogViewAnimator")),
                                                0)),
                                1)))
        appCompatImageButton.perform(scrollTo(), click())

        val appCompatButton = onView(
                allOf<View>(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(`is`<String>("android.widget.ScrollView")),
                                        0),
                                3)))
        appCompatButton.perform(scrollTo(), click())

        val appCompatButton2 = onView(
                allOf<View>(withId(R.id.button_validation_dog_creation), withText("Save the dog"),
                        childAtPosition(
                                allOf<View>(withId(R.id.cl_main_activity),
                                        childAtPosition(
                                                withId(R.id.nsv_dog_creation),
                                                0)),
                                5),
                        isDisplayed()))
        appCompatButton2.perform(click())

        onView(isRoot())
                .perform(waitId(android.support.design.R.id.snackbar_text, TimeUnit.SECONDS.toMillis(15)))
                .check(matches(isDisplayed()));

    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position))
            }
        }
    }
}