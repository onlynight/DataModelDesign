package com.github.onlynight.datamodeldesign.data;

import com.sun.istack.internal.NotNull;

/**
 * Created by lion on 2017/4/6.
 * data repository
 */
public abstract class BaseRepository {

    /**
     * get data source with the type
     *
     * @param type you should define it in your class and return different with this type.
     * @return data source model
     */
    public abstract BaseDataSource getDataSource(int type);

    /**
     * request data with data source.
     *
     * @param dataSource data source
     * @param listener   request data callback
     * @param args       params
     * @param <T>        the data source template
     */
    protected abstract <T> void getData(BaseDataSource<T> dataSource,
                                        @NotNull OnRequestListener<T> listener, Object... args);

    /**
     * request data with data source.
     *
     * @param type     you should define it in your class and return different with this type.
     * @param listener request data callback
     * @param args     params
     */
    public abstract void getData(int type,
                                 @NotNull OnRequestListener listener,
                                 Object... args);
}
