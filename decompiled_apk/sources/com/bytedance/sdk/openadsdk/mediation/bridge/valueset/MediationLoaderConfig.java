package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: classes8.dex */
public class MediationLoaderConfig {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10867a;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            ValueSet valueSet2 = (ValueSet) valueSet.objectValue(8424, ValueSet.class);
            if (valueSet2 != null) {
                this.f10867a = valueSet2;
            } else {
                this.f10867a = valueSet;
            }
        }
    }

    private boolean a() {
        ValueSet valueSet = this.f10867a;
        if (valueSet != null && !valueSet.isEmpty()) {
            return true;
        }
        return false;
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    public String getADNName() {
        if (a()) {
            return this.f10867a.stringValue(8003);
        }
        return "";
    }

    public ValueSet getAdSlotValueSet() {
        if (a()) {
            return (ValueSet) this.f10867a.objectValue(8548, ValueSet.class);
        }
        return null;
    }

    public int getAdType() {
        if (a()) {
            return this.f10867a.intValue(8008);
        }
        return 0;
    }

    public String getClassName() {
        if (a()) {
            return this.f10867a.stringValue(8010);
        }
        return "";
    }

    public Context getContext() {
        if (a()) {
            return (Context) this.f10867a.objectValue(8009, Context.class);
        }
        return null;
    }

    public Bridge getGMCustomAdLoader() {
        if (a()) {
            return (Bridge) this.f10867a.objectValue(8011, Bridge.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (a()) {
            return (ValueSet) this.f10867a.objectValue(8546, ValueSet.class);
        }
        return null;
    }
}
