package com.baidu.navisdk.pronavi.logic.service.guidepanel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.pageframe.logic.BNLogicService;
import com.baidu.navisdk.pronavi.data.model.c;
import com.baidu.navisdk.pronavi.logic.base.a;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGGuidePanelModelService<C extends a> extends BNLogicService<C> {
    private final c k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGGuidePanelModelService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.k = (c) ((a) this.i).b(c.class);
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    @oOoXoXO
    public h a(@OOXIXo com.baidu.navisdk.apicenter.a api) {
        IIX0o.x0xO0oo(api, "api");
        int d = api.d();
        if (d != 30001) {
            if (d == 30002) {
                this.k.a(api.c("paramA"));
                return null;
            }
            return null;
        }
        this.k.b(api.c("paramA"));
        return null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGGuidePanelModelService";
    }
}
