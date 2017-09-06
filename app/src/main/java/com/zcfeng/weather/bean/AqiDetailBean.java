package com.zcfeng.weather.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class AqiDetailBean {
    public String getCo() {
        return co;
    }

    public String getSo2() {
        return so2;
    }

    public String getO3() {
        return o3;
    }

    public String getNo2() {
        return no2;
    }

    public String getAqi() {
        return aqi;
    }

    public String getPm10() {
        return pm10;
    }

    public String getPm2_5() {
        return pm2_5;
    }

    public String getO3_8h() {
        return O3_8h;
    }

    public String getQuality() {
        return quality;
    }

    public String getPrimary_pollutant() {
        return primary_pollutant;
    }

    public AqiDetailBean(JSONObject jsonObject) throws JSONException {
        aqi=jsonObject.getString("aqi");
        co=jsonObject.getString("co");
        no2=jsonObject.getString("no2");
        so2=jsonObject.getString("so2");
        o3=jsonObject.getString("o3");
        pm10=jsonObject.getString("pm10");
        pm2_5=jsonObject.getString("pm2_5");
        O3_8h=jsonObject.getString("o3_8h");
        quality=jsonObject.getString("quality");
                primary_pollutant=jsonObject.getString("primary_pollutant");
    }
    private String co;
    private String so2;
    private String o3;
    private String no2;
    private String aqi;
    private String pm10;
    private String pm2_5;
    private String O3_8h;
    private String quality;
    private String primary_pollutant;
}
