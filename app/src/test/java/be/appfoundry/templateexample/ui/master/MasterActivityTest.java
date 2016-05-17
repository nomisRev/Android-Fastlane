package be.appfoundry.templateexample.ui.master;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import be.appfoundry.templateexample.BuildConfig;
import be.appfoundry.templateexample.R;
import be.appfoundry.templateexample.ui.detail.DetailActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = "be.appfoundry.templateexample")
public class MasterActivityTest {

    private static final String TEXT_TO_PRINT = "textToPrint";

    @Test
    public void preConditions() {
        final Activity activity = Robolectric.buildActivity(MasterActivity.class).get();
        assertNotNull(activity);
    }

    @Test
    public void testTextView() {
        final Activity activity = Robolectric.buildActivity(MasterActivity.class)
            .create()
            .start()
            .resume()
            .visible()
            .get();
        final TextView githubRepos = (TextView) activity.findViewById(R.id.github_repos);
        assertNotNull(githubRepos);
    }

    @Test
    public void testPrintRepos() {
        final MasterActivity activity = Robolectric.buildActivity(MasterActivity.class).
            create().start().resume().visible().get();
        activity.printRepo(TEXT_TO_PRINT);
        final TextView githubRepos = (TextView) activity.findViewById(R.id.github_repos);
        assertTrue(githubRepos.getText().toString().contains(TEXT_TO_PRINT));
    }

    @Test
    public void testShowError() {
        final MasterActivity activity = Robolectric.buildActivity(MasterActivity.class)
            .create()
            .start()
            .resume()
            .visible()
            .get();
        activity.showError();
        final TextView githubRepos = (TextView) activity.findViewById(R.id.github_repos);
        final String error = RuntimeEnvironment.application.getResources().getString(R.string.error);
        assertTrue(githubRepos.getText().toString().contains(error));
    }

    @Test
    public void testLaunchDetailActivity() {
        final Activity activity = Robolectric.buildActivity(MasterActivity.class).
            create().start().resume().visible().get();
        final TextView githubRepos = (TextView) activity.findViewById(R.id.github_repos);
        githubRepos.performClick();
        final ShadowActivity shadowActivity = shadowOf(activity);
        final Intent startedIntent = shadowActivity.getNextStartedActivity();
        final ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertEquals(shadowIntent.getIntentClass(), DetailActivity.class);
    }
}
