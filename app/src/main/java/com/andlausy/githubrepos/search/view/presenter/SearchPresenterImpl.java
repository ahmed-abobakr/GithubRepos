package com.andlausy.githubrepos.search.view.presenter;

import com.andlausy.githubrepos.base.exceptions.AuthException;
import com.andlausy.githubrepos.base.exceptions.NetworkException;
import com.andlausy.githubrepos.base.exceptions.UnknownException;
import com.andlausy.githubrepos.base.mvp.presenter.BasePresnterImpl;
import com.andlausy.githubrepos.search.data.cloud.SearchCloud;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenterImpl extends BasePresnterImpl<SearchContract.SearchView>
        implements SearchContract.SearchPresenter {

    @Inject
    SearchCloud cloud;

    public SearchPresenterImpl(SearchCloud cloud){
        this.cloud = cloud;
    }

    @Override
    public void search(String query) {
        if(query == null || query.isEmpty())
            getView().showEmptySearchErrorMessage();
        else
            addDisposable(cloud.searchRepositories(query)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(searchResponse -> {
                        if(searchResponse.getItems() != null)
                            getView().setSearchData(searchResponse.getItems());
                        else
                            getView().showUnknownError();
                    }, throwable -> {
                        throwable = cloud.mapException(throwable);
                        if(throwable instanceof AuthException){
                            getView().showAuthError();
                        }else if(throwable instanceof NetworkException){
                            getView().showNetworkError();
                        }else {
                            getView().showUnknownError();
                        }
                    }));
    }
}
