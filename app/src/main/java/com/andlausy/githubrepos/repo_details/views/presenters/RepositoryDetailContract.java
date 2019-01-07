package com.andlausy.githubrepos.repo_details.views.presenters;

import com.andlausy.githubrepos.base.mvp.presenter.BasePresneter;
import com.andlausy.githubrepos.base.mvp.view.BaseView;
import com.andlausy.githubrepos.repo_details.data.models.Subscriber;

import java.util.List;

public interface RepositoryDetailContract {

    interface RepositoryDetailView extends BaseView{
        void showRepoName(String name);
        void setSubscribersList(List<Subscriber> subscribersList);
    }

    interface RepositoryDetailPresenter extends BasePresneter<RepositoryDetailView>{
        void start(String repoName, String subscribersUrl);
    }
}
