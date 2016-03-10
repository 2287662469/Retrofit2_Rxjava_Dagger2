package com.finddreams.retrofit.api.service;


import com.finddreams.retrofit.bean.CityListBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 天气接口Api
 */
public interface WeatherApiService {
    /**
     * 查询可用城市列表
     */
    @GET("apistore/weatherservice/citylist")
    Observable<CityListBean> getCitylist(@Header("apikey") String apikey, @Query("cityname") String cityname);
}
