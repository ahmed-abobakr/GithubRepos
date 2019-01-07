package com.andlausy.githubrepos.base.mvp.view;

import android.os.Bundle;


import com.andlausy.githubrepos.base.mvp.presenter.BasePresneter;

import dagger.android.AndroidInjection;


public abstract class BaseActivity<T extends BasePresneter> extends BaseViewOnlyActivity {


    T mPresenter;


    public abstract T initPresenter();

    public T getPresenter(){
        if(mPresenter == null)
            mPresenter = initPresenter();
        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getPresenter().onViewAttached(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onViewDeAttached();
    }



}
