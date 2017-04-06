package com.github.onlynight.datamodeldesign.util;

import com.github.onlynight.datamodeldesign.http.HttpManager;

/**
 * Created by lion on 2017/4/6.
 * config manager to change the app configuration
 */
public class ConfigManager {

    private boolean userFakeData = true;
    private int hostType = HttpManager.HOST_TYPE_DEV;

    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public boolean isUserFakeData() {
        return userFakeData;
    }

    public void setUserFakeData(boolean userFakeData) {
        this.userFakeData = userFakeData;
    }

    public int getHostType() {
        return hostType;
    }

    public void setHostType(int hostType) {
        this.hostType = hostType;
    }
}
