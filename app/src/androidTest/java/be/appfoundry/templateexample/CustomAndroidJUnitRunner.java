package be.appfoundry.templateexample;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

public class CustomAndroidJUnitRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(final ClassLoader classLoader, final String className,
                                      final Context context)
        throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(classLoader, AndroidTestExampleApp.class.getName(), context);
    }
}