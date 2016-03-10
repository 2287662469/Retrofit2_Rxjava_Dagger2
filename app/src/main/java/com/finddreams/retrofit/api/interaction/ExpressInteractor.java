package com.finddreams.retrofit.api.interaction;



import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.bean.ExpressBean;

import rx.Subscription;

/**
*获取物流信息接口
*@author finddreams
*@address http://blog.csdn.net/finddreams
*/
public interface ExpressInteractor {
    Subscription getExpress(String apikey, String name, final OnNetResultListener<ExpressBean> resultListener);
}
