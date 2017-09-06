package com.zcfeng.weather.weaher;

import com.zcfeng.weather.bean.WeatherBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class WeatherUtils {
    public static String DataToString(WeatherBean bean){
        String txt="";
      String warning="";
        for (int i = 0; i < bean.getAlarmList().size(); i++) {
            warning += "第" + (i + 1) + "条预警" + bean.getAlarmList().get(i).getIssueContent();
        }

        txt = "今日天气： \n" + "白天：" + bean.getDayInfo().get(0).getDay_weather()
                + "\n晚上：" + bean.getDayInfo().get(0).getNight_weather()
                + "\n穿衣建议:" + bean.getDayInfo().get(0).getIndex("clothes").getDesc()
                + "\n约会：" + bean.getDayInfo().get(0).getIndex("yh").getTitle() + " ," + bean.getDayInfo().get(0).getIndex("yh").getDesc()
                + warning;
        return txt;
    }
}
