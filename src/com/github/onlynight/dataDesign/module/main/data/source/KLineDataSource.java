package com.github.onlynight.datadesign.module.main.data.source;

import com.github.onlynight.datadesign.data.BaseDataSource;
import com.github.onlynight.datadesign.data.OnRequestListener;
import com.github.onlynight.datadesign.http.HttpManager;
import com.github.onlynight.datadesign.module.main.data.KLine;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lion on 2017/4/6.
 * kline data source
 */
public class KLineDataSource implements BaseDataSource<KLine> {

    @Override
    public void getFakeData(@NotNull OnRequestListener<KLine> listener, Object... args) {
    }

    @Override
    public void getLocalData(@NotNull OnRequestListener<KLine> listener, Object... args) {
        KLine kLine = new KLine();
        kLine.setTime(new Date().getTime());
        List<Float> data = new ArrayList<>();
        kLine.setData(data);
        for (int i = 0; i < 5; i++) {
            data.add((float) i);
        }
        listener.onFinish(true, true, kLine, null);
    }

    @Override
    public void getRemoteData(@NotNull OnRequestListener<KLine> listener, @NotNull OnRequestListener.OnDataSourceListener dataSourceListener, Object... args) {
        HttpManager.getInstance().post("KLine", null, listener, dataSourceListener);
    }
}
