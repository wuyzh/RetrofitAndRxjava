package com.wuyazhou.learn.retrofit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.R;
import com.wuyazhou.learn.logview.LogShowUtil;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class RetrofitPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;

    public RetrofitPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public RetrofitPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public RetrofitPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_retrofit_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            LogShowUtil.addLog("wuyazhouHttp", "123");
        } else if (i == R.id.model_button_2) {
            LogShowUtil.addLog("wuyazhouTest", "456");
        } else {
        }
    }
}
