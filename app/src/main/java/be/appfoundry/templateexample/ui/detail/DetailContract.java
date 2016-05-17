package be.appfoundry.templateexample.ui.detail;

import be.appfoundry.core.mvp.MVPContract;

interface DetailContract {
    interface MvpView extends MVPContract.MvpView {
        void showSnackbar(final String data);
    }

    interface MvpPresenter<V extends MVPContract.MvpView> extends MVPContract.MvpPresenter<V> {
        void getData();
    }

    interface Component<V extends MVPContract.MvpView, P extends MVPContract.MvpPresenter<V>>
        extends MVPContract.Component<P> { }
}
