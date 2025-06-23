package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.view.View;

/* loaded from: classes13.dex */
public class ScaleLayoutManager extends ViewPagerLayoutManager {
    private int itemSpace;
    private float maxAlpha;
    private float minAlpha;
    private float minScale;
    private float moveSpeed;

    /* loaded from: classes13.dex */
    public static class Builder {
        private static final float DEFAULT_SPEED = 1.0f;
        private static float MAX_ALPHA = 1.0f;
        private static float MIN_ALPHA = 1.0f;
        private static final float SCALE_RATE = 0.8f;
        private Context context;
        private int itemSpace;
        private int orientation = 0;
        private float minScale = 0.8f;
        private float moveSpeed = 1.0f;
        private float maxAlpha = MAX_ALPHA;
        private float minAlpha = MIN_ALPHA;
        private boolean reverseLayout = false;
        private int distanceToBottom = Integer.MAX_VALUE;
        private int maxVisibleItemCount = -1;

        public Builder(Context context, int i) {
            this.itemSpace = i;
            this.context = context;
        }

        public ScaleLayoutManager build() {
            return new ScaleLayoutManager(this);
        }

        public Builder setDistanceToBottom(int i) {
            this.distanceToBottom = i;
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

    public ScaleLayoutManager(Context context, int i) {
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

    private float calculateScale(float f) {
        float abs = Math.abs(f - this.mSpaceMain);
        int i = this.mDecoratedMeasurement;
        if (abs - i > 0.0f) {
            abs = i;
        }
        return 1.0f - ((abs / i) * (1.0f - this.minScale));
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

    public float getMaxAlpha() {
        return this.maxAlpha;
    }

    public float getMinAlpha() {
        return this.minAlpha;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public float getMoveSpeed() {
        return this.moveSpeed;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setInterval() {
        return this.itemSpace + this.mDecoratedMeasurement;
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
        float calculateScale = calculateScale(this.mSpaceMain + f);
        view.setScaleX(calculateScale);
        view.setScaleY(calculateScale);
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

    public void setMinScale(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.minScale == f) {
            return;
        }
        this.minScale = f;
        removeAllViews();
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.moveSpeed == f) {
            return;
        }
        this.moveSpeed = f;
    }

    public ScaleLayoutManager(Context context, int i, int i2) {
        this(new Builder(context, i).setOrientation(i2));
    }

    public ScaleLayoutManager(Context context, int i, int i2, boolean z) {
        this(new Builder(context, i).setOrientation(i2).setReverseLayout(z));
    }

    public ScaleLayoutManager(Builder builder) {
        this(builder.context, builder.itemSpace, builder.minScale, builder.maxAlpha, builder.minAlpha, builder.orientation, builder.moveSpeed, builder.maxVisibleItemCount, builder.distanceToBottom, builder.reverseLayout);
    }

    private ScaleLayoutManager(Context context, int i, float f, float f2, float f3, int i2, float f4, int i3, int i4, boolean z) {
        super(context, i2, z);
        setDistanceToBottom(i4);
        setMaxVisibleItemCount(i3);
        this.itemSpace = i;
        this.minScale = f;
        this.moveSpeed = f4;
        this.maxAlpha = f2;
        this.minAlpha = f3;
    }
}
