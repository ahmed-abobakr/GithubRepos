package com.andlausy.githubrepos.search.data.cloud;

import android.util.Log;

import com.andlausy.githubrepos.base.data.BaseCloud;
import com.andlausy.githubrepos.search.data.models.SearchResponse;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class SearchCloud extends BaseCloud {

    public SearchCloud(Retrofit retrofit) {
        super(retrofit);
        Log.d("OkHttp", retrofit.baseUrl().toString());
    }

    public Observable<SearchResponse> searchRepositories(String query){
        return execute(SearchService.class).searchRepositories(query);
    }
}
