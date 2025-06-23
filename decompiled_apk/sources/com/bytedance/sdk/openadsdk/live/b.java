package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.c;
import com.bytedance.sdk.openadsdk.c.a.a.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bn;
import java.util.HashMap;
import java.util.Map;
import o0.xXxxox0I;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class b implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private static final b f10793a = new b();
    private ITTLiveTokenInjectionAuth b;
    private volatile Bridge c;
    private Map<String, String> d;
    private volatile C0571b e;

    /* loaded from: classes8.dex */
    public static final class a implements Bridge {

        /* renamed from: a, reason: collision with root package name */
        private ILiveAdCustomConfig f10796a;

        public a(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f10796a = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            this.f10796a.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
                            return null;
                        }
                        return (T) this.f10796a.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
                    }
                    return (T) this.f10796a.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
                }
                return (T) this.f10796a.convertToEnterFromMerge(valueSet.intValue(0));
            }
            return (T) Integer.valueOf(this.f10796a.openLR(valueSet.stringValue(0)));
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return xXxxox0I.oIX0oI().X0o0xo(10000, 1).OOXIXo();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0571b implements TTPluginListener {

        /* renamed from: a, reason: collision with root package name */
        int f10797a;
        String b;

        private C0571b() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
            a(i, classLoader, resources, bundle, false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, ClassLoader classLoader, Resources resources, Bundle bundle, boolean z) {
            this.f10797a = i;
            if (b.this.c != null) {
                b.this.c.call(3, xXxxox0I.oIX0oI().X0o0xo(0, i).Oxx0IOOO(1, classLoader).Oxx0IOOO(2, resources).Oxx0IOOO(3, bundle).Oxx0IOOO(4, b.this.a(z)).OOXIXo(), null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, String str, boolean z) {
            this.f10797a = i;
            this.b = str;
            if (b.this.c != null) {
                xXxxox0I X0o0xo2 = xXxxox0I.oIX0oI().X0o0xo(0, i);
                if (str != null) {
                    X0o0xo2.II0XooXoX(1, str);
                }
                X0o0xo2.Oxx0IOOO(2, b.this.a(z));
                b.this.c.call(2, X0o0xo2.OOXIXo(), null);
            }
        }
    }

    private b() {
    }

    private TTCustomController c(Map map) {
        Object obj = map.get("c_control");
        if (obj instanceof Bridge) {
            return new i((Bridge) obj);
        }
        return null;
    }

    private Object d(Map<String, Object> map) {
        try {
            String str = (String) map.get("expand_method_name");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get("expand_method_param");
            if (objArr != null) {
                return liveRoomService.callExpandMethod(str, objArr);
            }
            return liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th) {
            c.b("TTLiveSDkBridge", th);
            return null;
        }
    }

    private Boolean e(Map<String, Object> map) {
        try {
            String str = (String) map.get("scheme_uri");
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context a2 = a(map.get(bn.f.o));
            Uri parse = Uri.parse(str);
            if (parse != null && a2 != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.a.a(a2, parse));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            c.b("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 5) {
            if (i != 9) {
                return (T) a(cls, i, (Map) valueSet.objectValue(0, Map.class));
            }
            this.c = (Bridge) valueSet.objectValue(0, Bridge.class);
            if (this.e != null) {
                if (this.e.f10797a == 2 || this.e.f10797a == -3) {
                    this.e.a(this.e.f10797a, this.e.b, true);
                } else if (this.e.f10797a != 0) {
                    this.e.a(this.e.f10797a, null, null, null, true);
                }
            } else {
                this.e = new C0571b();
                Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.a.c.a().call(10, xXxxox0I.II0xO0(1).X0o0xo(0, 4).OOXIXo(), Bridge.class);
                ValueSet OOXIXo2 = xXxxox0I.II0xO0(1).Oxx0IOOO(0, this.e).OOXIXo();
                if (bridge != null) {
                    bridge.call(106, OOXIXo2, Void.class);
                }
            }
            return null;
        }
        b((Map) valueSet.objectValue(0, Map.class));
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().X0o0xo(10000, 2).OOXIXo();
    }

    private void b(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get("debug"))).booleanValue()).setECHostAppId(String.valueOf(map.get("ec_host_appid"))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.b.1
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (b.this.c != null) {
                    return b.this.c.call(0, xXxxox0I.oIX0oI().II0XooXoX(0, str).Oxx0IOOO(1, map2).OOXIXo(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret("p_secret").setHostPermission(new com.bytedance.sdk.openadsdk.live.a.a(c(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.a.b(this.c));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.b;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.a.c(iTTLiveTokenInjectionAuth));
        }
        Map<String, String> map2 = this.d;
        if (map2 != null) {
            hostActionParam.addHostInitExtra(map2);
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.b.2
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                c.a("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                if (b.this.e != null) {
                    b.this.e.a(-3, str, false);
                }
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                c.b("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.a.a();
                if (b.this.e != null) {
                    b.this.e.a(2, null, false);
                }
                b.this.d = null;
                b.this.b = null;
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        Boolean valueOf = Boolean.valueOf(String.valueOf(map.get("sub_process")));
        c.a("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.a.a(TTAppContextHolder.getContext(), String.valueOf(map.get("g_appid")), hostActionParam, iLiveInitCallback, valueOf.booleanValue())), " subProcess=", valueOf);
    }

    public static b a() {
        return f10793a;
    }

    public static Bridge a(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new a(iLiveAdCustomConfig);
    }

    public void a(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.b = iTTLiveTokenInjectionAuth;
    }

    public void a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.d = map;
    }

    public <T> T a(Class<T> cls, int i, Map<String, Object> map) {
        if (i == 0) {
            if (!com.bytedance.sdk.openadsdk.live.a.a(a(map.get(bn.f.o)), b(map.get("bundle")))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i == 7) {
            return (T) d(map);
        }
        if (i != 8) {
            return null;
        }
        return (T) e(map);
    }

    private Context a(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("onlyUpdateState", Boolean.valueOf(z));
        return hashMap;
    }

    private Bundle b(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
