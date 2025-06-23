package com.baidu.navisdk.pronavi.newenergy.logic;

import OXOo.OOXIXo;
import com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame;
import com.baidu.navisdk.pronavi.logic.a;
import com.baidu.navisdk.pronavi.logic.service.guidepanel.RGGuidePanelModelService;
import com.baidu.navisdk.pronavi.logic.service.ihighspeed.RGIHighSpeedService;
import com.baidu.navisdk.pronavi.logic.service.parkrec.RGParkRecService;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGNewEnergyLogicFrame extends RGBaseLogicFrame {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGNewEnergyLogicFrame(@OOXIXo a context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame, com.baidu.navisdk.pageframe.logic.BNLogicFrame
    public void r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame, com.baidu.navisdk.pageframe.logic.BNLogicFrame
    public void s() {
        super.s();
        a context = (a) n();
        IIX0o.oO(context, "context");
        a(new RGIHighSpeedService(context));
        a context2 = (a) n();
        IIX0o.oO(context2, "context");
        a(new RGGuidePanelModelService(context2));
        a(new RGParkRecService((com.baidu.navisdk.pronavi.logic.base.a) n()));
    }
}
