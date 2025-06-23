package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.view.View;

/* loaded from: classes13.dex */
public class RotateLayoutManager extends ViewPagerLayoutManager {
    private float angle;
    private int itemSpace;
    private float moveSpeed;
    private boolean reverseRotate;

    /* loaded from: classes13.dex */
    public static class Builder {
        private static final float DEFAULT_SPEED = 1.0f;
        private static float INTERVAL_ANGLE = 360.0f;
        private Context context;
        private int itemSpace;
        private int orientation = 0;
        private float angle = INTERVAL_ANGLE;
        private float moveSpeed = 1.0f;
        private boolean reverseRotate = false;
        private boolean reverseLayout = false;
        private int distanceToBottom = Integer.MAX_VALUE;
        private int maxVisibleItemCount = -1;

        public Builder(Context context, int i) {
            this.context = context;
            this.itemSpace = i;
        }

        public RotateLayoutManager build() {
            return new RotateLayoutManager(this);
        }

        public Builder setAngle(float f) {
            this.angle = f;
            return this;
        }

        public Builder setDistanceToBottom(int i) {
            this.distanceToBottom = i;
            return this;
        }

        public Builder setMaxVisibleItemCount(int i) {
            this.maxVisibleItemCount = i;
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

        public Builder setReverseRotate(boolean z) {
            this.reverseRotate = z;
            return this;
        }
    }

    public RotateLayoutManager(Context context, int i) {
        this(new Builder(context, i));
    }

    private float calRotation(float f) {
        float f2;
        if (this.reverseRotate) {
            f2 = this.angle;
        } else {
            f2 = -this.angle;
        }
        return (f2 / this.mInterval) * f;
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

    public int getItemSpace() {
        return this.itemSpace;
    }

    public float getMoveSpeed() {
        return this.moveSpeed;
    }

    public boolean getReverseRotate() {
        return this.reverseRotate;
    }

    public void setAngle(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.angle == f) {
            return;
        }
        this.angle = f;
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
        view.setRotation(calRotation(f));
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.moveSpeed == f) {
            return;
        }
        this.moveSpeed = f;
    }

    public void setReverseRotate(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.reverseRotate == z) {
            return;
        }
        this.reverseRotate = z;
        requestLayout();
    }

    public RotateLayoutManager(Context context, int i, int i2) {
        this(new Builder(context, i).setOrientation(i2));
    }

    public RotateLayoutManager(Context context, int i, int i2, boolean z) {
        this(new Builder(context, i).setOrientation(i2).setReverseLayout(z));
    }

    public RotateLayoutManager(Builder builder) {
        this(builder.context, builder.itemSpace, builder.angle, builder.orientation, builder.moveSpeed, builder.reverseRotate, builder.maxVisibleItemCount, builder.distanceToBottom, builder.reverseLayout);
    }

    private RotateLayoutManager(Context context, int i, float f, int i2, float f2, boolean z, int i3, int i4, boolean z2) {
        super(context, i2, z2);
        setDistanceToBottom(i4);
        setMaxVisibleItemCount(i3);
        this.itemSpace = i;
        this.angle = f;
        this.moveSpeed = f2;
        this.reverseRotate = z;
    }
}
