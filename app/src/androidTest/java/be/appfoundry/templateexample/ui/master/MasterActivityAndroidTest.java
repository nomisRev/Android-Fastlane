package be.appfoundry.templateexample.ui.master;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import be.appfoundry.templateexample.R;
import be.appfoundry.templateexample.core.service.AndroidMockGithubAPI;
import be.appfoundry.templateexample.ui.detail.DetailActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MasterActivityAndroidTest {

    @Rule
    public ActivityTestRule<MasterActivity> testRule =
        new ActivityTestRule<>(MasterActivity.class);

    @Test
    public void preConditions() {
        assertNotNull(testRule.getActivity());
    }

    @Test
    public void testGithubRepoView() {
        onView(withId(R.id.github_repos)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowRepo() {
        onView(withId(R.id.github_repos)).check(
            matches(withText(AndroidMockGithubAPI.repos.get(0).getName())));
    }

    @Test
    public void testRepoClicked() {
        Intents.init();

        onView(withId(R.id.github_repos)).perform(click());
        intended(hasComponent(hasClassName(DetailActivity.class.getName())));
    }
}