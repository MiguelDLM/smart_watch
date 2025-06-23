package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.cb;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class bq {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6254a = "ContainerFactoryBuilder";
    private static IXAdContainerFactory e;
    private Context c;
    private Class<?> d;
    public double b = 0.1d;
    private bv f = bv.a();

    public bq(Class<?> cls, Context context) {
        this.d = null;
        this.d = cls;
        this.c = context;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.d.getDeclaredConstructor(Context.class).newInstance(this.c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p_ver", "9.35");
                e.initConfig(jSONObject);
                this.b = e.getRemoteVersion();
                e.onTaskDistribute(bd.f6243a, MobadsPermissionSettings.getPermissionInfo());
                e.initCommonModuleObj(r.a());
            } catch (Throwable th) {
                this.f.b(f6254a, th.getMessage());
                throw new cb.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}
