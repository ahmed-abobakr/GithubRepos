package com.andlausy.githubrepos.base.di.builder;

import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyFragment;
import com.andlausy.githubrepos.base.mvp.view.di.BaseViewOnlyFragmentModule;
import com.andlausy.githubrepos.repo_details.views.di.RepositoryDetailModule;
import com.andlausy.githubrepos.repo_details.views.fragments.RepositoryDetailFragment;
import com.andlausy.githubrepos.search.view.di.SearchFragmentModule;
import com.andlausy.githubrepos.search.view.fragments.SearchFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = BaseViewOnlyFragmentModule.class)
    abstract BaseViewOnlyFragment bindBaseViewOnlyFragment();

    @ContributesAndroidInjector(modules = SearchFragmentModule.class)
    abstract SearchFragment bindSearchFragment();

    @ContributesAndroidInjector(modules = RepositoryDetailModule.class)
    abstract RepositoryDetailFragment bindRepositoryDetailFragment();
}
