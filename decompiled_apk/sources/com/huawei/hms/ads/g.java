package com.huawei.hms.ads;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.ads.dynamic.DynamicModule;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class g {
    private static volatile Context B = null;
    private static IRemoteCreator C = null;
    private static final String Code = "RemoteSdkInitializer";
    private static final List<String> D;
    private static d F = null;
    private static final String I = "com.huawei.hms.ads.common.inter.LoaderSpHandlerInter";
    private static String S = null;
    private static final String V = "adsuiengine";
    private static final String Z = "com.huawei.hms.ads.common.inter.LoaderCommonInter";

    static {
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(com.huawei.openalliance.ad.constant.x.cu);
    }

    public static synchronized IRemoteCreator Code(Context context) {
        Context V2;
        synchronized (g.class) {
            fb.V(Code, "newCreator: ");
            if (C != null) {
                fb.V(Code, "newCreator: mRemoteCreator != null return");
                return C;
            }
            try {
                V2 = V(context);
            } catch (Throwable th) {
                fb.Z(Code, "newCreator failed " + th.getLocalizedMessage());
            }
            if (V2 == null) {
                Log.i(Code, "newCreator: remoteContext= null");
                return null;
            }
            IRemoteCreator Code2 = IRemoteCreator.b.Code((IBinder) V2.getClassLoader().loadClass("com.huawei.hms.ads.uiengine.remote.RemoteCreator").newInstance());
            C = Code2;
            S = Code2.getVersion();
            C.setGlobalUtil(com.huawei.openalliance.ad.inter.e.Code(context));
            C.setSdkInfo(com.huawei.openalliance.ad.utils.d.d(context).intValue(), com.huawei.hms.ads.base.a.B, null);
            F = C.getUiEngineUtil();
            Log.i(Code, "newRemoteContext: mRemoteCreator :" + C);
            return C;
        }
    }

    private static Integer I(Context context) {
        return Integer.valueOf(D.contains(context.getPackageName()) ? 2 : 1);
    }

    private static Context V(Context context) {
        fb.V(Code, "newRemoteContext: ");
        if (B != null) {
            return B;
        }
        try {
            if (com.huawei.openalliance.ad.utils.ar.I(I)) {
                DynamicModule.setSpHandler(ec.Code(context));
            } else {
                fb.Z(Code, "LoaderSpHandler is not available");
            }
            if (com.huawei.openalliance.ad.utils.ar.I(Z)) {
                DynamicModule.setCommonInter(eb.Code(context));
            } else {
                fb.Z(Code, "LoaderCommonHandler is not available");
            }
            B = DynamicModule.load(context, I(context), V, "").getModuleContext();
        } catch (Throwable th) {
            fb.Z(Code, "newRemoteContext failed: " + th.getLocalizedMessage());
        }
        return B;
    }

    public static synchronized String Code() {
        String str;
        synchronized (g.class) {
            str = S;
        }
        return str;
    }

    public static d V() {
        return F;
    }
}
