package com.example.new_sample;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void click_number_btn() {
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn2)).perform(click());
        onView(withId(R.id.btn3)).perform(click());
        onView(withId(R.id.btn4)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn6)).perform(click());
        onView(withId(R.id.btn7)).perform(click());
        onView(withId(R.id.btn8)).perform(click());
        onView(withId(R.id.btn9)).perform(click());
        onView(withId(R.id.btn0)).perform(click());
        onView(withId(R.id.input)).check(matches(withText("1234567890")));
    }

    @Test
    public void force_operational_btn(){
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Error")));
        onView(withId(R.id.button_clear)).perform(longClick());

        onView(withId(R.id.btn_sub)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Error")));
        onView(withId(R.id.button_clear)).perform(longClick());

        onView(withId(R.id.btn_divide)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Error")));
        onView(withId(R.id.button_clear)).perform(longClick());

        onView(withId(R.id.btn_multi)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Error")));
        onView(withId(R.id.button_clear)).perform(longClick());

        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("Error")));
        onView(withId(R.id.button_clear)).perform(longClick());
    }

    @Test
    public void tambah_simple(){
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("2")));
    }

    @Test
    public void kurang_simple(){
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn_sub)).perform(click());
        onView(withId(R.id.btn1)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("0")));
    }

    @Test
    public void kali_simple(){
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_multi)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("25")));
    }

    @Test
    public void bagi_simple(){
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_divide)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("1")));
    }

    @Test
    public void modulus_simple(){
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_mod)).perform(click());
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.btn_equal)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("0")));
    }

    @Test
    public void convert_plus_minus(){
        onView(withId(R.id.btn5)).perform(click());
        onView(withId(R.id.button_pl_minus)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("-5")));
        onView(withId(R.id.button_pl_minus)).perform(click());
        onView(withId(R.id.output)).check(matches(withText("5")));
    }
}
