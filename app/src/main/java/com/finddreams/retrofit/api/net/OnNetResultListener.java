package com.finddreams.retrofit.api.net;

/**
 * 网络请求结果的监听
 *
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
public abstract class OnNetResultListener<T> {
    public abstract void onSuccess(T result);

    public void onFailure() {

    }
}
