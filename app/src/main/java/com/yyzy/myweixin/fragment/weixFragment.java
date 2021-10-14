package com.yyzy.myweixin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mywx.MyAdapter;
import com.yyzy.myweixin.Adapter.MyFragmentPagerAdapter;
import com.yyzy.myweixin.Adapter.WeixinListviewAdapter;
import com.yyzy.myweixin.R;
import com.yyzy.myweixin.util.WeiXin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class weixFragment extends Fragment {

    private static final String TAG = "wangge";
    List<WeiXin> list;
    ListView listView;
    private Context context;
    View view;
    private Button findBtn;

    MyAdapter myAdapter;

    Random random = new Random();
    List<WeiXin> arrylist = new ArrayList<WeiXin>();

    public weixFragment( Context context) {
        this.context = context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {


        View view = inflater.inflate(R.layout.tab_weixin, container, false);

//        findBtn = view.findViewById(R.id.wx_sousuo);
//        View view1 = getLayoutInflater().inflate()
//        findBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        init();
        shuaxinlist();
        Log.d(TAG, "onCreateView: " + arrylist.size());
        listView = view.findViewById(R.id.weixin_listview);
        WeixinListviewAdapter arrayAdapter = new WeixinListviewAdapter(context, R.layout.weixin_listview_item, arrylist);
        listView.setAdapter(arrayAdapter);
        return view;
    }


    public void init() {
        list = new ArrayList<WeiXin>();
        for (int i = 0; i < 8; i++) {
            WeiXin wx1 = new WeiXin(R.drawable.wd, "小黄", "要找xiaolv", "21:21");
            list.add(wx1);
            WeiXin wx2 = new WeiXin(R.drawable.wx, "小驴", "要找小黄", "14:36");
            list.add(wx2);
            WeiXin wx3 = new WeiXin(R.drawable.gw, "飞天青蛙", "飞起来找天鹅", "14:50");
            list.add(wx3);
            WeiXin wx4 = new WeiXin(R.drawable.kb, "玛玛拉稀", "啊吧啊吧啊吧", "14:35");
            list.add(wx4);
            WeiXin wx5 = new WeiXin(R.drawable.wd, "九天揽月", "揽个锤子", "12:00");
            list.add(wx5);
            WeiXin wx6 = new WeiXin(R.drawable.pyq, "宇智波", "佐助", "11:14");
            list.add(wx6);
            WeiXin wx7 = new WeiXin(R.drawable.xcx, "漩涡鸣人", "九尾起飞", "08:00");
            list.add(wx7);
            WeiXin wx8 = new WeiXin(R.drawable.yyy, "六道一乐", "六道拉面", "07:15");
            list.add(wx8);
        }

    }

    public void shuaxinlist(){
        arrylist.clear();
        for (int i=0;i<50;i++) {
            int n = random.nextInt(list.size());
            arrylist.add(list.get(n));
        }

    }


    public void update(){
        arrylist.clear();
        for (int i=0;i<50;i++) {
            int n = random.nextInt(list.size());
            arrylist.add(list.get(n));
        }
        myAdapter=new MyAdapter(view.getContext(),arrylist);
        listView.setAdapter(myAdapter);
    }
}