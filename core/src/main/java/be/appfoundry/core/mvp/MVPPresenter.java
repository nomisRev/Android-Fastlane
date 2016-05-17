package be.appfoundry.core.mvp;

public abstract class MVPPresenter<V extends MVPContract.MvpView> implements
                                                                  MVPContract.MvpPresenter<V> {
    private V view;

    @Override
    public V getView() {
        return view == null ? null : view;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}