package com.zcfeng.weather.bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class WeatherBean {
    ArrayList<AlarmBean> alarmList;
    ArrayList<DataBean> hourDataList;
    ArrayList<DayInfoBean> dayInfo;
    DataBean now;

    public String getCity() {
        return City;
    }

    String City;
    public void create(JSONObject jsonObject) throws JSONException {
        City=jsonObject.getJSONObject("cityInfo").getString("c3");
        now =new DataBean(jsonObject.getJSONObject("now"));

        if(jsonObject.has("alarmList")){
            alarmList=new ArrayList<>();
            alarmList.clear();
            JSONArray jsonArray=jsonObject.getJSONArray("alarmList");
            for(int i=0;i<jsonArray.length();i++){
                alarmList.add(new AlarmBean(jsonArray.getJSONObject(i)));
            }
        }
        if (jsonObject.has("hourDataList")){
            hourDataList=new ArrayList<>();
            hourDataList.clear();
            JSONArray array=jsonObject.getJSONArray("hourDataList");
            for (int i=0;i<array.length();i++){
                hourDataList.add(new DataBean(array.getJSONObject(i)));
            }
        }
        dayInfo=new ArrayList<>();
        dayInfo.clear();
        for (int i=1;i<8;i++){
            if(jsonObject.has("f"+i)){
                dayInfo.add(new DayInfoBean(jsonObject.getJSONObject("f"+i)));
            }
        }

    }

    public ArrayList<AlarmBean> getAlarmList() {
        return alarmList;
    }

    public ArrayList<DataBean> getHourDataList() {
        return hourDataList;
    }

    public ArrayList<DayInfoBean> getDayInfo() {
        return dayInfo;
    }

    public DataBean getNow() {
        return now;
    }
}
