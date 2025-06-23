package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.os.Bundle;
import com.baidu.entity.pb.action_t;
import com.baidu.entity.pb.explain_bubble_t;
import com.baidu.entity.pb.yellow_tips_list_t;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes8.dex */
public final class g {

    @OOXIXo
    public static final a P = new a(null);

    @oOoXoXO
    private String A;

    @oOoXoXO
    private String B;
    private int C;
    private int D;

    @oOoXoXO
    private String E;

    @oOoXoXO
    private String F;

    @oOoXoXO
    private String G;

    @oOoXoXO
    private List<String> H;

    @oOoXoXO
    private com.baidu.navisdk.yellowtipdata.model.data.a I;

    @oOoXoXO
    private com.baidu.navisdk.yellowtipdata.model.data.a J;

    @oOoXoXO
    private com.baidu.navisdk.yellowtipdata.model.data.a K;
    private int L;

    @oOoXoXO
    private String M;

    @oOoXoXO
    private String N;

    @oOoXoXO
    private List<String> O;

    @oOoXoXO
    private String c;

    @oOoXoXO
    private String d;

    @oOoXoXO
    private String e;

    @oOoXoXO
    private String f;

    @oOoXoXO
    private String g;
    private boolean h;

    @oOoXoXO
    private String j;
    private boolean m;

    @oOoXoXO
    private String o;

    @oOoXoXO
    private List<com.baidu.navisdk.yellowtipdata.model.data.b> p;
    private boolean q;
    private int s;
    private int t;

    @oOoXoXO
    private String u;

    @oOoXoXO
    private List<String> w;

    @oOoXoXO
    private List<String> x;
    private int y;

    @oOoXoXO
    private com.baidu.nplatform.comapi.basestruct.c z;

    /* renamed from: a, reason: collision with root package name */
    private int f9466a = -1;
    private int b = -1;
    private int i = -1;
    private int k = -1;
    private int l = -1;
    private int n = -1;
    private int r = -1;

    @OOXIXo
    private final X0IIOO v = XIxXXX0x0.oIX0oI(new b());

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        @oOoXoXO
        public final g a(@oOoXoXO yellow_tips_list_t yellow_tips_list_tVar) {
            if (yellow_tips_list_tVar == null) {
                return null;
            }
            try {
                g gVar = new g();
                gVar.p(yellow_tips_list_tVar.getTitle().toString("GBK"));
                gVar.m(yellow_tips_list_tVar.hasSubTitle() ? yellow_tips_list_tVar.getSubTitle().toString("GBK") : "");
                gVar.h(yellow_tips_list_tVar.hasExpalnTitle() ? yellow_tips_list_tVar.getExpalnTitle().toString("GBK") : "");
                gVar.a(yellow_tips_list_tVar.hasAssistInfo() ? yellow_tips_list_tVar.getAssistInfo().toString("GBK") : "");
                gVar.d(yellow_tips_list_tVar.getTipId());
                gVar.c(yellow_tips_list_tVar.hasIconId() ? yellow_tips_list_tVar.getIconId() : -1);
                gVar.a(yellow_tips_list_tVar.hasBackColorId() ? yellow_tips_list_tVar.getBackColorId() : -1);
                gVar.l(yellow_tips_list_tVar.hasPermitInfoId() ? yellow_tips_list_tVar.getPermitInfoId().toString("GBK") : "");
                ArrayList arrayList = new ArrayList();
                int endBtnCount = yellow_tips_list_tVar.getEndBtnCount();
                for (int i = 0; i < endBtnCount; i++) {
                    com.baidu.navisdk.yellowtipdata.model.data.b a2 = com.baidu.navisdk.yellowtipdata.model.data.b.f.a(yellow_tips_list_tVar.getEndBtn(i));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                gVar.c(arrayList);
                gVar.i(yellow_tips_list_tVar.getRoadNo());
                gVar.b(yellow_tips_list_tVar.getDisplayPos());
                gVar.f(yellow_tips_list_tVar.getJumpFlag() ? 1 : 0);
                gVar.h(yellow_tips_list_tVar.getPanelFlag() ? 1 : 0);
                gVar.f(yellow_tips_list_tVar.getEventId() == 0 ? "" : JNIGuidanceControl.getInstance().uidCodecEncode(yellow_tips_list_tVar.getEventId()));
                if (yellow_tips_list_tVar.getImageUrlCount() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    int imageUrlCount = yellow_tips_list_tVar.getImageUrlCount();
                    for (int i2 = 0; i2 < imageUrlCount; i2++) {
                        String byteStringMicro = yellow_tips_list_tVar.getImageUrl(i2).toString("GBK");
                        IIX0o.oO(byteStringMicro, "info.getImageUrl(i).toString(\"GBK\")");
                        arrayList2.add(byteStringMicro);
                    }
                    gVar.a(arrayList2);
                }
                if (yellow_tips_list_tVar.getCopyWritingsCount() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    int copyWritingsCount = yellow_tips_list_tVar.getCopyWritingsCount();
                    for (int i3 = 0; i3 < copyWritingsCount; i3++) {
                        String byteStringMicro2 = yellow_tips_list_tVar.getCopyWritings(i3).toString("GBK");
                        IIX0o.oO(byteStringMicro2, "info.getCopyWritings(i).toString(\"GBK\")");
                        arrayList3.add(byteStringMicro2);
                    }
                    gVar.b(arrayList3);
                }
                gVar.g(yellow_tips_list_tVar.getNewPattern() ? 1 : 0);
                gVar.g(yellow_tips_list_tVar.hasExplainSubTitle() ? yellow_tips_list_tVar.getExplainSubTitle().toString("GBK") : "");
                if (yellow_tips_list_tVar.getExplainBubble() != null) {
                    explain_bubble_t explainBubble = yellow_tips_list_tVar.getExplainBubble();
                    IIX0o.oO(explainBubble, "info.explainBubble");
                    gVar.b(explainBubble.getContent().toString("GBK"));
                    explain_bubble_t explainBubble2 = yellow_tips_list_tVar.getExplainBubble();
                    IIX0o.oO(explainBubble2, "info.explainBubble");
                    gVar.c(explainBubble2.getSubContent().toString("GBK"));
                    explain_bubble_t explainBubble3 = yellow_tips_list_tVar.getExplainBubble();
                    IIX0o.oO(explainBubble3, "info.explainBubble");
                    if (explainBubble3.getPoint() != null) {
                        gVar.a(new com.baidu.nplatform.comapi.basestruct.c(r0.getX(), r0.getY()));
                    }
                }
                gVar.k(yellow_tips_list_tVar.getTipsType());
                gVar.n(yellow_tips_list_tVar.hasTag() ? yellow_tips_list_tVar.getTag().toString("GBK") : "");
                gVar.o(yellow_tips_list_tVar.hasTagInfo() ? yellow_tips_list_tVar.getTagInfo().toString("GBK") : "");
                gVar.i(yellow_tips_list_tVar.hasFirstLine() ? yellow_tips_list_tVar.getFirstLine().toString("GBK") : "");
                if (yellow_tips_list_tVar.getSecondLineCount() > 0) {
                    ArrayList arrayList4 = new ArrayList();
                    int secondLineCount = yellow_tips_list_tVar.getSecondLineCount();
                    for (int i4 = 0; i4 < secondLineCount; i4++) {
                        String byteStringMicro3 = yellow_tips_list_tVar.getSecondLine(i4).toString("GBK");
                        IIX0o.oO(byteStringMicro3, "info.getSecondLine(i).toString(\"GBK\")");
                        arrayList4.add(byteStringMicro3);
                    }
                    gVar.d(arrayList4);
                }
                gVar.a(a(yellow_tips_list_tVar.getButtonAction()));
                gVar.b(a(yellow_tips_list_tVar.getMainAction()));
                gVar.c(a(yellow_tips_list_tVar.getLittleAction()));
                gVar.a(yellow_tips_list_tVar.getRoutePreviewOff());
                gVar.j(yellow_tips_list_tVar.getRouteTagOff() ? 1 : 0);
                gVar.e(yellow_tips_list_tVar.hasCityId() ? yellow_tips_list_tVar.getCityId().toString("GBK") : "");
                gVar.d(yellow_tips_list_tVar.hasCarlimitInfoId() ? yellow_tips_list_tVar.getCarlimitInfoId().toString("GBK") : "");
                if (yellow_tips_list_tVar.getTrafficLimitInfoIdCount() > 0) {
                    ArrayList arrayList5 = new ArrayList();
                    int trafficLimitInfoIdCount = yellow_tips_list_tVar.getTrafficLimitInfoIdCount();
                    for (int i5 = 0; i5 < trafficLimitInfoIdCount; i5++) {
                        String byteStringMicro4 = yellow_tips_list_tVar.getTrafficLimitInfoId(i5).toString("GBK");
                        IIX0o.oO(byteStringMicro4, "info.getTrafficLimitInfoId(i).toString(\"GBK\")");
                        arrayList5.add(byteStringMicro4);
                    }
                    gVar.e(arrayList5);
                }
                gVar.e(yellow_tips_list_tVar.getIdssCardId());
                gVar.l(yellow_tips_list_tVar.getUiType());
                gVar.k(yellow_tips_list_tVar.hasGifUrl() ? yellow_tips_list_tVar.getGifUrl().toString("GBK") : "");
                gVar.j(yellow_tips_list_tVar.hasGifUrlDark() ? yellow_tips_list_tVar.getGifUrlDark().toString("GBK") : "");
                return gVar;
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("YellowTipInfo", "parse --> e = " + e);
                }
                return null;
            }
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        private final com.baidu.navisdk.yellowtipdata.model.data.a a(action_t action_tVar) {
            if (action_tVar != null) {
                try {
                    int key = action_tVar.getKey();
                    String byteStringMicro = action_tVar.getValue().toString("GBK");
                    IIX0o.oO(byteStringMicro, "action.value.toString(\"GBK\")");
                    String byteStringMicro2 = action_tVar.getText().toString("GBK");
                    IIX0o.oO(byteStringMicro2, "action.text.toString(\"GBK\")");
                    return new com.baidu.navisdk.yellowtipdata.model.data.a(key, byteStringMicro, byteStringMicro2);
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("YellowTipInfo", "parseAction --> e = " + e);
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements oIX0oI<Integer> {
        public b() {
            super(0);
        }

        @Override // Oox.oIX0oI
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            String f = g.this.f();
            if (f == null || f.length() == 0) {
                return 0;
            }
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().checkUgcEvent(g.this.f(), bundle);
            if (bundle.getBoolean("isEventExist", false)) {
                return bundle.getInt("eventType", 0);
            }
            return 0;
        }
    }

    public final void a(boolean z) {
    }

    public final int b() {
        return this.n;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final void d(int i) {
        this.f9466a = i;
    }

    public final void e(int i) {
    }

    @oOoXoXO
    public final String f() {
        return this.u;
    }

    public final int g() {
        return ((Number) this.v.getValue()).intValue();
    }

    public final void h(@oOoXoXO String str) {
        this.e = str;
    }

    public final int i() {
        return this.f9466a;
    }

    public final void j(@oOoXoXO String str) {
    }

    public final void k(@oOoXoXO String str) {
    }

    public final void l(int i) {
    }

    @oOoXoXO
    public final String m() {
        return this.d;
    }

    @oOoXoXO
    public final String n() {
        return this.E;
    }

    @oOoXoXO
    public final String o() {
        return this.c;
    }

    public final void p(@oOoXoXO String str) {
        this.c = str;
    }

    public final boolean q() {
        if (this.t == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return "RouteCarYBannerInfo{tipType=" + this.f9466a + ", subType=" + this.b + ", title='" + this.c + "', subTitle='" + this.d + "', explainTitle='" + this.e + "', explainSubTitle='" + this.f + "', assistInfo='" + this.g + "', isUseLocalIcon=" + this.h + ", iconId=" + this.i + ", iconPath='" + this.j + "', style=" + this.k + ", priority=" + this.l + ", isShow=" + this.m + ", backGroundId=" + this.n + ", permitInfoId='" + this.o + "', list=" + this.p + ", flag=" + this.q + ", roadNo=" + this.r + ", jumpFlag=" + this.s + ", panelFlag=" + this.t + ", eventID='" + this.u + "', imageUrlList=" + this.w + ", labelList=" + this.x + ", newPattern=" + this.y + ", bubblePoint=" + this.z + ", bubbleContent='" + this.A + "', bubbleSubContent='" + this.B + "', displayPos=" + this.C + ", tipsType=" + this.D + ", tag='" + this.E + "', tagInfo='" + this.F + "', firstLine='" + this.G + "', secondLines=" + this.H + ", mainLabelAction=" + this.I + ", subLabelAction=" + this.J + ", btnAction=" + this.K + ", routeTagOff=" + this.L + ", cityId=" + this.M + ", carLimitInfoId=" + this.N + ", trafficLimitInfoIds=" + this.O + '}';
    }

    @oOoXoXO
    public final String a() {
        return this.g;
    }

    public final void b(@oOoXoXO String str) {
        this.A = str;
    }

    public final void c(@oOoXoXO List<com.baidu.navisdk.yellowtipdata.model.data.b> list) {
        this.p = list;
    }

    public final void d(@oOoXoXO List<String> list) {
        this.H = list;
    }

    @oOoXoXO
    public final String e() {
        return this.M;
    }

    public final void f(@oOoXoXO String str) {
        this.u = str;
    }

    public final void g(@oOoXoXO String str) {
        this.f = str;
    }

    public final int h() {
        return this.i;
    }

    public final void i(int i) {
        this.r = i;
    }

    @oOoXoXO
    public final List<com.baidu.navisdk.yellowtipdata.model.data.b> j() {
        return this.p;
    }

    @oOoXoXO
    public final String k() {
        return this.o;
    }

    public final void l(@oOoXoXO String str) {
        this.o = str;
    }

    public final void m(@oOoXoXO String str) {
        this.d = str;
    }

    public final void n(@oOoXoXO String str) {
        this.E = str;
    }

    public final void o(@oOoXoXO String str) {
        this.F = str;
    }

    public final boolean p() {
        return this.s == 1;
    }

    public final void a(@oOoXoXO String str) {
        this.g = str;
    }

    public final void b(int i) {
        this.C = i;
    }

    public final void c(@oOoXoXO String str) {
        this.B = str;
    }

    @oOoXoXO
    public final String d() {
        return this.N;
    }

    public final void e(@oOoXoXO String str) {
        this.M = str;
    }

    public final void f(int i) {
        this.s = i;
    }

    public final void g(int i) {
        this.y = i;
    }

    public final void h(int i) {
        this.t = i;
    }

    public final void i(@oOoXoXO String str) {
        this.G = str;
    }

    public final void j(int i) {
        this.L = i;
    }

    public final void k(int i) {
        this.D = i;
    }

    public final int l() {
        return this.r;
    }

    public final void a(int i) {
        this.n = i;
    }

    public final void b(@oOoXoXO com.baidu.navisdk.yellowtipdata.model.data.a aVar) {
        this.I = aVar;
    }

    public final void c(@oOoXoXO com.baidu.navisdk.yellowtipdata.model.data.a aVar) {
        this.J = aVar;
    }

    public final void d(@oOoXoXO String str) {
        this.N = str;
    }

    public final void e(@oOoXoXO List<String> list) {
        this.O = list;
    }

    public final void a(@oOoXoXO List<String> list) {
        this.w = list;
    }

    public final void b(@oOoXoXO List<String> list) {
        this.x = list;
    }

    @oOoXoXO
    public final com.baidu.navisdk.yellowtipdata.model.data.a c() {
        return this.K;
    }

    public final void a(@oOoXoXO com.baidu.nplatform.comapi.basestruct.c cVar) {
        this.z = cVar;
    }

    public final void a(@oOoXoXO com.baidu.navisdk.yellowtipdata.model.data.a aVar) {
        this.K = aVar;
    }
}
