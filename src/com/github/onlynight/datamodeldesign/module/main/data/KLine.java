package com.github.onlynight.datamodeldesign.module.main.data;

import java.util.List;

/**
 * Created by lion on 2017/4/6.
 * kline model
 */
public class KLine {

    private long time;
    private List<Float> data;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String content = "{ time:" + time + ", data:[";
        if (data != null) {
            for (Float aData : data) {
                content += aData + ", ";
            }
        }
        content += "]}";
        return content;
    }
}
