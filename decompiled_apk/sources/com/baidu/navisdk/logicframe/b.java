package com.baidu.navisdk.logicframe;

import OXOo.OOXIXo;
import android.app.Activity;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.context.business.a {

    @OOXIXo
    private final com.baidu.navisdk.framework.data.a f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@OOXIXo Activity activity, @OOXIXo String bizName, @OOXIXo com.baidu.navisdk.framework.data.a dataCenter) {
        super(activity, bizName);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(bizName, "bizName");
        IIX0o.x0xO0oo(dataCenter, "dataCenter");
        this.f = dataCenter;
    }

    @Override // com.baidu.navisdk.context.business.a, com.baidu.navisdk.context.d
    public void d() {
        super.d();
        this.f.a();
    }
}
