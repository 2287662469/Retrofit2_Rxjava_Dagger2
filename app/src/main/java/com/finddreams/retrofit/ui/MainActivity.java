package com.finddreams.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.finddreams.retrofit.App;
import com.finddreams.retrofit.R;
import com.finddreams.retrofit.api.config.AppComponent;
import com.finddreams.retrofit.api.config.ConstantApi;
import com.finddreams.retrofit.api.interaction.WeatherInteractor;
import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.bean.CityListBean;

import java.util.ArrayList;

import rx.Subscription;

/**
 * 主页
 *
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
public class MainActivity extends AppCompatActivity {


    private AppComponent component;
    private WeatherInteractor homeInteractor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        component = App.get(this).component();
        homeInteractor = component.getWeatherInteractor();

        getWeatherData();


    }

    public void getWeatherData() {
        Subscription subscription = homeInteractor.getCitylist(ConstantApi.baiduKey, "朝阳", new OnNetResultListener<CityListBean>() {

            @Override
            public void onSuccess(CityListBean result) {

                ArrayList<CityListBean.RetDataEntity> resultEntities = result.getRetData();

                listView.setAdapter(new CitysAdapter(resultEntities, MainActivity.this));
            }
        });
        //取消请求
//        subscription.unsubscribe();
    }
}
