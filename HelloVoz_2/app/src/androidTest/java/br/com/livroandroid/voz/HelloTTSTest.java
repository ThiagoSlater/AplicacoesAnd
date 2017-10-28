package br.com.livroandroid.voz;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HelloTTSTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void helloTTSTest() {
        ViewInteraction appCompatTextView = onView(
                allOf(withId(android.R.id.text1), withText("Falar um texto"),
                        childAtPosition(
                                withId(R.id.listView),
                                0),
                        isDisplayed()));
        appCompatTextView.perform(click());

        /*pressBack();

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("Falar um texto"),
                        childAtPosition(
                                withId(R.id.listView),
                                0),
                        isDisplayed()));
        appCompatTextView2.perform(click());*/

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.title), withText("Voz POrtugues(BR)"), isDisplayed()));
        appCompatTextView3.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withText("Falar o Texto"), isDisplayed()));
        appCompatButton.perform(click());

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.tMsg), withText("Olá, bom dia."), isDisplayed()));
        appCompatEditText.perform(replaceText("Hi, good  morning!"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.tMsg), withText("Hi, good  morning!"), isDisplayed()));

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.title), withText("Voz Inglês"), isDisplayed()));
        appCompatTextView4.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withText("Falar o Texto"), isDisplayed()));
        appCompatButton2.perform(click());

        /*appCompatEditText.perform(replaceText("Hi"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.tMsg), withText("Hi"), isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.tMsg), withText("Hi"), isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withText("Falar o Texto"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.tMsg), withText("Hi, good  morning!"), isDisplayed()));
        appCompatEditText2.perform(click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());*/

        /*ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.title), withText("Voz Inglês"), isDisplayed()));
        appCompatTextView5.perform(click());*/

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        /*ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.tMsg), withText("Hi, good  morning!"), isDisplayed()));
        appCompatEditText6.perform(replaceText("Ola, buenos dias!"), closeSoftKeyboard());*/

        ViewInteraction appCompatTextView6 = onView(
                allOf(withId(R.id.title), withText("Voz Espanhol"), isDisplayed()));
        appCompatTextView6.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withText("Falar o Texto"), isDisplayed()));
        appCompatButton3.perform(click());

        //openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction textView = onView(
                allOf(withId(R.id.title), withText("Check Data"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView.check(doesNotExist());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.title), withText("Install Data"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView2.check(doesNotExist());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.title), withText("Install Data"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(doesNotExist());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
