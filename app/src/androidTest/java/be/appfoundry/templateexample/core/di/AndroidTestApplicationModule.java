package be.appfoundry.templateexample.core.di;

import android.app.Application;
import android.content.Context;
import be.appfoundry.core.di.ApplicationModule;
import be.appfoundry.core.di.ApplicationScope;
import be.appfoundry.core.rx.RxUtil;
import be.appfoundry.core.rx.Transformers;
import dagger.Module;
import dagger.Provides;

@Module
public class AndroidTestApplicationModule extends ApplicationModule {

    public AndroidTestApplicationModule(final Application application) {
        super(application);
    }

    @ApplicationScope
    @Provides
    protected Context provideApplicationContext() {
        return application;
    }

    @ApplicationScope
    @Provides
    protected Transformers provideTransformers() {
        return new RxUtil();
    }
}