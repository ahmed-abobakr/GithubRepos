package com.andlausy.githubrepos.base.mvp.view;

import android.os.Bundle;

import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.widget.BlockingLoadingView;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseViewOnlyActivity extends DaggerAppCompatActivity implements BaseView {

    @Inject
    BlockingLoadingView mBlockLoadingView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showBlockLoading() {
        mBlockLoadingView.showBlockLoading();
    }

    @Override
    public void hideBlockLoading() {
        mBlockLoadingView.hideBlockingLoading();
    }

    @Override
    public void showAuthError() {
        Toast.makeText(this, R.string.auth_error_meesage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUnknownError() {
        Toast.makeText(this, R.string.unknown_error_message, Toast.LENGTH_LONG).show();
    }

    public void loadFragment(Fragment fragment, int id, String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(tag);

        transaction.commit();
    }

    protected void setTitle(String title){
        setTitle(title);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1)
            getSupportFragmentManager().popBackStack();
        else
            super.finish();
    }



}
