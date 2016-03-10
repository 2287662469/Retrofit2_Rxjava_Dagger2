package com.finddreams.retrofit.api.interaction;


import com.finddreams.retrofit.api.net.BaseSubsribe;
import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.api.service.WeatherApiService;
import com.finddreams.retrofit.bean.CityListBean;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 获取天气信息实现类
 */
public class WeatherInteractorImpl implements WeatherInteractor {
    private final WeatherApiService api;

    @Inject
    public WeatherInteractorImpl(WeatherApiService myApi) {
        this.api = myApi;
    }

    @Override
    public Subscription getCitylist(String apikey, String cityname, final OnNetResultListener<CityListBean> resultListener) {
        Observable<CityListBean> observable = api.getCitylist(apikey, cityname);
        Subscription subscribe = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseSubsribe<CityListBean>() {
            @Override
            public void onSuccess(CityListBean s) {
                resultListener.onSuccess(s);
            }
        });
        return subscribe;
    }
}
