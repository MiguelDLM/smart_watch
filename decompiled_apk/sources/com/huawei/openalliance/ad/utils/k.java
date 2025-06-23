package com.huawei.openalliance.ad.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.views.PPSSplashView;
import com.huawei.openalliance.ad.views.SplashLinkedVideoView;

/* loaded from: classes10.dex */
public class k {
    public static MaterialClickInfo Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return new MaterialClickInfo();
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        if (Code(view)) {
            return V(view, motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        sb.append(width);
        sb.append("*");
        sb.append(height);
        return new MaterialClickInfo.a().Code(Integer.valueOf((int) x)).V(Integer.valueOf((int) y)).V(sb.toString()).V(Long.valueOf(System.currentTimeMillis())).Code();
    }

    private static MaterialClickInfo V(View view, MotionEvent motionEvent) {
        float left = view.getLeft() + motionEvent.getX();
        float top = view.getTop() + motionEvent.getY();
        StringBuilder sb = new StringBuilder();
        ViewParent parent = view.getParent();
        for (int i = 0; i < 5 && parent != null; i++) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                left += viewGroup.getLeft();
                top += viewGroup.getTop();
            }
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                int width = viewGroup2.getWidth();
                int height = viewGroup2.getHeight();
                sb.append(width);
                sb.append("*");
                sb.append(height);
                return new MaterialClickInfo.a().Code(Integer.valueOf((int) left)).V(Integer.valueOf((int) top)).V(sb.toString()).V(Long.valueOf(System.currentTimeMillis())).Code();
            }
            parent = parent.getParent();
        }
        return new MaterialClickInfo();
    }

    public static void Code(View view, MotionEvent motionEvent, Integer num, MaterialClickInfo materialClickInfo) {
        if (materialClickInfo == null || view == null || motionEvent == null) {
            return;
        }
        materialClickInfo.Code(Long.valueOf(System.currentTimeMillis()));
        materialClickInfo.Code(Float.valueOf(d.a(view.getContext())));
        if (num != null) {
            materialClickInfo.V(num);
        }
        if (materialClickInfo.Z() == null) {
            materialClickInfo.V(com.huawei.openalliance.ad.constant.x.dd);
        }
        MaterialClickInfo Code = Code(view, motionEvent);
        if (Code != null) {
            materialClickInfo.I(Code.Code());
            materialClickInfo.Z(Code.V());
        }
    }

    private static boolean Code(View view) {
        ViewParent parent = view.getParent();
        for (int i = 0; i < 5 && parent != null; i++) {
            if ((parent instanceof SplashLinkedVideoView) || (parent instanceof PPSSplashView)) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }
}
