package com.zcfeng.weather.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class IndexBean {
    String title;
    String  desc;
    public IndexBean(JSONObject jsonObject) throws JSONException {
        title=jsonObject.getString("title");
        desc=jsonObject.getString("desc");
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
