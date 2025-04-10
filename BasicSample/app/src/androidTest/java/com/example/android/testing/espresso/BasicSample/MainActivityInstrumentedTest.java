package com.example.android.testing.espresso.BasicSample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

//    @Test
//    public void testTextViewHasCorrectText() {
//        onView(withId(R.id.textToBeChanged)).check(matches(withText("Hello Espresso!")));
//    }

    // Test: Change text with "123"
    @Test
    public void testChangeTextButton_with123Input() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    // Test: Change text with empty input
    @Test
    public void testChangeTextButton_withEmptyInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    // Test: Open second activity with "123"
    @Test
    public void testOpenActivity_with123Input() {
        // Type "123" in the EditText
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());

        // Click the Open Activity button
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the ShowTextActivity has the correct string in its TextView
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }

    // Test: Open second activity with empty input
    @Test
    public void testOpenActivity_withEmptyInput() {
        // Leave the EditText empty and press the button
        onView(withId(R.id.editTextUserInput)).perform(typeText(""), closeSoftKeyboard());

        // Click the button to open ShowTextActivity
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the ShowTextActivity displays an empty string
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void testOpenActivity_withNoInput() {
        // No input to the EditText (simulate user didn't type anything)
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Verify that ShowTextActivity displays an empty string
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }


    //New Test: "abcdef" with Change Text button
    @Test
    public void testChangeTextButton_withAbcdefInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    // New Test: "abcdef" with Open Activity button
    @Test
    public void testOpenActivity_withAbcdefInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")));
    }
}
