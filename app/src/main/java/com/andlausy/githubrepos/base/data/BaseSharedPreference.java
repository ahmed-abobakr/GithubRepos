package com.andlausy.githubrepos.base.data;

import android.content.Context;
import android.content.SharedPreferences;

public class BaseSharedPreference {

    private final String PREF_NAME = "GITHUBREPOES_PREFS";
    private final int MODE = Context.MODE_PRIVATE;

    public SharedPreferences getPrefenece(Context context){
        return context.getApplicationContext().getSharedPreferences(PREF_NAME, MODE);
    }

    public SharedPreferences.Editor getEditor(Context context){
        return getPrefenece(context.getApplicationContext()).edit();
    }

    public  void remove(Context context, String key) {
        getEditor(context).remove(key).commit();
    }

    public  void clearPrefs(Context context) {
        getEditor(context).clear().apply();
    }
}
