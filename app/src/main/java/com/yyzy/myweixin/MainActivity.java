package com.yyzy.myweixin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yyzy.myweixin.Adapter.MyFragmentPagerAdapter;
import com.yyzy.myweixin.fragment.faxianFragment;
import com.yyzy.myweixin.fragment.lianxrFragment;
import com.yyzy.myweixin.fragment.weixFragment;
import com.yyzy.myweixin.fragment.wodFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SwipeRefreshLayout swipeRefresh;
    ViewPager viewPager;
    MyFragmentPagerAdapter fragmentPagerAdapter;
    List<Fragment> fragmentList = new ArrayList<>();
    TextView title,wx_textview,lxr_textview,fx_text_view,wd_textview;

    ImageButton wx_buttom,lxr_buttom,fx_buttom,wd_buttom;


    LinearLayout wx_bottom,fx_bottom,lianxr_bottom,wd_bottom,toolbarlayout;
    weixFragment weixFragment;
    lianxrFragment lianxrFragment;
    faxianFragment faxianFragment;
    wodFragment wodFragment;
    public  void log(Object a){
        Log.d("显示", a+"");
    }
    @SuppressLint("WrongViewCast")
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        viewPager = findViewById(R.id.viewpager);
        fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setOffscreenPageLimit(4);//ViewPager的缓存为4帧
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);//初始设置ViewPager选中第一帧

        wx_bottom = findViewById(R.id.id_table_weiXin);
        log(viewPager.getAdapter());

        //下拉刷新
        swipeRefresh=findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });


        //页面滑动
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        title = findViewById(R.id.top);
    }

    //声明碎片，调用碎片
    private void initFragment() {
        weixFragment=new weixFragment(this);
        lianxrFragment=new lianxrFragment();
        faxianFragment=new faxianFragment();
        wodFragment=new wodFragment();

        fragmentList.add(weixFragment);
        fragmentList.add(lianxrFragment);
        fragmentList.add(faxianFragment);
        fragmentList.add(wodFragment);

        wx_bottom=findViewById(R.id.id_table_weiXin);
        lianxr_bottom=findViewById(R.id.id_table_txl);
        fx_bottom=findViewById(R.id.id_table_faXian);
        wd_bottom=findViewById(R.id.id_table_me);

    }
    //下拉刷新
    private void refreshFruits(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        weixFragment.update();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    //
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_table_weiXin:
                viewPager.setCurrentItem(0);

                log(111);
                break;
            case R.id.id_table_txl:
                viewPager.setCurrentItem(1);

                log(111);
                break;
            case R.id.id_table_faXian:
                viewPager.setCurrentItem(2);

                break;
            case R.id.id_table_me:
                viewPager.setCurrentItem(3);

                log(111);
                break;
            default:
                break;

        }
    }
}
