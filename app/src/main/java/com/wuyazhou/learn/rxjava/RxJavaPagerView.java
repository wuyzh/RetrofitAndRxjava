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
public class RxJavaPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private LinearLayout mLayout;
    Observer mObserver = null;

    public RxJavaPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
        initData();
    }

    public RxJavaPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        initData();
    }

    public RxJavaPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
        initData();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.pager_rxjava_layout, null);

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
        View button17  = mLayout.findViewById(R.id.model_button_17);
        button17.setOnClickListener(this);
        View button18  = mLayout.findViewById(R.id.model_button_18);
        button18.setOnClickListener(this);
        View button19  = mLayout.findViewById(R.id.model_button_19);
        button19.setOnClickListener(this);
        View button20  = mLayout.findViewById(R.id.model_button_20);
        button20.setOnClickListener(this);

        View button21  = mLayout.findViewById(R.id.model_button_21);
        button21.setOnClickListener(this);
        View button22  = mLayout.findViewById(R.id.model_button_22);
        button22.setOnClickListener(this);
        View button23  = mLayout.findViewById(R.id.model_button_23);
        button23.setOnClickListener(this);
        View button24  = mLayout.findViewById(R.id.model_button_24);
        button24.setOnClickListener(this);
        View button25  = mLayout.findViewById(R.id.model_button_25);
        button25.setOnClickListener(this);

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
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            RxJavaCreateTest.useCreate(mObserver);
        } else if (i == R.id.model_button_2) {
            RxJavaCreateTest.useJust(mObserver);
        } else if (i == R.id.model_button_3) {
            RxJavaCreateTest.useFrom(mObserver);
        } else if (i == R.id.model_button_4){
            RxJavaCreateTest.useInterval();
        }else if (i == R.id.model_button_5) {
            RxJavaCreateTest.useRange();
        }else if (i == R.id.model_button_6) {
            RxJavaCreateTest.useRepeat();
        }else if (i == R.id.model_button_7) {
            RxJavaMapTest.useMap();
        }else if (i == R.id.model_button_8) {
            RxJavaMapTest.useFlatMap();
        }else if (i == R.id.model_button_9) {
            RxJavaMapTest.useConcatMap();
        }else if (i == R.id.model_button_10) {
            RxJavaMapTest.useFlatMapIterable();
        }else if (i == R.id.model_button_11) {
            RxJavaMapTest.useBuffer();
        }else if (i == R.id.model_button_12) {
            RxJavaMapTest.useGroupBy();
        }else if (i == R.id.model_button_13) {
            RxJavaFilterTest.useFilter();
        }else if (i == R.id.model_button_14) {
            RxJavaFilterTest.useElementAt();
        }else if (i == R.id.model_button_15) {
            RxJavaFilterTest.useDistinct();
        }else if (i == R.id.model_button_16) {
            RxJavaFilterTest.useSkip();
        }else if (i == R.id.model_button_17) {
            RxJavaFilterTest.useTake();
        }else if (i == R.id.model_button_18) {
            RxJavaFilterTest.useIgnoreElements();
        }else if (i == R.id.model_button_19) {
            RxJavaFilterTest.useThrottleFirst();
        }else if (i == R.id.model_button_20) {
            RxJavaFilterTest.useThrottleTimeOut();
        }else if (i == R.id.model_button_21){
            RxJavaMergeTest.useStartWith();
        }else if (i == R.id.model_button_22){
            RxJavaMergeTest.useMerge();
        }else if (i == R.id.model_button_23){
            RxJavaMergeTest.useConcat();
        }else if (i == R.id.model_button_24){
            RxJavaMergeTest.useZip();
        }else if (i == R.id.model_button_25){
            RxJavaMergeTest.useCombineLastest();
        }else {

        }
    }
}
