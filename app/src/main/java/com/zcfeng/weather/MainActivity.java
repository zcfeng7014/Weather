package com.zcfeng.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.zcfeng.weather.adapter.MyAdapter;
import com.zcfeng.weather.adapter.MyGVAdapter;
import com.zcfeng.weather.location.LocationManager;
import com.zcfeng.weather.speech.SpeechManager;
import com.zcfeng.weather.weaher.WeatherCMD;
import com.zcfeng.weather.weaher.WeatherManager;
import com.zcfeng.weather.weaher.WeatherUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    SpeechManager speechManager;
    App app;
    @BindView(R.id.weatherinfo)
    TextView weatherinfo;
    @BindView(R.id.aqi)
    TextView aqi;
    @BindView(R.id.recyclerwiew)
    RecyclerView recyclerwiew;
    @BindView(R.id.tempture)
    TextView tempture;
    @BindView(R.id.wet)
    TextView wet;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.gridview)
    GridView gridview;
    MyGVAdapter gvAdapter;
    String[] mtitle = {"约会指数", "穿衣指数", "旅行指数", "运动指数", "化妆指数", "UV指数", "钓鱼指数", "洗车指数"};
    String[] keys = {"yh", "clothes", "travel", "sports", "beauty", "uv", "dy", "wash_car"};
    @BindView(R.id.city)
    TextView city;
    private LocationManager.LocationChangedAction mLocationListener = new LocationManager.LocationChangedAction() {
        @Override
        public void Action(AMapLocation amapLocation) {
            WeatherCMD cmd = new WeatherCMD();
            cmd.setLatitude(amapLocation.getLatitude());
            cmd.setLongitude(amapLocation.getLongitude());
            cmd.setNeedAlarm(1);
            cmd.setNeedIndex(1);
            cmd.setNeedHourData(1);
            WeatherManager weatherManager = WeatherManager.newInstance(getApplicationContext());
            weatherManager.getInfo(cmd, new WeatherManager.WeatherAdapter() {
                @Override
                public void OnWeatherInfoGet(JSONObject jsonObject) {
                    try {
                        app.bean.create(jsonObject.getJSONObject("showapi_res_body"));
                        dataToView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String text = WeatherUtils.DataToString(app.bean);


                    speechManager.speak(text);
                }
            });
        }
    };

    public void dataToView() {
        if (app.bean.getNow() == null) {
            LocationManager.newInstance(this, mLocationListener);
            return;
        }
        city.setText(app.bean.getCity());
        weatherinfo.setText(app.bean.getNow().getWeather());
        myAdapter.notifyDataSetChanged();
        aqi.setText(app.bean.getNow().getAqiDetail().getAqi() + " " + app.bean.getNow().getAqiDetail().getQuality());
        recyclerwiew.scrollToPosition(myAdapter.getItemCount() - 1);
        tempture.setText(" " + app.bean.getNow().getTemperature() + "°");
        wet.setText("湿度：" + app.bean.getNow().getSd());
        wind.setText(app.bean.getNow().getWind_power() + " " + app.bean.getNow().getWind_Direction());
        gvAdapter.notifyDataSetChanged();
    }

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        app = (App) getApplication();
        speechManager = SpeechManager.newInstance(this);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerwiew.setLayoutManager(mLayoutManager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerwiew.setHasFixedSize(true);
        myAdapter = new MyAdapter(app);
        recyclerwiew.setAdapter(myAdapter);
        gvAdapter = new MyGVAdapter(app, mtitle, keys);
        gridview.setAdapter(gvAdapter);

        LocationManager.newInstance(this, mLocationListener);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}