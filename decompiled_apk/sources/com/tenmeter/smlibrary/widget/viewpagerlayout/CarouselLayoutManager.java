package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.view.View;

/* loaded from: classes13.dex */
public class CarouselLayoutManager extends ViewPagerLayoutManager {
    private int itemSpace;
    private float minScale;
    private float moveSpeed;

    /* loaded from: classes13.dex */
    public static class Builder {
        private static final float DEFAULT_SPEED = 1.0f;
        private static final float MIN_SCALE = 0.5f;
        private Context context;
        private int itemSpace;
        private int orientation = 0;
        private float minScale = 0.5f;
        private float moveSpeed = 1.0f;
        private boolean reverseLayout = false;
        private int maxVisibleItemCount = -1;
        private int distanceToBottom = Integer.MAX_VALUE;

        public Builder(Context context, int i) {
            this.itemSpace = i;
            this.context = context;
        }

        public CarouselLayoutManager build() {
            return new CarouselLayoutManager(this);
        }

        public Builder setDistanceToBottom(int i) {
            this.distanceToBottom = i;
            return this;
        }

        public Builder setMaxVisibleItemCount(int i) {
            this.maxVisibleItemCount = i;
            return this;
        }

        public Builder setMinScale(float f) {
            this.minScale = f;
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
    }

    public CarouselLayoutManager(Context context, int i) {
        this(new Builder(context, i));
    }

    private float calculateScale(float f) {
        return (((this.minScale - 1.0f) * Math.abs(f - ((((ViewPagerLayoutManager) this).mOrientationHelper.getTotalSpace() - this.mDecoratedMeasurement) / 2.0f))) / (((ViewPagerLayoutManager) this).mOrientationHelper.getTotalSpace() / 2.0f)) + 1.0f;
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

    public float getMinScale() {
        return this.minScale;
    }

    public float getMoveSpeed() {
        return this.moveSpeed;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setInterval() {
        return this.mDecoratedMeasurement - this.itemSpace;
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
        float calculateScale = calculateScale(f + this.mSpaceMain);
        view.setScaleX(calculateScale);
        view.setScaleY(calculateScale);
    }

    public void setMinScale(float f) {
        assertNotInLayoutOrScroll(null);
        if (f > 1.0f) {
            f = 1.0f;
        }
        if (this.minScale == f) {
            return;
        }
        this.minScale = f;
        requestLayout();
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.moveSpeed == f) {
            return;
        }
        this.moveSpeed = f;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setViewElevation(View view, float f) {
        return view.getScaleX() * 5.0f;
    }

    public CarouselLayoutManager(Context context, int i, int i2) {
        this(new Builder(context, i).setOrientation(i2));
    }

    public CarouselLayoutManager(Context context, int i, int i2, boolean z) {
        this(new Builder(context, i).setOrientation(i2).setReverseLayout(z));
    }

    public CarouselLayoutManager(Builder builder) {
        this(builder.context, builder.itemSpace, builder.minScale, builder.orientation, builder.maxVisibleItemCount, builder.moveSpeed, builder.distanceToBottom, builder.reverseLayout);
    }

    private CarouselLayoutManager(Context context, int i, float f, int i2, int i3, float f2, int i4, boolean z) {
        super(context, i2, z);
        setEnableBringCenterToFront(true);
        setDistanceToBottom(i4);
        setMaxVisibleItemCount(i3);
        this.itemSpace = i;
        this.minScale = f;
        this.moveSpeed = f2;
    }
}
