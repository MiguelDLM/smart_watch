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

public class TanxDrawable extends Drawable implements NotConfused {
    private final Bitmap bm;
    private final tanxc_do config;
    private final Rect distRect = new Rect();
    private final Paint paint = new Paint(1);
    private final Rect srcRect = new Rect();

    public TanxDrawable(Bitmap bitmap, tanxc_do tanxc_do) {
        this.bm = transform(bitmap, tanxc_do);
        this.config = tanxc_do;
    }

    private Bitmap transform(Bitmap bitmap, tanxc_do tanxc_do) {
        if (tanxc_do == null || tanxc_do.tanxc_if() != ShapeMode.RECT_ROUND || tanxc_do.tanxc_for() <= 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), (float) tanxc_do.tanxc_for(), (float) tanxc_do.tanxc_for(), paint2);
        return createBitmap;
    }

    public void draw(@NonNull Canvas canvas) {
        ScaleMode scaleMode;
        float f;
        float f2;
        Rect bounds = getBounds();
        Bitmap bitmap = this.bm;
        if (bitmap != null && bitmap.getHeight() != 0 && this.bm.getWidth() != 0 && bounds != null && bounds.width() > 0 && bounds.height() > 0) {
            tanxc_do tanxc_do = this.config;
            if (tanxc_do == null) {
                scaleMode = ScaleMode.CENTER_CROP;
            } else {
                scaleMode = tanxc_do.tanxc_do();
            }
            if (scaleMode == ScaleMode.FIT_XY) {
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
                float f3 = 0.0f;
                if (scaleMode == ScaleMode.CENTER_CROP) {
                    if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                        f2 = (((float) this.bm.getHeight()) - (((float) bounds.height()) * (((float) this.bm.getWidth()) / ((float) bounds.width())))) * 0.5f;
                    } else {
                        f3 = (((float) this.bm.getWidth()) - (((float) bounds.width()) * (((float) this.bm.getHeight()) / ((float) bounds.height())))) * 0.5f;
                        f2 = 0.0f;
                    }
                    Rect rect3 = this.srcRect;
                    rect3.left = (int) f3;
                    rect3.right = (int) (((float) this.bm.getWidth()) - f3);
                    Rect rect4 = this.srcRect;
                    rect4.top = (int) f2;
                    rect4.bottom = (int) (((float) this.bm.getHeight()) - f2);
                    Rect rect5 = this.distRect;
                    rect5.left = 0;
                    rect5.top = 0;
                    rect5.right = getBounds().right;
                    this.distRect.bottom = getBounds().bottom;
                } else {
                    if (this.bm.getWidth() * bounds.height() < bounds.width() * this.bm.getHeight()) {
                        f3 = (((float) bounds.width()) - (((float) this.bm.getWidth()) * (((float) bounds.height()) / ((float) this.bm.getHeight())))) * 0.5f;
                        f = 0.0f;
                    } else {
                        f = (((float) bounds.height()) - (((float) this.bm.getHeight()) * (((float) bounds.width()) / ((float) this.bm.getWidth())))) * 0.5f;
                    }
                    Rect rect6 = this.srcRect;
                    rect6.left = 0;
                    rect6.top = 0;
                    rect6.right = this.bm.getWidth();
                    this.srcRect.bottom = this.bm.getHeight();
                    Rect rect7 = this.distRect;
                    rect7.left = (int) f3;
                    rect7.top = (int) f;
                    int width = bounds.width();
                    Rect rect8 = this.distRect;
                    rect7.right = width - rect8.left;
                    rect8.bottom = bounds.height() - this.distRect.top;
                }
            }
            canvas.drawBitmap(this.bm, this.srcRect, this.distRect, this.paint);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
