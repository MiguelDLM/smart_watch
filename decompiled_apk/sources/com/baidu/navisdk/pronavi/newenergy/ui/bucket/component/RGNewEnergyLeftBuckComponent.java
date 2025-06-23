package com.baidu.navisdk.pronavi.newenergy.ui.bucket.component;

import OXOo.OOXIXo;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.pronavi.ui.bucket.RGLeftBucketComponent;
import com.baidu.navisdk.pronavi.ui.bucket.config.a;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewEnergyLeftBuckComponent extends RGLeftBucketComponent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewEnergyLeftBuckComponent(@OOXIXo b context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void E() {
        a aVar;
        if (this.q == null) {
            if (com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true)) {
                aVar = new com.baidu.navisdk.pronavi.newenergy.ui.bucket.config.b();
            } else {
                aVar = new com.baidu.navisdk.pronavi.newenergy.ui.bucket.config.a();
            }
            this.q = aVar;
        }
        if (this.p == null) {
            this.p = new com.baidu.navisdk.pronavi.ui.bucket.factory.b();
        }
    }
}
