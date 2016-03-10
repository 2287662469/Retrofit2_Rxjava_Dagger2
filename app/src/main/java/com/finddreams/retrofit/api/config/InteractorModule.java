package com.finddreams.retrofit.api.config;


import com.finddreams.retrofit.api.interaction.ExpressInteractorImpl;
import com.finddreams.retrofit.api.net.RestApiAdapter;
import com.finddreams.retrofit.api.service.ExpressApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Module类
 * 提供需要注入的类
 *
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
@Module
public class InteractorModule {
    @Provides
    public Retrofit provideRestAdapter() {
        return RestApiAdapter.getInstance();
    }

    @Provides
    public ExpressApiService provideHomeApi(Retrofit restAdapter) {
        return restAdapter.create(ExpressApiService.class);
    }

    @Provides
    public ExpressInteractorImpl provideHomeInteractor(ExpressApiService myApi) {
        return new ExpressInteractorImpl(myApi);
    }
}
