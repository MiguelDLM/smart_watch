package com.baidu.platform.comapi.wnplatform.b;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.e.c;
import com.baidu.platform.comapi.wnplatform.e.d;
import com.baidu.platform.comapi.wnplatform.j.n;
import com.baidu.platform.comjni.bikenavi.JNIGuidanceControl;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a, reason: collision with root package name */
    int f9894a;
    private JNIGuidanceControl b;
    private long c;
    private int d;
    private boolean e;
    private boolean f = false;
    private String g;
    private String h;
    private Point i;

    public a() {
        this.b = null;
        this.c = 0L;
        this.d = 0;
        this.e = false;
        long d = b.a().I().d();
        this.c = d;
        if (d != 0) {
            this.b = new JNIGuidanceControl();
        }
        this.e = false;
        this.d = 0;
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        if (this.b == null) {
            return false;
        }
        int length = iArr.length;
        this.f9894a = length;
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = "";
        }
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = "";
        }
        return this.b.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
    }

    public int b() {
        return 0;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeReRouteCalcRoute", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.resumeReRouteCalcRoute(this.c);
        }
    }

    public int d() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getCurCorrectDirection", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCurCorrectDirection(this.c);
        }
        return 0;
    }

    public GeoPoint e() {
        int i;
        GeoPoint geoPoint = new GeoPoint(0, 0);
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (a(iArr, iArr2) && (i = iArr[0]) != 0 && iArr2[0] != 0) {
            geoPoint.setLongitudeE6(i);
            geoPoint.setLatitudeE6(iArr2[0]);
            return geoPoint;
        }
        return b.a().X().b();
    }

    public boolean f() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.isBrowseStatus", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.isBrowseStatus(this.c);
        }
        return false;
    }

    public boolean g() {
        return this.e;
    }

    public boolean h() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.startRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        this.e = true;
        return jNIGuidanceControl.startRouteGuide(this.c);
    }

    public boolean i() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.stopRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.stopRouteGuide(this.c);
        }
        return false;
    }

    public boolean j() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.resumeRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.resumeRouteGuide(this.c);
        }
        return false;
    }

    public boolean k() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.pauseRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.pauseRouteGuide(this.c);
        }
        return false;
    }

    public Point l() {
        int i;
        Point point = new Point(0, 0);
        int[] iArr = {0};
        int[] iArr2 = {0};
        if (b(iArr, iArr2) && (i = iArr[0]) != 0 && iArr2[0] != 0) {
            point.setIntX(i);
            point.setIntY(iArr2[0]);
        }
        return point;
    }

    public byte[] m() {
        return null;
    }

    public com.baidu.platform.comapi.wnplatform.e.a n() {
        byte[] routeDataBuffer;
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRouteDataBuffer()", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null || (routeDataBuffer = jNIGuidanceControl.getRouteDataBuffer(this.c)) == null) {
            return null;
        }
        try {
            List<MessageMicro> a2 = d.a(routeDataBuffer);
            if (a2.size() < 1) {
                return null;
            }
            return new c(0, 31, a2);
        } catch (IOException unused) {
            return null;
        }
    }

    public Bundle o() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getNaviRouteBoundWithNoMargin", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null || !jNIGuidanceControl.getNaviRouteBoundWithNoMargin(this.c, bundle)) {
            return null;
        }
        return bundle;
    }

    public boolean p() {
        return this.f;
    }

    public Bundle q() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getFirstParagraph", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.getFirstParagraph(this.c, bundle);
        }
        return bundle;
    }

    public void r() {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.PrepareRouteGuide", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.prepareRouteGuide(this.c);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a(true);
        this.b = null;
        this.i = null;
        this.d = 0;
    }

    public void s() {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.registerGetLaunchSystemTime(this.c);
        }
    }

    public boolean t() {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.isEngineIndoorNaviDefine(this.c);
        }
        return false;
    }

    public String u() {
        return this.g;
    }

    public String v() {
        return this.h;
    }

    public Point w() {
        return this.i;
    }

    public boolean b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.b == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("x", iArr);
        bundle.putIntArray("y", iArr2);
        bundle.putIntArray("serial", iArr3);
        return this.b.getViaNaviNodes(this.c, bundle);
    }

    public Bundle g(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getParagraphBound", "");
        Bundle bundle = new Bundle();
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.getParagraphBound(this.c, i, bundle);
        }
        return bundle;
    }

    public boolean c(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRotateMode", "" + i);
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setRotateMode(this.c, i);
        }
        return false;
    }

    public boolean d(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setLocateMode(this.c, i);
        }
        return false;
    }

    public void f(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setRouteStepFocus", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setParagraphFocus(this.c, i);
        }
    }

    public void i(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setNaviMode(this.c, i);
        }
    }

    public boolean j(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setOriNaviOverlooking(this.c, i);
        }
        return false;
    }

    public void k(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setGuidanceSpeed(this.c, i);
        }
    }

    public void h(int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setNaviType(this.c, i);
        }
    }

    public void d(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.getMatchRouteInfo(this.c, bundle);
        }
    }

    public boolean c(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRouteIDInfo", "" + bundle.toString());
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getRouteIDInfo(this.c, bundle);
        }
        return false;
    }

    public boolean f(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCurViaPoiPanoImage(this.c, bundle);
        }
        return false;
    }

    public Bundle b(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getRoutePlanResult", "" + i);
        Bundle bundle = new Bundle();
        if (this.b.getRouteResult(this.c, i, bundle)) {
            return bundle;
        }
        return null;
    }

    public void d(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.showNPCModel(this.c, z);
        }
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, String[] strArr, String[] strArr2) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return false;
        }
        this.f9894a = iArr.length;
        return jNIGuidanceControl.setNaviNodes(this.c, iArr, iArr2, iArr3, iArr4, strArr, strArr2, null, null);
    }

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setGuideTextMaxWordCnt", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setGuideTextMaxWordCnt(this.c, i);
        }
    }

    public void c(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.supportIndoorNavi(this.c, z);
        }
    }

    public boolean b(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPointMc", "" + iArr.toString() + " " + iArr2.toString());
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCarPointMC(this.c, iArr, iArr2);
        }
        return false;
    }

    public int a() {
        return this.f9894a;
    }

    public void e(Bundle bundle) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.getTravelData(this.c, bundle);
        }
    }

    public boolean a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (this.b == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("type", iArr3);
        bundle.putIntArray("x", iArr);
        bundle.putIntArray("y", iArr2);
        return this.b.getTrafficFacilities(this.c, bundle);
    }

    public boolean b(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getGPSMatchResult", "" + bundle.toString());
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getGPSMatchResult(this.c, bundle);
        }
        return false;
    }

    public boolean b(String str) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.setNetStatistics(this.c, str);
        }
        return false;
    }

    public int a(int i, int i2, int i3, int i4, byte[] bArr) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.calcRoute", "" + bArr);
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.calcRoute(this.c, i, i2, i3, bArr);
        }
        return 0;
    }

    public void b(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.needShowPoiPanoImage(this.c, z);
        }
    }

    public int a(String str) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.SearchRoutePlan(this.c, str);
        }
        return 0;
    }

    public com.baidu.platform.comapi.wnplatform.e.a a(int i) {
        byte[] GetProtobufResult;
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null || (GetProtobufResult = jNIGuidanceControl.GetProtobufResult(this.c, i)) == null) {
            return null;
        }
        try {
            List<MessageMicro> a2 = d.a(GetProtobufResult);
            if (a2.size() >= 1) {
                return new c(0, 31, a2);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.updateSensor(this.c, d, d2, d3, d4, d5, d6);
        }
    }

    public void a(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setBrowseStatus(this.c, z);
        }
    }

    public boolean a(int[] iArr, int[] iArr2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getShowPoint", "" + iArr.toString() + " " + iArr2.toString());
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getCarPoint(this.c, iArr, iArr2);
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getSimpleGuideInfo", "" + bundle.toString());
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getSimpleMapInfo(this.c, bundle);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(double r21, double r23, float r25, float r26, float r27, float r28, java.lang.String r29, java.lang.String r30, int r31, int r32, int r33, int r34, java.lang.String r35, int r36) {
        /*
            r20 = this;
            r0 = r20
            r1 = r34
            r2 = r35
            r12 = r29
            r0.g = r12
            com.baidu.platform.comjni.bikenavi.JNIGuidanceControl r3 = r0.b
            r4 = 0
            if (r3 == 0) goto Lb9
            r3 = 1
            r5 = r33
            if (r5 != r3) goto L17
            r16 = 1
            goto L19
        L17:
            r16 = 0
        L19:
            r4 = 61
            r15 = 4
            if (r1 == r4) goto L22
            r4 = 161(0xa1, float:2.26E-43)
            if (r1 == r4) goto L25
        L22:
            r17 = 1
            goto L49
        L25:
            java.lang.String r1 = "wf"
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 == 0) goto L32
            r1 = 2
            r17 = 2
            goto L49
        L32:
            java.lang.String r1 = "ml"
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 == 0) goto L3d
            r17 = 4
            goto L49
        L3d:
            java.lang.String r1 = "cl"
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 == 0) goto L22
            r1 = 8
            r17 = 8
        L49:
            com.baidu.platform.comjni.bikenavi.JNIGuidanceControl r1 = r0.b
            long r2 = r0.c
            r19 = 0
            r4 = r21
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            r0 = 4
            r15 = r32
            r18 = r36
            boolean r1 = r1.triggerGPSDataChange(r2, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.baidu.platform.comapi.walknavi.b r3 = com.baidu.platform.comapi.walknavi.b.a()
            com.baidu.platform.comapi.wnplatform.b.a r3 = r3.K()
            r3.d(r2)
            java.lang.String r3 = "status"
            int r3 = r2.getInt(r3)
            if (r3 != r0) goto L8f
            com.baidu.platform.comapi.walknavi.b r0 = com.baidu.platform.comapi.walknavi.b.a()
            com.baidu.platform.comapi.wnplatform.b.a r0 = r0.K()
            com.baidu.platform.comapi.basestruct.Point r0 = r0.l()
            goto La2
        L8f:
            java.lang.String r0 = "x"
            double r4 = r2.getDouble(r0)
            java.lang.String r0 = "y"
            double r6 = r2.getDouble(r0)
            com.baidu.platform.comapi.basestruct.Point r0 = new com.baidu.platform.comapi.basestruct.Point
            r0.<init>(r4, r6)
        La2:
            com.baidu.platform.comapi.walknavi.b r2 = com.baidu.platform.comapi.walknavi.b.a()
            com.baidu.platform.comapi.wnplatform.o.a r2 = r2.Y()
            boolean r2 = r2 instanceof com.baidu.platform.comapi.walknavi.h.b
            if (r2 == 0) goto Lb6
            r2 = r20
            r4 = r27
            r2.a(r0, r4, r3)
            goto Lb8
        Lb6:
            r2 = r20
        Lb8:
            return r1
        Lb9:
            r2 = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.wnplatform.b.a.a(double, double, float, float, float, float, java.lang.String, java.lang.String, int, int, int, int, java.lang.String, int):boolean");
    }

    public boolean a(int i, int i2, Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.getStepGuideText", "");
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            return jNIGuidanceControl.getGuideParagraph(this.c, i, i2, bundle);
        }
        return false;
    }

    public void a(int i, int i2, int i3, String str, String str2) {
        com.baidu.platform.comapi.wnplatform.d.a.a("WNaviGuidance.setVehiclePos", " " + i + " " + i2 + " " + i3);
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setVehiclePos(this.c, i, i2, i3, str, str2);
        }
    }

    public void a(String str, String str2) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.showFloor(this.c, str, str2);
        }
    }

    public void a(int i, int i2) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.setARRouteResID(this.c, i, i2);
        }
    }

    private void a(Point point, float f, int i) {
        Point c;
        if (point != null) {
            b.a().b("feedAr !!!" + point.getIntX() + "|" + point.getIntY() + "gpsacc:" + ((int) f));
        }
        if (com.baidu.platform.comapi.wnplatform.a.a().e() == null) {
            return;
        }
        int i2 = this.d;
        if (i2 < 3) {
            this.d = i2 + 1;
            Point b = n.a().b();
            if (b.getIntX() != 0 && b.getIntY() != 0) {
                this.i = b;
                float[] fArr = {(float) b.getDoubleX(), (float) b.getDoubleY()};
                b.a().b("updateLocation !!!" + ((int) fArr[0]) + "|" + ((int) fArr[1]) + "first:");
                com.baidu.platform.comapi.wnplatform.a.a().e().updateLocation(fArr, 1, false);
                return;
            }
        }
        if (point != null && point.getIntX() != 0 && point.getIntY() != 0) {
            Point bd09mcTogcj02ll = CoordinateUtil.bd09mcTogcj02ll(point.getIntX(), point.getIntY());
            this.i = bd09mcTogcj02ll;
            float[] fArr2 = {(float) bd09mcTogcj02ll.getDoubleX(), (float) this.i.getDoubleY()};
            b.a().b("updateLocation !!!" + ((int) this.i.getDoubleX()) + "|" + ((int) this.i.getDoubleY()) + "onSetUp:" + com.baidu.platform.comapi.walknavi.widget.a.a.f9843a);
            com.baidu.platform.comapi.wnplatform.a.a().e().updateLocation(fArr2, 1, i == 4);
        }
        if (this.i == null || (c = n.a().c()) == null) {
            return;
        }
        int a2 = (int) com.baidu.platform.comjni.tools.a.a(CoordinateUtil.gcj02Tobd09mc(this.i.getDoubleX(), this.i.getDoubleY()), c);
        b.a().b("under enter:" + a2);
    }
}
