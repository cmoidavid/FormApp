package com.docdoku.simple_form_application

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /**
     * In this exercise, we are going to use the MVP pattern
     *
     * Part 1:
     * TODO(1): Create a presenter for MainActivity: an interface IMainPresenter and an implementation MainPresenter
     * This presenter holds a reference on an IDataManager
     * TODO(2): While clicking on the et_dog_found_date view, show an AppCompatDialogFragment which implements DatePickerDialog.OnDateSetListener
     * Refer to https://developer.android.com/guide/topics/ui/controls/pickers.html for more information
     * Remember, the view is passive and must delegate every decision to the presenter, even the simplest ones !
     * TODO(3): When user clicks on button_validation_dog_creation, the presenter validates the form and then call the IDataManager to create the dog
     * The real request will be simulated by our FakeDataManager class
     * TODO(4): Re-arrange the layout to be material design compliant
     * You have to be careful of the positions of the buttons. You can also style your buttons by giving them a specific color
     * Refer to https://material.io/guidelines/components/buttons.html and use https://materialdoc.com/
     * to find how you can apply the material design guidelines
     *
     * You can also show an error message under the TextInputLayout when a field is not correct.
     * Check documentation about error messages: https://material.io/guidelines/components/text-fields.html#
     * TODO(Bonus): in the presenter, chain the call 'IDataManager.createDog' with 'IDataManager.insertDog'
     * This way, we are able to provide the user an experience even if he is offline !
     *
     * Part 2:
     * TODO(6): Use Dagger to provide instance of IDataManager in an ApplicationComponent
     * Remember you have to create a @Module class to provide the dependencies, use @Inject to specify the dependencies required by a class
     * and create a @Component class making the link between these two
     * So you have to create an ApplicationComponent class and an ApplicationModule class. You can either use the @Singleton scope
     * or create your own called @ApplicationScope
     * TODO(7): User Dagger to provide instance of IMainPresenter in an ActivityComponent
     * In this case, you can create an annotation called @ActivityScope and use it in your component and module
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
