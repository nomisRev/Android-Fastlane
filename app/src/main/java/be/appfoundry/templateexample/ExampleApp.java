package be.appfoundry.templateexample;

import android.app.Application;
import be.appfoundry.core.di.ApplicationComponent;
import be.appfoundry.core.di.ApplicationModule;
import be.appfoundry.core.di.DaggerApplicationComponent;
import be.appfoundry.core.di.ServiceModule;
import butterknife.ButterKnife;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class ExampleApp extends Application {
    private ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
        ButterKnife.setDebug(true);
        Fabric.with(this, new Crashlytics());
    }

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .serviceModule(new ServiceModule())
            .build();
    }
}
