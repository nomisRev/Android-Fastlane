package be.appfoundry.templateexample.ui.master;

import be.appfoundry.core.di.ActivityScope;
import be.appfoundry.core.di.ApplicationComponent;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface MasterComponent
    extends MasterContract.Component<MasterContract.MvpView, MasterPresenter> { }
