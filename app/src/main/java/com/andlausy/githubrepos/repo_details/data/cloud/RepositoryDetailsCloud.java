package com.andlausy.githubrepos.repo_details.data.cloud;

import com.andlausy.githubrepos.base.data.BaseCloud;
import com.andlausy.githubrepos.repo_details.data.models.Subscriber;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class RepositoryDetailsCloud extends BaseCloud {

    public RepositoryDetailsCloud(Retrofit retrofit) {
        super(retrofit);
    }

    public Observable<List<Subscriber>> getRepoSubscribers(String url){
        return execute(RepositoryDetailService.class).getRepoSubscribers(url);
    }


}
