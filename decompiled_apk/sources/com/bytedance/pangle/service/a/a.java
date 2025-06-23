package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends e.a {
    private static volatile a c;
    private final HashMap<ComponentName, IBinder> d = new HashMap<>();
    private final HashMap<ComponentName, b> e = new HashMap<>();
    private final C0564a<Intent> f = new C0564a<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> g = new HashMap<>();
    private final HashSet<ComponentName> h = new HashSet<>();
    private final HashSet<ComponentName> i = new HashSet<>();
    public final List<Runnable> b = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f10614a = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0564a<T> extends HashMap<g, T> {
        public C0564a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            g gVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<g> it = keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    gVar = it.next();
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (gVar.a() == ((g) obj).a()) {
                        break;
                    }
                } else {
                    gVar = null;
                    break;
                }
            }
            return (T) super.remove(gVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends HashSet<g> {
        public b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            g gVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (it.hasNext()) {
                    gVar = (g) it.next();
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (gVar.a() == ((g) obj).a()) {
                        break;
                    }
                } else {
                    gVar = null;
                    break;
                }
            }
            return super.remove(gVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.g.containsKey(component)) {
                com.bytedance.pangle.service.a d = d(intent, str);
                if (d == null) {
                    return component;
                }
                this.g.put(component, d);
                this.h.add(component);
            }
            com.bytedance.pangle.service.a aVar = this.g.get(component);
            if (aVar != null) {
                aVar.onStartCommand(intent, 0, 0);
            }
            return component;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e = e(intent, str);
        if (e != null) {
            e.onCreate();
        }
        return e;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            aVar.attach(plugin);
            return aVar;
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
            return null;
        }
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.e
    public final ComponentName a(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return c(intent, str);
            }
            this.f10614a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        } else {
            this.b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.e
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f10614a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    private boolean b(ComponentName componentName) {
        if (!this.h.contains(componentName)) {
            if (this.e.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.i.contains(componentName) || this.e.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.g.remove(componentName);
        this.i.remove(componentName);
        this.d.remove(componentName);
        this.h.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.g.containsKey(componentName)) {
            return false;
        }
        this.i.add(componentName);
        return b(componentName);
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(final Intent intent, final g gVar, final int i, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, gVar, str);
            }
            this.f10614a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.a(intent, gVar, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                    }
                }
            });
            return true;
        }
        this.b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, gVar, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(g gVar) {
        try {
            for (ComponentName componentName : this.e.keySet()) {
                b bVar = this.e.get(componentName);
                if (bVar.contains(gVar)) {
                    bVar.remove(gVar);
                    Intent remove = this.f.remove(gVar);
                    if (bVar.size() == 0) {
                        this.e.remove(componentName);
                        com.bytedance.pangle.service.a aVar = this.g.get(componentName);
                        if (aVar != null) {
                            aVar.onUnbind(remove);
                        }
                    }
                    b(componentName);
                    return;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, g gVar, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.g.containsKey(component)) {
                com.bytedance.pangle.service.a d = d(intent, str);
                if (d == null) {
                    return false;
                }
                this.g.put(component, d);
            }
            com.bytedance.pangle.service.a aVar = this.g.get(component);
            if (!this.d.containsKey(component)) {
                this.d.put(component, aVar.onBind(intent));
            }
            IBinder iBinder = this.d.get(component);
            if (iBinder != null) {
                if (this.e.containsKey(component)) {
                    if (!this.e.get(component).contains(gVar)) {
                        this.e.get(component).add(gVar);
                        this.f.put(gVar, intent);
                        gVar.a(component, iBinder);
                    }
                } else {
                    b bVar = new b();
                    bVar.add(gVar);
                    this.e.put(component, bVar);
                    this.f.put(gVar, intent);
                    gVar.a(component, iBinder);
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.pangle.e
    public final void a(final g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(gVar);
        } else {
            this.f10614a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(gVar);
                }
            });
        }
    }
}
