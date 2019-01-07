package com.andlausy.githubrepos.repo_details.views.presenters;

import com.andlausy.githubrepos.base.exceptions.AuthException;
import com.andlausy.githubrepos.base.exceptions.NetworkException;
import com.andlausy.githubrepos.base.mvp.presenter.BasePresnterImpl;
import com.andlausy.githubrepos.repo_details.data.cloud.RepositoryDetailsCloud;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoryDetailPresenterImpl extends BasePresnterImpl<RepositoryDetailContract.RepositoryDetailView>
        implements RepositoryDetailContract.RepositoryDetailPresenter {

    @Inject
    RepositoryDetailsCloud cloud;

    public RepositoryDetailPresenterImpl(RepositoryDetailsCloud cloud){
        this.cloud = cloud;
    }

    @Override
    public void start(String repoName, String subscribersUrl) {
        getView().showRepoName(repoName);
        //getView().showBlockLoading();
        cloud.getRepoSubscribers(subscribersUrl).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribers -> {
                    //getView().hideBlockLoading();
                    if(subscribers != null)
                        getView().setSubscribersList(subscribers);
                    else
                        getView().showUnknownError();
                }, throwable -> {
                    throwable = cloud.mapException(throwable);
                   // getView().hideBlockLoading();
                    if(throwable instanceof NetworkException)
                        getView().showNetworkError();
                    else if(throwable instanceof AuthException)
                        getView().showAuthError();
                    else
                        getView().showUnknownError();
                });
    }
}
