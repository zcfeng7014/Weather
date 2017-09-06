package com.zcfeng.weather.location;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zcfeng.weather.speech.SpeechManager;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class LocationManager {
    public AMapLocationClient mLocationClient = null;
    public static LocationManager locationManager;
    LocationChangedAction locationChangedAction;
    public static LocationManager newInstance(Context context,LocationChangedAction mLocationListener){
        if(locationManager==null){
            synchronized (SpeechManager.class){
                if(locationManager==null){
                    locationManager=new LocationManager(context,mLocationListener);
                }
            }
        }
        return locationManager;
    }
    private  LocationManager(Context context,LocationChangedAction locationChangedAction) {
        this.locationChangedAction=locationChangedAction;
        mLocationClient = new AMapLocationClient(context);
        mLocationClient.setLocationListener(mLocationListener);
        AMapLocationClientOption mLocationOption  = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setOnceLocationLatest(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }
    public AMapLocationListener mLocationListener = new AMapLocationListener(){
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            locationChangedAction.Action(amapLocation);

        }
    };
    public interface LocationChangedAction{
        void Action(AMapLocation amapLocation);
    }
}
