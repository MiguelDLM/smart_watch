package com.baidu.navisdk.pageframe.store;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class c extends a<com.baidu.navisdk.pageframe.ui.a> {
    @Override // com.baidu.navisdk.pageframe.store.a
    public void b(@OOXIXo Class<?> modelClass) {
        IIX0o.x0xO0oo(modelClass, "modelClass");
        if (com.baidu.navisdk.pageframe.store.data.c.class.isAssignableFrom(modelClass)) {
            return;
        }
        throw new IllegalArgumentException(modelClass.getCanonicalName() + " must RGViewBaseVM subclass");
    }
}
