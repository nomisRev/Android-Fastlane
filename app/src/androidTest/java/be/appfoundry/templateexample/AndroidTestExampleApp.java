package be.appfoundry.templateexample;

import be.appfoundry.core.di.ApplicationComponent;
import be.appfoundry.core.di.DaggerApplicationComponent;
import be.appfoundry.templateexample.core.di.AndroidTestApplicationModule;
import be.appfoundry.templateexample.core.di.AndroidTestServiceModule;

public class AndroidTestExampleApp extends ExampleApp {
    @Override
    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
            .applicationModule(new AndroidTestApplicationModule(this))
            .serviceModule(new AndroidTestServiceModule())
            .build();
    }
}