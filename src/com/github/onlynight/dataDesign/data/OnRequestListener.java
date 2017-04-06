package com.github.onlynight.datadesign.data;

import com.github.onlynight.datadesign.http.Response;

/**
 * Created by lion on 2017/4/6.
 * data source request listener
 */
public interface OnRequestListener<T> {

    /**
     * when request data finish, it will call this method.
     *
     * @param isRequestExist is request exist @Deprecated
     * @param requestSuccess is request success
     * @param data           request callback data
     * @param response       request origin response, only http request will return this param.
     * @return is request finish or need other action
     * {@link OnDataSourceListener#GET_DATA_SUCCESS}
     * {@link OnDataSourceListener#REQUEST_FAKE_DATA}
     * {@link OnDataSourceListener#REQUEST_LOCAL_DATA}
     * {@link OnDataSourceListener#REQUEST_REMOTE_DATA}
     */
    int onFinish(boolean isRequestExist, boolean requestSuccess,
                 T data, Response response);

    /**
     * when {@link OnRequestListener#onFinish(boolean, boolean, Object, Response)} be called,
     * then will call {@link OnDataSourceListener#onChange(int)} method.
     * it will tell the listener the request state and do which action.
     * {@link OnDataSourceListener#GET_DATA_SUCCESS}
     * {@link OnDataSourceListener#REQUEST_FAKE_DATA}
     * {@link OnDataSourceListener#REQUEST_LOCAL_DATA}
     * {@link OnDataSourceListener#REQUEST_REMOTE_DATA}
     */
    interface OnDataSourceListener {
        /**
         * request data state
         */

        // get data success you don't need to do anything
        int GET_DATA_SUCCESS = 0;

        // get data fail request fake data
        int REQUEST_FAKE_DATA = 1;

        // get data fail request local data
        int REQUEST_LOCAL_DATA = 2;

        // get data fail request remote data
        int REQUEST_REMOTE_DATA = 3;

        /**
         * when {@link OnRequestListener#onFinish(boolean, boolean, Object, Response)} be called,
         * then this method will be called.
         *
         * @param state
         */
        void onChange(int state);
    }
}
