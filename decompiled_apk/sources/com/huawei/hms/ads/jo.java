package com.huawei.hms.ads;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.d;

/* loaded from: classes10.dex */
public class jo {
    public static int Code(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static boolean V(View view, MotionEvent motionEvent) {
        int[] Code;
        if (view == null || motionEvent == null) {
            return true;
        }
        if ((view instanceof ImageView) && (Code = Code(view)) != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int width = view.getWidth();
            int height = view.getHeight();
            int i = Code[0];
            int i2 = Code[1];
            float abs = Math.abs((width / 2) - x) - (i / 2);
            float abs2 = Math.abs((height / 2) - y) - (i2 / 2);
            if (abs > 0.0f || abs2 > 0.0f) {
                return true;
            }
        }
        return false;
    }

    public static MaterialClickInfo Code(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return new MaterialClickInfo();
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        sb.append(width);
        sb.append("*");
        sb.append(height);
        return new MaterialClickInfo.a().Code(Integer.valueOf((int) x)).V(Integer.valueOf((int) y)).V(sb.toString()).V(Long.valueOf(System.currentTimeMillis())).Code();
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

    private static int[] Code(View view) {
        if (!(view instanceof ImageView)) {
            return null;
        }
        ImageView imageView = (ImageView) view;
        if (imageView.getDrawable() == null) {
            return null;
        }
        int width = imageView.getDrawable().getBounds().width();
        int height = imageView.getDrawable().getBounds().height();
        float[] fArr = new float[10];
        imageView.getImageMatrix().getValues(fArr);
        return new int[]{(int) (width * fArr[0]), (int) (height * fArr[4])};
    }
}
