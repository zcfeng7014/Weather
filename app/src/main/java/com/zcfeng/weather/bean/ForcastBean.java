package com.zcfeng.weather.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class ForcastBean {
    String wind_direction;
    String temperature_max;
    String wind_power;
    String weather;
    String temperature_min;
    String hour;
    String temperature;
    public String getWind_direction() {
        return wind_direction;
    }

    public String getTemperature_max() {
        return temperature_max;
    }

    public String getWind_power() {
        return wind_power;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemperature_min() {
        return temperature_min;
    }

    public String getHour() {
        return hour;
    }

    public String getTemperature() {
        return temperature;
    }


    public ForcastBean(JSONObject jsonObject) throws JSONException {
        wind_direction=jsonObject.getString("wind_direction");
        temperature_max=jsonObject.getString("temperature_max");
        wind_power=jsonObject.getString("wind_power");
        weather=jsonObject.getString("weather");
        temperature_min=jsonObject.getString("temperature_min");
        hour=jsonObject.getString("hour");
        temperature=jsonObject.getString("temperature");
    }
}
