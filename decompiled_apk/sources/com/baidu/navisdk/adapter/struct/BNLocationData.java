package com.baidu.navisdk.adapter.struct;

/* loaded from: classes7.dex */
public class BNLocationData {
    public final float accuracy;
    public final int altitude;
    public final float bias;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;
    public long time;

    /* loaded from: classes7.dex */
    public static class Builder {
        private float accuracy;
        private int altitude;
        private float bias = -1.0f;
        private float direction;
        private double latitude;
        private double longitude;
        private int satellitesNum;
        private float speed;
        private long time;

        public Builder accuracy(float f) {
            this.accuracy = f;
            return this;
        }

        public Builder altitude(int i) {
            this.altitude = i;
            return this;
        }

        public Builder bias(float f) {
            this.bias = f;
            return this;
        }

        public BNLocationData build() {
            return new BNLocationData(this.latitude, this.longitude, this.speed, this.direction, this.accuracy, this.bias, this.satellitesNum, this.altitude, this.time);
        }

        public Builder direction(float f) {
            this.direction = f;
            return this;
        }

        public Builder latitude(double d) {
            this.latitude = d;
            return this;
        }

        public Builder longitude(double d) {
            this.longitude = d;
            return this;
        }

        public Builder satellitesNum(int i) {
            this.satellitesNum = i;
            return this;
        }

        public Builder speed(float f) {
            this.speed = f;
            return this;
        }

        public Builder time(long j) {
            this.time = j;
            return this;
        }
    }

    private BNLocationData(double d, double d2, float f, float f2, float f3, float f4, int i, int i2, long j) {
        this.latitude = d;
        this.longitude = d2;
        this.speed = f;
        this.direction = f2;
        this.accuracy = f3;
        this.bias = f4;
        this.satellitesNum = i;
        this.altitude = i2;
        this.time = j;
    }
}
