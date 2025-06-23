package com.baidu.navisdk.pronavi.ui.bucket.config;

import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public int f7852a;
    public int b;
    public int c;
    public int d;
    public BNViewPriorityBucket.ItemLocation e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;

    public d(int i, int i2, int i3, BNViewPriorityBucket.ItemLocation itemLocation) {
        BNViewPriorityBucket.ItemLocation itemLocation2 = BNViewPriorityBucket.ItemLocation.START;
        this.g = false;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.f7852a = i;
        this.b = i2;
        this.c = i3;
        this.d = i3;
        this.e = itemLocation;
        this.f = 0;
    }

    public d a(int i) {
        this.d = i;
        return this;
    }

    public d b(int i) {
        this.h = i;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass() && this.f7852a == ((d) obj).f7852a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f7852a;
    }

    public String toString() {
        return "RGBucketItemData{id=" + this.f7852a + ", type=" + this.b + ", portraitPriority=" + this.c + ", landPriority=" + this.d + ", location=" + this.e + ", priorityForGone=" + this.h + ", showedOrientation=" + this.f + '}';
    }

    public d(int i, int i2, int i3, BNViewPriorityBucket.ItemLocation itemLocation, int i4) {
        BNViewPriorityBucket.ItemLocation itemLocation2 = BNViewPriorityBucket.ItemLocation.START;
        this.g = false;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.f7852a = i;
        this.b = i2;
        this.c = i3;
        this.d = i3;
        this.e = itemLocation;
        this.f = i4;
    }
}
