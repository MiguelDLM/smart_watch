package com.google.android.material.shape;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

@RequiresApi(22)
/* loaded from: classes9.dex */
class ShapeableDelegateV22 extends ShapeableDelegate {
    private boolean canUseViewOutline = false;
    private float cornerRadius = 0.0f;

    public ShapeableDelegateV22(@NonNull View view) {
        initMaskOutlineProvider(view);
    }

    private float getDefaultCornerRadius() {
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
        if (shapeAppearanceModel != null && (rectF = this.maskBounds) != null) {
            return shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
        }
        return 0.0f;
    }

    @DoNotInline
    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV22.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                ShapeableDelegateV22 shapeableDelegateV22 = ShapeableDelegateV22.this;
                if (shapeableDelegateV22.shapeAppearanceModel != null && !shapeableDelegateV22.maskBounds.isEmpty()) {
                    ShapeableDelegateV22 shapeableDelegateV222 = ShapeableDelegateV22.this;
                    RectF rectF = shapeableDelegateV222.maskBounds;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, shapeableDelegateV222.cornerRadius);
                }
            }
        });
    }

    private boolean isShapeRoundRect() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (!this.maskBounds.isEmpty() && (shapeAppearanceModel = this.shapeAppearanceModel) != null) {
            return shapeAppearanceModel.isRoundRect(this.maskBounds);
        }
        return false;
    }

    private boolean offsetZeroCornerEdgeBoundsIfPossible() {
        ShapeAppearanceModel shapeAppearanceModel;
        if (!this.maskBounds.isEmpty() && (shapeAppearanceModel = this.shapeAppearanceModel) != null && this.offsetZeroCornerEdgeBoundsEnabled && !shapeAppearanceModel.isRoundRect(this.maskBounds) && shapeUsesAllRoundedCornerTreatments(this.shapeAppearanceModel)) {
            float cornerSize = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.maskBounds);
            float cornerSize2 = this.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.maskBounds);
            float cornerSize3 = this.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.maskBounds);
            float cornerSize4 = this.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.maskBounds);
            if (cornerSize == 0.0f && cornerSize3 == 0.0f && cornerSize2 == cornerSize4) {
                RectF rectF = this.maskBounds;
                rectF.set(rectF.left - cornerSize2, rectF.top, rectF.right, rectF.bottom);
                this.cornerRadius = cornerSize2;
                return true;
            }
            if (cornerSize == 0.0f && cornerSize2 == 0.0f && cornerSize3 == cornerSize4) {
                RectF rectF2 = this.maskBounds;
                rectF2.set(rectF2.left, rectF2.top - cornerSize3, rectF2.right, rectF2.bottom);
                this.cornerRadius = cornerSize3;
                return true;
            }
            if (cornerSize2 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize3) {
                RectF rectF3 = this.maskBounds;
                rectF3.set(rectF3.left, rectF3.top, rectF3.right + cornerSize, rectF3.bottom);
                this.cornerRadius = cornerSize;
                return true;
            }
            if (cornerSize3 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize2) {
                RectF rectF4 = this.maskBounds;
                rectF4.set(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom + cornerSize);
                this.cornerRadius = cornerSize;
                return true;
            }
        }
        return false;
    }

    private static boolean shapeUsesAllRoundedCornerTreatments(ShapeAppearanceModel shapeAppearanceModel) {
        if ((shapeAppearanceModel.getTopLeftCorner() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.getTopRightCorner() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.getBottomLeftCorner() instanceof RoundedCornerTreatment) && (shapeAppearanceModel.getBottomRightCorner() instanceof RoundedCornerTreatment)) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public void invalidateClippingMethod(@NonNull View view) {
        boolean z;
        this.cornerRadius = getDefaultCornerRadius();
        if (!isShapeRoundRect() && !offsetZeroCornerEdgeBoundsIfPossible()) {
            z = false;
        } else {
            z = true;
        }
        this.canUseViewOutline = z;
        view.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public boolean shouldUseCompatClipping() {
        if (this.canUseViewOutline && !this.forceCompatClippingEnabled) {
            return false;
        }
        return true;
    }
}
