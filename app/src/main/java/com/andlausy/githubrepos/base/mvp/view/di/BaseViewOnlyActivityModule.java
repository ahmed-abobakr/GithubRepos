package com.andlausy.githubrepos.base.mvp.view.di;

import android.content.Context;

import com.andlausy.githubrepos.base.mvp.view.widget.BlockingLoadingView;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseViewOnlyActivityModule {

    @Provides
    BlockingLoadingView blockingLoadingView(Context context){
        return new BlockingLoadingView(context);
    }
}
