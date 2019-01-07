package com.andlausy.githubrepos.repo_details.views.di;

import com.andlausy.githubrepos.repo_details.data.cloud.RepositoryDetailsCloud;
import com.andlausy.githubrepos.repo_details.views.adapters.RepositorySubscriberAdapter;
import com.andlausy.githubrepos.repo_details.views.presenters.RepositoryDetailPresenterImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RepositoryDetailModule {

    @Provides
    RepositoryDetailPresenterImpl repositoryDetailPresenter(RepositoryDetailsCloud cloud){
        return new RepositoryDetailPresenterImpl(cloud);
    }

    @Provides
    RepositoryDetailsCloud repositoryDetailsCloud(Retrofit retrofit){
        return new RepositoryDetailsCloud(retrofit);
    }

    @Provides
    RepositorySubscriberAdapter repositorySubscriberAdapter(){
        return new RepositorySubscriberAdapter();
    }
}
