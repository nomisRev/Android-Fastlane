package be.appfoundry.templateexample.ui.detail;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import be.appfoundry.templateexample.R;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class DetailActivityAndroidTest {
    @Rule
    public ActivityTestRule<DetailActivity> testRule =
        new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void preConditions() {
        assertNotNull(testRule.getActivity());
    }

    @Test
    public void testDetailViewDisplayed() {
        onView(withId(R.id.detail_text_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testSnackbar() {
        onView(snackbarWithText(DetailPresenter.DATA)).check(matches(isDisplayed()));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Matcher<View> snackbarWithText(final String text) {
        return allOf(withId(android.support.design.R.id.snackbar_text), withText(text));
    }
}
