package com.andlausy.githubrepos.base.data;

import android.accounts.NetworkErrorException;

import com.andlausy.githubrepos.base.exceptions.ApiException;
import com.andlausy.githubrepos.base.exceptions.AuthException;
import com.andlausy.githubrepos.base.exceptions.NetworkException;
import com.andlausy.githubrepos.base.exceptions.UnknownException;


import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BaseCloud {

    Retrofit retrofit;

    @Inject
    public BaseCloud(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    protected <T> T execute(Class<T> cls){
        return retrofit.create(cls);
    }

    public Throwable mapException(Throwable throwable){
            if(throwable instanceof HttpException){
                HttpException httpException = (HttpException) throwable;
                ApiException apiException;
                Response response = httpException.response();
                try {
                    String errorBodyString = response.errorBody().string();
                    if(httpException.code() == 401)
                        return new AuthException(throwable);
                    else
                        return new UnknownException(throwable);
                }catch (Exception e){
                    return new UnknownException(throwable);
                }
            }else if(throwable instanceof IOException ||
                    throwable instanceof SocketException ||
                    throwable instanceof SocketTimeoutException ||
                    throwable instanceof UnknownHostException ||
                    throwable instanceof NetworkErrorException){
                return new NetworkException(throwable);
            }else
                return new UnknownException(throwable);
    }
}
