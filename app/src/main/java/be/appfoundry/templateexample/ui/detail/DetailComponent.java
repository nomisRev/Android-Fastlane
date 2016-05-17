package be.appfoundry.templateexample.ui.detail;

import be.appfoundry.core.di.ActivityScope;
import be.appfoundry.core.di.ApplicationComponent;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
interface DetailComponent
    extends DetailContract.Component<DetailContract.MvpView, DetailPresenter> { }
