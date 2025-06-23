package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.view.View;

/* loaded from: classes13.dex */
public class GalleryLayoutManager extends ViewPagerLayoutManager {
    private final float MAX_ELEVATION;
    private float angle;
    private boolean flipRotate;
    private int itemSpace;
    private float maxAlpha;
    private float minAlpha;
    private float moveSpeed;
    private boolean rotateFromEdge;

    /* loaded from: classes13.dex */
    public static class Builder {
        private static final float DEFAULT_SPEED = 1.0f;
        private static float INTERVAL_ANGLE = 30.0f;
        private static float MAX_ALPHA = 1.0f;
        private static float MIN_ALPHA = 0.5f;
        private Context context;
        private int itemSpace;
        private int orientation = 0;
        private float angle = INTERVAL_ANGLE;
        private float maxAlpha = MAX_ALPHA;
        private float minAlpha = MIN_ALPHA;
        private float moveSpeed = 1.0f;
        private boolean reverseLayout = false;
        private boolean flipRotate = false;
        private boolean rotateFromEdge = false;
        private int distanceToBottom = Integer.MAX_VALUE;
        private int maxVisibleItemCount = -1;

        public Builder(Context context, int i) {
            this.itemSpace = i;
            this.context = context;
        }

        public GalleryLayoutManager build() {
            return new GalleryLayoutManager(this);
        }

        public Builder setAngle(float f) {
            this.angle = f;
            return this;
        }

        public Builder setDistanceToBottom(int i) {
            this.distanceToBottom = i;
            return this;
        }

        public Builder setFlipRotate(boolean z) {
            this.flipRotate = z;
            return this;
        }

        public Builder setItemSpace(int i) {
            this.itemSpace = i;
            return this;
        }

        public Builder setMaxAlpha(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            this.maxAlpha = f;
            return this;
        }

        public Builder setMaxVisibleItemCount(int i) {
            this.maxVisibleItemCount = i;
            return this;
        }

        public Builder setMinAlpha(float f) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            this.minAlpha = f;
            return this;
        }

        public Builder setMoveSpeed(float f) {
            this.moveSpeed = f;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setReverseLayout(boolean z) {
            this.reverseLayout = z;
            return this;
        }

        public Builder setRotateFromEdge(boolean z) {
            this.rotateFromEdge = z;
            return this;
        }
    }

    public GalleryLayoutManager(Context context, int i) {
        this(new Builder(context, i));
    }

    private float calAlpha(float f) {
        float abs = Math.abs(f);
        float f2 = this.minAlpha;
        float f3 = this.maxAlpha;
        float f4 = this.mInterval;
        float f5 = (((f2 - f3) / f4) * abs) + f3;
        if (abs < f4) {
            return f5;
        }
        return f2;
    }

    private float calRotation(float f) {
        return ((-this.angle) / this.mInterval) * f;
    }

    public float getAngle() {
        return this.angle;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float getDistanceRatio() {
        float f = this.moveSpeed;
        if (f == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f;
    }

    public boolean getFlipRotate() {
        return this.flipRotate;
    }

    public int getItemSpace() {
        return this.itemSpace;
    }

    public float getMaxAlpha() {
        return this.maxAlpha;
    }

    public float getMinAlpha() {
        return this.minAlpha;
    }

    public float getMoveSpeed() {
        return this.moveSpeed;
    }

    public boolean getRotateFromEdge() {
        return this.rotateFromEdge;
    }

    public void setAngle(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.angle == f) {
            return;
        }
        this.angle = f;
        requestLayout();
    }

    public void setFlipRotate(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.flipRotate == z) {
            return;
        }
        this.flipRotate = z;
        requestLayout();
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setInterval() {
        return this.mDecoratedMeasurement + this.itemSpace;
    }

    public void setItemSpace(int i) {
        assertNotInLayoutOrScroll(null);
        if (this.itemSpace == i) {
            return;
        }
        this.itemSpace = i;
        removeAllViews();
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public void setItemViewProperty(View view, float f) {
        float calRotation = calRotation(f);
        float f2 = 0.0f;
        if (getOrientation() == 0) {
            if (this.rotateFromEdge) {
                if (calRotation <= 0.0f) {
                    f2 = this.mDecoratedMeasurement;
                }
                view.setPivotX(f2);
                view.setPivotY(this.mDecoratedMeasurementInOther * 0.5f);
            }
            if (this.flipRotate) {
                view.setRotationX(calRotation);
            } else {
                view.setRotationY(calRotation);
            }
        } else {
            if (this.rotateFromEdge) {
                if (calRotation <= 0.0f) {
                    f2 = this.mDecoratedMeasurement;
                }
                view.setPivotY(f2);
                view.setPivotX(this.mDecoratedMeasurementInOther * 0.5f);
            }
            if (this.flipRotate) {
                view.setRotationY(-calRotation);
            } else {
                view.setRotationX(-calRotation);
            }
        }
        view.setAlpha(calAlpha(f));
    }

    public void setMaxAlpha(float f) {
        assertNotInLayoutOrScroll(null);
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.maxAlpha == f) {
            return;
        }
        this.maxAlpha = f;
        requestLayout();
    }

    public void setMinAlpha(float f) {
        assertNotInLayoutOrScroll(null);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (this.minAlpha == f) {
            return;
        }
        this.minAlpha = f;
        requestLayout();
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.moveSpeed == f) {
            return;
        }
        this.moveSpeed = f;
    }

    public void setRotateFromEdge(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.rotateFromEdge == z) {
            return;
        }
        this.rotateFromEdge = z;
        removeAllViews();
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setViewElevation(View view, float f) {
        return 5.0f - ((Math.max(Math.abs(view.getRotationX()), Math.abs(view.getRotationY())) * 5.0f) / 360.0f);
    }

    public GalleryLayoutManager(Context context, int i, int i2) {
        this(new Builder(context, i).setOrientation(i2));
    }

    public GalleryLayoutManager(Context context, int i, int i2, boolean z) {
        this(new Builder(context, i).setOrientation(i2).setReverseLayout(z));
    }

    public GalleryLayoutManager(Builder builder) {
        this(builder.context, builder.itemSpace, builder.angle, builder.maxAlpha, builder.minAlpha, builder.orientation, builder.moveSpeed, builder.flipRotate, builder.rotateFromEdge, builder.maxVisibleItemCount, builder.distanceToBottom, builder.reverseLayout);
    }

    private GalleryLayoutManager(Context context, int i, float f, float f2, float f3, int i2, float f4, boolean z, boolean z2, int i3, int i4, boolean z3) {
        super(context, i2, z3);
        this.MAX_ELEVATION = 5.0f;
        setDistanceToBottom(i4);
        setMaxVisibleItemCount(i3);
        this.itemSpace = i;
        this.moveSpeed = f4;
        this.angle = f;
        this.maxAlpha = f2;
        this.minAlpha = f3;
        this.flipRotate = z;
        this.rotateFromEdge = z2;
    }
}
