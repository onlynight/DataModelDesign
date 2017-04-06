package com.github.onlynight.dataDesign.module.main.data.source;

import com.github.onlynight.dataDesign.data.BaseDataSource;
import com.github.onlynight.dataDesign.data.OnRequestListener;
import com.github.onlynight.dataDesign.http.HttpManager;
import com.github.onlynight.dataDesign.module.main.data.News;
import com.github.onlynight.dataDesign.util.LogUtils;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lion on 2017/4/6.
 * news data source
 */
public class NewsDataSource implements BaseDataSource<News> {

    @Override
    public void getFakeData(@NotNull OnRequestListener<News> listener, Object... args) {
        News news = new News();
        List<News.NewsItem> items = new ArrayList<>();
        News.NewsItem item = null;
        for (int i = 0; i < 10; i++) {
            item = new News.NewsItem();
            item.setId(i);
            item.setContent("news" + i);
            items.add(item);
        }
        news.setData(items);
        listener.onFinish(true, true, news, null);
    }

    @Override
    public void getLocalData(@NotNull OnRequestListener<News> listener, Object... args) {
    }

    @Override
    public void getRemoteData(@NotNull OnRequestListener<News> listener, @NotNull OnRequestListener.OnDataSourceListener dataSourceListener, Object... args) {
        Map<String, String> params = new HashMap<>();
        if (args != null && args.length >= 2) {
            int page = (int) args[0];
            int size = (int) args[1];
            LogUtils.d("params: page = " + page + " size = " + size);
            params.put("page", Integer.toString(page));
            params.put("size", Integer.toString(size));
        }
        HttpManager.getInstance().post("News", params, listener, dataSourceListener);
    }
}
