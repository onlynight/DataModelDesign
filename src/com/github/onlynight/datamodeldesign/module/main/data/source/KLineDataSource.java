package com.github.onlynight.datamodeldesign.module.main.data.source;

import com.github.onlynight.datamodeldesign.data.BaseDataSource;
import com.github.onlynight.datamodeldesign.data.OnRequestListener;
import com.github.onlynight.datamodeldesign.data.SimpleDataSource;
import com.github.onlynight.datamodeldesign.http.HttpManager;
import com.github.onlynight.datamodeldesign.module.main.data.KLine;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lion on 2017/4/6.
 * kline data source
 */
public class KLineDataSource extends SimpleDataSource<KLine> {

    @Override
    public void getLocalData(BaseDataSource<KLine> dataSource, @NotNull OnRequestListener<KLine> listener, @NotNull OnRequestListener.OnDataSourceListener<KLine> dataSourceListener, Object... args) {
        KLine kLine = new KLine();
        kLine.setTime(new Date().getTime());
        List<Float> data = new ArrayList<>();
        kLine.setData(data);
        for (int i = 0; i < 5; i++) {
            data.add((float) i + 1);
        }
        listener.onFinish(true, true, kLine, null);
        super.requestDataByState(OnRequestListener.OnDataSourceListener.REQUEST_REMOTE_DATA,
                dataSource, listener, dataSourceListener, args);
    }

    @Override
    public void getRemoteData(BaseDataSource<KLine> dataSource, @NotNull OnRequestListener<KLine> listener, @NotNull OnRequestListener.OnDataSourceListener<KLine> dataSourceListener, Object... args) {
        HttpManager.getInstance().post("KLine", null, dataSource,
                listener, dataSourceListener, args);
    }
}
