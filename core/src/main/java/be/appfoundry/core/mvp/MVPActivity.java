package be.appfoundry.core.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MVPActivity<P extends MVPContract.MvpPresenter, C extends MVPContract.Component<P>>
    extends AppCompatActivity implements MVPContract.MvpView {
    protected P presenter;
    protected C component;

    protected abstract C createComponent();

    protected P createPresenter() {
        return component.presenter();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = createComponent();
        presenter = createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}

