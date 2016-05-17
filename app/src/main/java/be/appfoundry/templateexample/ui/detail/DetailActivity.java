package be.appfoundry.templateexample.ui.detail;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.FrameLayout;
import be.appfoundry.core.mvp.MVPActivity;
import be.appfoundry.templateexample.ExampleApp;
import be.appfoundry.templateexample.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends MVPActivity<DetailPresenter, DetailComponent>
    implements DetailContract.MvpView {

    @BindView(R.id.content_view)
    FrameLayout contentView;

    @Override
    protected DetailComponent createComponent() {
        return DaggerDetailComponent.builder()
            .applicationComponent(((ExampleApp) getApplication()).getComponent())
            .build();
    }

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.detail_view);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getData();
    }

    @Override
    public void showSnackbar(final String data) {
        Snackbar.make(contentView, data, Snackbar.LENGTH_LONG).show();
    }
}
