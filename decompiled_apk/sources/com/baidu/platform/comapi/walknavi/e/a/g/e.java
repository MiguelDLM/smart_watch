package com.baidu.platform.comapi.walknavi.e.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    protected static UUID f9739a;

    public e(Context context) {
        try {
            if (f9739a == null && context != null) {
                synchronized (e.class) {
                    try {
                        if (f9739a == null) {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                            String string = sharedPreferences.getString("device_id", null);
                            if (string != null) {
                                f9739a = UUID.fromString(string);
                            } else {
                                f9739a = UUID.randomUUID();
                                sharedPreferences.edit().putString("device_id", f9739a.toString()).commit();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Exception e) {
            a.a("DeviceUuidFactory exception: " + e.getMessage());
        }
    }

    public UUID a() {
        return f9739a;
    }
}
