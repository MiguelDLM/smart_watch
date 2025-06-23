package com.baidu.navisdk.pageframe.logic;

import OXOo.OOXIXo;
import XO0OX.xoIox;
import android.app.Activity;
import com.baidu.navisdk.logicframe.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class a extends b {

    @OOXIXo
    private final com.baidu.navisdk.pageframe.store.b g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public a(@OOXIXo Activity activity, @OOXIXo String bizName, @OOXIXo com.baidu.navisdk.framework.data.a dataCenter, @OOXIXo com.baidu.navisdk.pageframe.store.b modelStore) {
        super(activity, bizName, dataCenter);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(bizName, "bizName");
        IIX0o.x0xO0oo(dataCenter, "dataCenter");
        IIX0o.x0xO0oo(modelStore, "modelStore");
        this.g = modelStore;
    }

    public final <T extends com.baidu.navisdk.pageframe.store.data.b> T b(@OOXIXo Class<T> tClass) {
        IIX0o.x0xO0oo(tClass, "tClass");
        return (T) this.g.a((Class) tClass);
    }
}
