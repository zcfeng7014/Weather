package com.zcfeng.weather.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class DataBean {
    AqiDetailBean aqiDetail;
    String weather_code;
    String temperature_time;
    String wind_direction;
    String wind_power;
    String sd;
    String weather;
    String temperature;
    public DataBean(JSONObject jsonObject) throws JSONException {
        aqiDetail=new AqiDetailBean(jsonObject.getJSONObject("aqiDetail"));
        weather=jsonObject.getString("weather");
        weather_code=jsonObject.getString("weather_code");
        temperature_time=jsonObject.getString("temperature_time");
        wind_direction=jsonObject.getString("wind_direction");
        wind_power=jsonObject.getString("wind_power");
        sd=jsonObject.getString("sd");
        temperature=jsonObject.getString("temperature");

    }
    public AqiDetailBean getAqiDetail() {
        return aqiDetail;
    }

    public String getWeather_code() {
        return weather_code;
    }

    public String getTemperature_time() {
        return temperature_time;
    }

    public String getWind_Direction() {
        return wind_direction;
    }

    public String getWind_power() {
        return wind_power;
    }

    public String getSd() {
        return sd;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemperature() {
        return temperature;
    }


}
