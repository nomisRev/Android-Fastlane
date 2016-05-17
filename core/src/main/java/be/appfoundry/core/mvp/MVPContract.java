package be.appfoundry.core.mvp;

public interface MVPContract {
    interface MvpView {}

    interface MvpPresenter<V extends MvpView> {
        V getView();
        boolean isViewAttached();
        void attachView(V view);
        void detachView();
    }

    interface Component<P extends MvpPresenter> {
        P presenter();
    }
}