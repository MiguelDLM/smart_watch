package com.baidu.navisdk.asr.model;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    public String A;
    public GeoPoint A0;
    public String B;
    public String B0;
    public String C;
    public b C0;
    public String D;
    public boolean D0;
    public String E;
    public int E0;
    public int F;
    public String F0;
    public String G;
    public int G0;
    public String H;
    public String I;
    public String J;
    public String K;
    public int L;
    public int M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public int U;
    public String V;
    public int W;
    public String X;
    public long Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f6552a;
    public String a0;
    public String b;
    public String b0;
    public String c;
    public String c0;
    public String d;
    public String d0;
    public int e;
    public String e0;
    public int f;
    public String f0;
    public String g;
    public ArrayList<String> g0;
    public String h;
    public int h0;
    public String i;
    public List<String> i0;
    public String j;
    public List<String> j0;
    public String k;
    public String k0;
    public String l;
    public int l0;
    public String m;
    public String m0;
    public String n;
    public String n0;
    public String o;

    /* renamed from: o0, reason: collision with root package name */
    public int f6553o0;
    public String p;
    public String p0;
    public String q;
    public List<String> q0;
    public String r;
    public String r0;
    public String s;
    public String s0;
    public String t;
    public int t0;
    public String u;
    public String u0;
    public String v;
    public int v0;
    public String w;
    public int w0;
    public String x;

    /* renamed from: x0, reason: collision with root package name */
    public String f6554x0;
    public String y;
    public int y0;
    public String z;
    public String z0;

    public a() {
        this.e = 0;
        this.f = 0;
        this.W = -1;
        this.A0 = new GeoPoint();
        this.C0 = new b();
        this.E0 = -1;
    }

    public String toString() {
        return "BNAsrResult{rawText='" + this.f6552a + "', parsedText='" + this.b + "', speechid='" + this.c + "', domain='" + this.d + "', isMultiple=" + this.e + ", haslocation=" + this.f + ", intent='" + this.g + "', lng='" + this.h + "', lat='" + this.i + "', title='" + this.j + "', tips='" + this.k + "', answer='" + this.l + "', ttsTips='" + this.m + "', ttsHtmlTips='" + this.n + "', tag='" + this.o + "', centre='" + this.p + "', centreCands='" + this.q + "', keywords='" + this.r + "', mode='" + this.s + "', origin='" + this.t + "', originCands='" + this.u + "', destination='" + this.v + "', destinationCands='" + this.w + "', focus='" + this.x + "', tactics='" + this.y + "', region='" + this.z + "', subway='" + this.A + "', busline='" + this.B + "', passPoi='" + this.C + "', order='" + this.D + "', content='" + this.E + "', tripNum=" + this.F + ", tripMultiReason='" + this.G + "', server='" + this.H + "', info='" + this.I + "', tplData='" + this.J + "', resultsJson='" + this.K + "', error=" + this.L + ", subError=" + this.M + ", errorDesc='" + this.N + "', mapContext='" + this.O + "', selectLastIntent='" + this.P + "', startList='" + this.Q + "', endList='" + this.R + "', routeSelect='" + this.S + "', confirmTag='" + this.T + "', number=" + this.U + ", action='" + this.V + "', index=" + this.W + ", pgName='" + this.X + "', pgID=" + this.Y + ", pgType='" + this.Z + "', openUrl='" + this.a0 + "', category='" + this.b0 + "', target='" + this.c0 + "', baseParams='" + this.d0 + "', searchType='" + this.e0 + "', uid='" + this.f0 + "', list=" + this.g0 + ", needConfirm=" + this.h0 + ", goRoads=" + this.i0 + ", avoidRoads=" + this.j0 + ", intention='" + this.k0 + "', eventType=" + this.l0 + ", eventTag='" + this.m0 + "', eventDetail='" + this.n0 + "', position=" + this.f6553o0 + ", type='" + this.p0 + "', detail=" + this.q0 + ", change='" + this.r0 + "', state='" + this.s0 + "', value=" + this.t0 + ", zoom='" + this.u0 + "', destinationRepeat=" + this.v0 + ", prefer=" + this.w0 + ", mrsl='" + this.f6554x0 + "', isNearest=" + this.y0 + ", sceneId='" + this.z0 + "', mPoint=" + this.A0 + ", pointName='" + this.B0 + "', sceneData=" + this.C0 + ", isAskType=" + this.D0 + ", confirmNum=" + this.E0 + ", ugcResultInfo='" + this.F0 + "'}";
    }

    public a(b bVar) {
        this.e = 0;
        this.f = 0;
        this.W = -1;
        this.A0 = new GeoPoint();
        new b();
        this.E0 = -1;
        this.C0 = bVar;
    }
}
