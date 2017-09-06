package com.zcfeng.weather.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class DayInfoBean {
    String day_weather;
    String night_weather;
    String air_press;
    String jiangshui;
    String night_wind_power;
    String day_wind_power;
    String day_weather_code;
    String sun_begin_end;
    String ziwaixian;
    String weekday;
    String night_air_temperature;
    String day_air_temperature;
    String day_wind_direction;
    String day;
    String night_weather_code;
    String night_wind_direction;
    ArrayList<ForcastBean> ThreeHourForcast;
    HashMap<String,IndexBean> index;
    public String getDay_weather() {
        return day_weather;
    }

    public String getNight_weather() {
        return night_weather;
    }

    public String getAir_press() {
        return air_press;
    }

    public String getJiangshui() {
        return jiangshui;
    }

    public String getNight_wind_power() {
        return night_wind_power;
    }

    public String getDay_wind_power() {
        return day_wind_power;
    }

    public String getDay_weather_code() {
        return day_weather_code;
    }

    public String getSun_begin_end() {
        return sun_begin_end;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getNight_air_temperature() {
        return night_air_temperature;
    }

    public String getDay_air_temperature() {
        return day_air_temperature;
    }

    public String getDay_wind_direction() {
        return day_wind_direction;
    }

    public String getDay() {
        return day;
    }

    public String getNight_weather_code() {
        return night_weather_code;
    }

    public String getNight_wind_direction() {
        return night_wind_direction;
    }


    public  DayInfoBean(JSONObject jsonObject) throws JSONException {
        day=jsonObject.getString("day");
        day_weather=jsonObject.getString("day_weather");
        night_weather=jsonObject.getString("night_weather");
        air_press=jsonObject.getString("air_press");
        jiangshui=jsonObject.getString("jiangshui");
        night_wind_power=jsonObject.getString("night_wind_power");
        day_wind_power=jsonObject.getString("day_wind_power");
        day_weather_code=jsonObject.getString("day_weather_code");
        sun_begin_end=jsonObject.getString("sun_begin_end");
        ziwaixian=jsonObject.getString("ziwaixian");
        weekday=jsonObject.getString("weekday");
        night_air_temperature=jsonObject.getString("night_air_temperature");
        day_air_temperature=jsonObject.getString("day_air_temperature");
        day_wind_direction=jsonObject.getString("day_wind_direction");
        night_weather_code=jsonObject.getString("night_weather_code");
        night_wind_direction=jsonObject.getString("night_wind_direction");
        if(jsonObject.has("3hourForcast")){
            ThreeHourForcast=new ArrayList<>();
            JSONArray arr=jsonObject.getJSONArray("3hourForcast");
            for(int i=0;i<arr.length();i++)
            {
                ThreeHourForcast.add(new ForcastBean(arr.getJSONObject(i)));
            }
        }
        if(jsonObject.has("index")){
            index=new HashMap<>();
            JSONObject object=jsonObject.getJSONObject("index");
            Iterator<String> iterator=object.keys();
            while(iterator.hasNext()){
                String key=iterator.next();
                index.put(key,new IndexBean(object.getJSONObject(key)));
            }
        }
    }
    public IndexBean getIndex(String key){
    return index.get(key);
    }
    public Set<String> getIndexKey(){
        return index.keySet();

    }
}
