package com.andlausy.githubrepos.search.data.cloud;

import com.andlausy.githubrepos.search.data.models.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {

    @GET("/search/repositories?q=we")
    Observable<SearchResponse> searchRepositories(@Query("q") String query);
}
