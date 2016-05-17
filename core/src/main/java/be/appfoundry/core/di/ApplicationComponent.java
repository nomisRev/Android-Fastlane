package be.appfoundry.core.di;

import android.content.Context;
import be.appfoundry.core.rx.Transformers;
import be.appfoundry.core.service.GithubAPI;
import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class,ServiceModule.class})
public interface ApplicationComponent {
    Context getApplicationContext();
    Transformers getTransfomers();
    GithubAPI getGithubAPI();
}