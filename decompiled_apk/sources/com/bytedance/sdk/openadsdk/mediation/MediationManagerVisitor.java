package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.a.a.a.b;
import com.bytedance.sdk.openadsdk.mediation.a.a.g;

/* loaded from: classes8.dex */
public class MediationManagerVisitor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile MediationManagerVisitor f10808a;
    private static volatile Bridge b;
    private b c;

    private MediationManagerVisitor() {
    }

    public static MediationManagerVisitor getInstance() {
        if (f10808a == null) {
            synchronized (MediationManagerVisitor.class) {
                try {
                    if (f10808a == null) {
                        f10808a = new MediationManagerVisitor();
                    }
                } finally {
                }
            }
        }
        return f10808a;
    }

    public synchronized IMediationManager getMediationManager() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                b = (Bridge) adManager.getExtra(null, bundle);
            }
            if (b == null) {
                return null;
            }
            if (this.c == null) {
                this.c = new g(b);
            }
            return this.c;
        } catch (Throwable th) {
            throw th;
        }
    }
}
