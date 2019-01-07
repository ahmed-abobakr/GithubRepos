package com.andlausy.githubrepos.base.mvp.view;

import android.os.Bundle;



import com.andlausy.githubrepos.base.mvp.presenter.BasePresneter;

import java.lang.reflect.Field;

import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends BasePresneter> extends BaseViewOnlyFragment{


    T mPresenter;

    public abstract T initPresenter();

    public T getPresenter(){
        if(mPresenter != null)
            return mPresenter;
        else
            return initPresenter();
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onViewAttached(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onViewDeAttached();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
