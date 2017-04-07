package com.github.onlynight.datamodeldesign.data;

import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 * base data source interface.
 * it defines data fake or local or remote data function.
 */
public interface BaseDataSource<T> {

    /**
     * get fake data
     *
     * @param listener           data callback listener
     * @param dataSourceListener data source listener
     * @param args               params
     * @return
     */
    void getFakeData(BaseDataSource<T> dataSource, @NotNull OnRequestListener<T> listener,
                     @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args);

    /**
     * get local data
     *
     * @param listener           data callback listener
     * @param args               params
     * @param dataSourceListener data source listener
     */
    void getLocalData(BaseDataSource<T> dataSource, @NotNull OnRequestListener<T> listener,
                      @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args);

    /**
     * get remote data
     *
     * @param listener           data callback listener
     * @param dataSourceListener change data source listener
     * @param args               params
     */
    void getRemoteData(BaseDataSource<T> dataSource, @NotNull OnRequestListener<T> listener,
                       @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args);

    /**
     * request data by data source type,
     * after get some source of data you can call this method to re-request data.
     *
     * @param state              data source state
     * @param dataSource         data source
     * @param listener           request callback listener
     * @param dataSourceListener data source callback listener
     * @param args               params
     */
    void requestDataByState(int state, BaseDataSource<T> dataSource,
                            @NotNull OnRequestListener<T> listener,
                            @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args);
}
