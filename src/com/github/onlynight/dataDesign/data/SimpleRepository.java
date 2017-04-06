package com.github.onlynight.dataDesign.data;

import com.github.onlynight.dataDesign.data.OnRequestListener.OnDataSourceListener;
import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 */
public abstract class SimpleRepository extends BaseRepository {

    protected <T> void getData(BaseDataSource<T> dataSource,
                               @NotNull OnRequestListener<T> listener, Object... args) {
        if (dataSource == null) {
            if (listener != null) {
                listener.onFinish(false, false, null, null);
            }
            return;
        }

        dataSource.getRemoteData(listener, new OnRequestListener.OnDataSourceListener() {
            @Override
            public void onChange(int state) {

                switch (state) {
                    case OnDataSourceListener.REQUEST_FAKE_DATA:
                        dataSource.getFakeData(listener, args);
                        break;
                    case OnDataSourceListener.REQUEST_LOCAL_DATA:
                        dataSource.getLocalData(listener, args);
                        break;
                }
            }
        }, args);
    }
}
