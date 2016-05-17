package be.appfoundry.templateexample.ui.master;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import be.appfoundry.core.mvp.MVPActivity;
import be.appfoundry.templateexample.ExampleApp;
import be.appfoundry.templateexample.R;
import be.appfoundry.templateexample.ui.detail.DetailActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MasterActivity extends MVPActivity<MasterPresenter, MasterComponent>
    implements MasterContract.MvpView {

    @BindView(R.id.github_repos)
    TextView githubRepo;

    @Override
    protected MasterComponent createComponent() {
        return DaggerMasterComponent.builder()
            .applicationComponent(((ExampleApp) getApplication()).getComponent())
            .build();
    }

    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.master_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getRepos();
    }

    @OnClick(R.id.github_repos)
    public void showDetailScreen() {
        final Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MasterContract.MvpView Implementation

    @Override
    public void printRepo(final String repoName) {
        githubRepo.setText(repoName);
    }

    @Override
    public void showError() {
        githubRepo.setText(R.string.error);
    }
}
