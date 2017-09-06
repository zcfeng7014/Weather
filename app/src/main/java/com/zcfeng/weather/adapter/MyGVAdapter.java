package com.zcfeng.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zcfeng.weather.App;
import com.zcfeng.weather.R;

/**
 * Created by Administrator on 2017/8/29/029.
 */

public class MyGVAdapter extends BaseAdapter {
    String[] titles;
    String[] keys;
    App app;
    public MyGVAdapter(App app,String[] titles,String[] keys){
        this.app=app;
        this.keys=keys;
        this.titles=titles;
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_index,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else
            viewHolder= (ViewHolder) view.getTag();
        viewHolder.mtitle.setText(titles[i]);
        if(app.bean.getDayInfo()!=null) {
            viewHolder.index.setText(app.bean.getDayInfo().get(0).getIndex(keys[i]).getTitle());
            viewHolder.content.setText(app.bean.getDayInfo().get(0).getIndex(keys[i]).getDesc());
        }
        return view;
    }
    class ViewHolder  {
        public TextView mtitle;
        public TextView index;
        public TextView content;
        public ViewHolder(View view){
            mtitle=view.findViewById(R.id.title);
            index=view.findViewById(R.id.index);
            content=view.findViewById(R.id.content);
        }
    }
}
