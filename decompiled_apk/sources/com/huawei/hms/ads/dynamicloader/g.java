package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamicloader.versionstrategy.VersionStrategyFactory;
import com.huawei.hms.ads.uiengineloader.af;
import com.huawei.hms.ads.uiengineloader.ah;
import com.huawei.hms.ads.uiengineloader.am;
import com.huawei.hms.ads.uiengineloader.u;
import com.huawei.hms.ads.uiengineloader.y;

/* loaded from: classes10.dex */
public final class g extends IDynamicLoader.Stub {
    public static String b = null;
    private static final String c = "DynamicLoader";
    private static final String d = "version_strategy_type";
    private static final String e = "media_app_pkg";

    private static IObjectWrapper a(Context context, Bundle bundle, String str) throws RemoteException {
        String string = bundle.getString("module_name");
        b = bundle.getString("loader_path");
        int i = bundle.getInt("version_strategy_type");
        String string2 = bundle.getString(b.e, b.f);
        af.b("DynamicLoader", "the moduleName is:" + string + ", versionStrategyType:" + i + " loaderVersionType : " + string2);
        try {
            am versionPolicy = VersionStrategyFactory.getVersionPolicy(i);
            if (versionPolicy == null) {
                af.c("DynamicLoader", "Invalid version policy.");
                return ah.a((Object) null);
            }
            u a2 = versionPolicy.a(context, bundle);
            if (a2 == null) {
                throw new RemoteException("Get loading strategy failed.");
            }
            y a3 = a2.a(context, string, str);
            if (a3 != null) {
                a3.f = string2;
                return ah.a(a2.a(context, a3));
            }
            af.b("DynamicLoader", "moduleInfo is null");
            throw new RemoteException("Null moduleInfo.");
        } catch (j e2) {
            af.c("DynamicLoader", "LoaderException:" + e2.getMessage());
            Bundle bundle2 = e2.f17282a;
            if (bundle2 != null) {
                af.c("DynamicLoader", "Get bundle from LoaderException.");
                return ah.a(bundle2);
            }
            throw new RemoteException("Load failed:" + e2.getMessage());
        } catch (Exception e3) {
            af.c("DynamicLoader", "Other exception." + e3.getClass().getSimpleName());
            throw new RemoteException("Load dynamic module failed.");
        }
    }

    @Override // com.huawei.hms.ads.dynamic.IDynamicLoader
    public final IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        if (iObjectWrapper == null) {
            af.c("DynamicLoader", "The context is null.");
            return ah.a((Object) null);
        }
        Context context = (Context) ah.a(iObjectWrapper);
        Object a2 = ah.a(iObjectWrapper2);
        if (!(a2 instanceof Bundle)) {
            af.c("DynamicLoader", "The moduleInfo type is not Bundle.");
            return ah.a((Object) null);
        }
        Bundle bundle = (Bundle) a2;
        int i2 = bundle.getInt("version_strategy_type", 0);
        String string = bundle.getString("media_app_pkg", "");
        af.b("DynamicLoader", "versionType=".concat(String.valueOf(i2)));
        if (i2 != 0) {
            return a(context, bundle, string);
        }
        h.a(context);
        return ah.a(h.a(context, bundle));
    }
}
