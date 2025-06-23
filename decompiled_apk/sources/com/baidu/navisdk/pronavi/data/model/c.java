package com.baidu.navisdk.pronavi.data.model;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class c extends com.baidu.navisdk.pageframe.store.data.b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final X0IIOO f7655a = XIxXXX0x0.oIX0oI(C0311c.f7657a);

    @OOXIXo
    private final X0IIOO b = XIxXXX0x0.oIX0oI(b.f7656a);

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7656a = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            return new com.baidu.navisdk.framework.lifecycle.b<>(Integer.valueOf(bNCommSettingManager.getSimpleGuideMode()));
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.data.model.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0311c extends Lambda implements oIX0oI<com.baidu.navisdk.framework.lifecycle.b<Integer>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0311c f7657a = new C0311c();

        public C0311c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.framework.lifecycle.b<Integer> invoke() {
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            return new com.baidu.navisdk.framework.lifecycle.b<>(Integer.valueOf(bNCommSettingManager.getSimpleGuideMode()));
        }
    }

    static {
        new a(null);
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> a() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.b.getValue();
    }

    @OOXIXo
    public final com.baidu.navisdk.framework.lifecycle.b<Integer> b() {
        return (com.baidu.navisdk.framework.lifecycle.b) this.f7655a.getValue();
    }

    public final void a(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelModelM", "updateCurUiModel:" + a().getValue() + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        Integer value = a().getValue();
        if (value != null && value.intValue() == i) {
            return;
        }
        a().setValue(Integer.valueOf(i));
    }

    public final void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelModelM", "updateUserSettingModel:" + b().getValue() + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        Integer value = b().getValue();
        if (value != null && value.intValue() == i) {
            return;
        }
        b().setValue(Integer.valueOf(i));
    }
}
