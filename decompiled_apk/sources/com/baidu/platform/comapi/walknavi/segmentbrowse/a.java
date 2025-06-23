package com.baidu.platform.comapi.walknavi.segmentbrowse;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f9830a;
    private String b;
    private int c;
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> d = new ArrayList<>();
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> e = new ArrayList<>();
    private ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f = new ArrayList<>();
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;

    public void a(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.e = arrayList;
    }

    public String b() {
        return this.m;
    }

    public int c() {
        return this.i;
    }

    public void d(int i) {
        this.c = i;
    }

    public String e() {
        return this.f9830a;
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> f() {
        return this.d;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public String toString() {
        return "WRouteMessageModel [iconName=" + this.f9830a + ", guideText=" + this.b + ", stepLength=" + this.g + ", uid=" + this.h + "]";
    }

    public String a() {
        return this.l;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(int i) {
        this.i = i;
    }

    public int d() {
        return this.c;
    }

    public void e(int i) {
        this.g = i;
    }

    public void f(int i) {
        this.h = i;
    }

    public void a(int i) {
        this.j = i;
    }

    public void b(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.f = arrayList;
    }

    public void c(ArrayList<com.baidu.platform.comapi.walknavi.segmentbrowse.widget.c> arrayList) {
        this.d = arrayList;
    }

    public void a(String str) {
        this.f9830a = str;
    }

    public void b(String str) {
        this.b = str;
    }
}
