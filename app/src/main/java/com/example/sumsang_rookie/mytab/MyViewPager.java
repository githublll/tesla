package com.example.sumsang_rookie.mytab;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
    private boolean scroll = false;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyViewPager(Context context) {
        super(context);
    }

    public boolean isScroll() {
        return scroll;
    }

    public void setScroll(boolean scroll) {//通过开关控制是否可以滑动
        this.scroll = scroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {

        //如果滑动不做处理不滑动返回false，不消费给父控件去处理
        if (scroll)
            return super.onTouchEvent(arg0);
        else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (scroll)
            return super.onInterceptTouchEvent(arg0);
        else {
            return false;
        }
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }


}
