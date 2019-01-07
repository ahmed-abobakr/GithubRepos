package com.andlausy.githubrepos.base.mvp.presenter;



import com.andlausy.githubrepos.base.mvp.view.BaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresnterImpl<T extends BaseView> implements BasePresneter<T> {

    private WeakReference<T> viewWeakRef;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onViewAttached(T view) {
        this.viewWeakRef = new WeakReference<T>(view);
    }

    @Override
    public void onViewDeAttached() {
        if (viewWeakRef != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
            viewWeakRef.clear();
            viewWeakRef = null;
        }
    }

    @Override
    public T getView() {
        return viewWeakRef.get();
    }

    protected void addDisposable(Disposable disposable) {
        this.disposable.add(disposable);
    }

    public boolean isViewAttached() {
        return viewWeakRef != null;
    }
}
