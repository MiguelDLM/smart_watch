package com.tenmeter.smlibrary.widget.viewpagerlayout;

import android.content.Context;
import android.view.View;

/* loaded from: classes13.dex */
public class CircleLayoutManager extends ViewPagerLayoutManager {
    public static final int BOTTOM = 13;
    public static final int CENTER_ON_TOP = 6;
    public static final int LEFT = 10;
    public static final int LEFT_ON_TOP = 4;
    public static final int RIGHT = 11;
    public static final int RIGHT_ON_TOP = 5;
    public static final int TOP = 12;
    private int angleInterval;
    private boolean flipRotate;
    private int gravity;
    private float maxRemoveAngle;
    private float minRemoveAngle;
    private float moveSpeed;
    private int radius;
    private int zAlignment;

    /* loaded from: classes13.dex */
    public static class Builder {
        private static float DISTANCE_RATIO = 10.0f;
        private static int INTERVAL_ANGLE = 30;
        private static int INVALID_VALUE = Integer.MIN_VALUE;
        private static int MAX_REMOVE_ANGLE = 90;
        private static int MIN_REMOVE_ANGLE = -90;
        private Context context;
        private int radius = INVALID_VALUE;
        private int angleInterval = INTERVAL_ANGLE;
        private float moveSpeed = 1.0f / DISTANCE_RATIO;
        private float maxRemoveAngle = MAX_REMOVE_ANGLE;
        private float minRemoveAngle = MIN_REMOVE_ANGLE;
        private boolean reverseLayout = false;
        private boolean flipRotate = false;
        private int gravity = 13;
        private int zAlignment = 4;
        private int maxVisibleItemCount = -1;
        private int distanceToBottom = Integer.MAX_VALUE;

        public Builder(Context context) {
            this.context = context;
        }

        public CircleLayoutManager build() {
            return new CircleLayoutManager(this);
        }

        public Builder setAngleInterval(int i) {
            this.angleInterval = i;
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

        public Builder setGravity(int i) {
            CircleLayoutManager.assertGravity(i);
            this.gravity = i;
            return this;
        }

        public Builder setMaxRemoveAngle(float f) {
            this.maxRemoveAngle = f;
            return this;
        }

        public Builder setMaxVisibleItemCount(int i) {
            this.maxVisibleItemCount = i;
            return this;
        }

        public Builder setMinRemoveAngle(float f) {
            this.minRemoveAngle = f;
            return this;
        }

        public Builder setMoveSpeed(int i) {
            this.moveSpeed = i;
            return this;
        }

        public Builder setRadius(int i) {
            this.radius = i;
            return this;
        }

        public Builder setReverseLayout(boolean z) {
            this.reverseLayout = z;
            return this;
        }

        public Builder setZAlignment(int i) {
            CircleLayoutManager.assertZAlignmentState(i);
            this.zAlignment = i;
            return this;
        }
    }

    public CircleLayoutManager(Context context) {
        this(new Builder(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertGravity(int i) {
        if (i != 10 && i != 11 && i != 12 && i != 13) {
            throw new IllegalArgumentException("gravity must be one of LEFT RIGHT TOP and BOTTOM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertZAlignmentState(int i) {
        if (i != 4 && i != 5 && i != 6) {
            throw new IllegalArgumentException("zAlignment must be one of LEFT_ON_TOP RIGHT_ON_TOP and CENTER_ON_TOP");
        }
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public int calItemLeft(View view, float f) {
        double sin;
        int i = this.gravity;
        if (i != 10) {
            if (i != 11) {
                sin = this.radius * Math.cos(Math.toRadians(90.0f - f));
            } else {
                int i2 = this.radius;
                sin = i2 - (i2 * Math.sin(Math.toRadians(90.0f - f)));
            }
        } else {
            sin = (this.radius * Math.sin(Math.toRadians(90.0f - f))) - this.radius;
        }
        return (int) sin;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public int calItemTop(View view, float f) {
        double cos;
        switch (this.gravity) {
            case 10:
            case 11:
                cos = this.radius * Math.cos(Math.toRadians(90.0f - f));
                break;
            case 12:
                cos = (this.radius * Math.sin(Math.toRadians(90.0f - f))) - this.radius;
                break;
            default:
                int i = this.radius;
                cos = i - (i * Math.sin(Math.toRadians(90.0f - f)));
                break;
        }
        return (int) cos;
    }

    public int getAngleInterval() {
        return this.angleInterval;
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

    public int getGravity() {
        return this.gravity;
    }

    public float getMaxRemoveAngle() {
        return this.maxRemoveAngle;
    }

    public float getMinRemoveAngle() {
        return this.minRemoveAngle;
    }

    public float getMoveSpeed() {
        return this.moveSpeed;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getZAlignment() {
        return this.zAlignment;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float maxRemoveOffset() {
        return this.maxRemoveAngle;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float minRemoveOffset() {
        return this.minRemoveAngle;
    }

    public void setAngleInterval(int i) {
        assertNotInLayoutOrScroll(null);
        if (this.angleInterval == i) {
            return;
        }
        this.angleInterval = i;
        removeAllViews();
    }

    public void setFlipRotate(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.flipRotate == z) {
            return;
        }
        this.flipRotate = z;
        requestLayout();
    }

    public void setGravity(int i) {
        assertNotInLayoutOrScroll(null);
        assertGravity(i);
        if (this.gravity == i) {
            return;
        }
        this.gravity = i;
        if (i != 10 && i != 11) {
            setOrientation(0);
        } else {
            setOrientation(1);
        }
        requestLayout();
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setInterval() {
        return this.angleInterval;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public void setItemViewProperty(View view, float f) {
        int i = this.gravity;
        if (i != 11 && i != 12) {
            if (this.flipRotate) {
                view.setRotation(360.0f - f);
                return;
            } else {
                view.setRotation(f);
                return;
            }
        }
        if (this.flipRotate) {
            view.setRotation(f);
        } else {
            view.setRotation(360.0f - f);
        }
    }

    public void setMaxRemoveAngle(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.maxRemoveAngle == f) {
            return;
        }
        this.maxRemoveAngle = f;
        requestLayout();
    }

    public void setMinRemoveAngle(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.minRemoveAngle == f) {
            return;
        }
        this.minRemoveAngle = f;
        requestLayout();
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.moveSpeed == f) {
            return;
        }
        this.moveSpeed = f;
    }

    public void setRadius(int i) {
        assertNotInLayoutOrScroll(null);
        if (this.radius == i) {
            return;
        }
        this.radius = i;
        removeAllViews();
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public void setUp() {
        int i;
        if (this.radius == Builder.INVALID_VALUE) {
            i = this.mDecoratedMeasurementInOther;
        } else {
            i = this.radius;
        }
        this.radius = i;
    }

    @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager
    public float setViewElevation(View view, float f) {
        int i = this.zAlignment;
        if (i == 4) {
            return (540.0f - f) / 72.0f;
        }
        if (i == 5) {
            return (f - 540.0f) / 72.0f;
        }
        return (360.0f - Math.abs(f)) / 72.0f;
    }

    public void setZAlignment(int i) {
        assertNotInLayoutOrScroll(null);
        assertZAlignmentState(i);
        if (this.zAlignment == i) {
            return;
        }
        this.zAlignment = i;
        requestLayout();
    }

    public CircleLayoutManager(Context context, boolean z) {
        this(new Builder(context).setReverseLayout(z));
    }

    public CircleLayoutManager(Context context, int i, boolean z) {
        this(new Builder(context).setGravity(i).setReverseLayout(z));
    }

    public CircleLayoutManager(Builder builder) {
        this(builder.context, builder.radius, builder.angleInterval, builder.moveSpeed, builder.maxRemoveAngle, builder.minRemoveAngle, builder.gravity, builder.zAlignment, builder.flipRotate, builder.maxVisibleItemCount, builder.distanceToBottom, builder.reverseLayout);
    }

    private CircleLayoutManager(Context context, int i, int i2, float f, float f2, float f3, int i3, int i4, boolean z, int i5, int i6, boolean z2) {
        super(context, (i3 == 10 || i3 == 11) ? 1 : 0, z2);
        setEnableBringCenterToFront(true);
        setMaxVisibleItemCount(i5);
        setDistanceToBottom(i6);
        this.radius = i;
        this.angleInterval = i2;
        this.moveSpeed = f;
        this.maxRemoveAngle = f2;
        this.minRemoveAngle = f3;
        this.gravity = i3;
        this.flipRotate = z;
        this.zAlignment = i4;
    }
}
