package com.yyzy.myweixin.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyzy.myweixin.R;
import com.yyzy.myweixin.util.WeiXin;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeixinListviewAdapter extends ArrayAdapter<WeiXin> {

    private static final String TAG = "wangge";
    private Context context;
    private List<WeiXin> list = new ArrayList<WeiXin>();

    public WeixinListviewAdapter(@NonNull Context context, int resource, @NonNull List<WeiXin> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "getView: "+list.size());
        //拿到一行
        convertView = LayoutInflater.from(context).inflate(R.layout.weixin_listview_item,null,false);
        //行控件
        HH hh=new HH();
        hh. image = convertView.findViewById(R.id.weixin_photo);
        hh. txtName = convertView.findViewById(R.id.weixin_name);
        hh. txtMessage = convertView.findViewById(R.id.weixin_message);
        hh. txtTime = convertView.findViewById(R.id.weixin_time);
        //把集合中的内容放进控件
        hh. image.setImageResource(list.get(position).getImage());
        hh.txtName.setText(list.get(position).getName());
        hh.txtMessage.setText(list.get(position).getMessage());
        hh.txtTime.setText(list.get(position).getTime());
        convertView.setTag(hh);
        //返回行
        return convertView;
    }
    class HH{
        ImageView image;
        TextView txtName;
        TextView txtMessage;
        TextView txtTime;
    }
}
