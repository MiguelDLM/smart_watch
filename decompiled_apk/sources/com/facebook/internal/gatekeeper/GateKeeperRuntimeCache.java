package com.facebook.internal.gatekeeper;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GateKeeperRuntimeCache {

    @OOXIXo
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, GateKeeper>> gateKeepers = new ConcurrentHashMap<>();

    public static /* synthetic */ List dumpGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.dumpGateKeepers(str);
    }

    public static /* synthetic */ GateKeeper getGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeper(str, str2);
    }

    public static /* synthetic */ boolean getGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        return gateKeeperRuntimeCache.getGateKeeperValue(str, str2, z);
    }

    public static /* synthetic */ void resetCache$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.resetCache(str);
    }

    public static /* synthetic */ void setGateKeeper$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, GateKeeper gateKeeper, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeper(str, gateKeeper);
    }

    public static /* synthetic */ void setGateKeeperValue$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeeperValue(str, str2, z);
    }

    public static /* synthetic */ void setGateKeepers$default(GateKeeperRuntimeCache gateKeeperRuntimeCache, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            str = FacebookSdk.getApplicationId();
        }
        gateKeeperRuntimeCache.setGateKeepers(str, list);
    }

    @oOoXoXO
    public final List<GateKeeper> dumpGateKeepers(@OOXIXo String appId) {
        IIX0o.x0xO0oo(appId, "appId");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        Iterator<Map.Entry<String, GateKeeper>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @oOoXoXO
    public final GateKeeper getGateKeeper(@OOXIXo String appId, @OOXIXo String name) {
        IIX0o.x0xO0oo(appId, "appId");
        IIX0o.x0xO0oo(name, "name");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(name);
    }

    public final boolean getGateKeeperValue(@OOXIXo String appId, @OOXIXo String name, boolean z) {
        IIX0o.x0xO0oo(appId, "appId");
        IIX0o.x0xO0oo(name, "name");
        GateKeeper gateKeeper = getGateKeeper(appId, name);
        if (gateKeeper != null) {
            return gateKeeper.getValue();
        }
        return z;
    }

    public final void resetCache(@OOXIXo String appId) {
        IIX0o.x0xO0oo(appId, "appId");
        this.gateKeepers.remove(appId);
    }

    public final void setGateKeeper(@OOXIXo String appId, @OOXIXo GateKeeper gateKeeper) {
        IIX0o.x0xO0oo(appId, "appId");
        IIX0o.x0xO0oo(gateKeeper, "gateKeeper");
        if (!this.gateKeepers.containsKey(appId)) {
            this.gateKeepers.put(appId, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = this.gateKeepers.get(appId);
        if (concurrentHashMap != null) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
    }

    public final void setGateKeeperValue(@OOXIXo String appId, @OOXIXo String name, boolean z) {
        IIX0o.x0xO0oo(appId, "appId");
        IIX0o.x0xO0oo(name, "name");
        setGateKeeper(appId, new GateKeeper(name, z));
    }

    public final void setGateKeepers(@OOXIXo String appId, @OOXIXo List<GateKeeper> gateKeeperList) {
        IIX0o.x0xO0oo(appId, "appId");
        IIX0o.x0xO0oo(gateKeeperList, "gateKeeperList");
        ConcurrentHashMap<String, GateKeeper> concurrentHashMap = new ConcurrentHashMap<>();
        for (GateKeeper gateKeeper : gateKeeperList) {
            concurrentHashMap.put(gateKeeper.getName(), gateKeeper);
        }
        this.gateKeepers.put(appId, concurrentHashMap);
    }
}
