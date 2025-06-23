package com.alimm.tanx.core.image.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class TanxDrawable extends Drawable implements NotConfused {
    private final Bitmap bm;
    private final tanxc_do config;
    private final Paint paint = new Paint(1);
    private final Rect srcRect = new Rect();
    private final Rect distRect = new Rect();

    public TanxDrawable(Bitmap bitmap, tanxc_do tanxc_doVar) {
        this.bm = transform(bitmap, tanxc_doVar);
        this.config = tanxc_doVar;
    }

    private Bitmap transform(Bitmap bitmap, tanxc_do tanxc_doVar) {
        if (tanxc_doVar != null && tanxc_doVar.tanxc_if() == ShapeMode.RECT_ROUND && tanxc_doVar.tanxc_for() > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), tanxc_doVar.tanxc_for(), tanxc_doVar.tanxc_for(), paint);
            return createBitmap;
        }
        return bitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        ScaleMode tanxc_do;
        float height;
        float f;
        Rect bounds = getBounds();
        Bitmap bitmap = this.bm;
        if (bitmap != null && bitmap.getHeight() != 0 && this.bm.getWidth() != 0 && bounds != null && bounds.width() > 0 && bounds.height() > 0) {
            tanxc_do tanxc_doVar = this.config;
            if (tanxc_doVar == null) {
                tanxc_do = ScaleMode.CENTER_CROP;
            } else {
                tanxc_do = tanxc_doVar.tanxc_do();
            }
            if (tanxc_do == ScaleMode.FIT_XY) {
                Rect rect = this.srcRect;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.bm.getWidth();
                this.srcRect.bottom = this.bm.getHeight();
                Rect rect2 = this.distRect;
                rect2.left = 0;
                rect2.top = 0;
                rect2.right = getBounds().width();
                this.distRect.bottom = getBounds().height();
            } else {
                float f2 = 0.0f;
                if (tanxc_do == ScaleMode.CENTER_CROP) {
                    if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                        f = (this.bm.getHeight() - (bounds.height() * (this.bm.getWidth() / bounds.width()))) * 0.5f;
                    } else {
                        f2 = (this.bm.getWidth() - (bounds.width() * (this.bm.getHeight() / bounds.height()))) * 0.5f;
                        f = 0.0f;
                    }
                    Rect rect3 = this.srcRect;
                    rect3.left = (int) f2;
                    rect3.right = (int) (this.bm.getWidth() - f2);
                    Rect rect4 = this.srcRect;
                    rect4.top = (int) f;
                    rect4.bottom = (int) (this.bm.getHeight() - f);
                    Rect rect5 = this.distRect;
                    rect5.left = 0;
                    rect5.top = 0;
                    rect5.right = getBounds().right;
                    this.distRect.bottom = getBounds().bottom;
                } else {
                    if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                        f2 = (bounds.width() - (this.bm.getWidth() * (bounds.height() / this.bm.getHeight()))) * 0.5f;
                        height = 0.0f;
                    } else {
                        height = (bounds.height() - (this.bm.getHeight() * (bounds.width() / this.bm.getWidth()))) * 0.5f;
                    }
                    Rect rect6 = this.srcRect;
                    rect6.left = 0;
                    rect6.top = 0;
                    rect6.right = this.bm.getWidth();
                    this.srcRect.bottom = this.bm.getHeight();
                    Rect rect7 = this.distRect;
                    rect7.left = (int) f2;
                    rect7.top = (int) height;
                    int width = bounds.width();
                    Rect rect8 = this.distRect;
                    rect7.right = width - rect8.left;
                    rect8.bottom = bounds.height() - this.distRect.top;
                }
            }
            canvas.drawBitmap(this.bm, this.srcRect, this.distRect, this.paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
