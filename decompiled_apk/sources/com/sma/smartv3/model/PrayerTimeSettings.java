package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PrayerTimeSettings {
    private int arsJuristicMethod;
    private int asrAdjustment;
    private int calculationMethod;
    private int dhuhrAdjustment;
    private int fajrAdjustment;
    private int hijriDateAdjustment;
    private int ishaAdjustment;
    private int maghribAdjustment;
    private int sunriseAdjustment;

    public PrayerTimeSettings() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public final int component1() {
        return this.calculationMethod;
    }

    public final int component2() {
        return this.arsJuristicMethod;
    }

    public final int component3() {
        return this.hijriDateAdjustment;
    }

    public final int component4() {
        return this.fajrAdjustment;
    }

    public final int component5() {
        return this.sunriseAdjustment;
    }

    public final int component6() {
        return this.dhuhrAdjustment;
    }

    public final int component7() {
        return this.asrAdjustment;
    }

    public final int component8() {
        return this.maghribAdjustment;
    }

    public final int component9() {
        return this.ishaAdjustment;
    }

    @OOXIXo
    public final PrayerTimeSettings copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        return new PrayerTimeSettings(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrayerTimeSettings)) {
            return false;
        }
        PrayerTimeSettings prayerTimeSettings = (PrayerTimeSettings) obj;
        return this.calculationMethod == prayerTimeSettings.calculationMethod && this.arsJuristicMethod == prayerTimeSettings.arsJuristicMethod && this.hijriDateAdjustment == prayerTimeSettings.hijriDateAdjustment && this.fajrAdjustment == prayerTimeSettings.fajrAdjustment && this.sunriseAdjustment == prayerTimeSettings.sunriseAdjustment && this.dhuhrAdjustment == prayerTimeSettings.dhuhrAdjustment && this.asrAdjustment == prayerTimeSettings.asrAdjustment && this.maghribAdjustment == prayerTimeSettings.maghribAdjustment && this.ishaAdjustment == prayerTimeSettings.ishaAdjustment;
    }

    public final int getArsJuristicMethod() {
        return this.arsJuristicMethod;
    }

    public final int getAsrAdjustment() {
        return this.asrAdjustment;
    }

    public final int getCalculationMethod() {
        return this.calculationMethod;
    }

    public final int getDhuhrAdjustment() {
        return this.dhuhrAdjustment;
    }

    public final int getFajrAdjustment() {
        return this.fajrAdjustment;
    }

    public final int getHijriDateAdjustment() {
        return this.hijriDateAdjustment;
    }

    public final int getIshaAdjustment() {
        return this.ishaAdjustment;
    }

    public final int getMaghribAdjustment() {
        return this.maghribAdjustment;
    }

    public final int getSunriseAdjustment() {
        return this.sunriseAdjustment;
    }

    public int hashCode() {
        return (((((((((((((((this.calculationMethod * 31) + this.arsJuristicMethod) * 31) + this.hijriDateAdjustment) * 31) + this.fajrAdjustment) * 31) + this.sunriseAdjustment) * 31) + this.dhuhrAdjustment) * 31) + this.asrAdjustment) * 31) + this.maghribAdjustment) * 31) + this.ishaAdjustment;
    }

    public final void setArsJuristicMethod(int i) {
        this.arsJuristicMethod = i;
    }

    public final void setAsrAdjustment(int i) {
        this.asrAdjustment = i;
    }

    public final void setCalculationMethod(int i) {
        this.calculationMethod = i;
    }

    public final void setDhuhrAdjustment(int i) {
        this.dhuhrAdjustment = i;
    }

    public final void setFajrAdjustment(int i) {
        this.fajrAdjustment = i;
    }

    public final void setHijriDateAdjustment(int i) {
        this.hijriDateAdjustment = i;
    }

    public final void setIshaAdjustment(int i) {
        this.ishaAdjustment = i;
    }

    public final void setMaghribAdjustment(int i) {
        this.maghribAdjustment = i;
    }

    public final void setSunriseAdjustment(int i) {
        this.sunriseAdjustment = i;
    }

    @OOXIXo
    public String toString() {
        return "PrayerTimeSettings(calculationMethod=" + this.calculationMethod + ", arsJuristicMethod=" + this.arsJuristicMethod + ", hijriDateAdjustment=" + this.hijriDateAdjustment + ", fajrAdjustment=" + this.fajrAdjustment + ", sunriseAdjustment=" + this.sunriseAdjustment + ", dhuhrAdjustment=" + this.dhuhrAdjustment + ", asrAdjustment=" + this.asrAdjustment + ", maghribAdjustment=" + this.maghribAdjustment + ", ishaAdjustment=" + this.ishaAdjustment + HexStringBuilder.COMMENT_END_CHAR;
    }

    public PrayerTimeSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.calculationMethod = i;
        this.arsJuristicMethod = i2;
        this.hijriDateAdjustment = i3;
        this.fajrAdjustment = i4;
        this.sunriseAdjustment = i5;
        this.dhuhrAdjustment = i6;
        this.asrAdjustment = i7;
        this.maghribAdjustment = i8;
        this.ishaAdjustment = i9;
    }

    public /* synthetic */ PrayerTimeSettings(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, IIXOooo iIXOooo) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0 : i8, (i10 & 256) == 0 ? i9 : 0);
    }
}
