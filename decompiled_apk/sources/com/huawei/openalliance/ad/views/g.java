package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.huawei.openalliance.ad.utils.bc;

/* loaded from: classes10.dex */
public abstract class g extends ClipDrawable {
    private Bitmap B;
    private Bitmap C;
    private boolean D;
    private PorterDuffXfermode F;
    private Drawable I;
    private Canvas S;
    private Paint Z;

    public g(Drawable drawable, int i, int i2) {
        super(drawable, i, i2);
        Code(drawable);
    }

    private void Code() {
        if (this.B != null) {
            return;
        }
        V();
    }

    private void I() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.C;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.C = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        this.S = new Canvas(this.C);
    }

    private void V() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.B = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        this.I.setBounds(bounds);
        int level = this.I.getLevel();
        this.I.setLevel(10000);
        this.I.draw(canvas);
        this.I.setLevel(level);
    }

    private void Z() {
        Canvas canvas;
        I();
        Path V = V(getLevel());
        if (V == null || (canvas = this.S) == null) {
            Log.e("HwEclipseClipDrawable", "getClipPath fail.");
        } else {
            canvas.drawPath(V, this.Z);
        }
    }

    public abstract Path V(int i);

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        Code();
        Z();
        if (this.B == null || this.C == null) {
            return;
        }
        Rect bounds = getBounds();
        if (this.D) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, bounds.width(), bounds.height(), null);
        canvas.drawBitmap(this.C, 0.0f, 0.0f, this.Z);
        this.Z.setXfermode(this.F);
        canvas.drawBitmap(this.B, 0.0f, 0.0f, this.Z);
        this.Z.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.I.setBounds(i, i2, i3, i4);
        if (this.B != null) {
            V();
        }
        if (this.C != null) {
            I();
            Path V = V(getLevel());
            if (V != null) {
                this.S.drawPath(V, this.Z);
            } else {
                Log.e("HwEclipseClipDrawable", "getClipPath fail.");
            }
        }
    }

    public void Code(PorterDuff.Mode mode) {
        this.F = new PorterDuffXfermode(mode);
    }

    private void Code(Drawable drawable) {
        Paint paint = new Paint();
        this.Z = paint;
        paint.setAntiAlias(true);
        this.Z.setColor(-16711936);
        this.I = drawable;
        Code(PorterDuff.Mode.SRC_IN);
        this.D = bc.C();
    }
}
