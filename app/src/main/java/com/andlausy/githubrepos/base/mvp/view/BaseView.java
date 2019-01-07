package com.andlausy.githubrepos.base.mvp.view;


import com.andlausy.githubrepos.base.mvp.presenter.BasePresneter;

public interface BaseView<T extends BasePresneter> {

    void showBlockLoading();

    void hideBlockLoading();

    void showAuthError();

    void showNetworkError();

    void showUnknownError();
}
