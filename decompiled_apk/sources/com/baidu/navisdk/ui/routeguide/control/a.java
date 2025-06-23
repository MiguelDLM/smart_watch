package com.baidu.navisdk.ui.routeguide.control;

import XIXIX.OOXIXo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.asr.a;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.l;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static a m;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<List<String>> f8526a;
    private List<String> b;
    private boolean c;
    public MutableLiveData<com.baidu.navisdk.ugc.eventdetails.model.d> h;
    public Observer<com.baidu.navisdk.ugc.eventdetails.model.d> i;
    public Observer<com.baidu.navisdk.ugc.eventdetails.model.d> j;
    public int d = 0;
    private final BNDynamicOverlay e = BNMapController.getDynamicOverlay();
    com.baidu.navisdk.ugc.report.data.datastatus.a f = new com.baidu.navisdk.ugc.report.data.datastatus.a();
    Bundle g = new Bundle();
    public com.baidu.navisdk.ugc.eventdetails.model.d k = new com.baidu.navisdk.ugc.eventdetails.model.d();
    private final Handler l = new HandlerC0437a();

    /* renamed from: com.baidu.navisdk.ui.routeguide.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0437a extends com.baidu.navisdk.util.worker.loop.b {
        public HandlerC0437a() {
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 1) {
                if (message.arg1 == 0) {
                    try {
                        JSONObject jSONObject = (JSONObject) ((com.baidu.navisdk.cmdrequest.j) message.obj).b;
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                        if (gVar.d()) {
                            gVar.e("UgcModule_Others", "handleMessage - msg:" + jSONObject.toString());
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("help_info");
                        if (optJSONObject != null) {
                            a.this.k.f8073a = optJSONObject.optString("show_copy");
                            a.this.k.b = optJSONObject.optString("broadcast_copy");
                            a.this.k.c = optJSONObject.optString("help_num");
                        } else {
                            com.baidu.navisdk.ugc.eventdetails.model.d dVar = a.this.k;
                            Resources resources = JarUtils.getResources();
                            int i = R.string.asr_rg_ugc_report_success;
                            dVar.f8073a = resources.getString(i);
                            a.this.k.b = JarUtils.getResources().getString(i);
                        }
                        a aVar = a.this;
                        aVar.h.setValue(aVar.k);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                com.baidu.navisdk.ugc.eventdetails.model.d dVar2 = a.this.k;
                if (dVar2 != null) {
                    Resources resources2 = JarUtils.getResources();
                    int i2 = R.string.asr_rg_ugc_report_success;
                    dVar2.f8073a = resources2.getString(i2);
                    a.this.k.b = JarUtils.getResources().getString(i2);
                    a aVar2 = a.this;
                    MutableLiveData<com.baidu.navisdk.ugc.eventdetails.model.d> mutableLiveData = aVar2.h;
                    if (mutableLiveData != null) {
                        mutableLiveData.setValue(aVar2.k);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements l.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8528a;
        final /* synthetic */ String b;

        public b(int i, String str) {
            this.f8528a = i;
            this.b = str;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i, l.i iVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_Others", "showUGCEventVerifyNotificationView - clickCloseIcon");
            }
            if (this.f8528a == 5015) {
                a.this.c(this.b, false);
            } else {
                a.this.a(5, this.b);
            }
            a.this.e();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i) {
            if (i == 0) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.e()) {
                    gVar.g("UgcModule_Others", "showUGCEventVerifyNotificationView - onConfirmBtnClick");
                }
                int i2 = this.f8528a;
                if (i2 == 5012 || i2 == 5015) {
                    a.this.c = true;
                    a.this.e();
                    if (this.f8528a == 5015) {
                        a.this.c(this.b, true);
                    } else {
                        a.this.a(false, false);
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "1", String.valueOf(this.f8528a));
                    return;
                }
                a.this.c = true;
                a.this.e();
                a aVar = a.this;
                aVar.a(aVar.a(true, this.f8528a), this.b);
                com.baidu.navisdk.ugc.replenishdetails.d.o().a(this.b);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "1", String.valueOf(this.f8528a));
                return;
            }
            if (i == 1) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar2.e()) {
                    gVar2.e("UgcModule_Others", "showUGCEventVerifyNotificationView - onCancelBtnClick");
                }
                int i3 = this.f8528a;
                if (i3 == 5012 || i3 == 5015) {
                    a.this.c = true;
                    a.this.e();
                    a.this.b(this.f8528a, this.b);
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "2", String.valueOf(this.f8528a));
                    return;
                }
                a.this.c = true;
                a.this.e();
                a aVar2 = a.this;
                aVar2.a(aVar2.a(false, this.f8528a), this.b);
                com.baidu.navisdk.ugc.replenishdetails.d.o().a(this.b);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "2", String.valueOf(this.f8528a));
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_Others", "showUGCEventVerifyNotificationView - onAutoHide");
            }
            a.this.c = false;
            if (this.f8528a == 5015) {
                a.this.c(this.b, false);
            } else {
                a.this.a(5, this.b);
            }
            a.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends g0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8529a;
        final /* synthetic */ int b;

        public c(int i, int i2) {
            this.f8529a = i;
            this.b = i2;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            if (!a.this.c) {
                a.this.c = true;
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "3", String.valueOf(this.f8529a));
            }
            if (a.this.e != null) {
                a.this.e.hideAll(BNDynamicOverlay.Key.NAVI_MAY_STOP_BUBBLE_LAYER);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            if (!a.this.c) {
                a.this.c = true;
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "3", String.valueOf(this.f8529a));
                com.baidu.navisdk.asr.d.B().c();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a(boolean z) {
            if (this.f8529a == 5015) {
                a.this.b(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Observer<com.baidu.navisdk.ugc.eventdetails.model.d> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.ugc.eventdetails.model.d dVar) {
            String str;
            String str2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "livedata : voice observer show and broadcast");
            }
            if (TextUtils.isEmpty(dVar.f8073a)) {
                str = JarUtils.getResources().getString(R.string.asr_rg_ugc_event_verify_success);
            } else {
                str = dVar.f8073a;
            }
            if (TextUtils.isEmpty(dVar.b)) {
                str2 = JarUtils.getResources().getString(R.string.asr_rg_ugc_event_verify_success);
            } else {
                str2 = dVar.b;
            }
            a.this.a(str, str2, true);
            a.this.h.removeObserver(this);
            a.this.h = null;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Observer<com.baidu.navisdk.ugc.eventdetails.model.d> {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.ugc.eventdetails.model.d dVar) {
            String str;
            String str2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "livedata : panel observer show and broadcast");
            }
            if (TextUtils.isEmpty(dVar.f8073a)) {
                str = JarUtils.getResources().getString(R.string.asr_rg_ugc_event_verify_success);
            } else {
                str = dVar.f8073a;
            }
            if (TextUtils.isEmpty(dVar.b)) {
                str2 = JarUtils.getResources().getString(R.string.asr_rg_ugc_event_verify_success);
            } else {
                str2 = dVar.b;
            }
            a.this.a(str, str2, false);
            a.this.h.removeObserver(this);
            a.this.h = null;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements l.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8532a;
        final /* synthetic */ String b;

        public f(int i, String str) {
            this.f8532a = i;
            this.b = str;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void b() {
            int i = this.f8532a;
            if (i == 5015) {
                a.this.a((String) null, this.b);
            } else if (i == 5012) {
                a.this.b((String) null, false);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("8.0.15.4", "1");
            s.T().c(2);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a(int i, l.i iVar) {
            String c = iVar.c();
            if (!TextUtils.isEmpty(c)) {
                int i2 = this.f8532a;
                if (i2 == 5012) {
                    a.this.b(c, false);
                    a.this.c(c);
                } else if (i2 == 5015) {
                    a.this.a(c, this.b);
                }
            }
            s.T().c(2);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
        public void a() {
            int i = this.f8532a;
            if (i == 5015) {
                a.this.a((String) null, this.b);
            } else if (i == 5012) {
                a.this.b((String) null, false);
            }
            s.T().c(2);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements g0.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8533a;

        public g(a aVar, int i) {
            this.f8533a = i;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "3", String.valueOf(this.f8533a));
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void d() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "3", String.valueOf(this.f8533a));
        }
    }

    /* loaded from: classes8.dex */
    public class h extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public h(a aVar, int i) {
            super(i);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "reason = " + str);
            }
            TTSPlayerControl.playXDTTSText(JarUtils.getResources().getString(R.string.asr_rg_ugc_report_fail), 0);
        }
    }

    /* loaded from: classes8.dex */
    public class i extends com.baidu.navisdk.asr.i.a {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        public i(int i, String str) {
            this.b = i;
            this.c = str;
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            String str2;
            super.a(str, z);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "showUGCEventVerifyNotificationView - voiceCallback-confirm, intention :" + str + ", result : " + z);
            }
            int i = this.b;
            if (i == 5012) {
                if (!z) {
                    a.this.b((String) null, true);
                }
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            } else {
                if (i == 5015) {
                    a.this.a(this.c, z);
                    com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                    return;
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.k.3", "2", null, null);
                a.this.c = true;
                s.T().p();
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                a.this.a(a.this.a(z, this.b), this.c);
                if (!z) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "2", str2, String.valueOf(this.b));
            }
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "showUGCEventVerifyNotificationView-voiceCallback-stop");
            }
            if (!a()) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("8.0.15.4", "0");
            }
            a.this.e();
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(boolean z, int i2) {
        return i2 == 5015 ? z ? 4 : 3 : z ? 3 : 4;
    }

    public static a d() {
        if (m == null) {
            m = new a();
        }
        return m;
    }

    private String e(int i2) {
        return i2 != 110 ? i2 != 127 ? i2 != 5012 ? i2 != 5015 ? "ugc_event_verify" : "ugc_doubt_break_verify" : "ugc_door_yaw_verify" : "ugc_verify_sample_without_ui" : "ugc_construct_verify";
    }

    private String f(int i2) {
        return i2 != 110 ? i2 != 5012 ? i2 != 5015 ? "ugc_event_verify" : "ugc_doubt_break_verify" : "ugc_door_yaw_verify" : "ugc_construct_verify";
    }

    private boolean g(int i2) {
        com.baidu.navisdk.ui.routeguide.ugc.d a2 = com.baidu.navisdk.ui.routeguide.ugc.d.a(com.baidu.navisdk.framework.a.c().a());
        for (Map.Entry<String, ?> entry : a2.a().entrySet()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "sharedpreference : key = " + entry.getKey() + " value = " + entry.getValue());
            }
        }
        return a2.b(a2.a(i2));
    }

    private void c(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_Others", "enterUgcEventVerify, params = " + i2);
        }
        try {
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(12, i2, bundle);
            int i3 = bundle.getInt("enUgcType");
            String string = bundle.getString("usEncodeUgcID");
            if (i2 == -1 && i3 == 5015 && bundle.containsKey("needPanel") && !bundle.getBoolean("needPanel")) {
                a(bundle);
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.0.15.3", String.valueOf(i3), string);
            } else {
                if (d().d != 1 || b(string) || l0.c(string) || i3 <= 0) {
                    return;
                }
                if (i3 == 127) {
                    if (com.baidu.navisdk.asr.d.B().o()) {
                        d(i2);
                        a(bundle.getString("enUgcVoiceText"), string, i3, (com.baidu.navisdk.ui.routeguide.mapmode.subview.l) null);
                        return;
                    }
                    return;
                }
                a(i3, string, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcModule_Others", e2.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.baidu.navisdk.asr.d.B().c();
        s.T().c(1);
    }

    private void f() {
        MutableLiveData<com.baidu.navisdk.ugc.eventdetails.model.d> mutableLiveData = new MutableLiveData<>();
        this.h = mutableLiveData;
        if (mutableLiveData.hasObservers()) {
            this.h.removeObserver(this.i);
            this.h.removeObserver(this.j);
        }
        this.i = new d();
        this.j = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, String str) {
        ArrayList arrayList = new ArrayList();
        if (i2 == 5012) {
            String string = JarUtils.getResources().getString(R.string.nsdk_ugc_internal_gate);
            String string2 = JarUtils.getResources().getString(R.string.nsdk_ugc_closed_gate);
            String string3 = JarUtils.getResources().getString(R.string.nsdk_ugc_unidirectional_gate);
            l.i iVar = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_internal_gate), null, string);
            l.i iVar2 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_closed_gate), null, string2);
            l.i iVar3 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_unidirectional_gate), null, string3);
            arrayList.add(iVar);
            arrayList.add(iVar2);
            arrayList.add(iVar3);
        } else if (i2 == 5015) {
            l.i iVar4 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_road_closed), null, "封路");
            l.i iVar5 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_type_default_road_build), null, "施工");
            l.i iVar6 = new l.i(JarUtils.getResources().getDrawable(R.drawable.nsdk_ugc_guanzhi_new), null, "管制");
            arrayList.add(iVar4);
            arrayList.add(iVar5);
            arrayList.add(iVar6);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.l a2 = x.b().a(new com.baidu.navisdk.ui.routeguide.model.e().a(true).c(2).a(arrayList).d(10000).b("请问造成不可通行的原因是？").a(new f(i2, str)));
        a2.a(new g(this, i2));
        if (!a2.y()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "showUGCEventVerifyNotificationView - secondPanel - show error!");
                return;
            }
            return;
        }
        TTSPlayerControl.playTTS("请问造成不可通行的原因是？", 1);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8", String.valueOf(i2), "2", null);
    }

    private void d(int i2) {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(12, i2, bundle);
        long j = bundle.getLong("nLinkID");
        double d2 = bundle.getDouble("gcjLongitude", -1.0d);
        double d3 = bundle.getDouble("gcjLatitude", -1.0d);
        double d4 = bundle.getDouble(RouteGuideParams.RGKey.AssistInfo.Speed, OOXIXo.f3760XO);
        Bundle b2 = com.baidu.navisdk.util.common.o.b(d2, d3);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "墨卡托坐标为：" + b2.getInt("MCx") + "," + b2.getInt("MCy"));
        }
        String str = b2.getInt("MCx") + "," + b2.getInt("MCy");
        String valueOf = String.valueOf(j);
        String valueOf2 = String.valueOf(d4);
        this.g.putString("yawLink", valueOf);
        this.g.putString("yawPoint", str);
        this.g.putString("yawSpeed", valueOf2);
        this.g.putString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, i2 == -1 ? "1" : "0");
    }

    public void a(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        if (i2 == 4) {
            c(i3);
        } else if (i2 != 5) {
            com.baidu.navisdk.ugc.replenishdetails.d.o().b(message);
        } else {
            a(4, i3);
        }
    }

    private void a(int i2, int i3) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "verify ugc_maybe_stop without window");
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(12, i3, bundle);
        String string = bundle.getString("usEncodeUgcID");
        double d2 = bundle.getDouble(RouteGuideParams.RGKey.AssistInfo.Speed);
        this.g.putString("eventId", string);
        this.g.putInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 2);
        this.g.putInt("voteType", i2);
        this.g.putInt("voteWay", 1);
        this.g.putString("yawSpeed", String.valueOf(d2));
        com.baidu.navisdk.ugc.eventdetails.control.d.a(this.g, this.l, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z) {
        if (this.g == null) {
            this.g = new Bundle();
        }
        this.g.putString("eventId", str);
        this.g.putInt("voteType", z ? 4 : 3);
        this.g.putInt("voteWay", !z ? 1 : 0);
        this.g.putInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 1);
        com.baidu.navisdk.ugc.eventdetails.control.d.a(this.g, this.l, 1);
    }

    private com.baidu.nplatform.comapi.basestruct.c c() {
        GeoPoint b2 = com.baidu.navisdk.util.logic.h.b();
        Bundle c2 = com.baidu.navisdk.util.common.o.c(b2.getLongitudeE6(), b2.getLatitudeE6());
        return new com.baidu.nplatform.comapi.basestruct.c(c2.getInt("MCx"), c2.getInt("MCy"));
    }

    private void a(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "ugc verify upload data without window");
        }
        Bundle bundle2 = new Bundle();
        long j = bundle.getLong("nLinkID");
        double d2 = bundle.getDouble("gcjLongitude", -1.0d);
        double d3 = bundle.getDouble("gcjLatitude", -1.0d);
        double d4 = bundle.getDouble(RouteGuideParams.RGKey.AssistInfo.Speed, OOXIXo.f3760XO);
        String string = bundle.getString("usEncodeUgcID");
        Bundle b2 = com.baidu.navisdk.util.common.o.b(d2, d3);
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "墨卡托坐标为：" + b2.getInt("MCx") + "," + b2.getInt("MCy"));
        }
        String str = b2.getInt("MCx") + "," + b2.getInt("MCy");
        String valueOf = String.valueOf(j);
        String valueOf2 = String.valueOf(d4);
        bundle2.putString("yawLink", valueOf);
        bundle2.putString("yawPoint", str);
        bundle2.putString("yawSpeed", valueOf2);
        bundle2.putString("eventId", string);
        bundle2.putInt("voteType", 3);
        bundle2.putInt("voteWay", 1);
        bundle2.putInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 1);
        com.baidu.navisdk.ugc.eventdetails.control.d.a(bundle2, this.l, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (JarUtils.getResources().getString(R.string.nsdk_ugc_internal_gate).equals(str)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "4", String.valueOf(5012));
        } else if (JarUtils.getResources().getString(R.string.nsdk_ugc_closed_gate).equals(str)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "5", String.valueOf(5012));
        } else if (JarUtils.getResources().getString(R.string.nsdk_ugc_unidirectional_gate).equals(str)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.8.1", "1", "6", String.valueOf(5012));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getUgcInfoById(i2, bundle);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "ugc info bundle =" + bundle);
        }
        String string = bundle.getString("bubbleTitle");
        int i3 = bundle.getInt("patternId");
        Bundle bundle2 = bundle.getBundle("point");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointArray");
        com.baidu.navisdk.model.datastruct.b a2 = new com.baidu.navisdk.model.datastruct.b().b(i3).a(string, "");
        if (bundle2 != null) {
            a2.a(new com.baidu.nplatform.comapi.basestruct.c(bundle2.getDouble("pointX"), bundle2.getDouble("pointY")));
        }
        com.baidu.navisdk.model.datastruct.b b2 = new com.baidu.navisdk.model.datastruct.b().b(1518);
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                b2.a(new com.baidu.nplatform.comapi.basestruct.c(((Bundle) parcelableArrayList.get(i4)).getDouble("x"), ((Bundle) parcelableArrayList.get(i4)).getDouble("y")));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        arrayList.add(b2);
        this.e.setDataSet(BNDynamicOverlay.Key.NAVI_MAY_STOP_BUBBLE_LAYER, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
        this.e.showAll(BNDynamicOverlay.Key.NAVI_MAY_STOP_BUBBLE_LAYER);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r18, java.lang.String r19, int r20) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.control.a.a(int, java.lang.String, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, boolean z) {
        if (this.f == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "asyncGateFeedbackData: gateUploadData == null");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        this.f.t = bundle.getString("session");
        this.f.g = JNITrajectoryControl.sInstance.getCurrentUUID();
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.f;
        aVar.h = str;
        aVar.e = 13;
        aVar.f = 204;
        if (z) {
            aVar.d = 30;
        } else {
            aVar.d = 1;
        }
        com.baidu.navisdk.ugc.https.e.a(aVar, (com.baidu.navisdk.ugc.https.c) new h(this, 2), false, 2);
    }

    public List<String> b() {
        WeakReference<List<String>> weakReference = this.f8526a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean b(String str) {
        List<String> b2 = b();
        if (!l0.c(str) && b2 != null && b2.size() > 0) {
            Iterator<String> it = b2.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                    if (!gVar.d()) {
                        return true;
                    }
                    gVar.e("UgcModule_Others", "containEventIdFromCache, return = true, eventId = " + str);
                    return true;
                }
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_Others", "containEventIdFromCache, return = false, eventId = " + str);
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar3.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("containEventIdFromCache, eventId = ");
            sb.append(str);
            sb.append(", list = ");
            sb.append(b2 == null ? "null" : Integer.valueOf(b2.size()));
            gVar3.e("UgcModule_Others", sb.toString());
        }
        return false;
    }

    private void a(int i2) {
        com.baidu.navisdk.ui.routeguide.ugc.d a2 = com.baidu.navisdk.ui.routeguide.ugc.d.a(com.baidu.navisdk.framework.a.c().a());
        if (i2 == 110 || i2 == 5015 || i2 == 5012) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Others", "type freq match and add record success");
            }
            a2.a(a2.a(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Bundle bundle = this.g;
        if (bundle == null) {
            return;
        }
        bundle.putString("eventId", str2);
        this.g.putInt("voteType", 3);
        this.g.putInt("voteWay", 0);
        this.g.putString("reason", str);
        this.g.putInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 1);
        com.baidu.navisdk.ugc.eventdetails.control.d.a(this.g, this.l, 1);
    }

    public void a(String str, String str2, int i2, com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.k.3", "1", null, null);
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        String f2 = f(i2);
        if (!com.baidu.navisdk.asr.query.a.a(a2).b(f2)) {
            if (i2 != 127) {
                TTSPlayerControl.playTTS(str, 1);
                return;
            }
            return;
        }
        if (lVar != null) {
            lVar.e0();
        }
        f();
        this.h.observeForever(this.i);
        com.baidu.navisdk.asr.query.a.a(a2).a(f2);
        if (i2 != 127) {
            a(str2, i2);
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.0.15.3", String.valueOf(i2), str2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("zid", com.baidu.navisdk.framework.b.F());
            jSONObject.put(MapItem.KEY_ITEM_SID, 1);
            jSONObject.put("event_id", str2);
            jSONObject.put("groupid", "0");
            jSONObject.put("sub_type", this.g.getString("reason"));
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, this.g.getInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE));
            jSONObject.put("action_speed", this.g.getString("yawSpeed"));
            jSONObject.put("yaw_point", this.g.getString("yawPoint"));
            jSONObject.put("yaw_linkid", this.g.getString("yawLink"));
            jSONObject.put(UserDataStore.STATE, String.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.put("vote_way", 0);
            jSONObject.put("business_trigger", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String a3 = com.baidu.navisdk.module.asr.c.a().b((Object) e(i2)).a(jSONObject).a(str).a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("VerifyVoiceUpload", a3);
        }
        com.baidu.navisdk.asr.d.B().a(new a.C0199a().c(true).e(true).a(str).b(a3).a());
    }

    private void a(String str, int i2) {
        com.baidu.navisdk.asr.d.B().a(new i(i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        String str;
        String string = JarUtils.getResources().getString(R.string.asr_rg_ugc_event_verify_success);
        if (z2) {
            TTSPlayerControl.playXDTTSText(string, 1);
        } else {
            TTSPlayerControl.playTTS(string, 1);
        }
        if (z) {
            str = JarUtils.getResources().getString(R.string.nsdk_string_ugc_event_verify_succeed);
        } else {
            str = "";
        }
        s.T().d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z) {
        if (z) {
            TTSPlayerControl.playXDTTSText(str2, 1);
        } else {
            TTSPlayerControl.playTTS(str2, 1);
        }
        s.T().e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "asyncRCEventFeedback - voteType=" + i2 + ", eventId=" + str);
        }
        com.baidu.navisdk.ugc.eventdetails.control.d.a(str, i2, this.l, 1, 0);
    }

    public void a(String str, boolean z) {
        if (this.g == null) {
            this.g = new Bundle();
        }
        this.g.putString("eventId", str);
        this.g.putInt("voteType", z ? 4 : 3);
        this.g.putInt("voteWay", 0);
        this.g.putInt(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, 1);
        com.baidu.navisdk.ugc.eventdetails.control.d.a(this.g, this.l, 1);
    }

    public void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Others", "addUgcEventId - eventId = " + str);
        }
        if (this.f8526a == null || this.b == null) {
            this.b = new ArrayList();
            this.f8526a = new WeakReference<>(this.b);
        }
        this.b.add(str);
    }

    public void a() {
        m = null;
        this.b = null;
        this.f8526a = null;
        this.d = 0;
        this.g = null;
        this.f = null;
        this.j = null;
        this.i = null;
        this.k = null;
    }
}
