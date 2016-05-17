package be.appfoundry.core.service;

import be.appfoundry.core.model.GitHubRepo;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface GithubAPI {
    @GET("/users/google/repos")
    Observable<List<GitHubRepo>> getRepos();
}
