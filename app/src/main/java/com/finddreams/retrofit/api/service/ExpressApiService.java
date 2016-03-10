package com.finddreams.retrofit.api.service;


import com.finddreams.retrofit.bean.ExpressBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 物流接口Api
 */
public interface ExpressApiService {
    @GET("netpopo/express/express2")
    Observable<ExpressBean> getExpress(@Header("apikey") String apikey, @Query("name") String name);
}
