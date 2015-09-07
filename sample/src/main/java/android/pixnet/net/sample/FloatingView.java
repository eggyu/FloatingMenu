package android.pixnet.net.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;

/**
 * Created by abreu on 15/9/7.
 * Copyright (c) 2015, p42106@gmail.com All Rights Reserved.
 * <p/>
 * -----------------------------------------------------
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #                佛祖保佑         永無BUG             #
 * #                                                   #
 * -----------------------------------------------------
 */
public class FloatingView extends ViewGroup implements View.OnClickListener {
    private OnItemClickListener mOnItemClickListener;
    private boolean mIsChanged = true;
    private int mButtonX, mButtonY, mWidth_button_buttom, mHeight_button_buttom;
    private View mButton_buttom;

    public FloatingView(Context context) {
        this(context, null);
    }

    public FloatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatingView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        for (int i = getChildCount() - 1; i > -1; i--) {
            measureChild(getChildAt(i), widthMeasureSpec, (getHeight() / getChildCount()) * i);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        layoutBottom();
        if (mIsChanged) {
            for (int i = getChildCount() - 2; i > -1; i--) {
                View child = getChildAt(i);
                child.layout(0, mButtonY - mHeight_button_buttom * (getChildCount() - i - 1), mHeight_button_buttom, getMeasuredHeight() - mHeight_button_buttom * (getChildCount() - i - 1));
                final int finalI = i;
                child.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onClick(v, finalI);
                    }
                });
                child.setVisibility(GONE);

            }
        }
    }

    private void layoutBottom() {
        mButton_buttom = getChildAt(getChildCount() - 1);
        mButton_buttom.setOnClickListener(this);
        mWidth_button_buttom = getHeight() / getChildCount();
        mHeight_button_buttom = getHeight() / getChildCount();
        mButtonX = 0;
        mButtonY = getMeasuredHeight() - mHeight_button_buttom;
        mButton_buttom.layout(mButtonX, mButtonY, mWidth_button_buttom, getMeasuredHeight());
    }

    @Override
    public void onClick(View v) {
        toggleMenu();

    }

    private void toggleMenu() {

        if (mIsChanged) {
            int count = getChildCount();
            for (int i = 0; i < count - 1; i++) {
                View child = getChildAt(i);
                TranslateAnimation ta = new TranslateAnimation(-child.getMeasuredWidth(), 0, 0, 0);
                ta.setDuration(1000 + i * 100);
                child.startAnimation(ta);
                child.setVisibility(VISIBLE);
                mIsChanged = false;
            }
        } else {

            int count = getChildCount();
            for (int i = 0; i < count - 1; i++) {
                View child = getChildAt(i);
                TranslateAnimation ta = new TranslateAnimation(0, -child.getMeasuredWidth(), 0, 0);
                ta.setDuration(1000 + i * 100);
                child.startAnimation(ta);
                child.setVisibility(GONE);


                mIsChanged = true;
            }
        }

    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onClick(View v, int child);
    }
}
