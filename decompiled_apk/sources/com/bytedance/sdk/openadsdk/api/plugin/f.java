package com.bytedance.sdk.openadsdk.api.plugin;

import XXO0.oIX0oI;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.a;
import com.bytedance.sdk.openadsdk.api.plugin.e;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import o0.XxX0x0xxx;
import o0.xXxxox0I;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f extends com.bytedance.sdk.openadsdk.api.a {

    /* renamed from: a, reason: collision with root package name */
    private static final a f10707a = new a();
    private volatile Initializer b;
    private d c;
    private com.bytedance.sdk.openadsdk.a.b d = new com.bytedance.sdk.openadsdk.a.b() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
        @Override // com.bytedance.sdk.openadsdk.a.b
        public Bridge a(int i) {
            return f.this.a(i);
        }
    };

    /* loaded from: classes8.dex */
    public static final class a extends a.c {
        private a() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.a.c
        public void a(Throwable th) {
            e.a(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.a.c
        public Object a(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                e.a(TTAppContextHolder.getContext()).a((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.b.a((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return e.a(TTAppContextHolder.getContext()).a(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean b(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.b(context, adConfig, initCallback);
        this.c = d.a("duration");
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        c.a(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public com.bytedance.sdk.openadsdk.a.b c() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public void a(Result result) {
        if (result.isSuccess()) {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 0);
            ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
            if (executorService != null) {
                com.bytedance.sdk.openadsdk.e.a.a().a(executorService);
            }
            c.a();
            return;
        }
        c.a(result.code(), result.message(), 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public void b(Context context, xXxxox0I xxxxox0i) {
        d dVar = this.c;
        if (dVar == null) {
            dVar = d.a("duration");
        }
        dVar.b("wait_asyn_cost");
        try {
            Initializer a2 = a(dVar);
            try {
                if (a2 == null) {
                    b(XxX0x0xxx.oIX0oI().X0o0xo(false).II0xO0(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).oxoX("Init error").XO());
                    return;
                }
                a(a2.getManager());
                try {
                    dVar.a();
                    JSONObject jSONObject = new JSONObject();
                    dVar.a(jSONObject, 20L);
                    jSONObject.put("zeus", e.a(TTAppContextHolder.getContext()).a());
                    a2.init(context, xxxxox0i.Oxx0IOOO(9, jSONObject).OOXIXo());
                    if (context != null) {
                        Zeus.hookHuaWeiVerifier((Application) context.getApplicationContext());
                    }
                } catch (Exception e) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    b(XxX0x0xxx.oIX0oI().X0o0xo(false).II0xO0(4207).oxoX("Init error").XO());
                    throw e;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                b(XxX0x0xxx.oIX0oI().X0o0xo(false).II0xO0(MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR).oxoX("UnExpected initializer error :" + th.getMessage()).XO());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.a e2) {
            e2.printStackTrace();
            b(XxX0x0xxx.oIX0oI().X0o0xo(false).II0xO0(e2.a()).oxoX(e2.getMessage()).XO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bridge a(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.b.a();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.d.a(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.a.a.a();
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean a(Context context, xXxxox0I xxxxox0i) {
        if (this.b == null) {
            return false;
        }
        this.b.init(context, xxxxox0i.OOXIXo());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public boolean a() {
        if (this.b != null) {
            return this.b.isInitSuccess();
        }
        return false;
    }

    private Initializer a(d dVar) throws com.bytedance.sdk.openadsdk.api.plugin.a {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Create initializer");
                        this.b = b(dVar);
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.api.a
    public a.c b() {
        return f10707a;
    }

    private static Initializer b(d dVar) throws com.bytedance.sdk.openadsdk.api.plugin.a {
        try {
            dVar.b("call_create_initializer");
            BaseDexClassLoader a2 = e.a(TTAppContextHolder.getContext()).a(dVar);
            if (a2 != null) {
                Class<?> loadClass = a2.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                dVar.b("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putLong("call_init_time", dVar.b());
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new e.c());
                dVar.b("create_bundle_cost");
                Method declaredMethod = loadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                dVar.b("get_init_method_cost");
                try {
                    Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                    dVar.b("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.c.b("TTPluginManager", "Create initializer success");
                    return initializer;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.a(4205, "Get initializer failed");
        } catch (Throwable th2) {
            if (th2 instanceof com.bytedance.sdk.openadsdk.api.plugin.a) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.a(4205, oIX0oI.I0Io.f4096II0xO0 + th2.a() + ", " + th2.getMessage() + oIX0oI.I0Io.f4095I0Io);
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.a(4206, th2.getMessage());
        }
    }
}
