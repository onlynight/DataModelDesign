package com.github.onlynight.dataDesign.module.main.data;

import com.github.onlynight.dataDesign.http.BaseHttpResult;

import java.util.List;

/**
 * Created by lion on 2017/4/6.
 * news model
 */
public class News extends BaseHttpResult {

    private List<NewsItem> data;

    public List<NewsItem> getData() {
        return data;
    }

    @Override
    public String toString() {
        String content = "{ data:[";
        if (data != null) {
            for (NewsItem item : data) {
                content += item.toString() + ",\n";
            }
        }
        content += "] }";
        return content;
    }

    public void setData(List<NewsItem> data) {
        this.data = data;
    }

    public static class NewsItem {
        private int id;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "{ id:" + id + ", content:" + getContent() + " }";
        }
    }
}
