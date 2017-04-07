package com.github.onlynight.datamodeldesign.data;

import com.github.onlynight.datamodeldesign.data.OnRequestListener.OnDataSourceListener;
import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 */
public abstract class SimpleRepository extends BaseRepository implements OnDataSourceListener {

    protected <T> void getData(BaseDataSource<T> dataSource,
                               @NotNull OnRequestListener<T> listener, Object... args) {
        if (dataSource == null) {
            if (listener != null) {
                listener.onFinish(false, false, null, null);
            }
            return;
        }

        dataSource.getRemoteData(dataSource, listener, this, args);
    }

    @Override
    public <T> void getLocalDataFirst(BaseDataSource<T> dataSource,
                                      @NotNull OnRequestListener<T> listener, Object... args) {
        if (dataSource == null) {
            if (listener != null) {
                listener.onFinish(false, false, null, null);
            }
            return;
        }

        dataSource.getLocalData(dataSource, listener, this, args);
    }

    @Override
    public void onChange(int state, BaseDataSource dataSource, OnRequestListener listener, Object... args) {
        switch (state) {
            case OnDataSourceListener.REQUEST_FAKE_DATA:
                dataSource.getFakeData(dataSource, listener, this, args);
                break;
            case OnDataSourceListener.REQUEST_LOCAL_DATA:
                dataSource.getLocalData(dataSource, listener, this, args);
                break;
            case OnDataSourceListener.REQUEST_REMOTE_DATA:
                dataSource.getRemoteData(dataSource, listener, this, args);
                break;
        }
    }
}
