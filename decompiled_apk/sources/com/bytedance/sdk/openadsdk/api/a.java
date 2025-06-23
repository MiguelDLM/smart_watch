package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationTTLiveTokenInjectionAuthImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private TTAdSdk.InitCallback f10660a;

    /* renamed from: com.bytedance.sdk.openadsdk.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static abstract class AbstractC0566a<T> {
        private AbstractC0566a() {
        }

        public abstract void a(b<T> bVar, int i);

        public void a(Throwable th) {
        }
    }

    /* loaded from: classes8.dex */
    public interface b<T> {
        void a(T t);
    }

    /* loaded from: classes8.dex */
    public static abstract class c implements TTAdManager {

        /* renamed from: a, reason: collision with root package name */
        private volatile Manager f10665a;
        private volatile boolean b;
        private List<WeakReference<b<Manager>>> c = new CopyOnWriteArrayList();

        /* renamed from: com.bytedance.sdk.openadsdk.api.a$c$1, reason: invalid class name */
        /* loaded from: classes8.dex */
        public class AnonymousClass1 extends AbstractC0566a<Loader> {

            /* renamed from: a, reason: collision with root package name */
            Loader f10666a;
            final b<Manager> b;
            final /* synthetic */ SoftReference c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.c = softReference;
                this.b = new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.a.b
                    public void a(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f10666a = manager.createLoader((Context) anonymousClass1.c.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.a.AbstractC0566a
            public void a(final b<Loader> bVar, int i) {
                Loader loader = this.f10666a;
                if (loader != null) {
                    bVar.a(loader);
                } else {
                    c.this.a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.a.b
                        public void a(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c.this.a(anonymousClass1.b);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.f10666a = manager.createLoader((Context) anonymousClass12.c.get());
                            bVar.a(AnonymousClass1.this.f10666a);
                        }
                    }, i + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, xXxxox0I.II0xO0(2).Oxx0IOOO(9, cls).Oxx0IOOO(10, bundle).OOXIXo(), cls);
        }

        public Object a(Object obj) {
            return obj;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new e(new AnonymousClass1(new SoftReference(context))).a();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.f10665a != null) {
                return (T) b(this.f10665a, cls, bundle);
            }
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.4
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    c.b(c.this.f10665a, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            if (this.f10665a != null) {
                return this.f10665a.values().stringValue(12);
            }
            return "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "6.3.1.7";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f10665a != null) {
                return this.f10665a.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.2
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(4, xXxxox0I.II0xO0(1).Oxx0IOOO(8, c.this.a(obj)).OOXIXo(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.5
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(3, xXxxox0I.II0xO0(1).Oxx0IOOO(7, context).OOXIXo(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.6
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(1, xXxxox0I.oIX0oI().X0o0xo(11, i).OOXIXo(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap hashMap = new HashMap();
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
            hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, xXxxox0I.II0xO0(1).Oxx0IOOO(0, hashMap).OOXIXo(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            a(new b<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.a.c.3
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Manager manager) {
                    manager.getBridge(1).call(5, xXxxox0I.II0xO0(1).Oxx0IOOO(8, obj).OOXIXo(), Void.class);
                }
            }, 5);
        }

        public void a(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet OOXIXo2 = xXxxox0I.xoIox(com.bytedance.sdk.openadsdk.c.a.c.b.b(adSlot)).xxIXOIIO(13, z).X0o0xo(14, i).OOXIXo();
            if (this.f10665a != null) {
                return (String) this.f10665a.getBridge(1).call(2, OOXIXo2, String.class);
            }
            return null;
        }

        public void a(boolean z) {
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Manager manager) {
            this.f10665a = manager;
            if (this.f10665a != null) {
                Iterator<WeakReference<b<Manager>>> it = this.c.iterator();
                while (it.hasNext()) {
                    WeakReference<b<Manager>> next = it.next();
                    b<Manager> bVar = next != null ? next.get() : null;
                    if (bVar != null) {
                        bVar.a(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(b<Manager> bVar) {
            this.c.add(new WeakReference<>(bVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final b<Manager> bVar, final int i) {
            if (this.f10665a != null) {
                try {
                    bVar.a(this.f10665a);
                    return;
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    a(th);
                    return;
                }
            }
            if (!this.b && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.bytedance.sdk.openadsdk.e.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.a.c.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f10665a != null) {
                            bVar.a(c.this.f10665a);
                        } else {
                            com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        }
                    } catch (Throwable th2) {
                        com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        c.this.a(th2);
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    public class d implements EventListener {
        private d() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i, Result result) {
            a.this.b(result);
            return null;
        }
    }

    public void a(Result result) {
    }

    public abstract boolean a();

    public abstract boolean a(Context context, xXxxox0I xxxxox0i);

    public abstract c b();

    public abstract void b(Context context, xXxxox0I xxxxox0i);

    public boolean b(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.bytedance.sdk.openadsdk.a.b c();

    public void a(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.a.c.a().a(c());
        if (b(context, adConfig, initCallback)) {
            this.f10660a = initCallback;
            final xXxxox0I xoIox2 = xXxxox0I.xoIox(com.bytedance.sdk.openadsdk.c.a.c.a.a(adConfig));
            xoIox2.XO(1, SystemClock.elapsedRealtime());
            xoIox2.II0XooXoX(5, "main");
            xoIox2.xxIXOIIO(4, true);
            xoIox2.X0o0xo(6, 999);
            xoIox2.X0o0xo(10, 6317);
            xoIox2.II0XooXoX(11, "6.3.1.7");
            xoIox2.II0XooXoX(12, "com.byted.pangle");
            xoIox2.xxIXOIIO(14, false);
            xoIox2.Oxx0IOOO(16, com.bytedance.sdk.openadsdk.a.c.a());
            Thread currentThread = Thread.currentThread();
            xoIox2.II0XooXoX(2, currentThread.getName());
            xoIox2.X0o0xo(3, currentThread.getPriority());
            xoIox2.Oxx0IOOO(15, new d());
            xoIox2.Oxx0IOOO(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                xoIox2.Oxx0IOOO(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!a(context, xoIox2)) {
                com.bytedance.sdk.openadsdk.e.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b(context, xoIox2);
                    }
                });
            }
            b().a(true);
        }
    }

    public void b(Result result) {
        a(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f10660a;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.c.e("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f10660a;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f10660a = null;
    }

    /* loaded from: classes8.dex */
    public static class e extends com.bytedance.sdk.openadsdk.c.a.a {

        /* renamed from: a, reason: collision with root package name */
        private AbstractC0566a<Loader> f10677a;

        public e(AbstractC0566a<Loader> abstractC0566a) {
            this.f10677a = abstractC0566a;
        }

        private void a(b<Loader> bVar, int i) {
            try {
                com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "load ad slot type: " + i);
                this.f10677a.a(bVar, i);
            } catch (Throwable th) {
                this.f10677a.a(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void b(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.3
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(6, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void c(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.4
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(9, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void d(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.5
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(1, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void e(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.7
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(7, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void f(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.8
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(8, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void g(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.9
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(5, xXxxox0I.xoIox(valueSet).xxIXOIIO(2, true).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void h(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.10
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(9, xXxxox0I.xoIox(valueSet).xxIXOIIO(2, true).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void i(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.2
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(1, xXxxox0I.xoIox(valueSet).xxIXOIIO(2, true).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void a(final ValueSet valueSet, final Bridge bridge) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.1
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(5, xXxxox0I.xoIox(valueSet).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public void a(final ValueSet valueSet, final Bridge bridge, final int i) {
            a(new b<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.a.e.6
                @Override // com.bytedance.sdk.openadsdk.api.a.b
                public void a(Loader loader) {
                    loader.load(3, xXxxox0I.xoIox(valueSet).X0o0xo(3, i).Oxx0IOOO(1, bridge).OOXIXo(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.c.a.a
        public Pair<Integer, String> a(Exception exc) {
            com.bytedance.sdk.openadsdk.api.c.d("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(4202, "Load ad failed: " + exc.getMessage());
        }
    }

    public void a(Manager manager) {
        com.bytedance.sdk.openadsdk.api.c.b("_tt_ad_sdk_", "update manager");
        b().a(manager);
        b().register(com.bytedance.sdk.openadsdk.a.c.a());
    }
}
