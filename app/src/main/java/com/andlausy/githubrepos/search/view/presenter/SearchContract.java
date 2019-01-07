package com.andlausy.githubrepos.search.view.presenter;

import com.andlausy.githubrepos.base.mvp.presenter.BasePresneter;
import com.andlausy.githubrepos.base.mvp.view.BaseView;
import com.andlausy.githubrepos.search.data.models.Item;

import java.util.List;

public interface SearchContract {

    interface SearchView extends BaseView{

        void showEmptySearchErrorMessage();
        void setSearchData(List<Item> searchData);
    }

    interface SearchPresenter extends BasePresneter<SearchView>{
        void search(String query);
    }
}
