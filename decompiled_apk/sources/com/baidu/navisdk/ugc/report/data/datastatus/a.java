package com.baidu.navisdk.ugc.report.data.datastatus;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.report.data.datarepository.b;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.s;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class a {
    public GeoPoint R;
    public e.b U;
    public String V;
    private ArrayList<String> a0;

    /* renamed from: a, reason: collision with root package name */
    public int f8263a = -1;
    public String b = null;
    public String c = null;
    public int d = 0;
    public int e = -1;
    public int f = -1;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public int l = 0;
    public String m = "";
    public String n = null;
    public int o = 0;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = "";
    public String x = null;
    public String y = null;
    public int z = -1;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public int E = -1;
    public String F = null;
    public int G = -1;
    public String H = null;
    public int I = -1;
    public String J = null;
    public String K = null;
    public String L = null;
    public String M = null;
    public int N = -1;
    public int O = 0;
    public String P = null;
    public String Q = null;
    public String S = null;
    public String T = null;
    public int W = -1;
    public int X = -1;
    public int Y = -1;
    public int Z = -1;
    public int b0 = 1;

    public static a c(a aVar) {
        a aVar2 = new a();
        if (!aVar2.a(aVar)) {
            return null;
        }
        aVar2.f();
        return aVar2;
    }

    private String d(String str) {
        return str == null ? "" : str;
    }

    private String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private void f() {
        this.b = c(this.b);
        this.c = c(this.c);
        this.g = d(this.g);
        this.h = e(this.h);
        this.j = c(this.j);
        this.k = e(this.k);
        this.p = d(this.p);
        this.q = d(this.q);
        this.r = d(this.r);
        this.s = e(this.s);
        this.t = d(this.t);
        this.u = d(this.u);
        this.v = e(this.v);
        this.x = c(this.x);
        this.y = d(this.y);
        this.A = e(this.A);
        this.B = d(this.B);
        this.C = e(this.C);
        this.J = c(this.J);
        this.K = c(this.K);
        this.L = e(this.L);
        this.M = e(this.M);
        this.P = d(this.P);
        this.Q = d(this.Q);
        this.S = d(this.S);
        this.T = d(this.T);
        this.V = d(this.V);
    }

    public boolean a(a aVar) {
        if (aVar == null) {
            return false;
        }
        this.f8263a = aVar.f8263a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
        this.z = aVar.z;
        this.A = aVar.A;
        this.B = aVar.B;
        this.C = aVar.C;
        this.D = aVar.D;
        this.E = aVar.E;
        this.F = aVar.F;
        this.G = aVar.G;
        this.H = aVar.H;
        this.I = aVar.I;
        this.J = aVar.J;
        this.K = aVar.K;
        this.L = aVar.L;
        this.M = aVar.M;
        this.N = aVar.N;
        this.O = aVar.O;
        this.P = aVar.P;
        this.Q = aVar.Q;
        this.S = aVar.S;
        this.T = aVar.T;
        if (aVar.U != null) {
            e.b bVar = new e.b();
            this.U = bVar;
            bVar.a(aVar.U);
        }
        this.W = aVar.W;
        this.X = aVar.X;
        this.Y = aVar.Y;
        this.Z = aVar.Z;
        a(aVar.a0);
        this.V = aVar.V;
        this.b0 = aVar.b0;
        return true;
    }

    public boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        this.f8263a = aVar.f8263a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = aVar.y;
        this.z = aVar.z;
        this.A = aVar.A;
        this.B = aVar.B;
        this.C = aVar.C;
        this.E = aVar.E;
        this.F = aVar.F;
        this.G = aVar.G;
        this.H = aVar.H;
        this.I = aVar.I;
        this.J = aVar.J;
        this.K = aVar.K;
        this.L = aVar.L;
        this.M = aVar.M;
        this.N = aVar.N;
        this.O = aVar.O;
        this.P = aVar.P;
        this.Q = aVar.Q;
        this.S = aVar.S;
        this.T = aVar.T;
        this.X = aVar.X;
        this.Y = aVar.Y;
        this.Z = aVar.Z;
        this.b0 = aVar.b0;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UgcReportInfoUploadPackage{");
        sb.append("id=");
        sb.append(this.f8263a);
        sb.append(", userPoint='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", point='");
        sb.append(this.c);
        sb.append('\'');
        sb.append(", businessTrigger=");
        sb.append(this.d);
        sb.append(", parentType=");
        sb.append(this.e);
        sb.append(", subType=");
        sb.append(this.f);
        sb.append(", guid='");
        sb.append(this.g);
        sb.append('\'');
        sb.append(", content='");
        sb.append(this.h);
        sb.append('\'');
        sb.append(", photoPicPath='");
        sb.append(this.i);
        sb.append('\'');
        sb.append(", photoPoint='");
        sb.append(this.j);
        sb.append('\'');
        sb.append(", roadName='");
        sb.append(this.k);
        sb.append('\'');
        sb.append(", isChange=");
        sb.append(this.l);
        sb.append(", contact='");
        sb.append(this.m);
        sb.append('\'');
        sb.append(", voicePath='");
        sb.append(this.n);
        sb.append('\'');
        sb.append(", os=");
        sb.append(this.o);
        sb.append(", osv='");
        sb.append(this.p);
        sb.append('\'');
        sb.append(", sv='");
        sb.append(this.q);
        sb.append('\'');
        sb.append(", cuid='");
        sb.append(this.r);
        sb.append('\'');
        sb.append(", name='");
        sb.append(this.s);
        sb.append('\'');
        sb.append(", sessionId='");
        sb.append(this.t);
        sb.append('\'');
        sb.append(", mrsl='");
        sb.append(this.u);
        sb.append('\'');
        sb.append(", fromName='");
        sb.append(this.v);
        sb.append('\'');
        sb.append(", fromPoint='");
        sb.append(this.w);
        sb.append('\'');
        sb.append(", toPoint='");
        sb.append(this.x);
        sb.append('\'');
        sb.append(", fromUid='");
        sb.append(this.y);
        sb.append('\'');
        sb.append(", cityId=");
        sb.append(this.z);
        sb.append(", cityName='");
        sb.append(this.A);
        sb.append('\'');
        sb.append(", toUid='");
        sb.append(this.B);
        sb.append('\'');
        sb.append(", toName='");
        sb.append(this.C);
        sb.append('\'');
        sb.append(", screenshotPicPath='");
        sb.append(this.D);
        sb.append('\'');
        sb.append(", laneType=");
        sb.append(this.E);
        sb.append(", detailType=");
        sb.append(this.G);
        sb.append(", speedLimit=");
        sb.append(this.I);
        sb.append(", startPoint='");
        sb.append(this.J);
        sb.append('\'');
        sb.append(", endPoint='");
        sb.append(this.K);
        sb.append('\'');
        sb.append(", startName='");
        sb.append(this.L);
        sb.append('\'');
        sb.append(", endName='");
        sb.append(this.M);
        sb.append('\'');
        sb.append(", mark=");
        sb.append(this.N);
        sb.append(", supply=");
        sb.append(this.O);
        sb.append(", linkid='");
        sb.append(this.P);
        sb.append('\'');
        sb.append(", linkidx='");
        sb.append(this.Q);
        sb.append('\'');
        sb.append(", mGeoPoint=");
        sb.append(this.R);
        sb.append(", recordTime=");
        sb.append(this.W);
        sb.append(", lanePosition=");
        sb.append(this.X);
        sb.append(", detailPosition=");
        sb.append(this.Y);
        sb.append(", subPosition=");
        sb.append(this.Z);
        sb.append(", sugWord='");
        sb.append(this.S);
        sb.append('\'');
        sb.append(", speechId='");
        sb.append(this.T);
        sb.append('\'');
        sb.append(", linkid_short='");
        sb.append(this.V);
        sb.append('\'');
        sb.append(", photoPathArray='");
        ArrayList<String> arrayList = this.a0;
        if (arrayList == null) {
            sb.append("null");
        } else {
            sb.append(Arrays.toString(arrayList.toArray()));
        }
        sb.append('\'');
        sb.append(", videoInfo=");
        sb.append(this.U);
        sb.append(", reportWay=");
        sb.append(this.b0);
        sb.append('}');
        return sb.toString();
    }

    public String d() {
        e.b bVar = this.U;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L9
            java.lang.String r7 = ""
            return r7
        L9:
            java.lang.String r0 = ","
            int r1 = r7.indexOf(r0)
            if (r1 <= 0) goto L5a
            int r2 = r7.length()
            int r2 = r2 + (-1)
            if (r1 >= r2) goto L5a
            r2 = 0
            java.lang.String r3 = r7.substring(r2, r1)
            int r1 = r1 + 1
            int r4 = r7.length()
            java.lang.String r1 = r7.substring(r1, r4)
            double r3 = java.lang.Double.parseDouble(r3)     // Catch: java.lang.Exception -> L5a
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch: java.lang.Exception -> L5a
            double r4 = java.lang.Double.parseDouble(r1)     // Catch: java.lang.Exception -> L5a
            java.lang.Double r1 = java.lang.Double.valueOf(r4)     // Catch: java.lang.Exception -> L5a
            java.text.NumberFormat r4 = java.text.NumberFormat.getInstance()     // Catch: java.lang.Exception -> L5a
            r4.setGroupingUsed(r2)     // Catch: java.lang.Exception -> L5a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5a
            r2.<init>()     // Catch: java.lang.Exception -> L5a
            java.lang.String r3 = r4.format(r3)     // Catch: java.lang.Exception -> L5a
            r2.append(r3)     // Catch: java.lang.Exception -> L5a
            r2.append(r0)     // Catch: java.lang.Exception -> L5a
            java.lang.String r0 = r4.format(r1)     // Catch: java.lang.Exception -> L5a
            r2.append(r0)     // Catch: java.lang.Exception -> L5a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L5a
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 == 0) goto L5e
            return r0
        L5e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.report.data.datastatus.a.c(java.lang.String):java.lang.String");
    }

    public boolean e() {
        e.b bVar = this.U;
        return bVar != null && bVar.d();
    }

    @Nullable
    public ArrayList<String> c() {
        return this.a0;
    }

    public void b(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(str + ":UgcReportInfoUploadPackage", "parentType:" + this.e + "laneType:" + this.E + "detailType" + this.G + "os:" + this.o + "cuid" + this.r);
        }
    }

    public void b(b bVar) {
        if (bVar != null) {
            this.E = bVar.b;
            this.F = bVar.f8246a;
        } else {
            this.E = 0;
            this.F = null;
        }
    }

    public void b() {
        String str = this.n;
        if (str != null) {
            try {
                s.a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str2 = this.i;
        if (str2 != null) {
            try {
                s.a(str2);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        String str3 = this.D;
        if (str3 != null) {
            try {
                s.a(str3);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (e()) {
            this.U.b();
            this.U.a();
        }
        ArrayList<String> arrayList = this.a0;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = this.a0.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                try {
                    s.a(next);
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void a() {
        this.f8263a = -1;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = 0;
        this.m = "";
        this.n = null;
        this.o = 0;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = "";
        this.x = null;
        this.y = null;
        this.z = -1;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = -1;
        this.F = null;
        this.G = -1;
        this.H = null;
        this.I = -1;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = -1;
        this.O = 0;
        this.P = null;
        this.R = null;
        this.Q = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.W = -1;
        this.X = -1;
        this.Y = -1;
        this.Z = -1;
        ArrayList<String> arrayList = this.a0;
        if (arrayList != null) {
            arrayList.clear();
            this.a0 = null;
        }
        this.b0 = 1;
    }

    public void a(e.b bVar) {
        if (bVar == null) {
            e.b bVar2 = this.U;
            if (bVar2 != null) {
                bVar2.a();
                return;
            }
            return;
        }
        if (this.U == null) {
            this.U = new e.b();
        }
        this.U.a(bVar);
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.G = bVar.b;
            this.H = bVar.f8246a;
        } else {
            this.G = 0;
            this.H = null;
        }
    }

    public void a(String str, String str2) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcReportInfoUploadPackage", "addPhotoPath(), photoPath = " + str + " photoPoint = " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.a0 == null) {
            this.a0 = new ArrayList<>(3);
        }
        if (!this.a0.contains(str)) {
            this.a0.add(str);
        }
        this.j = str2;
    }

    public void a(String str) {
        ArrayList<String> arrayList;
        int indexOf;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcReportInfoUploadPackage", "deletePhotoPath: " + str);
        }
        if (TextUtils.isEmpty(str) || (arrayList = this.a0) == null || (indexOf = arrayList.indexOf(str)) < 0) {
            return;
        }
        this.a0.remove(indexOf);
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.a0 = new ArrayList<>(arrayList);
        } else {
            this.a0 = null;
        }
    }
}
