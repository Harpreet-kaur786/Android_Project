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

    @Test
    public void testTextViewHasCorrectText() {
        onView(withId(R.id.textToBeChanged)).check(matches(withText("Hello Espresso!")));
    }
    @Test
    public void testChangeTextButton_with123Input() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }
    @Test
    public void testChangeTextButton_withEmptyInput() {
        onView(withId(R.id.editTextUserInput)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }
    @Test
    public void testOpenActivity_with123Input() {
        // Type "123" in the EditText
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard());

        // Click the Open Activity and Change Text button
        onView(withId(R.id.activityChangeTextBtn)).perform(click());

        // Check that the ShowTextActivity has the correct string in its TextView
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }
}
