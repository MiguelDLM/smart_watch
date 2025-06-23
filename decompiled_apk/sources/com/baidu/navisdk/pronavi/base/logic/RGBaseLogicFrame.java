package com.baidu.navisdk.pronavi.base.logic;

import OXOo.OOXIXo;
import com.baidu.navisdk.pageframe.logic.BNLogicFrame;
import com.baidu.navisdk.pronavi.logic.a;
import com.baidu.navisdk.pronavi.logic.service.devicestate.RGDeviceStateService;
import com.baidu.navisdk.pronavi.logic.service.roadcondition.BNRoadConditionService;
import com.baidu.navisdk.pronavi.logic.service.voice.BNVoiceService;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class RGBaseLogicFrame extends BNLogicFrame<a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGBaseLogicFrame(@OOXIXo a context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // com.baidu.navisdk.pageframe.logic.BNLogicFrame
    public void r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pageframe.logic.BNLogicFrame
    public void s() {
        a(new BNRoadConditionService((com.baidu.navisdk.pronavi.logic.base.a) n()));
        a(new BNVoiceService((com.baidu.navisdk.pronavi.logic.base.a) n()));
        a context = (a) n();
        IIX0o.oO(context, "context");
        a(new RGDeviceStateService(context));
    }
}
