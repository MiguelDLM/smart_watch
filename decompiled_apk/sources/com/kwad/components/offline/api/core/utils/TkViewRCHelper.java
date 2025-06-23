package com.kwad.components.offline.api.core.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.h;

/* loaded from: classes11.dex */
public class TkViewRCHelper {
    private boolean mClipBackground;

    @NonNull
    private h.a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    /* loaded from: classes11.dex */
    public static class CornerConf {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public boolean isLeftTop() {
            return this.leftTop;
        }

        public boolean isRightBottom() {
            return this.rightBottom;
        }

        public boolean isTopRight() {
            return this.topRight;
        }

        public void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }

        public CornerConf setBottomLeft(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public CornerConf setLeftTop(boolean z) {
            this.leftTop = z;
            return this;
        }

        public CornerConf setRightBottom(boolean z) {
            this.rightBottom = z;
            return this;
        }

        public CornerConf setTopRight(boolean z) {
            this.topRight = z;
            return this;
        }
    }

    public TkViewRCHelper() {
        this.radiusArray = new float[8];
        this.mCornerConf = new h.a();
    }

    private Path getPath() {
        float[] radius;
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        if (this.mRadius == 0.0f) {
            radius = this.radiusArray;
        } else {
            radius = getRadius();
        }
        this.mPath.addRoundRect(this.mRectF, radius, Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float[] fArr = this.radiusArray;
        float f8 = 0.0f;
        if (this.mCornerConf.isLeftTop()) {
            f = this.mRadius;
        } else {
            f = 0.0f;
        }
        fArr[0] = f;
        float[] fArr2 = this.radiusArray;
        if (this.mCornerConf.isLeftTop()) {
            f2 = this.mRadius;
        } else {
            f2 = 0.0f;
        }
        fArr2[1] = f2;
        float[] fArr3 = this.radiusArray;
        if (this.mCornerConf.isTopRight()) {
            f3 = this.mRadius;
        } else {
            f3 = 0.0f;
        }
        fArr3[2] = f3;
        float[] fArr4 = this.radiusArray;
        if (this.mCornerConf.isTopRight()) {
            f4 = this.mRadius;
        } else {
            f4 = 0.0f;
        }
        fArr4[3] = f4;
        float[] fArr5 = this.radiusArray;
        if (this.mCornerConf.isRightBottom()) {
            f5 = this.mRadius;
        } else {
            f5 = 0.0f;
        }
        fArr5[4] = f5;
        float[] fArr6 = this.radiusArray;
        if (this.mCornerConf.isRightBottom()) {
            f6 = this.mRadius;
        } else {
            f6 = 0.0f;
        }
        fArr6[5] = f6;
        float[] fArr7 = this.radiusArray;
        if (this.mCornerConf.isBottomLeft()) {
            f7 = this.mRadius;
        } else {
            f7 = 0.0f;
        }
        fArr7[6] = f7;
        float[] fArr8 = this.radiusArray;
        if (this.mCornerConf.isBottomLeft()) {
            f8 = this.mRadius;
        }
        fArr8[7] = f8;
        return this.radiusArray;
    }

    public void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public void afterDraw(Canvas canvas) {
        if (!this.mClipBackground) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            canvas.save();
            canvas.clipPath(getPath());
        } else {
            canvas.saveLayer(this.mRectF, null, 31);
        }
    }

    public void beforeDraw(Canvas canvas) {
        if (!this.mClipBackground) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
        } else {
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    @NonNull
    public h.a getCornerConf() {
        return this.mCornerConf;
    }

    public void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void onSizeChanged(int i, int i2) {
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    public void setRadius(float f) {
        this.mRadius = f;
    }

    public void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }

    public TkViewRCHelper(h.a aVar) {
        this.radiusArray = new float[8];
        if (aVar == null) {
            this.mCornerConf = new h.a();
        } else {
            this.mCornerConf = aVar;
        }
    }
}
