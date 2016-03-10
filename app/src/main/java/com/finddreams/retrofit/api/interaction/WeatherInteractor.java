package com.finddreams.retrofit.api.interaction;


import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.bean.CityListBean;

import rx.Subscription;

/**
 * 获取天气信息接口
 *
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
public interface WeatherInteractor {
    Subscription getCitylist(String apikey, String cityname, final OnNetResultListener<CityListBean> resultListener);
}
