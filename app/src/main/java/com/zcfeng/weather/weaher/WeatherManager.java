package com.zcfeng.weather.weaher;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class WeatherManager {
    private final RequestQueue requestQueue;
    private static WeatherManager weatherManager;
  public static WeatherManager  newInstance(Context context ){
      if(weatherManager==null){
          synchronized (WeatherManager.class){
              if(weatherManager==null){
                  weatherManager=new WeatherManager(context);
              }
          }
      }
      return weatherManager;
  }
    private WeatherManager(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getInfo(WeatherCMD cmd, final WeatherAdapter weatherAdapter) {
        String url="http://ali-weather.showapi.com/gps-to-weather"
                +"?from="+3 +
                "&lat="+cmd.getLatitude()+
                "&lng=" +cmd.getLongitude()+
                "&need3HourForcast=" +cmd.getNeed3HourForcast()+
                "&needAlarm=" +cmd.getNeedAlarm()+
                "&needHourData=" +cmd.getNeedHourData()+
                "&needIndex="+cmd.getNeedIndex()+
                "&needMoreDay="+cmd.getNeedMoreDay();
        requestQueue.add(new JsonObjectRequest(Request.Method.GET,url,null , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                weatherAdapter.OnWeatherInfoGet(jsonObject);

            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<String, String>();
                hashMap.put("Authorization","APPCODE e861d141f20849cab565a51358ca1f45");
                return hashMap;
            }
        });
    }
    public interface WeatherAdapter{
        void OnWeatherInfoGet(JSONObject jsonObject);
    }
}
