package com.baidu.mapapi.map;

import android.graphics.Color;

/* loaded from: classes7.dex */
public class MyLocationConfiguration {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5838a;
    public int accuracyCircleFillColor;
    public int accuracyCircleStrokeColor;
    private boolean b;
    private BitmapDescriptor c;
    private float d;
    private BitmapDescriptor e;
    public boolean enableArrow;
    public boolean enableDirection;
    private String f;
    private float g;
    private boolean h;
    public final LocationMode locationMode;
    public int width;

    /* loaded from: classes7.dex */
    public static class Builder {
        private String d;
        public boolean enableArrow;
        public LocationMode locationMode;
        public boolean enableDirection = true;

        /* renamed from: a, reason: collision with root package name */
        private boolean f5839a = false;
        private BitmapDescriptor b = null;
        private BitmapDescriptor c = null;
        private float e = 1.0f;
        private float f = 1.0f;
        private boolean g = true;
        public int accuracyCircleStrokeColor = 4653056;
        public int accuracyCircleFillColor = 4521984;

        public Builder(LocationMode locationMode, boolean z) {
            this.locationMode = locationMode;
            this.enableArrow = z;
        }

        public MyLocationConfiguration build() {
            return new MyLocationConfiguration(this);
        }

        public Builder setAccuracyCircleFillColor(int i) {
            this.accuracyCircleFillColor = a(i);
            return this;
        }

        public Builder setAccuracyCircleStrokeColor(int i) {
            this.accuracyCircleStrokeColor = a(i);
            return this;
        }

        public Builder setAnimation(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setArrow(BitmapDescriptor bitmapDescriptor) {
            this.b = bitmapDescriptor;
            return this;
        }

        public Builder setArrowSize(float f) {
            this.f = f;
            return this;
        }

        public Builder setCustomMarker(BitmapDescriptor bitmapDescriptor) {
            this.c = bitmapDescriptor;
            return this;
        }

        public Builder setGifMarker(String str) {
            this.d = str;
            return this;
        }

        public Builder setMarkerRotation(boolean z) {
            this.f5839a = z;
            return this;
        }

        public Builder setMarkerSize(float f) {
            this.e = f;
            return this;
        }

        private int a(int i) {
            return Color.argb(((-16777216) & i) >> 24, i & 255, (65280 & i) >> 8, (16711680 & i) >> 16);
        }
    }

    /* loaded from: classes7.dex */
    public enum LocationMode {
        NORMAL,
        FOLLOWING,
        COMPASS
    }

    private int a(int i) {
        return Color.argb(((-16777216) & i) >> 24, i & 255, (65280 & i) >> 8, (16711680 & i) >> 16);
    }

    public BitmapDescriptor getArrow() {
        return this.c;
    }

    public float getArrowSize() {
        return this.d;
    }

    public BitmapDescriptor getCustomMarker() {
        return this.e;
    }

    public String getGifMarker() {
        return this.f;
    }

    public float getMarkerSize() {
        return this.g;
    }

    public boolean isEnableCustom() {
        return this.b;
    }

    public boolean isEnableRotation() {
        return this.f5838a;
    }

    public boolean isNeedAnimation() {
        return this.h;
    }

    public void setAnimation(boolean z) {
        this.h = z;
    }

    public void setArrow(BitmapDescriptor bitmapDescriptor) {
        this.c = bitmapDescriptor;
    }

    public void setArrowSize(float f) {
        this.d = f;
    }

    public void setCustomMarker(BitmapDescriptor bitmapDescriptor) {
        this.e = bitmapDescriptor;
    }

    public void setGifMarker(String str) {
        this.f = str;
    }

    public void setMarkerRotation(boolean z) {
        this.f5838a = z;
    }

    public void setMarkerSize(float f) {
        this.g = f;
    }

    private MyLocationConfiguration(Builder builder) {
        this.enableDirection = true;
        this.f5838a = false;
        this.b = true;
        this.d = 1.0f;
        this.g = 1.0f;
        this.h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = builder.locationMode;
        boolean z = builder.enableArrow;
        this.enableArrow = z;
        this.b = true;
        if (z) {
            this.f5838a = builder.f5839a;
            if (builder.b == null) {
                builder.setArrow(BitmapDescriptorFactory.fromAsset("icon_arrow.png"));
            }
            this.c = builder.b;
            this.e = builder.c;
            String str = builder.d;
            this.f = str;
            if (this.e == null && str == null) {
                this.e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
            }
            this.g = builder.e;
            this.d = builder.f;
            this.h = builder.g;
        } else {
            this.f5838a = builder.f5839a;
            this.f = builder.d;
            this.e = builder.c;
            this.g = builder.e;
            if (this.f == null && this.e == null) {
                this.e = BitmapDescriptorFactory.fromAsset("icon_blue.png");
            }
            this.h = builder.g;
        }
        this.accuracyCircleFillColor = builder.accuracyCircleFillColor;
        this.accuracyCircleStrokeColor = builder.accuracyCircleStrokeColor;
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i, int i2) {
        this.enableDirection = true;
        this.f5838a = false;
        this.b = true;
        this.d = 1.0f;
        this.g = 1.0f;
        this.h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.b = false;
        this.enableDirection = z;
        this.e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i);
        this.accuracyCircleStrokeColor = a(i2);
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor, int i, int i2, int i3) {
        this.enableDirection = true;
        this.f5838a = false;
        this.b = true;
        this.d = 1.0f;
        this.g = 1.0f;
        this.h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.enableDirection = z;
        this.e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(i);
        this.accuracyCircleStrokeColor = a(i2);
        this.width = i3;
    }

    public MyLocationConfiguration(LocationMode locationMode, boolean z, BitmapDescriptor bitmapDescriptor) {
        this.enableDirection = true;
        this.f5838a = false;
        this.b = true;
        this.d = 1.0f;
        this.g = 1.0f;
        this.h = true;
        this.accuracyCircleFillColor = 4521984;
        this.accuracyCircleStrokeColor = 4653056;
        this.width = 0;
        this.locationMode = locationMode == null ? LocationMode.NORMAL : locationMode;
        this.b = false;
        this.enableDirection = z;
        this.e = bitmapDescriptor;
        this.accuracyCircleFillColor = a(4521984);
        this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
    }
}
