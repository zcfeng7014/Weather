package com.zcfeng.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcfeng.weather.App;
import com.zcfeng.weather.R;

/**
 * Created by Administrator on 2017/8/28/028.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    App app;
    public MyAdapter(App datas) {
        app = datas;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);


        ViewHolder vh = new ViewHolder(view);
        vh.mTextView =(TextView) view.findViewById(R.id.time);
        vh.weatherinfo=view.findViewById(R.id.weather);
        vh.tempture=view.findViewById(R.id.tempture);
       // vh.iv=view.findViewById(R.id.iv);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        String time=app.bean.getHourDataList().get(position).getTemperature_time();
        String weatherinfo=app.bean.getHourDataList().get(position).getWeather();
        String temp=app.bean.getHourDataList().get(position).getTemperature();
        viewHolder.mTextView.setText(time);
        viewHolder.weatherinfo.setText(weatherinfo);
        viewHolder.tempture.setText(temp+"°");
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        if(app.bean.getHourDataList()==null)
            return 0;
        return app.bean.getHourDataList().size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView iv;
        public TextView weatherinfo;
        public TextView tempture;
        public ViewHolder(View view){
            super(view);


        }
    }
}