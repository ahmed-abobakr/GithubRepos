package com.andlausy.githubrepos.search.view.di;

import com.andlausy.githubrepos.base.mvp.view.di.BaseViewOnlyFragmentModule;
import com.andlausy.githubrepos.search.data.cloud.SearchCloud;
import com.andlausy.githubrepos.search.view.adapters.SearchReposAdapter;
import com.andlausy.githubrepos.search.view.presenter.SearchPresenterImpl;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = BaseViewOnlyFragmentModule.class)
public class SearchFragmentModule {

    @Provides
    SearchPresenterImpl searchPresenter(SearchCloud cloud){
        return new SearchPresenterImpl(cloud);
    }

    @Provides
    SearchReposAdapter searchReposAdapter(){
        return new SearchReposAdapter();
    }

    @Provides
    SearchCloud searchCloud(Retrofit retrofit){
        return new SearchCloud(retrofit);
    }
}
