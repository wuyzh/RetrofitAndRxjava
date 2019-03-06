package com.wuyazhou.learn.retrofitAndRxjava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wuyazhou.learn.R;
import com.wuyazhou.learn.retrofitAndRxjava.api.WeatherService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wuyazhou.learn.MainActivity.URL;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class RetrofitAndRxJavaPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private LinearLayout mLayout;
    private WeatherService mWeatherService;

    public RetrofitAndRxJavaPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public RetrofitAndRxJavaPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public RetrofitAndRxJavaPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.pager_retrofit_and_rxjava_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
    }

    public void initData(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                build();
        mWeatherService = retrofit.create(WeatherService.class);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            RetrofitAndRxJavaTest.getWeatherInfoModelByParam(mWeatherService,"临沂");
        } else {

        }
    }
}
