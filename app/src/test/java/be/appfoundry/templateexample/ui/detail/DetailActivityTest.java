package be.appfoundry.templateexample.ui.detail;

import android.app.Activity;
import android.widget.TextView;
import be.appfoundry.templateexample.BuildConfig;
import be.appfoundry.templateexample.R;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, packageName = "be.appfoundry.templateexample")
public class DetailActivityTest {

    @Test
    public void preConditions() {
        final Activity activity = Robolectric.buildActivity(DetailActivity.class).get();
        assertNotNull(activity);
    }

    @Test
    public void testTextView() {
        final Activity activity = Robolectric.buildActivity(DetailActivity.class)
            .create()
            .start()
            .resume()
            .visible()
            .get();
        final TextView detailTextView = (TextView) activity.findViewById(R.id.detail_text_view);
        assertNotNull(detailTextView);
        final String text = RuntimeEnvironment.application.getResources().getString(R.string.detail_activity);
        assertEquals(detailTextView.getText().toString(), text);
    }

    @Test
    public void testSnackbar() {
        final DetailActivity activity = Robolectric.buildActivity(DetailActivity.class)
            .create()
            .start()
            .resume()
            .visible()
            .get();
        final TextView snackbar =
            (TextView) activity.findViewById(android.support.design.R.id.snackbar_text);
        Assert.assertNotNull(snackbar);
        Assert.assertEquals(snackbar.getText(), DetailPresenter.DATA);
    }
}
