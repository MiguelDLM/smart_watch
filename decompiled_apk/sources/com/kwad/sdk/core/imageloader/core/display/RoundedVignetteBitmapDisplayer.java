package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;

/* loaded from: classes11.dex */
public class RoundedVignetteBitmapDisplayer extends RoundedBitmapDisplayer {

    /* loaded from: classes11.dex */
    public static class RoundedVignetteDrawable extends RoundedBitmapDisplayer.RoundedDrawable {
        public RoundedVignetteDrawable(Bitmap bitmap, int i, int i2) {
            super(bitmap, i, i2);
        }

        @Override // com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer.RoundedDrawable, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.mRect.centerX(), (this.mRect.centerY() * 1.0f) / 0.7f, 1.3f * this.mRect.centerX(), new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.paint.setShader(new ComposeShader(this.bitmapShader, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public RoundedVignetteBitmapDisplayer(int i, int i2) {
        super(i, i2);
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.RoundedBitmapDisplayer, com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new RoundedVignetteDrawable(decodedResult.mBitmap, this.cornerRadius, this.margin));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
