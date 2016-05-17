package be.appfoundry.core.di;

import be.appfoundry.core.service.GithubAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    @ApplicationScope
    @Provides
    Retrofit provideRestAdapter() {
        return new Retrofit.Builder().baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    }

    @ApplicationScope
    @Provides
    protected GithubAPI provideGithubAPI(Retrofit retrofit) {
        return retrofit.create(GithubAPI.class);
    }
}
