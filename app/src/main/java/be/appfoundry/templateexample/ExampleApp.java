package be.appfoundry.templateexample;

import android.app.Application;
import be.appfoundry.core.di.ApplicationComponent;
import be.appfoundry.core.di.ApplicationModule;
import be.appfoundry.core.di.DaggerApplicationComponent;
import be.appfoundry.core.di.ServiceModule;
import butterknife.ButterKnife;

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
    }

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .serviceModule(new ServiceModule())
            .build();
    }
}
