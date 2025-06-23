package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;

/* loaded from: classes8.dex */
public class MediationAdClassLoader implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private static volatile MediationAdClassLoader f10851a;

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (f10851a == null) {
            synchronized (MediationAdClassLoader.class) {
                f10851a = new MediationAdClassLoader();
            }
        }
        return f10851a;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    @RequiresApi(api = 19)
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            MediationLoaderConfig create = MediationLoaderConfig.create(valueSet);
            Context context = (Context) valueSet.objectValue(8009, Context.class);
            try {
                Object newInstance = Class.forName(create.getClassName()).newInstance();
                if (newInstance instanceof Bridge) {
                    Bridge bridge = (Bridge) newInstance;
                    MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                    create2.add(8009, context);
                    ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
                    if (valueSet2 != null) {
                        create2.add(8424, valueSet2);
                    } else {
                        create2.add(8424, valueSet);
                    }
                    bridge.call(8241, create2.build(), null);
                }
            } catch (ClassNotFoundException e) {
                e = e;
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e = e2;
                e.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        } else if (i == 8229) {
            try {
                Class.forName(valueSet.stringValue(8010));
                return (T) Boolean.TRUE;
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
                return (T) Boolean.FALSE;
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
