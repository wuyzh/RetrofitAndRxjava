package com.wuyazhou.learn.rxjava;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wuyazhou.learn.R;
import com.wuyazhou.learn.logview.LogShowUtil;

import rx.Observer;


/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class RxJavaPager2View extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private LinearLayout mLayout;
    Observer mObserver = null;

    public RxJavaPager2View(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public RxJavaPager2View(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public RxJavaPager2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.pager_rxjava_2_layout, null);

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

        View button7  = mLayout.findViewById(R.id.model_button_7);
        button7.setOnClickListener(this);
        View button8  = mLayout.findViewById(R.id.model_button_8);
        button8.setOnClickListener(this);
        View button9  = mLayout.findViewById(R.id.model_button_9);
        button9.setOnClickListener(this);
        View button10  = mLayout.findViewById(R.id.model_button_10);
        button10.setOnClickListener(this);
        View button11  = mLayout.findViewById(R.id.model_button_11);
        button11.setOnClickListener(this);
        View button12  = mLayout.findViewById(R.id.model_button_12);
        button12.setOnClickListener(this);

        View button13  = mLayout.findViewById(R.id.model_button_13);
        button13.setOnClickListener(this);
        View button14  = mLayout.findViewById(R.id.model_button_14);
        button14.setOnClickListener(this);
        View button15  = mLayout.findViewById(R.id.model_button_15);
        button15.setOnClickListener(this);
        View button16  = mLayout.findViewById(R.id.model_button_16);
        button16.setOnClickListener(this);
    }

    public void initData(){
        mObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束",true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String string) {
                LogShowUtil.addLog("RxJava",string,true);
            }
        };
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            RxJavaAssistTest.useDelay();
        } else if (i == R.id.model_button_2) {
            RxJavaAssistTest.useDo();
        } else if (i == R.id.model_button_3) {
            RxJavaAssistTest.useSubscribeOn();
        } else if (i == R.id.model_button_4){
            RxJavaAssistTest.useObserveOn();
        }else if (i == R.id.model_button_5) {
            RxJavaAssistTest.useTimeOut();
        }else if (i == R.id.model_button_6) {
            RxJavaAssistTest.useTimeOut2();
        }else if (i == R.id.model_button_7) {
            RxJavaCatchTest.useCatch();
        }else if (i == R.id.model_button_8) {
            RxJavaCatchTest.useRetry();
        }else if (i == R.id.model_button_9) {
            RxJavaBooleanTest.useAll();
        }else if (i == R.id.model_button_10) {
            RxJavaBooleanTest.useContains();
        }else if (i == R.id.model_button_11) {
            RxJavaBooleanTest.useIsEmpty();
        }else if (i == R.id.model_button_12) {
            RxJavaConditionTest.useAmb();
        }else if (i == R.id.model_button_13) {
            RxJavaConditionTest.useDefaultIfEmpty();
        }else if (i == R.id.model_button_14) {
            RxJavaConvertTest.useToList();
        }else if (i == R.id.model_button_15) {
            RxJavaConvertTest.useToSortList();
        }else if (i == R.id.model_button_16) {
            RxJavaConvertTest.useToMap();
        }else {

        }
    }
}
