package com.github.onlynight.datamodeldesign.module.main.data;

import com.github.onlynight.datamodeldesign.data.BaseDataSource;
import com.github.onlynight.datamodeldesign.data.OnRequestListener;
import com.github.onlynight.datamodeldesign.data.SimpleRepository;
import com.github.onlynight.datamodeldesign.module.main.data.source.KLineDataSource;
import com.github.onlynight.datamodeldesign.module.main.data.source.NewsDataSource;
import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 * main activity repository
 */
public class MainActivityRepository extends SimpleRepository {

    /**
     * you should define data source type here.
     */
    public static final int DATA_TYPE_NEWS = 0;
    public static final int DATA_TYPE_KLINE = 1;

    private NewsDataSource newsDataSource;
    private KLineDataSource kLineDataSource;

    /**
     * this method just help you create data source.
     *
     * @param type you should define it in your class and return different with this type.
     * @return specific data source
     */
    @Override
    public BaseDataSource getDataSource(int type) {
        switch (type) {
            case DATA_TYPE_NEWS:
                if (newsDataSource == null) {
                    newsDataSource = new NewsDataSource();
                }
                return newsDataSource;
            case DATA_TYPE_KLINE:
                if (kLineDataSource == null) {
                    kLineDataSource = new KLineDataSource();
                }
                return kLineDataSource;
        }
        return null;
    }


    @Override
    public void getData(int type, @NotNull OnRequestListener listener,
                        Object... args) {
        switch (type) {
            case DATA_TYPE_NEWS:
                getData(getDataSource(type), listener, args);
                break;
            case DATA_TYPE_KLINE:
                getData(getDataSource(type), listener, args);
                break;
        }
    }

    @Override
    public void getLocalDataFirst(int type, @NotNull OnRequestListener listener, Object... args) {
        switch (type) {
            case DATA_TYPE_NEWS:
                getLocalDataFirst(getDataSource(type), listener, args);
                break;
            case DATA_TYPE_KLINE:
                getLocalDataFirst(getDataSource(type), listener, args);
                break;
        }
    }

    public void getNews(int page, int size,
                        @NotNull OnRequestListener<News> listener) {
        getData(DATA_TYPE_NEWS, listener, page, size);
    }

    public void getKLine(long time,
                         @NotNull OnRequestListener<KLine> listener) {
        getLocalDataFirst(DATA_TYPE_KLINE, listener, time);
    }
}
