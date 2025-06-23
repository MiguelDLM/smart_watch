package com.baidu.navisdk.routetab.data;

import com.baidu.entity.pb.Cars;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f7973a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private byte[] p;
    private long q;
    private long r;
    private Cars s;

    public String a() {
        return this.k;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.h;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f7973a;
    }

    public String toString() {
        return "RouteExtTabInfo{type='" + this.f7973a + "', startInfoJson='" + this.b + "', endInfoJson='" + this.c + "', tabInitSuccess=" + this.d + ", duNoticeIconUrl='" + this.e + "', duNoticeTitle='" + this.f + "', tabTitle='" + this.g + "', tabSubTitlePre='" + this.h + "', tabSubTitleSuf='" + this.i + "', tabSubTitleIcon='" + this.j + "', extInfo='" + this.k + "', bottomBtnIcon='" + this.l + "', bottomBtnText='" + this.m + "', bottomBtnJumpLink='" + this.n + "', bottomBtnJumpLinkType='" + this.o + "', routeData=" + Arrays.toString(this.p) + ", oldId=" + this.q + ", newId=" + this.r + ", cars=" + this.s + '}';
    }
}
