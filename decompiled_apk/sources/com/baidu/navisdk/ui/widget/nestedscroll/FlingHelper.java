package com.baidu.navisdk.ui.widget.nestedscroll;

import android.content.Context;
import android.view.ViewConfiguration;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Field;

/* loaded from: classes8.dex */
public class FlingHelper {
    private static final float INFLEXION = 0.35f;
    private static final String TAG = "FlingHelper";
    private static float mPhysicalCoeff;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private static float mFlingFriction = ViewConfiguration.getScrollFriction();
    private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));

    public FlingHelper(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
    }

    public static Field getDeclaredField(Object obj, String str) {
        Field field = null;
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            if (cls != null) {
                try {
                    field = cls.getDeclaredField(str);
                } catch (NoSuchFieldException e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(TAG, "FlingHelper getDeclareField: " + str + " NoSuchFieldException! e = " + e);
                    }
                }
            }
            if (field != null) {
                field.setAccessible(true);
            }
            return field;
        }
        return null;
    }

    private double getSplineDeceleration(int i) {
        return Math.log((Math.abs(i) * INFLEXION) / (mFlingFriction * mPhysicalCoeff));
    }

    private double getSplineDecelerationByDistance(double d) {
        return ((DECELERATION_RATE - 1.0d) * Math.log(d / (mFlingFriction * mPhysicalCoeff))) / DECELERATION_RATE;
    }

    private int getSplineFlingDuration(int i) {
        return (int) (Math.exp(getSplineDeceleration(i) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
    }

    public double getSplineFlingDistance(int i) {
        double splineDeceleration = getSplineDeceleration(i);
        double d = DECELERATION_RATE;
        return mFlingFriction * mPhysicalCoeff * Math.exp((d / (d - 1.0d)) * splineDeceleration);
    }

    public int getVelocityByDistance(double d) {
        return Math.abs((int) (((Math.exp(getSplineDecelerationByDistance(d)) * mFlingFriction) * mPhysicalCoeff) / 0.3499999940395355d));
    }
}
