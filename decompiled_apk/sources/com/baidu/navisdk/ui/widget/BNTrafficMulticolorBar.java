package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.baidu.navisdk.k;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class BNTrafficMulticolorBar extends View {
    private static final String TAG = "BNTrafficMulticolorBar";
    DecimalFormat dec;
    private Paint mBGPaint;
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private List<m> mRoadConditionItems;
    private Paint paint;
    private int totalLength;

    public BNTrafficMulticolorBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dec = new DecimalFormat("0.00");
        this.mRoadConditionItems = new ArrayList();
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        initPaint();
    }

    private void initPaint() {
        if (this.paint == null) {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
        }
        if (this.mBGPaint == null) {
            Paint paint2 = new Paint();
            this.mBGPaint = paint2;
            paint2.setAntiAlias(true);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int i = height / 2;
        if (height > 0 && width > 0) {
            Bitmap bitmap = this.mCacheBitmap;
            if (bitmap == null || this.mCacheCanvas == null) {
                if (k.f6861a && bitmap != null && !bitmap.isRecycled()) {
                    this.mCacheBitmap.recycle();
                }
                this.mCacheBitmap = null;
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                this.mCacheBitmap = createBitmap;
                createBitmap.eraseColor(0);
                this.mCacheCanvas = new Canvas(this.mCacheBitmap);
            }
            if (this.mCacheBitmap == null) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "onDraw --> mCacheBitmap= " + this.mCacheBitmap);
                    return;
                }
                return;
            }
            canvas.drawARGB(0, 0, 0, 0);
            canvas.saveLayer(0.0f, 0.0f, width, height, this.mBGPaint, 31);
            List<m> list = this.mRoadConditionItems;
            if (list != null && !list.isEmpty()) {
                int size = this.mRoadConditionItems.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    m mVar = this.mRoadConditionItems.get(i4);
                    try {
                        int parseDouble = (int) (width * Double.parseDouble(this.dec.format((mVar.c - i2) / this.totalLength)));
                        this.paint.setColor(mVar.a());
                        int i5 = parseDouble + i3;
                        this.mCacheCanvas.drawRect(new Rect(i3, 0, i5, height), this.paint);
                        i3 = i5;
                        i2 = mVar.c;
                    } catch (Exception unused) {
                    }
                }
            }
            try {
                Rect rect = new Rect(0, 0, width, height);
                float f = i;
                canvas.drawRoundRect(new RectF(rect), f, f, this.mBGPaint);
                this.mBGPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(this.mCacheBitmap, rect, rect, this.mBGPaint);
                this.mBGPaint.setXfermode(null);
                canvas.restore();
                return;
            } catch (Exception e) {
                g gVar = g.ROUTE_GUIDE;
                if (gVar.c()) {
                    gVar.a("BNTrafficMulticolorBar_onDraw", e);
                    return;
                }
                return;
            }
        }
        g gVar2 = g.COMMON_UI;
        if (gVar2.c()) {
            gVar2.c(TAG, "onDraw height: " + height + ";rootViewWidth:" + width);
        }
    }

    public void recycle() {
        if (LogUtil.LOGGABLE) {
            Log.e(TAG, "recycle ->");
        }
        Bitmap bitmap = this.mCacheBitmap;
        if (bitmap != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                bitmap.recycle();
            }
            this.mCacheBitmap = null;
        }
        this.mCacheCanvas = null;
    }

    public void setMulticolorData(List<m> list) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder("data:");
            if (list != null) {
                if (list.size() <= 0) {
                    gVar.e(TAG, "updateData data is empty");
                } else {
                    for (m mVar : list) {
                        sb.append("\n\t----");
                        sb.append(mVar.toString());
                    }
                    g.COMMON.e(TAG, "updateData->" + sb.toString());
                }
            } else {
                gVar.e(TAG, "updateData data is null");
            }
        }
        if (list != null && list.size() != 0) {
            List<m> list2 = this.mRoadConditionItems;
            if (list2 != null) {
                list2.clear();
            } else {
                this.mRoadConditionItems = new ArrayList();
            }
            this.mRoadConditionItems.addAll(list);
            this.totalLength = this.mRoadConditionItems.get(r6.size() - 1).c;
            invalidate();
        }
    }

    public BNTrafficMulticolorBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dec = new DecimalFormat("0.00");
        this.mRoadConditionItems = new ArrayList();
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        initPaint();
    }

    public BNTrafficMulticolorBar(Context context) {
        super(context);
        this.dec = new DecimalFormat("0.00");
        this.mRoadConditionItems = new ArrayList();
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        initPaint();
    }
}
