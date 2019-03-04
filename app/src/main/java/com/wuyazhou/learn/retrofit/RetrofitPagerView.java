package com.wuyazhou.learn.retrofit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wuyazhou.learn.R;
import com.wuyazhou.learn.retrofit.api.HttpService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wuyazhou.learn.MainActivity.URL;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class RetrofitPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private LinearLayout mLayout;
    private HttpService mHttpService;

    public RetrofitPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public RetrofitPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public RetrofitPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.pager_retrofit_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);

        View button3  = mLayout.findViewById(R.id.model_button_3);
        button3.setOnClickListener(this);

        View button4  = mLayout.findViewById(R.id.model_button_4);
        button4.setOnClickListener(this);

        View button5  = mLayout.findViewById(R.id.model_button_5);
        button5.setOnClickListener(this);

        View button6  = mLayout.findViewById(R.id.model_button_6);
        button6.setOnClickListener(this);
    }

    public void initData(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        mHttpService = retrofit.create(HttpService.class);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            RetrofitTest.getJsonObject(mHttpService);
        } else if (i == R.id.model_button_2) {
            RetrofitTest.getWeatherInfoModelByParam(mHttpService,"北京");
        } else if (i == R.id.model_button_3) {
            Map<String, String> params = new HashMap<>(1);
            params.put("city","青岛");
            RetrofitTest.getWeatherInfoModelByParams(mHttpService,params);
        } else if (i == R.id.model_button_4){
            RetrofitTest.getWeatherInfoModelByPathAndParam(mHttpService,"weatherApi","北京");
        }else if (i == R.id.model_button_5) {
            RetrofitTest.getWeatherInfoModelByPostField(mHttpService,"青岛");
        }else if (i == R.id.model_button_6) {
            RetrofitTest.getWeatherInfoModelByPostBody(mHttpService,new HttpService.CityBody("平邑"));
        }else {

        }
    }
}
