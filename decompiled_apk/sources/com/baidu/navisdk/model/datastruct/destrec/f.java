package com.baidu.navisdk.model.datastruct.destrec;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.entity.pb.DestItems;
import com.baidu.entity.pb.RecPoiInfo;
import com.baidu.entity.pb.StreetView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public class f {
    private static final int C = ScreenUtil.getInstance().dip2px(74);
    private static final int D = ScreenUtil.getInstance().dip2px(17);
    private static final int E = ScreenUtil.getInstance().dip2px(23);
    private static final int F = ScreenUtil.getInstance().dip2px(6);
    private static final int G = ScreenUtil.getInstance().dip2px(18);
    private static final int H = ScreenUtil.getInstance().dip2px(6);
    private static final int I = ScreenUtil.getInstance().dip2px(16);
    private int A;
    private int B;

    /* renamed from: a, reason: collision with root package name */
    private String f6920a;
    private String b;
    private int c;
    private int d;
    private com.baidu.nplatform.comapi.basestruct.c e;
    private String f;
    private String g;
    private com.baidu.navisdk.model.datastruct.b h;
    private int j;
    private i l;
    private int n;
    private String o;
    private int p;
    private String[] q;
    private String[] r;
    private String[] s;
    private com.baidu.navisdk.model.datastruct.destrec.b t;
    private e u;
    private int w;
    private int x;
    private int y;
    private boolean z;
    private final List<String> i = new ArrayList();
    private final List<b> k = new ArrayList();
    private final List<String> m = new ArrayList();
    private final List<com.baidu.navisdk.model.datastruct.destrec.a> v = new ArrayList();

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f6921a;
        private final String b;
        private final int c;
        private final String d;
        private final int e;

        public String a() {
            return this.f6921a;
        }

        public String b() {
            return this.b;
        }

        public String toString() {
            return "Label{summaryText='" + this.f6921a + "', text='" + this.b + "', textType=" + this.c + " occupancy=" + this.d + " parkStatus=" + this.e + '}';
        }

        private b(String str, String str2, int i, String str3, int i2) {
            this.f6921a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = i2;
        }
    }

    public static f a(RecPoiInfo recPoiInfo, int i, int i2, int i3) {
        if (recPoiInfo == null) {
            return null;
        }
        f fVar = new f();
        fVar.w = i;
        fVar.x = i2;
        fVar.y = i3;
        fVar.b = recPoiInfo.getUid().toStringUtf8();
        fVar.c = recPoiInfo.getPoiType();
        fVar.f6920a = recPoiInfo.getName().toStringUtf8();
        fVar.d = recPoiInfo.getIconId();
        fVar.e = new com.baidu.nplatform.comapi.basestruct.c(recPoiInfo.getPoint().getX(), recPoiInfo.getPoint().getY());
        fVar.f = recPoiInfo.getRichText().toStringUtf8();
        fVar.g = recPoiInfo.getButtonText().toStringUtf8();
        fVar.j = recPoiInfo.getHighlightTextType();
        fVar.l = fVar.a(recPoiInfo.getStreetView());
        fVar.n = recPoiInfo.getRelatPoiType();
        fVar.p = recPoiInfo.getPatternid();
        fVar.o = recPoiInfo.getBibleText().toStringUtf8();
        fVar.t = com.baidu.navisdk.model.datastruct.destrec.b.a(recPoiInfo.getParkingInfo());
        fVar.u = e.g.a(recPoiInfo.getParkingSpace(), fVar.b);
        if (recPoiInfo.getDestRouteMd5Count() > 0) {
            for (int i4 = 0; i4 < recPoiInfo.getDestRouteMd5Count(); i4++) {
                String stringUtf8 = recPoiInfo.getDestRouteMd5(i4).toStringUtf8();
                if (!TextUtils.isEmpty(stringUtf8)) {
                    fVar.m.add(stringUtf8);
                }
            }
        }
        for (int i5 = 0; i5 < recPoiInfo.getFirstParkingSpaceCount(); i5++) {
            com.baidu.navisdk.model.datastruct.destrec.a a2 = com.baidu.navisdk.model.datastruct.destrec.a.e.a(recPoiInfo.getFirstParkingSpace(i5));
            if (a2 != null) {
                fVar.v.add(a2);
            }
        }
        if (fVar.m.size() == 0) {
            fVar.q = recPoiInfo.getVisionContents().toStringUtf8().split("\\$");
        } else {
            String[] split = recPoiInfo.getVisionContents().toStringUtf8().split("\\|");
            if (split.length == 2) {
                fVar.s = split[0].split("\\$");
                fVar.r = split[1].split("\\$");
            } else {
                fVar.r = recPoiInfo.getVisionContents().toStringUtf8().split("\\$");
                fVar.s = recPoiInfo.getVisionContents().toStringUtf8().split("\\$");
            }
        }
        if (recPoiInfo.getHighlightTextCount() > 0) {
            for (int i6 = 0; i6 < recPoiInfo.getHighlightTextCount(); i6++) {
                String stringUtf82 = recPoiInfo.getHighlightText(i6).toStringUtf8();
                if (!TextUtils.isEmpty(stringUtf82)) {
                    fVar.i.add(stringUtf82);
                }
            }
        }
        if (recPoiInfo.getDestItemsCount() > 0) {
            for (int i7 = 0; i7 < recPoiInfo.getDestItemsCount(); i7++) {
                DestItems destItems = recPoiInfo.getDestItems(i7);
                String stringUtf83 = destItems == null ? "" : destItems.getTagText().toStringUtf8();
                String stringUtf84 = destItems != null ? destItems.getSummaryText().toStringUtf8() : "";
                int textType = destItems == null ? 0 : destItems.getTextType();
                com.baidu.navisdk.model.datastruct.destrec.b bVar = fVar.t;
                int c = bVar == null ? 0 : bVar.c();
                com.baidu.navisdk.model.datastruct.destrec.b bVar2 = fVar.t;
                int a3 = bVar2 == null ? 0 : bVar2.a();
                com.baidu.navisdk.model.datastruct.destrec.b bVar3 = fVar.t;
                int b2 = bVar3 == null ? 0 : bVar3.b();
                String str = a3 + "/" + c;
                if (!TextUtils.isEmpty(stringUtf83)) {
                    fVar.k.add(new b(stringUtf84, stringUtf83, textType, str, b2));
                }
            }
        }
        if (fVar.d > 0) {
            com.baidu.navisdk.model.datastruct.b bVar4 = new com.baidu.navisdk.model.datastruct.b();
            fVar.h = bVar4;
            bVar4.a(fVar.j());
            fVar.h.a(fVar.e);
            fVar.h.a(fVar.q);
            fVar.h.b(fVar.p);
            fVar.h.a(fVar.m);
            fVar.h.b(fVar.r);
            fVar.h.c(fVar.s);
        }
        fVar.A = fVar.k();
        return fVar;
    }

    private int k() {
        int i = (D * 2) + E;
        if (this.k.size() > 0) {
            i += F + G;
        }
        if (!TextUtils.isEmpty(this.f)) {
            i += H + I;
        }
        return Math.max(i, C);
    }

    public String b() {
        return this.f;
    }

    public com.baidu.navisdk.model.datastruct.destrec.b c() {
        return this.t;
    }

    public int d() {
        return this.A;
    }

    public List<b> e() {
        return this.k;
    }

    public com.baidu.navisdk.model.datastruct.b f() {
        return this.h;
    }

    public String g() {
        return this.f6920a;
    }

    public e h() {
        return this.u;
    }

    public com.baidu.nplatform.comapi.basestruct.c i() {
        return this.e;
    }

    public String j() {
        return this.b;
    }

    public String toString() {
        return "DestRecPoiData{name='" + this.f6920a + "', uid='" + this.b + "', poiType=" + this.c + ", iconId=" + this.d + ", point=" + this.e + ", describe='" + this.f + "', buttonText='" + this.g + "', mapGData=" + this.h + ", highlightList=" + this.i + ", highlightTextType=" + this.j + ", labelList=" + this.k + ", streetView=" + this.l + ", routeMd5=" + this.m + ", relatePoiType=" + this.n + ", bibleText='" + this.o + "', patternId=" + this.p + ", visionContents=" + Arrays.toString(this.q) + ", curDestContents=" + Arrays.toString(this.r) + ", notCurDestContents=" + Arrays.toString(this.s) + ", destParkingInfoData=" + this.t + ", parkingSpace=" + this.u + ", firstParkingSpaceList=" + this.v + ", tabPos=" + this.w + ", multiPos=" + this.x + ", poiPos=" + this.y + ", selected=" + this.z + ", height=" + this.A + ", poiPosition=" + this.B + '}';
    }

    private i a(StreetView streetView) {
        i iVar = new i();
        if (streetView != null) {
            iVar.b(streetView.getStreetViewUrl().toStringUtf8());
            iVar.a(streetView.getImageUrl().toStringUtf8());
            iVar.a(streetView.getImageType());
            Bundle b2 = o.b(streetView.getPoint().getX(), streetView.getPoint().getY());
            iVar.a(new com.baidu.nplatform.comapi.basestruct.c(b2.getInt("MCx"), b2.getInt("MCy")));
        }
        return iVar;
    }

    public String a() {
        return this.g;
    }

    public void a(int i) {
        this.B = i;
    }
}
