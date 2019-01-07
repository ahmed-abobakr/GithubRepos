package com.andlausy.githubrepos.base.mvp.view.widget;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.andlausy.githubrepos.R;


import javax.inject.Inject;

public class BlockingLoadingView {

    private MaterialDialog mProgressDialog;
    Context mContext;

    @Inject
    public BlockingLoadingView(Context context){
        this.mContext = context;
    }

    public void showBlockLoading(){
        if (mProgressDialog == null) {
            mProgressDialog = new MaterialDialog(mContext);
        }
        mProgressDialog.setCancelable(false);
        mProgressDialog.setTitle(mContext.getResources().getString(R.string.loading_message));
        mProgressDialog.show();
    }

    public void hideBlockingLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
