package com.baidu.navisdk.model.datastruct;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class RoutePlanTime {
    public int day;
    public int hour;
    public int minute;
    public int month;
    public boolean valid;
    public int year;

    public RoutePlanTime() {
    }

    public String format() {
        return this.year + "/" + this.month + "/" + this.day + " " + this.hour + ":" + this.minute;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public RoutePlanTime setDay(int i) {
        this.day = i;
        return this;
    }

    public RoutePlanTime setHour(int i) {
        this.hour = i;
        return this;
    }

    public RoutePlanTime setMinute(int i) {
        this.minute = i;
        return this;
    }

    public RoutePlanTime setMonth(int i) {
        this.month = i;
        return this;
    }

    public RoutePlanTime setValid(boolean z) {
        this.valid = z;
        return this;
    }

    public RoutePlanTime setYear(int i) {
        this.year = i;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("year", this.year);
        bundle.putInt("month", this.month);
        bundle.putInt("day", this.day);
        bundle.putInt("hour", this.hour);
        bundle.putInt("minute", this.minute);
        bundle.putBoolean("valid", this.valid);
        return bundle;
    }

    public String toSimpleString() {
        return String.format("%d-%d-%d %d:%d %b", Integer.valueOf(this.year), Integer.valueOf(this.month), Integer.valueOf(this.day), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Boolean.valueOf(this.valid));
    }

    public String toString() {
        return "RoutePlanTime{year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ", valid=" + this.valid + '}';
    }

    public RoutePlanTime(int i, int i2, boolean z) {
        this.hour = i;
        this.minute = i2;
        this.valid = z;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePlanTime m82clone() {
        RoutePlanTime routePlanTime = new RoutePlanTime();
        routePlanTime.year = this.year;
        routePlanTime.day = this.day;
        routePlanTime.month = this.month;
        routePlanTime.hour = this.hour;
        routePlanTime.minute = this.minute;
        routePlanTime.valid = this.valid;
        return routePlanTime;
    }
}
