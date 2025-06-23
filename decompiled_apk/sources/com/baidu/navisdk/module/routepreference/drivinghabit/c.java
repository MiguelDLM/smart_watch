package com.baidu.navisdk.module.routepreference.drivinghabit;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f7480a = null;
    public String b = null;
    public boolean c = false;
    public ArrayList<a> d;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f7481a = null;
        public String b = null;
        public int c = 0;

        public String toString() {
            return "HabitItem{name='" + this.f7481a + "', summary='" + this.b + "', preferValue=" + this.c + '}';
        }
    }

    public String toString() {
        return "DrivingHabitModel{titleName='" + this.f7480a + "', titleSummary='" + this.b + "', isMultiple=" + this.c + ", habitItems=" + this.d + '}';
    }
}
