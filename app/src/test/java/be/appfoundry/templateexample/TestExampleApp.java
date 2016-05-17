package be.appfoundry.templateexample;

import be.appfoundry.core.di.ApplicationComponent;
import be.appfoundry.core.di.DaggerApplicationComponent;
import be.appfoundry.templateexample.core.di.TestApplicationModule;
import be.appfoundry.templateexample.core.di.TestServiceModule;

public class TestExampleApp extends ExampleApp {
    @Override
    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
            .applicationModule(new TestApplicationModule(this))
            .serviceModule(new TestServiceModule())
            .build();
    }
}