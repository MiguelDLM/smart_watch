package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.uiengine.b;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class cg extends b.AbstractBinderC0657b {
    private static final byte[] D = new byte[0];
    private static cg F = null;
    private static final String S = "MultiMPlayingManagerPro";
    private Context L;

    /* renamed from: a, reason: collision with root package name */
    private IMultiMediaPlayingManager f17257a;
    private final Map<Long, cf> b = new HashMap();

    private cg(Context context) {
        this.L = context;
    }

    public static cg Code(Context context) {
        return V(context);
    }

    private Long I(com.huawei.hms.ads.uiengine.a aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            return Long.valueOf(aVar.Code());
        } catch (Throwable th) {
            fb.V(S, "get id err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    private static cg V(Context context) {
        cg cgVar;
        synchronized (D) {
            try {
                if (F == null) {
                    F = new cg(context);
                }
                cgVar = F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cgVar;
    }

    private cf Z(com.huawei.hms.ads.uiengine.a aVar) {
        cf cfVar;
        try {
            long Code = aVar.Code();
            if (this.b.containsKey(Long.valueOf(Code))) {
                cfVar = this.b.get(Long.valueOf(Code));
            } else {
                cf cfVar2 = new cf(this.L, aVar);
                this.b.put(Long.valueOf(Code), cfVar2);
                cfVar = cfVar2;
            }
            if (fb.Code()) {
                fb.Code(S, "getProxy = %s, proxy = %s", Long.valueOf(Code), cfVar);
            }
            return cfVar;
        } catch (Throwable th) {
            fb.V(S, "getProxy err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(com.huawei.hms.ads.uiengine.a aVar) {
        Long I = I(aVar);
        fb.V(S, "removeAgent %s", I);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(Z(aVar));
        }
        if (I != null) {
            this.b.remove(I);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void I(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fb.V(S, "stop %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.I(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(com.huawei.hms.ads.uiengine.a aVar) {
        fb.V(S, "removeListeners %s", I(aVar));
        cf Z = Z(aVar);
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(Z);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Z(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fb.V(S, "pause %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Z(str, Z(aVar));
        }
    }

    public void Code(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.f17257a = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void V(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fb.V(S, "manualPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.V(str, Z(aVar));
        }
    }

    @Override // com.huawei.hms.ads.uiengine.b
    public void Code(String str, com.huawei.hms.ads.uiengine.a aVar) {
        fb.V(S, "autoPlay %s", I(aVar));
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.f17257a;
        if (iMultiMediaPlayingManager != null) {
            iMultiMediaPlayingManager.Code(str, Z(aVar));
        }
    }
}
