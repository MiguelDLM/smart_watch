package com.baidu.navisdk.pronavi.data.model;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class i extends com.baidu.navisdk.pageframe.store.data.b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final X0IIOO f7673a = XIxXXX0x0.oIX0oI(a.f7674a);

    @OOXIXo
    private final com.baidu.navisdk.framework.lifecycle.b<Integer> b = new com.baidu.navisdk.framework.lifecycle.b<>(-1);

    /* loaded from: classes7.dex */
    public static final class a extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f7674a = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            return new com.baidu.navisdk.framework.lifecycle.b<>(Integer.valueOf(bNCommSettingManager.getVoiceMode()));
        }
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> a() {
        return this.b;
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> b() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f7673a.getValue();
    }
}
