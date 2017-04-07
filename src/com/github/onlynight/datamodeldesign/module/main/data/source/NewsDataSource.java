package com.github.onlynight.datamodeldesign.module.main.data.source;

import com.github.onlynight.datamodeldesign.data.BaseDataSource;
import com.github.onlynight.datamodeldesign.data.OnRequestListener;
import com.github.onlynight.datamodeldesign.data.SimpleDataSource;
import com.github.onlynight.datamodeldesign.http.HttpManager;
import com.github.onlynight.datamodeldesign.module.main.data.News;
import com.github.onlynight.datamodeldesign.util.LogUtils;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lion on 2017/4/6.
 * news data source
 */
public class NewsDataSource extends SimpleDataSource<News> {

    @Override
    public void getFakeData(BaseDataSource<News> dataSource,
                            @NotNull OnRequestListener<News> listener,
                            @NotNull OnRequestListener.OnDataSourceListener<News> dataSourceListener, Object... args) {
        News news = new News();
        List<News.NewsItem> items = new ArrayList<>();
        News.NewsItem item = null;
        for (int i = 0; i < 10; i++) {
            item = new News.NewsItem();
            item.setId(i + 1);
            item.setContent("news" + (i + 1));
            items.add(item);
        }
        news.setData(items);
        listener.onFinish(true, true, news, null);

        super.getFakeData(dataSource, listener, dataSourceListener, args);
    }

    @Override
    public void getRemoteData(BaseDataSource<News> dataSource,
                              @NotNull OnRequestListener<News> listener,
                              @NotNull OnRequestListener.OnDataSourceListener<News> dataSourceListener, Object... args) {
        Map<String, String> params = new HashMap<>();
        if (args != null && args.length >= 2) {
            int page = (int) args[0];
            int size = (int) args[1];
            LogUtils.d("params: page = " + page + " size = " + size);
            params.put("page", Integer.toString(page));
            params.put("size", Integer.toString(size));
        }
        HttpManager.getInstance().post("News", params, dataSource, listener, dataSourceListener, args);
    }
}
