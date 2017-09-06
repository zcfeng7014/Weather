package com.zcfeng.weather.weaher;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class WeatherCMD {
    private double Latitude=0;

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public int getNeed3HourForcast() {
        return need3HourForcast;
    }

    public void setNeed3HourForcast(int need3HourForcast) {
        this.need3HourForcast = need3HourForcast;
    }

    public int getNeedAlarm() {
        return needAlarm;
    }

    public void setNeedAlarm(int needAlarm) {
        this.needAlarm = needAlarm;
    }

    public int getNeedHourData() {
        return needHourData;
    }

    public void setNeedHourData(int needHourData) {
        this.needHourData = needHourData;
    }

    public int getNeedIndex() {
        return needIndex;
    }

    public void setNeedIndex(int needIndex) {
        this.needIndex = needIndex;
    }

    public int getNeedMoreDay() {
        return needMoreDay;
    }

    public void setNeedMoreDay(int needMoreDay) {
        this.needMoreDay = needMoreDay;
    }

    private double Longitude=0;
    private int need3HourForcast=0;
    private int needAlarm=0;
    private int needHourData=0;
    private int needIndex=0;
    private int needMoreDay=0;
}
