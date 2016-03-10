package com.finddreams.retrofit.api.interaction;


import com.finddreams.retrofit.api.net.BaseSubsribe;
import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.api.service.ExpressApiService;
import com.finddreams.retrofit.bean.ExpressBean;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 获取物流信息实现类
 */
public class ExpressInteractorImpl implements ExpressInteractor {
    private final ExpressApiService api;

    @Inject
    public ExpressInteractorImpl(ExpressApiService myApi) {
        this.api = myApi;
    }

    @Override
    public Subscription getExpress(String apikey, String name, final OnNetResultListener<ExpressBean> resultListener) {
        Observable<ExpressBean> observable = api.getExpress(apikey, name);
        Subscription subscribe = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseSubsribe<ExpressBean>() {
            @Override
            public void onSuccess(ExpressBean s) {
                resultListener.onSuccess(s);
            }
        });
        return subscribe;
    }
}
