package com.andlausy.githubrepos.base.mvp.presenter;


import com.andlausy.githubrepos.base.mvp.view.BaseView;

public interface BasePresneter<T extends BaseView> {

    void onViewAttached(T view);

    void onViewDeAttached();

    T getView();
}
