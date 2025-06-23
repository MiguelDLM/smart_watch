package com.baidu.navisdk.pageframe.logic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.logicframe.LogicFrame;
import com.baidu.navisdk.pageframe.logic.a;
import com.baidu.navisdk.pageframe.store.data.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class BNLogicFrame<C extends a> extends LogicFrame<C> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNLogicFrame(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        r();
        s();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oOoXoXO
    public final <T extends b> T a(@OOXIXo Class<T> tClass) {
        IIX0o.x0xO0oo(tClass, "tClass");
        return (T) ((a) n()).b(tClass);
    }

    public abstract void r();

    public abstract void s();
}
