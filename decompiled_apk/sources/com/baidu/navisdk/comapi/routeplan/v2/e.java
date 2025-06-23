package com.baidu.navisdk.comapi.routeplan.v2;

import XXO0.oIX0oI;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.mapframework.common.mapview.MapInfoProvider;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.e;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.j;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanTime;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.g0;
import com.baidu.navisdk.util.common.k0;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.statistic.q;
import com.baidu.navisdk.util.statistic.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.qq.e.comm.constants.ErrorCode;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class e extends com.baidu.navisdk.comapi.base.a {
    protected static int p = -1;
    private static boolean q = false;
    public static boolean r = false;
    protected int h;
    public boolean i;
    protected com.baidu.navisdk.comapi.routeplan.b o;

    /* renamed from: a, reason: collision with root package name */
    protected final Object f6729a = new Object();
    protected JNIGuidanceControl b = null;
    protected f c = null;
    protected k0 d = new k0();
    protected int e = -1;
    protected int f = -1;
    private int g = 0;
    private d j = null;
    public Map<Integer, d> k = new HashMap();
    private final List<a> l = new ArrayList();
    protected int m = 1;
    protected int n = 0;

    private boolean l(int i) {
        return i == 2 || i == 41;
    }

    private boolean m(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    private void o() {
        int c = c();
        if (c != 0 && 2 != c) {
            if (1 == c || 3 == c) {
                g0.g().a(true);
                return;
            }
            return;
        }
        g0.g().a(g0.g().e());
    }

    private RoutePlanTime p() {
        return g0.g().c();
    }

    private Pair<RoutePlanTime, RoutePlanTime> q() {
        return g0.g().d();
    }

    public void a(com.baidu.navisdk.comapi.routeplan.b bVar) {
        this.o = bVar;
    }

    public void b(a aVar) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("unRegisterRoutePlanListener --> listenerName = ");
            sb.append(aVar == null ? "" : aVar.getName());
            sb.append(", listener = ");
            sb.append(aVar);
            LogUtil.e("BNRoutePlanV2", sb.toString());
            LogUtil.printList("BNRoutePlanV2", "unRegisterRoutePlanListener", "mListenersV2", this.l);
        }
        if (aVar != null) {
            synchronized (this.l) {
                this.l.remove(aVar);
            }
        }
        if (aVar == null || !this.l.contains(aVar)) {
            return;
        }
        synchronized (this.l) {
            this.l.remove(aVar);
        }
    }

    public d c(int i) {
        if (this.k.containsKey(Integer.valueOf(i))) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "getSession() found. rid=" + i);
            }
            return this.k.get(Integer.valueOf(i));
        }
        if (!LogUtil.LOGGABLE) {
            return null;
        }
        LogUtil.e("BNRoutePlanV2", "getSession() not found. rid=" + i);
        return null;
    }

    public boolean d(int i) {
        if (this.k.containsKey(Integer.valueOf(i))) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "removeRequestCache() found. rid=" + i + ", mapSize=" + this.k.size());
            }
            synchronized (this.k) {
                this.k.remove(Integer.valueOf(i));
            }
            return true;
        }
        if (!LogUtil.LOGGABLE) {
            return false;
        }
        LogUtil.e("BNRoutePlanV2", "removeRequestCache() not found. rid=" + i + ", mapSize=" + this.k.size());
        return false;
    }

    public void e(int i) {
        d dVar = this.j;
        if (dVar != null) {
            dVar.e = i;
            g(i);
        }
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl != null) {
            jNIGuidanceControl.SetCalcRouteNetMode(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "SetCalcRouteNetMode netmode:" + i);
            }
        }
        b(false);
    }

    public b f() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    public void g(int i) {
        if (this.j != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "setEngineCalcRouteNetMode=" + i + ", old=" + this.j.f);
            }
            this.j.f = i;
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "setEngineCalcRouteNetMode=" + i + ", but session is null!!!");
        }
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(int i) {
        if (this.j != null) {
            LogUtil.e("BNRoutePlanV2", "setOnToOffNetworkMode=" + i + ", old=" + this.j.g);
            this.j.g = i;
            return;
        }
        LogUtil.e("BNRoutePlanV2", "setOnToOffNetworkMode=" + i + ", but session is null!!!");
    }

    public void j(int i) {
        if (this.b != null) {
            LogUtil.e("BNRoutePlanV2", "triggerGPSStatus (2739): eGPSStatus --> " + i);
            this.b.TriggerGPSStatus(i);
        }
    }

    public boolean k(int i) {
        if (this.b != null && com.baidu.navisdk.module.init.a.a()) {
            try {
                return this.b.TriggerNetStatusChange(i);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void n() {
        boolean z;
        k k = com.baidu.navisdk.framework.interfaces.c.p().k();
        Bundle bundle = new Bundle();
        if (k != null && k.j0()) {
            z = true;
        } else {
            z = false;
        }
        bundle.putBoolean("bRedBlueLight", z);
        JNIGuidanceControl.getInstance().setTracfficLightSwitch(bundle);
    }

    public void a(a aVar) {
        a(aVar, false);
    }

    public f h() {
        return (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
    }

    public int l() {
        d dVar = this.j;
        if (dVar != null && dVar.e() != null) {
            return this.j.e().k();
        }
        return this.n;
    }

    public int m() {
        d dVar = this.j;
        if (dVar != null && dVar.e() != null) {
            return this.j.e().m();
        }
        return this.m;
    }

    public void a(a aVar, boolean z) {
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("registerRoutePlanListener --> listenerName = ");
            sb.append(aVar == null ? "" : aVar.getName());
            sb.append(", listener = ");
            sb.append(aVar);
            sb.append(", isNaving = ");
            sb.append(z);
            LogUtil.e("BNRoutePlanV2", sb.toString());
        }
        if (aVar != null) {
            synchronized (this.l) {
                try {
                    g gVar = g.ROUTE_PLAN;
                    if (gVar.d()) {
                        gVar.a("BNRoutePlanV2", "registerRoutePlanListener", "mListenersV2", this.l);
                    }
                    if (!this.l.contains(aVar)) {
                        if (z) {
                            this.l.add(0, aVar);
                        } else {
                            this.l.add(aVar);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void f(int i) {
        this.h = i;
    }

    public String k() {
        Bundle bundle;
        d dVar = this.j;
        if (dVar == null || dVar.e() == null || (bundle = this.j.e().r) == null) {
            return null;
        }
        return bundle.getString("speech_id", null);
    }

    public int j() {
        d dVar = this.j;
        if (dVar == null || dVar.e() == null) {
            return -1;
        }
        return this.j.e().g;
    }

    public int i() {
        f fVar = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            return fVar.f();
        }
        return 0;
    }

    private void c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        RoutePlanTime p2 = p();
        Pair<RoutePlanTime, RoutePlanTime> q2 = q();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "putCalcTimeIntoExtraBundle --> curTime = " + p2 + ", startAndEndTime = " + q2);
        }
        if (p2 != null) {
            bundle.putBundle("curTimeBundle", p2.toBundle());
        }
        if (q2 != null) {
            RoutePlanTime routePlanTime = q2.first;
            if (routePlanTime != null) {
                bundle.putBundle("startTimeBundle", routePlanTime.toBundle());
            }
            RoutePlanTime routePlanTime2 = q2.second;
            if (routePlanTime2 != null) {
                bundle.putBundle("endTimeBundle", routePlanTime2.toBundle());
            }
        }
    }

    public d g() {
        return this.j;
    }

    public int d() {
        return this.h;
    }

    public int e() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.d();
        }
        return 3;
    }

    private void b(d dVar, int i) {
        if (i == 3 || i == 4) {
            dVar.b(1);
            return;
        }
        if (i == 2) {
            dVar.b(2);
            return;
        }
        if (i == 1) {
            dVar.b(0);
        } else {
            if (i != 5 || dVar.c() == 2) {
                return;
            }
            dVar.b(3);
        }
    }

    public boolean a(d dVar, int i, int i2) {
        boolean z;
        a(i, i2);
        if (a(dVar, i)) {
            d(dVar.f6728a);
        }
        if (LogUtil.LOGGABLE) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("rp.dispatchMessage() ");
            if (dVar == null) {
                stringBuffer.append("session=null.");
            } else {
                stringBuffer.append("sessionid=" + dVar.f6728a);
                if (dVar.e() == null) {
                    stringBuffer.append(", request=null.");
                } else {
                    stringBuffer.append(", requestid=" + dVar.e().s);
                }
            }
            stringBuffer.append(",resultType=" + i);
            stringBuffer.append(",subType=" + i2);
            LogUtil.e("BNRoutePlanV2", stringBuffer.toString());
        }
        if (dVar != null && dVar.e() != null && dVar.e().p != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() single. rid=" + dVar.e().s + ", rtype=" + i + ", stype=" + i2 + ", lisName=" + dVar.e().p.getName());
            }
            dVar.e().p.notifyRoutePlanMsg(i, i2, dVar, dVar.e().r);
            z = true;
        } else {
            if (m(i) && (dVar == null || dVar.f6728a != 0)) {
                LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() cacheSession not found.");
            } else {
                synchronized (this.k) {
                }
                for (d dVar2 : new HashMap(this.k).values()) {
                    if (dVar2 != null && dVar2.e() != null && dVar2.e().p != null) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() cacheSession. rid=" + dVar2.e().s + ", rtype=" + i + ", stype=" + i2 + ", lisName=" + dVar2.e().p.getName());
                        }
                        dVar2.e().p.notifyRoutePlanMsg(i, i2, dVar, null);
                    }
                }
            }
            z = false;
        }
        ArrayList<a> arrayList = new ArrayList();
        synchronized (this.l) {
            arrayList.addAll(this.l);
        }
        for (a aVar : arrayList) {
            if (aVar != null && (!z || aVar.isPersist())) {
                aVar.notifyRoutePlanMsg(i, i2, dVar, (dVar == null || dVar.e() == null) ? null : dVar.e().r);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() all. rtype=" + i + ", stype=" + i2 + ", lisName=" + aVar.getName() + ", listenerV2 = " + aVar);
                }
            }
        }
        if (dVar != null) {
            b(dVar, i);
        }
        return z;
    }

    public int c() {
        d dVar = this.j;
        if (dVar != null) {
            return dVar.b();
        }
        return 3;
    }

    public int b(int i) {
        int i2;
        return (i <= 0 || i != this.f || (i2 = p) <= 0) ? i : i2;
    }

    public int b(Bundle bundle) {
        if (bundle == null) {
            return -2;
        }
        try {
            boolean u = com.baidu.navisdk.module.abtest.model.d.u();
            bundle.putBoolean("commute_ab_test_category", u);
            return u ? 1 : 0;
        } catch (Exception unused) {
            bundle.putBoolean("commute_ab_test_category", true);
            return -1;
        } catch (Throwable th) {
            bundle.putBoolean("commute_ab_test_category", true);
            throw th;
        }
    }

    public void b(boolean z) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            return;
        }
        jNIGuidanceControl.SetRouteSpec(z);
    }

    private boolean b(ArrayList<RoutePlanNode> arrayList) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "setDestsPosV2 --> mGuidanceControl = " + this.b + "\n       array = " + arrayList);
        }
        LogUtil.out("BNRoutePlanV2", "setDestsPosV2 --> mGuidanceControl = " + this.b + "\n       array = " + arrayList);
        if (this.b == null || arrayList == null || arrayList.size() == 0) {
            return false;
        }
        return this.b.setSdkDestPosNav(arrayList);
    }

    public int b() {
        d dVar = this.j;
        if (dVar != null && dVar.e() != null) {
            return this.j.e().d;
        }
        com.baidu.navisdk.comapi.routeplan.b bVar = this.o;
        if (bVar != null) {
            return bVar.b(this.m);
        }
        return 0;
    }

    private void a(int i, int i2) {
        String str;
        if (i == 18) {
            str = "算路二片成功";
        } else if (i == 49) {
            str = "算路多结果成功";
        } else if (i == 65) {
            str = "行中偏航成功";
        } else if (i == 67) {
            str = "行前偏航成功";
        } else if (i == 145) {
            str = "同步操作";
        } else if (i == 81) {
            str = "路况更新成功";
        } else if (i == 82) {
            str = "路况更新失败";
        } else if (i == 177) {
            str = "天气数据更新成功";
        } else if (i == 178) {
            str = "天气数据更新失败";
        } else if (i == 1) {
            str = "算路开始";
        } else if (i == 2) {
            str = "算路一片成功";
        } else if (i == 3) {
            str = "算路失败（上层）";
        } else if (i != 4) {
            switch (i) {
                case 4097:
                    str = "算路一片pb解析成功";
                    break;
                case 4098:
                    str = "算路一片pb解析失败";
                    break;
                case 4099:
                    str = "算路二片pb解析成功";
                    break;
                case 4100:
                    str = "算路二片pb解析失败";
                    break;
                case 4101:
                    str = "行中偏航pb解析成功";
                    break;
                case 4102:
                    str = "行中偏航pb解析失败";
                    break;
                case 4103:
                    str = "行前偏航pb解析成功";
                    break;
                case 4104:
                    str = "行前偏航pb解析失败";
                    break;
                default:
                    switch (i) {
                        case 4107:
                            str = "算路多结果pb解析成功";
                            break;
                        case 4108:
                            str = "算路多结果pb解析失败";
                            break;
                        case 4109:
                            str = "天气pb解析成功";
                            break;
                        case 4110:
                            str = "天气pb解析失败";
                            break;
                        default:
                            str = String.valueOf(i);
                            break;
                    }
            }
        } else {
            str = "算路失败（引擎/服务）";
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("20.0.2.10", str, String.valueOf(i2));
    }

    private boolean a(d dVar, int i) {
        if (dVar == null) {
            return false;
        }
        if (dVar.e() != null && i != 18 && i != 19 && i != 49 && i != 97 && i != 98) {
            if (i != 2) {
                if (i == 3 || i == 4 || i == 5) {
                }
            } else if (dVar.e().g == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean a(Handler handler) {
        d dVar;
        boolean z = false;
        if (handler == null) {
            LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() removeRequestByHandler, return for handler=null");
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() removeRequestByHandler, handler=" + handler.hashCode());
        }
        if (!j.d() && (dVar = this.j) != null && dVar.e() != null && this.j.e().q != null && this.j.e().q == handler) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() remove mProcessingSession ");
            }
            this.j.e().p = null;
            this.j.e().q = null;
            z = true;
        }
        synchronized (this.k) {
        }
        for (d dVar2 : new HashMap(this.k).values()) {
            if (dVar2 != null && dVar2.e() != null && dVar2.e().q != null && dVar2.e().q == handler) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNRoutePlanV2", "rp.dispatchMessage() remove map. id=" + dVar2.f6728a);
                }
                dVar2.e().p = null;
                dVar2.e().q = null;
                d(dVar2.f6728a);
                z = true;
            }
        }
        return z;
    }

    public boolean a(@NonNull b bVar) {
        return a(bVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02bd A[Catch: all -> 0x000d, TryCatch #3 {all -> 0x000d, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0010, B:9:0x0028, B:11:0x0030, B:12:0x0037, B:15:0x0049, B:16:0x0071, B:18:0x0075, B:19:0x0078, B:21:0x0082, B:23:0x008c, B:25:0x0096, B:29:0x00a2, B:32:0x00a8, B:36:0x00be, B:34:0x00d5, B:39:0x00cb, B:41:0x00cf, B:43:0x00dc, B:45:0x0112, B:47:0x0118, B:49:0x0121, B:51:0x0133, B:52:0x0137, B:55:0x0139, B:57:0x013d, B:59:0x014b, B:60:0x015b, B:64:0x0154, B:66:0x0158, B:67:0x015d, B:70:0x0167, B:72:0x017d, B:74:0x0187, B:75:0x01a2, B:77:0x01a4, B:79:0x01a8, B:81:0x01b9, B:83:0x01cf, B:84:0x01d4, B:87:0x01da, B:88:0x01ee, B:92:0x0218, B:96:0x0231, B:97:0x0244, B:99:0x026a, B:100:0x0284, B:104:0x02b4, B:106:0x02bd, B:107:0x02c4, B:111:0x02d0, B:113:0x02d9, B:114:0x02dc, B:116:0x02e8, B:119:0x02f7, B:121:0x0305, B:123:0x031d, B:124:0x032b, B:126:0x032d, B:128:0x033d, B:130:0x034b, B:132:0x0351, B:135:0x0353, B:137:0x035b, B:138:0x0363, B:141:0x0369, B:143:0x037f, B:144:0x0392, B:146:0x0398, B:148:0x039e, B:149:0x03a1, B:151:0x03a6, B:153:0x03d2, B:155:0x03f5, B:156:0x0429, B:159:0x042f, B:160:0x0451, B:162:0x0457, B:163:0x0463, B:165:0x0465, B:166:0x0467, B:170:0x0478, B:173:0x047e, B:174:0x04a4, B:179:0x04a8, B:181:0x0385, B:183:0x038f, B:185:0x04a9, B:187:0x04b9, B:188:0x04d1, B:190:0x02a9, B:193:0x0271, B:195:0x0277, B:196:0x027e, B:197:0x023b, B:198:0x020f, B:168:0x0468, B:169:0x0477), top: B:3:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0271 A[Catch: all -> 0x000d, TryCatch #3 {all -> 0x000d, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0010, B:9:0x0028, B:11:0x0030, B:12:0x0037, B:15:0x0049, B:16:0x0071, B:18:0x0075, B:19:0x0078, B:21:0x0082, B:23:0x008c, B:25:0x0096, B:29:0x00a2, B:32:0x00a8, B:36:0x00be, B:34:0x00d5, B:39:0x00cb, B:41:0x00cf, B:43:0x00dc, B:45:0x0112, B:47:0x0118, B:49:0x0121, B:51:0x0133, B:52:0x0137, B:55:0x0139, B:57:0x013d, B:59:0x014b, B:60:0x015b, B:64:0x0154, B:66:0x0158, B:67:0x015d, B:70:0x0167, B:72:0x017d, B:74:0x0187, B:75:0x01a2, B:77:0x01a4, B:79:0x01a8, B:81:0x01b9, B:83:0x01cf, B:84:0x01d4, B:87:0x01da, B:88:0x01ee, B:92:0x0218, B:96:0x0231, B:97:0x0244, B:99:0x026a, B:100:0x0284, B:104:0x02b4, B:106:0x02bd, B:107:0x02c4, B:111:0x02d0, B:113:0x02d9, B:114:0x02dc, B:116:0x02e8, B:119:0x02f7, B:121:0x0305, B:123:0x031d, B:124:0x032b, B:126:0x032d, B:128:0x033d, B:130:0x034b, B:132:0x0351, B:135:0x0353, B:137:0x035b, B:138:0x0363, B:141:0x0369, B:143:0x037f, B:144:0x0392, B:146:0x0398, B:148:0x039e, B:149:0x03a1, B:151:0x03a6, B:153:0x03d2, B:155:0x03f5, B:156:0x0429, B:159:0x042f, B:160:0x0451, B:162:0x0457, B:163:0x0463, B:165:0x0465, B:166:0x0467, B:170:0x0478, B:173:0x047e, B:174:0x04a4, B:179:0x04a8, B:181:0x0385, B:183:0x038f, B:185:0x04a9, B:187:0x04b9, B:188:0x04d1, B:190:0x02a9, B:193:0x0271, B:195:0x0277, B:196:0x027e, B:197:0x023b, B:198:0x020f, B:168:0x0468, B:169:0x0477), top: B:3:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5 A[Catch: all -> 0x000d, TryCatch #3 {all -> 0x000d, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0010, B:9:0x0028, B:11:0x0030, B:12:0x0037, B:15:0x0049, B:16:0x0071, B:18:0x0075, B:19:0x0078, B:21:0x0082, B:23:0x008c, B:25:0x0096, B:29:0x00a2, B:32:0x00a8, B:36:0x00be, B:34:0x00d5, B:39:0x00cb, B:41:0x00cf, B:43:0x00dc, B:45:0x0112, B:47:0x0118, B:49:0x0121, B:51:0x0133, B:52:0x0137, B:55:0x0139, B:57:0x013d, B:59:0x014b, B:60:0x015b, B:64:0x0154, B:66:0x0158, B:67:0x015d, B:70:0x0167, B:72:0x017d, B:74:0x0187, B:75:0x01a2, B:77:0x01a4, B:79:0x01a8, B:81:0x01b9, B:83:0x01cf, B:84:0x01d4, B:87:0x01da, B:88:0x01ee, B:92:0x0218, B:96:0x0231, B:97:0x0244, B:99:0x026a, B:100:0x0284, B:104:0x02b4, B:106:0x02bd, B:107:0x02c4, B:111:0x02d0, B:113:0x02d9, B:114:0x02dc, B:116:0x02e8, B:119:0x02f7, B:121:0x0305, B:123:0x031d, B:124:0x032b, B:126:0x032d, B:128:0x033d, B:130:0x034b, B:132:0x0351, B:135:0x0353, B:137:0x035b, B:138:0x0363, B:141:0x0369, B:143:0x037f, B:144:0x0392, B:146:0x0398, B:148:0x039e, B:149:0x03a1, B:151:0x03a6, B:153:0x03d2, B:155:0x03f5, B:156:0x0429, B:159:0x042f, B:160:0x0451, B:162:0x0457, B:163:0x0463, B:165:0x0465, B:166:0x0467, B:170:0x0478, B:173:0x047e, B:174:0x04a4, B:179:0x04a8, B:181:0x0385, B:183:0x038f, B:185:0x04a9, B:187:0x04b9, B:188:0x04d1, B:190:0x02a9, B:193:0x0271, B:195:0x0277, B:196:0x027e, B:197:0x023b, B:198:0x020f, B:168:0x0468, B:169:0x0477), top: B:3:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026a A[Catch: all -> 0x000d, TryCatch #3 {all -> 0x000d, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x0010, B:9:0x0028, B:11:0x0030, B:12:0x0037, B:15:0x0049, B:16:0x0071, B:18:0x0075, B:19:0x0078, B:21:0x0082, B:23:0x008c, B:25:0x0096, B:29:0x00a2, B:32:0x00a8, B:36:0x00be, B:34:0x00d5, B:39:0x00cb, B:41:0x00cf, B:43:0x00dc, B:45:0x0112, B:47:0x0118, B:49:0x0121, B:51:0x0133, B:52:0x0137, B:55:0x0139, B:57:0x013d, B:59:0x014b, B:60:0x015b, B:64:0x0154, B:66:0x0158, B:67:0x015d, B:70:0x0167, B:72:0x017d, B:74:0x0187, B:75:0x01a2, B:77:0x01a4, B:79:0x01a8, B:81:0x01b9, B:83:0x01cf, B:84:0x01d4, B:87:0x01da, B:88:0x01ee, B:92:0x0218, B:96:0x0231, B:97:0x0244, B:99:0x026a, B:100:0x0284, B:104:0x02b4, B:106:0x02bd, B:107:0x02c4, B:111:0x02d0, B:113:0x02d9, B:114:0x02dc, B:116:0x02e8, B:119:0x02f7, B:121:0x0305, B:123:0x031d, B:124:0x032b, B:126:0x032d, B:128:0x033d, B:130:0x034b, B:132:0x0351, B:135:0x0353, B:137:0x035b, B:138:0x0363, B:141:0x0369, B:143:0x037f, B:144:0x0392, B:146:0x0398, B:148:0x039e, B:149:0x03a1, B:151:0x03a6, B:153:0x03d2, B:155:0x03f5, B:156:0x0429, B:159:0x042f, B:160:0x0451, B:162:0x0457, B:163:0x0463, B:165:0x0465, B:166:0x0467, B:170:0x0478, B:173:0x047e, B:174:0x04a4, B:179:0x04a8, B:181:0x0385, B:183:0x038f, B:185:0x04a9, B:187:0x04b9, B:188:0x04d1, B:190:0x02a9, B:193:0x0271, B:195:0x0277, B:196:0x027e, B:197:0x023b, B:198:0x020f, B:168:0x0468, B:169:0x0477), top: B:3:0x0003, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(@androidx.annotation.NonNull com.baidu.navisdk.comapi.routeplan.v2.b r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeplan.v2.e.a(com.baidu.navisdk.comapi.routeplan.v2.b, boolean):boolean");
    }

    private boolean a(ArrayList<RoutePlanNode> arrayList) {
        boolean a2;
        if (this.j.e().r.containsKey("fixCalcNode") && this.j.e().r.getBoolean("fixCalcNode")) {
            a2 = b(arrayList);
        } else {
            a2 = a(arrayList, l(this.j.e().f), this.j.e().f);
        }
        if (!a2) {
            g gVar = g.ROUTE_PLAN;
            if (gVar.a()) {
                gVar.a("calcRouteAfterNetworkingConfirm setDestsPos fail from navi.");
            }
            a(this.j, 3, ErrorCode.BIDDING_C2S_NO_AD);
            e.c cVar = new e.c();
            cVar.f6721a = ErrorCode.BIDDING_C2S_NO_AD;
            cVar.b = com.baidu.navisdk.comapi.routeplan.c.b(ErrorCode.BIDDING_C2S_NO_AD);
            notifyObservers(1, 6, cVar);
            t.u().g(ErrorCode.BIDDING_C2S_NO_AD);
        }
        return a2;
    }

    public void a(Bundle bundle) {
        int b = b(bundle);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "putCommuteABCategoryIntoExtraBundle --> ret = " + b);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("9.8", "" + b, null, null);
    }

    private int a(int i, boolean z, String str) {
        String str2;
        Bundle bundle;
        int i2;
        boolean z2;
        int CalcRouteWithPB;
        GeoPoint mapCenter;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "calcRouteInner() hasMrsl=" + z + ", usReqRouteCnt=" + i + ", mrsl=" + str + ", time=" + SystemClock.elapsedRealtime());
        }
        if (this.j == null) {
            return -1;
        }
        if (com.baidu.navisdk.framework.b.R()) {
            com.baidu.navisdk.comapi.routeplan.b bVar = this.o;
            if (bVar != null) {
                j(bVar.a());
            }
            BNRouteGuider.getInstance().setGuideEndType(this.g);
            h(0);
        }
        if (z.a(com.baidu.navisdk.framework.a.c().a())) {
            k(3);
        } else {
            k(1);
        }
        LogUtil.e("BNRoutePlanV2", "calcRouteInner. mCalcPrefCarNo = " + this.j.e().l);
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (jNIGuidanceControl == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanV2", "calcRouteInner --> mGuidanceControl is null!!!");
            }
            return -1;
        }
        Bundle bundle2 = this.j.e().t;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("calcRouteInner mVehicleCache:");
            sb.append(this.m);
            sb.append(", mSubVehicleCache:");
            sb.append(this.n);
            sb.append(", localRouteCarInfo:");
            sb.append(bundle2 != null ? bundle2.toString() : "null");
            LogUtil.e("BNRoutePlanV2", sb.toString());
        }
        boolean SetLocalRouteCarInfoFromBundle = jNIGuidanceControl.SetLocalRouteCarInfoFromBundle(this.m, this.n, bundle2);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "SetLocalRouteCarInfo result:" + SetLocalRouteCarInfoFromBundle);
            LogUtil.e("BNRoutePlanV2", "calcRouteInner entry=" + this.j.e().f + ", prefer=" + this.j.e().d);
        }
        if (q) {
            q = false;
        }
        q.a(0, "sdk_start_lib_routeplan", System.currentTimeMillis());
        com.baidu.navisdk.skyeye.a.n().m();
        g gVar = g.ROUTE_PLAN;
        if (gVar.a()) {
            gVar.a("start CalcRoute");
        }
        f(this.j.e().f);
        if (this.j.e().r == null) {
            this.j.e().r = new Bundle();
        }
        Bundle bundle3 = this.j.e().r;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "calcRouteInner() --> extraData = " + bundle3);
        }
        if (bundle3 != null) {
            if (!bundle3.containsKey("restore_dest_cal")) {
                bundle3.putBoolean("restore_dest_cal", false);
            }
            if (j.d() && (mapCenter = MapInfoProvider.getMapInfo().getMapCenter()) != null) {
                bundle3.putBoolean("isGlobal", com.baidu.navisdk.framework.b.a(mapCenter.getLongitude(), mapCenter.getLatitude(), 0));
            }
            if (!bundle3.containsKey("subTypeBybaseline")) {
                bundle3.putInt("subTypeBybaseline", 0);
            }
            if (bundle3.containsKey(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_MRSL)) {
                this.j.e().j = true;
                this.j.e().k = bundle3.getString(BNaviCommonParams.RoutePlanKey.EXTRA_KEY_MRSL);
            }
            c(bundle3);
            bundle3.putIntArray("viasPreferBundle", this.j.h());
        }
        a(bundle3);
        if (LogUtil.LOGGABLE && this.j.e() != null) {
            LogUtil.autoCheck("calRoute", this.j.e().p());
        }
        if (!this.j.e().r.containsKey(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE)) {
            this.j.e().r.putInt(BNaviCommonParams.RoutePlanKey.VEHICLE_TYPE, this.m);
        }
        String b = this.j.e().b();
        if (!TextUtils.isEmpty(b)) {
            this.j.e().r.putString("client_info", b);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "extraData =" + this.j.e().r.toString());
        }
        if (this.j.e().h != 1) {
            LogUtil.e("BNRoutePlanV2", "calcRouteInner. not with pb.");
            str2 = "subTypeBybaseline";
            bundle = bundle3;
            z2 = false;
            CalcRouteWithPB = jNIGuidanceControl.CalcRoute(this.j.e().d, this.j.e().e, i, this.j.e().m, this.j.e().n, this.j.e().j, this.j.e().k, this.j.e().g, this.j.e().f, r, this.j.e().c(), this.j.e().r.getString("convoyId"), com.baidu.navisdk.framework.b.E(), this.j.e().l(), this.j.e().j(), this.j.e().i(), this.j.e().d(), this.j.e().r);
            i2 = -1;
        } else {
            str2 = "subTypeBybaseline";
            bundle = bundle3;
            i2 = -1;
            z2 = false;
            LogUtil.e("BNRoutePlanV2", "calcRouteInner. with pb.");
            CalcRouteWithPB = jNIGuidanceControl.CalcRouteWithPB(this.j.e().g(), this.j.e().h(), this.j.e().d, this.j.e().r, this.j.e().f(), this.j.e().f);
        }
        if (r) {
            r = z2;
        }
        if (bundle != null && bundle.getInt(str2, i2) == 0) {
            Throwable th = new Throwable();
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            if (stackTrace != null) {
                sb2.append("printCallStack --> ");
                sb2.append(th.getMessage());
                sb2.append("\n");
                sb2.append("----------start----------");
                sb2.append("\n");
                for (int i3 = 0; i3 < stackTrace.length; i3++) {
                    sb2.append("        at ");
                    sb2.append(stackTrace[i3].getClassName());
                    sb2.append(FileUtils.FILE_EXTENSION_SEPARATOR);
                    sb2.append(stackTrace[i3].getMethodName());
                    sb2.append(oIX0oI.I0Io.f4096II0xO0);
                    sb2.append(stackTrace[i3].getFileName());
                    sb2.append(":");
                    sb2.append(stackTrace[i3].getLineNumber());
                    sb2.append(oIX0oI.I0Io.f4095I0Io);
                    sb2.append("\n");
                }
                sb2.append("--------end---------");
            }
            g.ROUTE_PLAN.a("calRouteprintCallStack", sb2.toString());
        }
        return CalcRouteWithPB;
    }

    private int a(RoutePlanNode routePlanNode, boolean z, int i) {
        JNIGuidanceControl jNIGuidanceControl = this.b;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "setStartPosV2 --> mGuidanceControl = " + this.b + "\n       start = " + routePlanNode + "\n       isFromNavEntry" + z + "\n       entry" + i);
        }
        if (jNIGuidanceControl == null) {
            return 5090;
        }
        if (routePlanNode == null) {
            return 5091;
        }
        String str = routePlanNode.mName;
        if (str != null) {
            if (str.equals("我的位置")) {
                t.u().D = routePlanNode.mSensorAngle >= 0.0f ? 1 : 0;
            } else {
                t.u().D = 2;
            }
        }
        LogUtil.e("BNRoutePlanV2", "setStartPos. mHasSensor = " + t.u().D);
        t.u().B = routePlanNode.mFrom;
        int i2 = routePlanNode.mLocType;
        if (i2 == 1) {
            t.u().C = 1;
        } else if (i2 == 2) {
            t.u().C = 2;
        } else if (i2 == 3) {
            t.u().C = 3;
        } else {
            t.u().C = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.navisdk.comapi.routeplan.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
        }
        LogUtil.e("BNRoutePlaner startRecordStarInfos cost :", ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "");
        LogUtil.e("SetStartPos: fAltitude:", routePlanNode.mAltitude + "");
        StringBuilder sb = new StringBuilder();
        sb.append(routePlanNode.mLocType == 1);
        sb.append("");
        LogUtil.e("is GPSLocation:", sb.toString());
        if (z) {
            return jNIGuidanceControl.SetStartPosNavComeFrom(routePlanNode, i);
        }
        return jNIGuidanceControl.SetStartPosNav(routePlanNode);
    }

    private boolean a(ArrayList<RoutePlanNode> arrayList, boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanV2", "setDestsPosV2 --> mGuidanceControl = " + this.b + "\n       array = " + arrayList + "\n       isFromNavEntry" + z + "\n       entry" + i);
        }
        if (this.b == null || arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (z) {
            return this.b.SetDestsPosNavComeFrom(arrayList, i);
        }
        return this.b.SetDestsPosNav(arrayList);
    }

    public void a(boolean z) {
        if (this.b == null || !com.baidu.navisdk.module.init.a.a()) {
            return;
        }
        this.b.EnableRoadCondition(z);
    }

    public int a(int i) {
        d dVar = this.j;
        if (dVar != null && dVar.e() != null && this.j.e().m() == i) {
            return this.j.e().d;
        }
        com.baidu.navisdk.comapi.routeplan.b bVar = this.o;
        if (bVar != null) {
            return bVar.b(i);
        }
        return 0;
    }

    public void a() {
        d dVar;
        f fVar = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null || (dVar = this.j) == null) {
            return;
        }
        fVar.b((ArrayList<RoutePlanNode>) dVar.c);
        fVar.c();
    }
}
