package com.baidu.navisdk.module.ar.msg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Message;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes7.dex */
public abstract class a implements Observer {
    public abstract void a(@OOXIXo Message message);

    @Override // java.util.Observer
    public final void update(@oOoXoXO Observable observable, @oOoXoXO Object obj) {
        if (obj != null) {
            a((Message) obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Message");
    }
}
