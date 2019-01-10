package com.example.sergio.twoactivities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    //para arrancar las actividades
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void onMainActivityClickButtonLaunchSecondActivity() {
        //busca button con ese nom y darle click
        onView(withId(R.id.button)).perform(click());
        //comprobar que se este mostrando por pantalla
        onView(withId(R.id.text_header)).check(matches(isDisplayed()));

        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.txtHeader)).check(matches(isDisplayed()));

    }
    @Test
    public void textInputOutput() {
        onView(withId(R.id.editText_main)).perform(typeText("PUTO TEST DE MIERDAAAAA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!."));
        onView(withId(R.id.editText_main)).perform(click());
        onView(withId(R.id.editText_main))
                .check(matches(withText("PUTO TEST DE MIERDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +
                        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!.")));
    }



    @Test
    //comprueba que los test funcionan
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.sergio.twoactivities", appContext.getPackageName());
    }



}
