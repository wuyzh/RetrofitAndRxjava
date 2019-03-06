package com.wuyazhou.learn;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wuyazhou.learn.logview.LogShowView;
import com.wuyazhou.learn.retrofit.RetrofitPagerView;
import com.wuyazhou.learn.retrofitAndRxjava.RetrofitAndRxJavaPagerView;
import com.wuyazhou.learn.rxjava.RxJavaPager2View;
import com.wuyazhou.learn.rxjava.RxJavaPagerView;
import com.wuyazhou.pagerview.ModelPagerView;
import com.wuyazhou.pagerview.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "https://www.apiopen.top/";
    private ViewPager mViewPager = null;

    private List<View> mViews = new ArrayList<View>();
    private List<String> mViewTitle = new ArrayList<String>();
    private ViewPagerAdapter mViewPagerAdapter = null;

    private LogShowView mShowLogView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initShowLogView();
    }

    private void initPager(){
        mViewPager = findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter(mViews,mViewTitle, this);
        mViewPager.setAdapter(mViewPagerAdapter);
        addViewPagerView("Retrofit",new RetrofitPagerView(this));
        addViewPagerView("RxJava(一)",new RxJavaPagerView(this));
        addViewPagerView("RxJava(二)",new RxJavaPager2View(this));
        addViewPagerView("Retrofit和RxJava",new RetrofitAndRxJavaPagerView(this));
        addViewPagerView("标题二",new ModelPagerView(this));
        mViewPagerAdapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(2);
    }

    private void addViewPagerView(String title, View view){
        mViewTitle.add(title);
        mViews.add(view);
    }

    private void initShowLogView(){
        mShowLogView = findViewById(R.id.show_log_view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViews.clear();
        mViews = null;
        mShowLogView.release();
    }
}
