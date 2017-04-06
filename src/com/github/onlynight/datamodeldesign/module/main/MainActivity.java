package com.github.onlynight.datamodeldesign.module.main;

import com.github.onlynight.datamodeldesign.data.OnRequestListener;
import com.github.onlynight.datamodeldesign.http.Response;
import com.github.onlynight.datamodeldesign.module.main.data.KLine;
import com.github.onlynight.datamodeldesign.module.main.data.News;
import com.github.onlynight.datamodeldesign.module.main.data.MainActivityRepository;
import com.github.onlynight.datamodeldesign.util.LogUtils;

/**
 * Created by lion on 2017/4/6.
 * mock activity
 */
public class MainActivity {

    private MainActivityRepository repository;

    public void onCreate() {
        repository = new MainActivityRepository();
        repository.getNews(1, 10, new OnRequestListener<News>() {
            @Override
            public int onFinish(boolean isRequestExist, boolean requestSuccess, News data, Response response) {
                if (data != null) {
                    LogUtils.d(data.toString());
                    return OnDataSourceListener.GET_DATA_SUCCESS;
                } else {
                    return OnDataSourceListener.REQUEST_FAKE_DATA;
                }
            }
        });

        repository.getKLine(1L, new OnRequestListener<KLine>() {
            @Override
            public int onFinish(boolean isRequestExist, boolean requestSuccess, KLine data, Response response) {
                if (data != null) {
                    LogUtils.d(data.toString());
                    return OnDataSourceListener.GET_DATA_SUCCESS;
                } else {
                    return OnDataSourceListener.REQUEST_LOCAL_DATA;
                }
            }
        });
    }
}
