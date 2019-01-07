package com.andlausy.githubrepos.base.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.widget.BlockingLoadingView;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;

public abstract class BaseViewOnlyFragment extends DaggerFragment implements BaseView {

    @Inject
    BlockingLoadingView mBlockLoadingView;

    private Unbinder unbinder;

    @LayoutRes
    protected abstract int getLayout();

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(unbinder != null){
            unbinder.unbind();
        }
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
        Toast.makeText(getActivity(), R.string.auth_error_meesage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(getActivity(), R.string.network_error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUnknownError() {
        Toast.makeText(getActivity(), R.string.unknown_error_message, Toast.LENGTH_LONG).show();
    }


}
