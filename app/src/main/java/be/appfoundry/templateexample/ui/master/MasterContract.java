package be.appfoundry.templateexample.ui.master;

import be.appfoundry.core.mvp.MVPContract;

public interface MasterContract {
    interface MvpView extends MVPContract.MvpView {
        void printRepo(final String repoName);

        void showError();
    }

    interface MvpPresenter<V extends MVPContract.MvpView> extends MVPContract.MvpPresenter<V> {
        void getRepos();
    }

    interface Component<V extends MVPContract.MvpView, P extends MVPContract.MvpPresenter<V>>
        extends MVPContract.Component<P> { }
}
