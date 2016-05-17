package be.appfoundry.templateexample.core.di;

import be.appfoundry.core.di.ApplicationScope;
import be.appfoundry.core.di.ServiceModule;
import be.appfoundry.core.service.GithubAPI;
import be.appfoundry.templateexample.core.service.MockGithubAPI;
import dagger.Provides;
import retrofit2.Retrofit;

public class TestServiceModule extends ServiceModule {

    @ApplicationScope
    @Provides
    @Override
    public GithubAPI provideGithubAPI(final Retrofit retrofit) {
        return new MockGithubAPI();
    }
}
