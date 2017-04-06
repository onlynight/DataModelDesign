package com.github.onlynight.datadesign.http;

import com.github.onlynight.datadesign.data.OnRequestListener;
import com.github.onlynight.datadesign.util.LogUtils;
import com.sun.istack.internal.NotNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by lion on 2017/4/6.
 * http manager simple sample
 */
public class HttpManager {

    public static final int HOST_TYPE_RELEASE = 0;
    public static final int HOST_TYPE_TEST = 1;
    public static final int HOST_TYPE_DEV = 2;

    private static final String HOST_RELEASE = "https://www.baidu.com";
    private static final String HOST_TEST = "https://www.baidu.com";
    private static final String HOST_DEV = "https://www.baidu.com";

    private static String HOST = HOST_RELEASE;

    public void changeHost(int hostType) {
        switch (hostType) {
            case HOST_TYPE_RELEASE:
                HOST = HOST_RELEASE;
                break;
            case HOST_TYPE_TEST:
                HOST = HOST_TEST;
                break;
            case HOST_TYPE_DEV:
                HOST = HOST_DEV;
                break;
        }
    }

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) {
            instance = new HttpManager();
        }
        return instance;
    }

    private HttpManager() {
    }

    public <T> void get(String action, Map<String, String> params,
                        @NotNull OnRequestListener<T> listener,
                        @NotNull OnRequestListener.OnDataSourceListener dataSourceListener) {
        // TODO: 2017/4/6 send a http get request
        /**
         * you can use Gson or FastJson to parse json to JavaBean with this type;
         */
        Type type = getTemplate(listener);
        int state = listener.onFinish(true, true, null, null);
        if (dataSourceListener != null) {
            dataSourceListener.onChange(state);
        }
    }

    public <T> void post(String action, Map<String, String> params,
                         @NotNull OnRequestListener<T> listener,
                         @NotNull OnRequestListener.OnDataSourceListener dataSourceListener) {
        // TODO: 2017/4/6 send a http post request
        /**
         * you can use Gson or FastJson to parse json to JavaBean with this type;
         */
        Type type = getTemplate(listener);
        int state = listener.onFinish(true, true, null, null);
        if (dataSourceListener != null) {
            dataSourceListener.onChange(state);
        }
    }

    public static Type getTemplate(Object obj) {
        Type[] genericInterfaces = obj.getClass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
                if (genericTypes != null && genericTypes.length > 0) {
                    LogUtils.d("Generic type: " + genericTypes[0]);
                    return genericTypes[0];
                }
            }
        }

        return null;
    }
}
