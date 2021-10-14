package com.example.mywx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyzy.myweixin.R;
import com.yyzy.myweixin.util.WeiXin;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<WeiXin> list;

    public MyAdapter(Context context, List<WeiXin> arrylist) {
        this.context = this.context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView  = LayoutInflater.from(context).inflate(R.layout.tab_weixin,null);
        ImageView imageView= convertView.findViewById(R.id.weixin_photo);
        TextView txt = convertView.findViewById(R.id.weixin_name);
        TextView txt1 = convertView.findViewById(R.id.weixin_message);
        TextView time = convertView.findViewById(R.id.weixin_time);
        WeiXin fruit = list.get(position);
        imageView.setImageResource(fruit.getImage());
        txt.setText(fruit.getName());
        txt1.setText(fruit.getMessage());
        time.setText(fruit.getTime());
        return convertView;
    }
}
