package be.appfoundry.templateexample.core.service;

import android.accounts.NetworkErrorException;
import be.appfoundry.core.model.GitHubRepo;
import be.appfoundry.core.service.GithubAPI;
import java.util.Collections;
import java.util.List;
import rx.Observable;

public class MockGithubAPI implements GithubAPI {

    private final List<GitHubRepo> repos;
    public boolean throwError;

    public MockGithubAPI(){
        final GitHubRepo githubRepo = new GitHubRepo();
        githubRepo.setName("test");
        githubRepo.setUrl("www.test.com");
        githubRepo.setDescription("test_desc");
        repos = Collections.singletonList(githubRepo);
    }

    @Override
    public Observable<List<GitHubRepo>> getRepos() {
        return throwError ? Observable.error(new NetworkErrorException("exception")) : Observable.just(repos);
    }
}
