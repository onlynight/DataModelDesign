package com.github.onlynight.datamodeldesign.data;

import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/7.
 * simple data source sample
 */
public class SimpleDataSource<T> implements BaseDataSource<T> {

    @Override
    public void getFakeData(BaseDataSource<T> dataSource,
                            @NotNull OnRequestListener<T> listener,
                            @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args) {
        requestDataByState(OnRequestListener.OnDataSourceListener.GET_DATA_SUCCESS,
                dataSource, listener, dataSourceListener, args);
    }

    @Override
    public void getLocalData(BaseDataSource<T> dataSource,
                             @NotNull OnRequestListener<T> listener,
                             @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args) {
        requestDataByState(OnRequestListener.OnDataSourceListener.GET_DATA_SUCCESS,
                dataSource, listener, dataSourceListener, args);
    }

    @Override
    public void getRemoteData(BaseDataSource<T> dataSource,
                              @NotNull OnRequestListener<T> listener,
                              @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args) {
        requestDataByState(OnRequestListener.OnDataSourceListener.GET_DATA_SUCCESS,
                dataSource, listener, dataSourceListener, args);
    }

    @Override
    public void requestDataByState(int state, BaseDataSource<T> dataSource,
                                   @NotNull OnRequestListener<T> listener,
                                   @NotNull OnRequestListener.OnDataSourceListener<T> dataSourceListener, Object... args) {
        if (dataSourceListener != null) {
            dataSourceListener.onChange(state,
                    dataSource, listener, args);
        }
    }
}
