package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMUserInfo {
    private final int age;
    private final int gender;
    private final float height;
    private final int maxHR;
    private final int restingHR;
    private final float vo2Max;
    private final float weight;

    public GMUserInfo() {
        this(0, 0, 0.0f, 0.0f, 0, 0, 0.0f, 127, null);
    }

    public static /* synthetic */ GMUserInfo copy$default(GMUserInfo gMUserInfo, int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = gMUserInfo.age;
        }
        if ((i5 & 2) != 0) {
            i2 = gMUserInfo.gender;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            f = gMUserInfo.height;
        }
        float f4 = f;
        if ((i5 & 8) != 0) {
            f2 = gMUserInfo.weight;
        }
        float f5 = f2;
        if ((i5 & 16) != 0) {
            i3 = gMUserInfo.maxHR;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            i4 = gMUserInfo.restingHR;
        }
        int i8 = i4;
        if ((i5 & 64) != 0) {
            f3 = gMUserInfo.vo2Max;
        }
        return gMUserInfo.copy(i, i6, f4, f5, i7, i8, f3);
    }

    public final int component1() {
        return this.age;
    }

    public final int component2() {
        return this.gender;
    }

    public final float component3() {
        return this.height;
    }

    public final float component4() {
        return this.weight;
    }

    public final int component5() {
        return this.maxHR;
    }

    public final int component6() {
        return this.restingHR;
    }

    public final float component7() {
        return this.vo2Max;
    }

    @OOXIXo
    public final GMUserInfo copy(int i, int i2, float f, float f2, int i3, int i4, float f3) {
        return new GMUserInfo(i, i2, f, f2, i3, i4, f3);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMUserInfo)) {
            return false;
        }
        GMUserInfo gMUserInfo = (GMUserInfo) obj;
        return this.age == gMUserInfo.age && this.gender == gMUserInfo.gender && Float.compare(this.height, gMUserInfo.height) == 0 && Float.compare(this.weight, gMUserInfo.weight) == 0 && this.maxHR == gMUserInfo.maxHR && this.restingHR == gMUserInfo.restingHR && Float.compare(this.vo2Max, gMUserInfo.vo2Max) == 0;
    }

    public final int getAge() {
        return this.age;
    }

    public final int getGender() {
        return this.gender;
    }

    public final float getHeight() {
        return this.height;
    }

    public final int getMaxHR() {
        return this.maxHR;
    }

    public final int getRestingHR() {
        return this.restingHR;
    }

    public final float getVo2Max() {
        return this.vo2Max;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((((((this.age * 31) + this.gender) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.weight)) * 31) + this.maxHR) * 31) + this.restingHR) * 31) + Float.floatToIntBits(this.vo2Max);
    }

    @OOXIXo
    public String toString() {
        return "GMUserInfo(age=" + this.age + ", gender=" + this.gender + ", height=" + this.height + ", weight=" + this.weight + ", maxHR=" + this.maxHR + ", restingHR=" + this.restingHR + ", vo2Max=" + this.vo2Max + oIX0oI.I0Io.f4095I0Io;
    }

    public GMUserInfo(int i, int i2, float f, float f2, int i3, int i4, float f3) {
        this.age = i;
        this.gender = i2;
        this.height = f;
        this.weight = f2;
        this.maxHR = i3;
        this.restingHR = i4;
        this.vo2Max = f3;
    }

    public /* synthetic */ GMUserInfo(int i, int i2, float f, float f2, int i3, int i4, float f3, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) == 0 ? i2 : 0, (i5 & 4) != 0 ? -9999.0f : f, (i5 & 8) != 0 ? -9999.0f : f2, (i5 & 16) != 0 ? -9999 : i3, (i5 & 32) != 0 ? -9999 : i4, (i5 & 64) != 0 ? -9999.0f : f3);
    }
}
