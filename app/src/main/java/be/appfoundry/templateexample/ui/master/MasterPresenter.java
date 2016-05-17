package be.appfoundry.templateexample.ui.master;

import be.appfoundry.core.model.GitHubRepo;
import be.appfoundry.core.mvp.MVPPresenter;
import be.appfoundry.core.rx.Transformers;
import be.appfoundry.core.service.GithubAPI;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;

public class MasterPresenter extends MVPPresenter<MasterContract.MvpView>
    implements MasterContract.MvpPresenter<MasterContract.MvpView> {

    private final GithubAPI githubAPI;
    private final Transformers transformers;

    @Inject
    public MasterPresenter(final GithubAPI githubAPI, final Transformers transformers) {
        this.githubAPI = githubAPI;
        this.transformers = transformers;
    }

    @Override
    public void getRepos() {
        githubAPI.getRepos()
            .flatMap(gitHubRepos -> Observable.from(gitHubRepos))
            .compose(transformers.<GitHubRepo>applyIOSchedulers())
            .subscribe(new Subscriber<GitHubRepo>() {
                @Override
                public void onCompleted() {
                    //empty
                }

                @Override
                public void onError(final Throwable throwable) {
                    if (isViewAttached()) {
                        getView().showError();
                    }
                }

                @Override
                public void onNext(final GitHubRepo gitHubRepo) {
                    if (isViewAttached()) {
                        getView().printRepo(gitHubRepo.getName());
                    }
                }
            });
    }
}
