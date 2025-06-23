package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;

/* loaded from: classes10.dex */
public class a {
    public static final int B = 0;
    private static final String C = "PPSDialogUtil";
    public static final float Code = 16.0f;
    public static final int I = 16;
    public static final float V = 6.0f;
    protected static final int Z = 36;

    public static void Code(Context context, int i, ImageView imageView, PPSBaseDialogContentView pPSBaseDialogContentView, int i2) {
        Code(context, i, imageView, pPSBaseDialogContentView, i2, 0);
    }

    public static void Code(Context context, int i, ImageView imageView, PPSBaseDialogContentView pPSBaseDialogContentView, int i2, int i3) {
        int V2;
        int V3;
        fb.V(C, "getRealOrientation orientation %s", Integer.valueOf(i));
        if (context == null || pPSBaseDialogContentView == null || imageView == null) {
            fb.I(C, "param is invalid, return");
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pPSBaseDialogContentView.getLayoutParams();
        int abs = Math.abs((int) imageView.getX());
        int V4 = w.V(context, 36.0f);
        int i4 = (V4 >> 1) + abs;
        double d = V4 * 0.5d;
        int viewWidthPercent = (int) ((i2 * (1.0f - pPSBaseDialogContentView.getViewWidthPercent()) * 0.5d) + w.V(context, 16.0f) + d);
        int viewWidthPercent2 = (int) (((i2 * ((pPSBaseDialogContentView.getViewWidthPercent() * 0.5d) + 0.5d)) - w.V(context, 16.0f)) - d);
        fb.Code(C, "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        fb.Code(C, "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V4), Integer.valueOf(i4));
        if (1 != i && 9 != i) {
            layoutParams.removeRule(14);
            pPSBaseDialogContentView.setLayoutParams(layoutParams);
            if (i4 < i2 / 3) {
                V3 = w.V(context, 16.0f);
                V2 = abs - V3;
                pPSBaseDialogContentView.setPaddingStart(V2 - w.V(context, i3));
            } else {
                V2 = i4 < (i2 * 2) / 3 ? i4 - (pPSBaseDialogContentView.getViewWith() >> 1) : ((abs + V4) + w.V(context, 16.0f)) - pPSBaseDialogContentView.getViewWith();
                pPSBaseDialogContentView.setPaddingStart(V2 - w.V(context, i3));
            }
        }
        if (i4 < viewWidthPercent) {
            fb.Code(C, "curImgCenter < locationX");
            layoutParams.removeRule(14);
            pPSBaseDialogContentView.setLayoutParams(layoutParams);
            V3 = w.V(context, 16.0f);
            V2 = abs - V3;
            pPSBaseDialogContentView.setPaddingStart(V2 - w.V(context, i3));
        }
        if (i4 <= viewWidthPercent2) {
            fb.Code(C, "locationX =< curImgCenter =< locationX2");
            layoutParams.addRule(14);
            pPSBaseDialogContentView.setLayoutParams(layoutParams);
        } else {
            fb.Code(C, "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            pPSBaseDialogContentView.setLayoutParams(layoutParams);
            V2 = ((abs + V4) + w.V(context, 16.0f)) - pPSBaseDialogContentView.getViewWith();
            fb.Code(C, "paddingStart: %s", Integer.valueOf(V2));
            pPSBaseDialogContentView.setPaddingStart(V2 - w.V(context, i3));
        }
    }
}
