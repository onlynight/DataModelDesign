package com.github.onlynight.datadesign.data;

import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 * base data source interface.
 * it defines data fake or local or remote data function.
 */
public interface BaseDataSource<T> {

    /**
     * get fake data
     * @param listener data callback listener
     * @param args params
     * @return
     */
    void getFakeData(@NotNull OnRequestListener<T> listener, Object... args);

    /**
     * get local data
     * @param listener data callback listener
     * @param args params
     */
    void getLocalData(@NotNull OnRequestListener<T> listener, Object... args);

    /**
     * get remote data
     * @param listener data callback listener
     * @param dataSourceListener change data source listener
     * @param args params
     */
    void getRemoteData(@NotNull OnRequestListener<T> listener,
                      @NotNull OnRequestListener.OnDataSourceListener dataSourceListener, Object... args);
}
