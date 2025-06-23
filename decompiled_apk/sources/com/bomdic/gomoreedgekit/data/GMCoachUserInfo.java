package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class GMCoachUserInfo {
    private final int age;
    private final int gender;
    private final float height;
    private final int maxHR;
    private final int restingHR;
    private final float staminaLevel;
    private final float vo2Max;
    private final float weight;

    public GMCoachUserInfo() {
        this(0, 0, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 255, null);
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

    public final float component8() {
        return this.staminaLevel;
    }

    @OOXIXo
    public final GMCoachUserInfo copy(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4) {
        return new GMCoachUserInfo(i, i2, f, f2, i3, i4, f3, f4);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMCoachUserInfo)) {
            return false;
        }
        GMCoachUserInfo gMCoachUserInfo = (GMCoachUserInfo) obj;
        return this.age == gMCoachUserInfo.age && this.gender == gMCoachUserInfo.gender && Float.compare(this.height, gMCoachUserInfo.height) == 0 && Float.compare(this.weight, gMCoachUserInfo.weight) == 0 && this.maxHR == gMCoachUserInfo.maxHR && this.restingHR == gMCoachUserInfo.restingHR && Float.compare(this.vo2Max, gMCoachUserInfo.vo2Max) == 0 && Float.compare(this.staminaLevel, gMCoachUserInfo.staminaLevel) == 0;
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

    public final float getStaminaLevel() {
        return this.staminaLevel;
    }

    public final float getVo2Max() {
        return this.vo2Max;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((((((((this.age * 31) + this.gender) * 31) + Float.floatToIntBits(this.height)) * 31) + Float.floatToIntBits(this.weight)) * 31) + this.maxHR) * 31) + this.restingHR) * 31) + Float.floatToIntBits(this.vo2Max)) * 31) + Float.floatToIntBits(this.staminaLevel);
    }

    @OOXIXo
    public String toString() {
        return "GMCoachUserInfo(age=" + this.age + ", gender=" + this.gender + ", height=" + this.height + ", weight=" + this.weight + ", maxHR=" + this.maxHR + ", restingHR=" + this.restingHR + ", vo2Max=" + this.vo2Max + ", staminaLevel=" + this.staminaLevel + oIX0oI.I0Io.f4095I0Io;
    }

    public GMCoachUserInfo(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4) {
        this.age = i;
        this.gender = i2;
        this.height = f;
        this.weight = f2;
        this.maxHR = i3;
        this.restingHR = i4;
        this.vo2Max = f3;
        this.staminaLevel = f4;
    }

    public /* synthetic */ GMCoachUserInfo(int i, int i2, float f, float f2, int i3, int i4, float f3, float f4, int i5, IIXOooo iIXOooo) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) == 0 ? i2 : 0, (i5 & 4) != 0 ? -9999.0f : f, (i5 & 8) != 0 ? -9999.0f : f2, (i5 & 16) != 0 ? -9999 : i3, (i5 & 32) == 0 ? i4 : -9999, (i5 & 64) != 0 ? -9999.0f : f3, (i5 & 128) == 0 ? f4 : -9999.0f);
    }
}
