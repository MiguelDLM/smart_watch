package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class PPSBaseSwipeView extends PPSBaseStyleView {
    protected ScanningView F;
    protected ImageView S;

    public PPSBaseSwipeView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap Code(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0 || drawingCache == null) {
            fb.V(getViewTag(), "captureWidget NULL");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, 0, measuredWidth, measuredHeight);
        view.destroyDrawingCache();
        return createBitmap;
    }

    public void V() {
        ScanningView scanningView = this.F;
        if (scanningView != null) {
            scanningView.V();
        }
    }

    public String getViewTag() {
        return "PPSSplashSwipeClickView";
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        fb.V(getViewTag(), "w=%s, h=%s, oldw=%s, oldh=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        this.S.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSBaseSwipeView.1
            @Override // java.lang.Runnable
            public void run() {
                fb.V(PPSBaseSwipeView.this.getViewTag(), "POST %s %s", Integer.valueOf(PPSBaseSwipeView.this.S.getHeight()), Integer.valueOf(PPSBaseSwipeView.this.S.getWidth()));
                if (PPSBaseSwipeView.this.F.getSrcBitmap() == null) {
                    PPSBaseSwipeView pPSBaseSwipeView = PPSBaseSwipeView.this;
                    pPSBaseSwipeView.F.setSrcBitmap(pPSBaseSwipeView.Code(pPSBaseSwipeView.S));
                }
                ScanningView scanningView = PPSBaseSwipeView.this.F;
                if (scanningView != null) {
                    scanningView.Code();
                }
            }
        });
    }

    public PPSBaseSwipeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSBaseSwipeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
