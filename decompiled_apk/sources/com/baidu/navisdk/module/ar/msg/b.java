package com.baidu.navisdk.module.ar.msg;

import OXOo.OOXIXo;
import java.util.Observable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class b extends Observable {
    public final void a(@OOXIXo a observer) {
        IIX0o.x0xO0oo(observer, "observer");
        addObserver(observer);
    }

    public final void b(@OOXIXo a observer) {
        IIX0o.x0xO0oo(observer, "observer");
        deleteObserver(observer);
    }
}
