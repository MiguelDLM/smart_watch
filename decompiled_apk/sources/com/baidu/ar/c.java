package com.baidu.ar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.d;
import com.baidu.ar.digital.IDigital;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c {
    private Looper B;
    private a C;
    private DefaultParams D;
    private gc E;
    private fs F;
    private bb G;
    private dh H;
    private fe I;
    private ARProxyManager M;
    private List<Integer> N;
    private ft O;
    private List<String> P;
    private LuaMsgListener Q;
    private List<String> R;
    private LuaMsgListener S;
    private final List<String> U;
    private List<String> V;
    private p W;
    private boolean aa;
    private ej ab;
    private d.a ac;
    private bf ad;
    private Context mContext;
    private ConcurrentHashMap<String, String> J = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> K = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, com.baidu.ar.d> L = new ConcurrentHashMap<>();
    private List<String> T = new ArrayList();

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                        C0117c c0117c = (C0117c) message.obj;
                        c.this.a(c0117c.mClassName, c0117c.ah, c0117c.ai, c0117c.ag, c0117c.aj, c0117c.ak);
                        break;
                    case 1002:
                        b bVar = (b) message.obj;
                        c.this.a(bVar.mClassName, bVar.ag);
                        break;
                    case 1003:
                        d dVar = (d) message.obj;
                        c.this.a(dVar.mClassName, dVar.aj, dVar.ak);
                        break;
                }
            } catch (Exception e) {
                kf.b("AbilityManager", "handleMessage Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        HashMap<String, Object> ag;
        String mClassName;

        public b(String str, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.ag = hashMap;
        }
    }

    /* renamed from: com.baidu.ar.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0117c {
        HashMap<String, Object> ag;
        List<String> ah;
        boolean ai;
        String aj;
        df ak;
        String mClassName;

        public C0117c(String str, String str2, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            ArrayList arrayList = new ArrayList();
            this.ah = arrayList;
            arrayList.add(str2);
            this.ai = z;
            this.ag = hashMap;
        }

        public C0117c(String str, List<String> list, boolean z, HashMap<String, Object> hashMap) {
            this.mClassName = str;
            this.ah = list;
            this.ai = z;
            this.ag = hashMap;
        }
    }

    /* loaded from: classes7.dex */
    public class d {
        String aj;
        df ak;
        String mClassName;

        public d(String str) {
            this.mClassName = str;
        }

        public d(String str, String str2, df dfVar) {
            this.mClassName = str;
            this.aj = str2;
            this.ak = dfVar;
        }
    }

    public c(Context context, Looper looper, DefaultParams defaultParams, p pVar, ej ejVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.U = copyOnWriteArrayList;
        this.V = new ArrayList();
        this.aa = true;
        this.mContext = context;
        this.B = looper;
        this.C = new a(looper);
        this.D = defaultParams;
        setMdlModelPath(defaultParams.getMdlAlgoModelPath());
        this.M = new ARProxyManager();
        this.W = pVar;
        this.ab = ejVar;
        m();
        copyOnWriteArrayList.add("ability_common_filter");
        n();
    }

    private com.baidu.ar.d g(String str) {
        com.baidu.ar.d dVar = (com.baidu.ar.d) kr.cq(str);
        if (dVar == null) {
            kf.b("AbilityManager", "createARAbility error!!!");
            return null;
        }
        this.L.put(str, dVar);
        dVar.a(this.mContext, this.B);
        dVar.a(this.H, this.G, this.ab);
        dVar.a(this.F);
        dVar.a(this.I);
        dVar.a(this.ac);
        p pVar = this.W;
        if (pVar != null) {
            dVar.a(pVar.aq());
        }
        ARProxyManager aRProxyManager = this.M;
        if (aRProxyManager != null && aRProxyManager.d(str)) {
            this.M.a(dVar, str);
        }
        return dVar;
    }

    private void k() {
        if (this.F == null) {
            return;
        }
        this.N = Arrays.asList(301, 303);
        ft ftVar = new ft() { // from class: com.baidu.ar.c.3
            @Override // com.baidu.ar.ft
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                c.this.a(i, hashMap);
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                return c.this.N;
            }
        };
        this.O = ftVar;
        this.F.c(ftVar);
        this.P = Arrays.asList("id");
        this.Q = new LuaMsgListener() { // from class: com.baidu.ar.c.4
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return c.this.P;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                c.this.a(hashMap);
            }
        };
        this.F.ei().addLuaMsgListener(this.Q);
        this.R = Arrays.asList("event_name");
        this.S = new LuaMsgListener() { // from class: com.baidu.ar.c.5
            @Override // com.baidu.ar.lua.LuaMsgListener
            public List<String> getMsgKeyListened() {
                return c.this.R;
            }

            @Override // com.baidu.ar.lua.LuaMsgListener
            public void onLuaMessage(HashMap<String, Object> hashMap) {
                c.this.b(hashMap);
                c.this.c(hashMap);
            }
        };
        this.F.ei().addLuaMsgListener(this.S);
    }

    private void l() {
        if (this.F != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("ability_name", this.U);
            this.F.b(1902, hashMap);
        }
    }

    private void m() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = getClass().getClassLoader();
        for (Map.Entry<String, String> entry : m.ew.entrySet()) {
            if (kr.a(entry.getValue(), classLoader)) {
                this.J.put(entry.getKey(), entry.getValue());
            }
        }
        this.K.putAll(m.eB);
        kf.u("AbilityManager", "initSupportedARClasses mSupportedARClasses = " + this.J.values());
        kf.c("AbilityManager", "initSupportedARClasses time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void n() {
        this.ac = new d.a() { // from class: com.baidu.ar.c.6
            @Override // com.baidu.ar.d.a
            public boolean a(String str, df dfVar) {
                if (c.this.K == null || !c.this.K.containsKey(str)) {
                    return false;
                }
                String str2 = (String) c.this.K.get(str);
                if (TextUtils.isEmpty(str2) || c.this.C == null) {
                    return false;
                }
                c.this.C.sendMessage(c.this.C.obtainMessage(1003, new d(str2, str, dfVar)));
                return true;
            }
        };
    }

    private void o() {
        bf bfVar = new bf() { // from class: com.baidu.ar.c.7
            @Override // com.baidu.ar.bf
            public void b(boolean z) {
                Iterator it = c.this.L.values().iterator();
                while (it.hasNext()) {
                    ((com.baidu.ar.d) it.next()).b(z);
                }
            }
        };
        this.ad = bfVar;
        this.G.setCameraSwitchListener(bfVar);
    }

    private List<String> p() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.T.iterator();
        while (it.hasNext()) {
            String str = this.J.get(it.next());
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.U.contains(str)) {
            if (this.C == null) {
                return false;
            }
            b bVar = new b(this.J.get(str), hashMap);
            a aVar = this.C;
            aVar.sendMessage(aVar.obtainMessage(1002, bVar));
            return true;
        }
        kf.b("AbilityManager", "adjustAbility abilityType = " + str + " not start!!!");
        return false;
    }

    public ARProxyManager getARProxyManager() {
        return this.M;
    }

    public List<String> getActiveAbilities() {
        return this.U;
    }

    public List<String> getSupportedAbilities() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = this.J.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public boolean isAbilityActive(String str) {
        return this.U.contains(str);
    }

    public boolean isAbilitySupported(String str) {
        return this.J.get(str) != null;
    }

    public void onCaseCreate(String str) {
        j();
        if (this.L.isEmpty()) {
            return;
        }
        for (com.baidu.ar.d dVar : this.L.values()) {
            kf.c("AbilityManager", "onCaseCreate casePath = " + str);
            dVar.onCaseCreate(str);
        }
    }

    public void onCaseDestroy() {
        if (this.L.isEmpty()) {
            return;
        }
        Iterator<com.baidu.ar.d> it = this.L.values().iterator();
        while (it.hasNext()) {
            it.next().onCaseDestroy();
        }
    }

    public void pause() {
        if (this.L.isEmpty()) {
            return;
        }
        Iterator<com.baidu.ar.d> it = this.L.values().iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    public void release() {
        ARProxyManager aRProxyManager = this.M;
        if (aRProxyManager != null) {
            aRProxyManager.release();
            this.M = null;
        }
        Iterator<com.baidu.ar.d> it = this.L.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.L.clear();
        this.J.clear();
        fs fsVar = this.F;
        if (fsVar != null && fsVar.ei() != null) {
            this.F.d(this.O);
            this.F.ei().removeLuaMsgListener(this.Q);
            this.F.ei().removeLuaMsgListener(this.S);
            this.F = null;
            this.O = null;
            this.Q = null;
            this.S = null;
        }
        this.N = null;
        this.P = null;
        this.R = null;
        fe feVar = this.I;
        if (feVar != null) {
            feVar.destroy();
            this.I = null;
        }
        dh dhVar = this.H;
        if (dhVar != null) {
            dhVar.release();
            this.H = null;
        }
        List<String> list = this.V;
        if (list != null) {
            list.clear();
            this.V = null;
        }
        this.mContext = null;
        this.B = null;
        this.D = null;
        this.E = null;
        this.ab = null;
        this.G = null;
        if (this.W != null) {
            this.W = null;
        }
    }

    public void resume() {
        if (this.L.isEmpty()) {
            return;
        }
        Iterator<com.baidu.ar.d> it = this.L.values().iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
    }

    public void setMdlModelPath(String str) {
        if (this.E == null) {
            this.E = new gc();
        }
        this.E.a(str, this.mContext);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        return a(str, hashMap, false);
    }

    public boolean stopAbility(String str) {
        return a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, HashMap<String, Object> hashMap) {
        if (i == 301) {
            if (this.L == null || !this.U.contains("ability_image_track")) {
                startAbility("ability_imu", hashMap);
                return;
            }
            return;
        }
        if (i != 303) {
            return;
        }
        if (this.L == null || !this.U.contains("ability_image_track")) {
            stopAbility("ability_imu");
        }
    }

    private void j() {
        DefaultParams defaultParams = this.D;
        if (defaultParams != null && defaultParams.isDigitalArEnable()) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("socket_enable", Integer.valueOf(this.D.isDigitalSocketEnable() ? 1 : 0));
            hashMap.put("socket_url", this.D.getDigitalSocketUrl());
            hashMap.put("app_id", this.D.getDigitalUnitAppId());
            hashMap.put("app_key", this.D.getDigitalUnitAppKey());
            startAbility("ability_digital", hashMap);
            IDigital digitalAR = getARProxyManager().getDigitalAR();
            if (digitalAR != null) {
                digitalAR.initDigital(hashMap);
            }
        }
    }

    public void h() {
        ARProxyManager aRProxyManager = this.M;
        if (aRProxyManager != null) {
            aRProxyManager.f();
        }
        ArrayList<String> arrayList = new ArrayList();
        List<String> p = p();
        for (String str : this.U) {
            String str2 = !TextUtils.isEmpty(str) ? this.J.get(str) : null;
            if (!TextUtils.isEmpty(str2) && !p.contains(str2) && !arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        g();
        if (this.C != null) {
            for (String str3 : arrayList) {
                if (!j(str3)) {
                    a aVar = this.C;
                    aVar.sendMessage(aVar.obtainMessage(1003, new d(str3)));
                }
            }
        }
    }

    public void i() {
        ej ejVar = this.ab;
        if (ejVar != null) {
            ejVar.a(FilterNode.faceFilter, false);
            this.ab.a(FilterNode.makeupFilter, false);
        }
        ARProxyManager aRProxyManager = this.M;
        if (aRProxyManager != null) {
            aRProxyManager.f();
        }
        Iterator<String> it = this.U.iterator();
        while (it.hasNext()) {
            i(it.next());
        }
        this.U.clear();
        this.U.add("ability_common_filter");
        List<String> list = this.V;
        if (list != null && list.size() > 0) {
            this.U.addAll(this.V);
        }
        if (this.C != null) {
            for (Map.Entry<String, com.baidu.ar.d> entry : this.L.entrySet()) {
                if (!j(entry.getKey())) {
                    a aVar = this.C;
                    aVar.sendMessage(aVar.obtainMessage(1003, new d(entry.getKey())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(HashMap<String, Object> hashMap) {
        String str = (String) hashMap.get("event_name");
        kf.c("AbilityManager", "operateAbilityByEvent eventName = " + str);
        if (!"ability_operation".equals(str)) {
            String str2 = m.ey.get(str);
            if (!TextUtils.isEmpty(str2)) {
                startAbility(str2, hashMap);
                return;
            }
            String str3 = m.ez.get(str);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            stopAbility(str3);
            return;
        }
        String str4 = (String) hashMap.get("ability_name");
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        String str5 = (String) hashMap.get("ability_action");
        if ("open".equals(str5)) {
            startAbility(str4, hashMap);
            return;
        }
        if ("close".equals(str5)) {
            stopAbility(str4);
        } else if ("adjust".equals(str5)) {
            adjustAbility(str4, hashMap);
        } else if ("query".equals(str5)) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(HashMap<String, Object> hashMap) {
        ej ejVar;
        FilterNode filterNode;
        if ("ability_operation".equals((String) hashMap.get("event_name"))) {
            String str = (String) hashMap.get("ability_name");
            if (TextUtils.isEmpty(str) || !m.ex.contains(str)) {
                return;
            }
            kf.c("AbilityManager", "operateFilterState abilityName = " + str);
            String str2 = (String) hashMap.get("ability_action");
            if ("open".equals(str2) && "close".equals(str2)) {
                boolean equals = "open".equals(str2);
                if (this.ab != null) {
                    if ("ability_makeup_filter".equals(str)) {
                        ejVar = this.ab;
                        filterNode = FilterNode.makeupFilter;
                    } else if ("ability_face_filter".equals(str)) {
                        ejVar = this.ab;
                        filterNode = FilterNode.faceFilter;
                    } else {
                        if (!"ability_beauty_filter".equals(str)) {
                            if ("ability_lut_filter".equals(str)) {
                                ejVar = this.ab;
                                filterNode = FilterNode.lutFilter;
                            }
                            this.ab.dD();
                        }
                        ejVar = this.ab;
                        filterNode = FilterNode.skinFilter;
                    }
                    ejVar.a(filterNode, equals);
                    this.ab.dD();
                }
            }
        }
    }

    private void h(String str) {
        if (this.U.contains(str)) {
            kf.c("AbilityManager", "enableAbility() abilityName " + str + " has enabled!!!");
            return;
        }
        this.U.add(str);
        if ((str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) && this.D.isUseMakeupFilter()) {
            this.U.add("ability_makeup_filter");
        }
    }

    private void i(String str) {
        ConcurrentHashMap<String, com.baidu.ar.d> concurrentHashMap;
        com.baidu.ar.d dVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = this.J;
        if (concurrentHashMap2 != null) {
            String str2 = concurrentHashMap2.get(str);
            if (!TextUtils.isEmpty(str2) && (concurrentHashMap = this.L) != null && (dVar = concurrentHashMap.get(str2)) != null) {
                dVar.l(str);
            }
        }
        if (this.U.contains(str)) {
            if (str.equals("ability_makeup_filter") || str.equals("ability_face_filter")) {
                this.U.remove("ability_makeup_filter");
            }
            this.U.remove(str);
            return;
        }
        kf.c("AbilityManager", "disableAbility() abilityName " + str + " has disabled!!!");
    }

    private boolean j(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.V) == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(this.J.get(it.next()))) {
                return true;
            }
        }
        return false;
    }

    public void a(ARType aRType) {
        ARType aRType2 = ARType.FACE;
        if (aRType != aRType2) {
            i();
        } else {
            if (!l.s("ability_face_model")) {
                return;
            }
            if (this.D.isUseFaceFilter()) {
                h("ability_face_model");
            }
        }
        this.ab.c(FilterParam.SkinFilter.whiten.getFilterNode().getNodeName(), aRType == aRType2 || this.D.isUseBeautyFilter());
        String str = m.eA.get(aRType);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.J.get(str);
        if (!TextUtils.isEmpty(str2) && this.L.get(str2) != null) {
            this.L.get(str2).k(str);
        }
        if (this.U.contains(str) || aRType == ARType.IMU || TextUtils.isEmpty(str2) || this.C == null) {
            return;
        }
        this.U.add(str);
        C0117c c0117c = new C0117c(str2, str, false, (HashMap<String, Object>) null);
        a aVar = this.C;
        aVar.sendMessage(aVar.obtainMessage(1001, c0117c));
    }

    public void g() {
        if (this.D == null) {
            return;
        }
        this.T.clear();
        this.U.clear();
        this.U.add("ability_common_filter");
        List<String> list = this.V;
        if (list != null && list.size() > 0) {
            this.U.addAll(this.V);
        }
        if (this.D.isUseFaceFilter() && l.t("ability_face_filter")) {
            this.T.add("ability_face_filter");
            ej ejVar = this.ab;
            if (ejVar != null) {
                ejVar.c(FilterParam.SkinFilter.whiten.getFilterNode().getNodeName(), true);
                this.ab.a(FilterNode.faceFilter, true);
            }
            if (this.aa) {
                this.aa = false;
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_FILTER_ADJUST, 200L, "");
                StatisticApi.onEventDebounce(StatisticConstants.EVENT_BEAUTIFY_ADJUST, 200L, "");
            }
        }
        if (this.D.isUseMakeupFilter()) {
            if (l.t("ability_makeup_filter")) {
                this.T.add("ability_makeup_filter");
            }
            ej ejVar2 = this.ab;
            if (ejVar2 != null) {
                ejVar2.a(FilterNode.makeupFilter, true);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.T.contains("ability_face_filter")) {
            arrayList.add("ability_face_filter");
        }
        if (this.T.contains("ability_makeup_filter")) {
            arrayList.add("ability_makeup_filter");
        }
        if (arrayList.size() > 0) {
            a(arrayList);
        }
        DefaultParams defaultParams = this.D;
        if (defaultParams != null) {
            String renderPipeline = defaultParams.getRenderPipeline();
            if (TextUtils.isEmpty(renderPipeline) || !renderPipeline.contains(FilterNode.highlightFilter.getNodeName())) {
                return;
            }
            this.C.postDelayed(new Runnable() { // from class: com.baidu.ar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ab != null) {
                        c.this.ab.dE();
                    }
                }
            }, 100L);
        }
    }

    public void a(fs fsVar, bb bbVar) {
        this.F = fsVar;
        this.G = bbVar;
        bbVar.setEnabledAbilities(this.U);
        o();
        this.H = new dh(bbVar, this.B);
        fe c = com.baidu.ar.b.c();
        this.I = c;
        if (c != null) {
            try {
                c.setContext(this.mContext);
            } catch (Exception e) {
                kf.b("AbilityManager", "setup exception: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, df dfVar) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "destroyAbility error!!! arClassName is empty!!!";
        } else {
            com.baidu.ar.d dVar = this.L.get(str);
            if (dVar != null) {
                if (TextUtils.isEmpty(str2) || dfVar == null) {
                    dVar.r();
                } else {
                    dVar.c(str2, dfVar);
                }
                if (dVar.s()) {
                    ARProxyManager aRProxyManager = this.M;
                    if (aRProxyManager != null && aRProxyManager.d(str)) {
                        this.M.f(str);
                    }
                    this.L.remove(str);
                    dVar.release();
                    return;
                }
                return;
            }
            str3 = "destroyAbility error!!! As arClassName = " + str + " not active!!!";
        }
        kf.b("AbilityManager", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, HashMap<String, Object> hashMap) {
        com.baidu.ar.d dVar = this.L.get(str);
        if (dVar != null) {
            dVar.adjust(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, HashMap<String, Object> hashMap, String str2, df dfVar) {
        String str3;
        if (l.r(str)) {
            com.baidu.ar.d dVar = this.L.get(str);
            if (dVar != null) {
                kf.c("AbilityManager", "createARAbility arClassName = " + str + " ARAbility exist!!!");
                if (list != null) {
                    if (z) {
                        dVar.r();
                    }
                    dVar.b(list);
                }
                dVar.adjust(hashMap);
            } else {
                dVar = g(str);
                if (dVar == null) {
                    str3 = "createARAbility createARAbility error!!!";
                } else {
                    if (list != null) {
                        dVar.b(list);
                    }
                    if (!TextUtils.isEmpty(this.D.getFaceAlgoModelPath())) {
                        dVar.setFaceModelPath(this.D.getFaceAlgoModelPath());
                    }
                    dVar.setMdlConfigParams(this.E);
                    dVar.setup(hashMap);
                }
            }
            if (TextUtils.isEmpty(str2) || dfVar == null) {
                return;
            }
            dVar.b(str2, dfVar);
            return;
        }
        str3 = "checkARTypeAuth error!!!";
        kf.b("AbilityManager", str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "id"
            java.lang.Object r0 = r7.get(r0)
            r1 = -1
            int r0 = com.baidu.ar.as.a(r0, r1)
            java.lang.String r2 = "open"
            java.lang.Object r2 = r7.get(r2)
            int r1 = com.baidu.ar.as.a(r2, r1)
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L1b
            r1 = 1
            goto L1c
        L1b:
            r1 = 0
        L1c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "operateAbilityById id = "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = " && open = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "AbilityManager"
            com.baidu.ar.kf.c(r5, r4)
            r4 = 5001(0x1389, float:7.008E-42)
            if (r0 != r4) goto L42
            java.lang.String r0 = "ability_gesture"
        L40:
            r2 = r1
            goto L5a
        L42:
            r4 = 5011(0x1393, float:7.022E-42)
            if (r0 != r4) goto L49
            java.lang.String r0 = "ability_image_segmentation"
            goto L40
        L49:
            r4 = 3005(0xbbd, float:4.211E-42)
            if (r0 != r4) goto L51
            java.lang.String r0 = "ability_logo_recognition"
            r2 = 1
            goto L5a
        L51:
            r3 = 3006(0xbbe, float:4.212E-42)
            r4 = 0
            if (r0 != r3) goto L58
        L56:
            r0 = r4
            goto L5a
        L58:
            r2 = r1
            goto L56
        L5a:
            if (r0 == 0) goto L65
            if (r2 == 0) goto L62
            r6.startAbility(r0, r7)
            goto L65
        L62:
            r6.stopAbility(r0)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.c.a(java.util.HashMap):void");
    }

    private void a(final List<String> list) {
        fn.prepareCaseRes(ARType.FACE, null, null, new ILibLoader.a() { // from class: com.baidu.ar.c.2
            @Override // com.baidu.ar.libloader.ILibLoader.a
            public void a(ARType aRType, String str, String str2) {
                c.this.U.addAll(c.this.T);
                String str3 = (String) c.this.J.get("ability_face_filter");
                if (TextUtils.isEmpty(str3) || c.this.C == null) {
                    return;
                }
                if (c.this.L.get(str3) == null) {
                    c.this.C.sendMessage(c.this.C.obtainMessage(1001, new C0117c(str3, (List<String>) list, true, (HashMap<String, Object>) null)));
                } else {
                    ((com.baidu.ar.d) c.this.L.get(str3)).r();
                    ((com.baidu.ar.d) c.this.L.get(str3)).b(list);
                }
            }

            @Override // com.baidu.ar.libloader.ILibLoader.a
            public void a(DuMixErrorType duMixErrorType, String str) {
                kf.b("AbilityManager", "startDefaultFaceAbility error!!! errorType = " + duMixErrorType.toString() + " && error message = " + str);
            }
        });
    }

    public boolean a(String str, HashMap<String, Object> hashMap, boolean z) {
        StringBuilder sb;
        String str2;
        if (l.s(str)) {
            if (z && !this.V.contains(str)) {
                this.V.add(str);
            }
            if (!this.U.contains(str)) {
                String str3 = this.J.get(str);
                if (!TextUtils.isEmpty(str3)) {
                    h(str);
                    if (this.C != null) {
                        C0117c c0117c = new C0117c(str3, str, false, hashMap);
                        a aVar = this.C;
                        aVar.sendMessage(aVar.obtainMessage(1001, c0117c));
                        return true;
                    }
                }
                return false;
            }
            sb = new StringBuilder();
            sb.append("startAbility abilityType = ");
            sb.append(str);
            str2 = " is exist!!!";
        } else {
            sb = new StringBuilder();
            sb.append("startAbility abilityType = ");
            sb.append(str);
            str2 = " is no authorization!!!";
        }
        sb.append(str2);
        kf.b("AbilityManager", sb.toString());
        return false;
    }

    public boolean a(String str, List<String> list, String str2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !kr.a(str, getClass().getClassLoader())) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.J.put(it.next(), str);
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        this.K.put(str2, str);
        return true;
    }

    public boolean a(String str, boolean z) {
        a aVar;
        if (z && this.V.contains(str)) {
            this.V.remove(str);
        }
        i(str);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.U.iterator();
        while (it.hasNext()) {
            String str2 = this.J.get(it.next());
            if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        String str3 = this.J.get(str);
        if (arrayList.contains(str3) || (aVar = this.C) == null) {
            return false;
        }
        aVar.sendMessage(aVar.obtainMessage(1003, new d(str3)));
        return true;
    }
}
