package com.baidu.navisdk.ui.widget;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.k;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class RoadCondBar extends View {
    private static final String TAG = "RoadCondBar";
    private NinePatchDrawable bgBitmap;
    private Bitmap carPointBitmap;
    private float carPointEdgeWidth;
    private float carPointPlaintEdge;
    private float carPointSize;
    private float colorBarEdgeWidth;
    private float colorBarMarginTop;
    private boolean hasSetData;
    private int height;
    private Paint mBGPaint;
    private Bitmap mCacheBitmap;
    private Canvas mCacheCanvas;
    private double mCurCarProgress;
    private int mItemTotalIndex;
    private int mLastH;
    private int mLastW;
    private Paint[] mPaints;
    private Paint mPassPaint;
    private List<m> mRoadConditionItems;
    private int width;

    public RoadCondBar(Context context) {
        super(context);
        this.colorBarEdgeWidth = 16.0f;
        this.colorBarMarginTop = 13.34f;
        this.carPointSize = 54.6f;
        this.carPointEdgeWidth = 0.0f;
        this.carPointPlaintEdge = 6.0f;
        this.mCurCarProgress = OOXIXo.f3760XO;
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        this.height = 0;
        this.width = 0;
        this.bgBitmap = null;
        this.carPointBitmap = null;
        this.hasSetData = false;
        init(context);
    }

    private float getRoadConditionItemDrawHeight(int i, int i2, int i3) {
        int i4 = this.mItemTotalIndex;
        if (i4 <= 0) {
            return 0.0f;
        }
        return (float) (((((i3 - this.colorBarMarginTop) * 1.0d) * (i2 - i)) * 1.0d) / i4);
    }

    private void init(Context context) {
        initPaints();
        initSize(context);
        this.bgBitmap = (NinePatchDrawable) b.f(R.drawable.nsdk_drawable_roadcondition_fg);
        this.carPointBitmap = b.a(R.drawable.nsdk_drawable_roadcondition_carpoint);
        setBackgroundDrawable(null);
        Log.e(TAG, "graphics.Bitmap 初始化 -> viewHash= " + hashCode() + ",BitmapHash = " + this.carPointBitmap.hashCode());
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.mBGPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mPassPaint = paint2;
        paint2.setColor(-3158065);
        this.mPaints[0] = new Paint();
        this.mPaints[0].setColor(m.b(0));
        this.mPaints[1] = new Paint();
        this.mPaints[1].setColor(m.b(1));
        this.mPaints[2] = new Paint();
        this.mPaints[2].setColor(m.b(2));
        this.mPaints[3] = new Paint();
        this.mPaints[3].setColor(m.b(3));
        this.mPaints[4] = new Paint();
        this.mPaints[4].setColor(m.b(4));
    }

    private void initSize(Context context) {
        this.colorBarEdgeWidth = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
        this.carPointSize = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_27dp);
        this.colorBarMarginTop = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_7dp);
        this.carPointPlaintEdge = context.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp);
    }

    private boolean isDataValid() {
        List<m> list = this.mRoadConditionItems;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public void dispose() {
        if (LogUtil.LOGGABLE) {
            Log.e(TAG, "dispose ->");
        }
        recycle();
        List<m> list = this.mRoadConditionItems;
        if (list != null) {
            list.clear();
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = this.width;
        if (i2 > 0 && (i = this.height) > 0) {
            if (!this.hasSetData) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "onDraw-> hasSetData false");
                    return;
                }
                return;
            }
            Bitmap bitmap = this.mCacheBitmap;
            int i3 = 0;
            if (bitmap == null || this.mCacheCanvas == null || i2 != this.mLastW || i != this.mLastH) {
                if (k.f6861a && bitmap != null && !bitmap.isRecycled()) {
                    this.mCacheBitmap.recycle();
                }
                this.mCacheBitmap = null;
                int i4 = this.width;
                this.mLastW = i4;
                int i5 = this.height;
                this.mLastH = i5;
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_4444);
                this.mCacheBitmap = createBitmap;
                createBitmap.eraseColor(0);
                this.mCacheCanvas = new Canvas(this.mCacheBitmap);
            }
            if (this.mCacheBitmap != null && this.mCacheCanvas != null) {
                float f = this.height - this.carPointSize;
                this.bgBitmap.setBounds(new Rect(0, 0, this.width, (int) ((this.height - this.carPointSize) + this.colorBarMarginTop)));
                this.bgBitmap.draw(canvas);
                canvas.saveLayer(0.0f, 0.0f, this.width, this.height, this.mBGPaint, 31);
                Canvas canvas2 = this.mCacheCanvas;
                float f2 = this.colorBarEdgeWidth;
                canvas2.drawRect(f2, this.colorBarMarginTop, this.width - f2, f, this.mPaints[0]);
                if (isDataValid()) {
                    float f3 = f;
                    int i6 = 0;
                    while (i3 < this.mRoadConditionItems.size()) {
                        m mVar = this.mRoadConditionItems.get(i3);
                        float roadConditionItemDrawHeight = f3 - getRoadConditionItemDrawHeight(i6, mVar.c, (int) (this.height - this.carPointSize));
                        if (this.mRoadConditionItems.size() != 1) {
                            Canvas canvas3 = this.mCacheCanvas;
                            float f4 = this.colorBarEdgeWidth;
                            canvas3.drawRect(f4, roadConditionItemDrawHeight, this.width - f4, f3, this.mPaints[mVar.b]);
                        } else {
                            Canvas canvas4 = this.mCacheCanvas;
                            float f5 = this.colorBarEdgeWidth;
                            canvas4.drawRect(f5, this.colorBarMarginTop, this.width - f5, f3, this.mPaints[mVar.b]);
                        }
                        i3++;
                        f3 = roadConditionItemDrawHeight;
                        i6 = mVar.c;
                    }
                }
                float f6 = this.height - this.carPointSize;
                int i7 = (int) (((f6 - r3) * (1.0d - this.mCurCarProgress)) + this.colorBarMarginTop);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(TAG, "onDraw-> mCurCarProgress=" + this.mCurCarProgress + ", curCarPointH=" + i7);
                }
                Canvas canvas5 = this.mCacheCanvas;
                float f7 = this.colorBarEdgeWidth;
                float f8 = i7;
                canvas5.drawRect(f7, f8, this.width - f7, this.height - this.carPointSize, this.mPassPaint);
                try {
                    float f9 = this.colorBarEdgeWidth;
                    RectF rectF = new RectF(f9, this.colorBarMarginTop, this.width - f9, this.height - this.carPointSize);
                    int i8 = this.width;
                    float f10 = this.colorBarEdgeWidth;
                    canvas.drawRoundRect(rectF, (i8 - (f10 * 2.0f)) / 2.0f, (i8 - (f10 * 2.0f)) / 2.0f, this.mBGPaint);
                    this.mBGPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(this.mCacheBitmap, 0.0f, 0.0f, this.mBGPaint);
                    this.mBGPaint.setXfermode(null);
                    canvas.saveLayer(0.0f, 0.0f, this.width, this.height, this.mBGPaint, 31);
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("RoadCondBar_onDraw", e);
                    }
                }
                try {
                    float f11 = this.carPointEdgeWidth;
                    float f12 = this.carPointPlaintEdge;
                    canvas.drawBitmap(this.carPointBitmap, (Rect) null, new RectF(f11, f8 - f12, this.width - f11, (f8 + this.carPointSize) - f12), this.mBGPaint);
                    canvas.restore();
                    return;
                } catch (Exception e2) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.printException("RoadCondBar_onDraw", e2);
                        return;
                    }
                    return;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "onDraw-> mCacheBitmap= " + this.mCacheBitmap + ", mCacheCanvas= " + this.mCacheCanvas);
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "onDraw-> width= " + this.width + ", height= " + this.height);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        long measuredHeight = getMeasuredHeight();
        long measuredWidth = getMeasuredWidth();
        long j = measuredHeight * measuredWidth * 16;
        if (measuredHeight <= 10000 && measuredWidth <= 10000 && j <= 2147483647L) {
            this.width = (int) measuredWidth;
            this.height = (int) measuredHeight;
            this.carPointEdgeWidth = (int) ((r1 - this.carPointSize) / 2.0f);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "---> BNRoadConditionView: cacheBitmapSize is " + j + ", cacheBitmapSize exceeds 32 bits ");
        }
    }

    public void recycle() {
        Object valueOf;
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
        if (this.bgBitmap != null) {
            this.bgBitmap = null;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("graphics.Bitmap recycle -> viewHash= ");
            sb.append(hashCode());
            sb.append(",BitmapHash = ");
            Bitmap bitmap2 = this.carPointBitmap;
            if (bitmap2 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bitmap2.hashCode());
            }
            sb.append(valueOf);
            Log.e(TAG, sb.toString());
        }
        Bitmap bitmap3 = this.carPointBitmap;
        if (bitmap3 != null) {
            if (k.f6861a && Build.VERSION.SDK_INT < 28) {
                bitmap3.recycle();
            }
            this.carPointBitmap = null;
        }
    }

    public void resetData() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "resetData-> ");
        }
        List<m> list = this.mRoadConditionItems;
        if (list != null) {
            list.clear();
        }
    }

    public void updateData(List<m> list) {
        this.hasSetData = true;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder("data:");
            if (list != null) {
                if (list.size() <= 0) {
                    LogUtil.e(TAG, "updateData data is empty");
                } else {
                    for (m mVar : list) {
                        sb.append("\n\t----");
                        sb.append(mVar.toString());
                    }
                    LogUtil.e(TAG, "updateData->" + sb.toString());
                }
            } else {
                LogUtil.e(TAG, "updateData data is null");
            }
        }
        if (list != null && list.size() != 0) {
            List<m> list2 = this.mRoadConditionItems;
            if (list2 != null) {
                list2.clear();
            }
            this.mRoadConditionItems.addAll(list);
            List<m> list3 = this.mRoadConditionItems;
            this.mItemTotalIndex = list3.get(list3.size() - 1).c;
        }
    }

    public void updateProgress(double d) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "updateProgress-> carProgress=" + d);
        }
        this.mCurCarProgress = d;
        invalidate();
    }

    public RoadCondBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.colorBarEdgeWidth = 16.0f;
        this.colorBarMarginTop = 13.34f;
        this.carPointSize = 54.6f;
        this.carPointEdgeWidth = 0.0f;
        this.carPointPlaintEdge = 6.0f;
        this.mCurCarProgress = OOXIXo.f3760XO;
        this.mRoadConditionItems = new ArrayList();
        this.mItemTotalIndex = 0;
        this.mBGPaint = null;
        this.mPaints = new Paint[5];
        this.mPassPaint = null;
        this.mCacheBitmap = null;
        this.mCacheCanvas = null;
        this.mLastW = 0;
        this.mLastH = 0;
        this.height = 0;
        this.width = 0;
        this.bgBitmap = null;
        this.carPointBitmap = null;
        this.hasSetData = false;
        init(context);
    }
}
