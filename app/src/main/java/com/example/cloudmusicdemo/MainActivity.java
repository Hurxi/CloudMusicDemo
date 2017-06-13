package com.example.cloudmusicdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cloudmusicdemo.adapter.BannerAdapter;
import com.example.cloudmusicdemo.adapter.HomeHeadFooterAdapter;
import com.example.cloudmusicdemo.bean.Banner;
import com.example.cloudmusicdemo.bean.Home;
import com.example.cloudmusicdemo.bean.HomeResponse;
import com.example.cloudmusicdemo.bean.Result;
import com.example.cloudmusicdemo.utils.HttpUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import image.SmartImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @BindView(R.id.dl)
    DrawerLayout dl;

    @BindView(R.id.vp_main)
    ViewPager vp_main;

    @BindView(R.id.my)
    ImageView my;

    @BindView(R.id.found)
    ImageView found;


    @BindView(R.id.friend)
    ImageView friend;

    ArrayList<Fragment> fragments;

    //侧边栏布局
    //内容布局
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments = new ArrayList<>();
        MyFragment f1 = new MyFragment();
        FoundFragment f2 = new FoundFragment();
        FriendFragment f3 = new FriendFragment();
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);

        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        vp_main.setAdapter(mainAdapter);
    }

    class MainAdapter extends FragmentPagerAdapter {
        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }





    @OnClick(R.id.iv_menu)
    void showMenu(View view){
        dl.openDrawer(Gravity.LEFT);
    }
}
