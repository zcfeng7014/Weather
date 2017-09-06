package com.zcfeng.weather.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class AlarmBean {
    String signalLevel;
    String issueContent;
    String issueTime;
    String province;
    String signalType;
    public String getSignalLevel() {
        return signalLevel;
    }

    public String getIssueContent() {
        return issueContent;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public String getProvince() {
        return province;
    }

    public String getSignalType() {
        return signalType;
    }

    public AlarmBean(JSONObject jsonObject) throws JSONException {
        signalLevel=jsonObject.getString("signalLevel");
        issueContent=jsonObject.getString("issueContent");
        issueTime=jsonObject.getString("issueTime");
        province=jsonObject.getString("province");
        signalType=jsonObject.getString("signalType");
    }

}
