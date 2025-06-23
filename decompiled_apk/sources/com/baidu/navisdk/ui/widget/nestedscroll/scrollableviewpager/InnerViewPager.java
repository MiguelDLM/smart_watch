package com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class InnerViewPager extends ViewPager {
    public static final Object TAG = new Object();
    private boolean scrollAvailable;
    private Method setCurrentItemInternalMethod;

    public InnerViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    private Method getDeclaredMethod(Object obj) {
        Method method = null;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            if (cls != null) {
                try {
                    Class<?> cls2 = Boolean.TYPE;
                    method = cls.getDeclaredMethod("setCurrentItemInternal", Integer.TYPE, cls2, cls2);
                } catch (NoSuchMethodException e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("InnerViewPager", "InnerViewPager NoSuchFieldException! e = " + e);
                    }
                }
            }
            if (method != null) {
                method.setAccessible(true);
            }
            return method;
        }
        return null;
    }

    private void init() {
        setTag(TAG);
        this.setCurrentItemInternalMethod = getDeclaredMethod(this);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.scrollAvailable && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollAvailable && super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setCurrentItem(int i, boolean z, boolean z2) {
        Method method = this.setCurrentItemInternalMethod;
        if (method != null) {
            try {
                method.invoke(this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (IllegalAccessException e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("InnerViewPager", "InnerViewPager IllegalAccessException! e = " + e);
                }
                setCurrentItem(i);
                return;
            } catch (InvocationTargetException e2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("InnerViewPager", "InnerViewPager InvocationTargetException! e = " + e2);
                }
                setCurrentItem(i);
                return;
            }
        }
        setCurrentItem(i);
    }

    public void setScrollAvailable(boolean z) {
        this.scrollAvailable = z;
    }

    public InnerViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
