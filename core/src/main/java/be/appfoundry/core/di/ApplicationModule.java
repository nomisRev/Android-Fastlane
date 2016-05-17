package be.appfoundry.core.di;

import android.app.Application;
import android.content.Context;
import be.appfoundry.core.rx.RxUtil;
import be.appfoundry.core.rx.Transformers;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    protected Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @ApplicationScope
    @Provides
    protected Context provideApplicationContext(){
        return application;
    }

    @ApplicationScope
    @Provides
    protected Transformers provideTransformers(){
        return new RxUtil();
    }
}
