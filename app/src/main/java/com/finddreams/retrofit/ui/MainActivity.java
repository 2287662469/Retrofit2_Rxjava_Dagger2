package com.finddreams.retrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.finddreams.retrofit.App;
import com.finddreams.retrofit.R;
import com.finddreams.retrofit.api.config.AppComponent;
import com.finddreams.retrofit.api.config.ConstantApi;
import com.finddreams.retrofit.api.interaction.ExpressInteractorImpl;
import com.finddreams.retrofit.api.net.OnNetResultListener;
import com.finddreams.retrofit.bean.ExpressBean;


import java.util.ArrayList;

import rx.Subscription;

/**
 * 主页
 * @author finddreams
 * @address http://blog.csdn.net/finddreams
 */
public class MainActivity extends AppCompatActivity {


    private AppComponent component;
    private ExpressInteractorImpl homeInteractor;
    private Button retrofit;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = (Button) findViewById(R.id.retrofit);
        listView = (ListView) findViewById(R.id.listview);
        component = App.get(this).component();
        homeInteractor = component.getHomeInteractor();
        retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getExpressData();
            }
        });


    }

    public void getExpressData() {
        Subscription subscription = homeInteractor.getExpress(ConstantApi.baiduKey, "", new OnNetResultListener<ExpressBean>() {

            @Override
            public void onSuccess(ExpressBean result) {

                ArrayList<ExpressBean.ResultEntity> resultEntities = result.getResult();

                listView.setAdapter(new ExpressAdapter(resultEntities, MainActivity.this));
            }
        });
        //取消请求
//        subscription.unsubscribe();
    }
}
