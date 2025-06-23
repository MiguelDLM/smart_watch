package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import android.content.Context;
import com.angcyo.dsladapter.DslAdapterItem;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class StatusBaseItem<T> extends DslAdapterItem {

    @OOXIXo
    private final Context mContext;

    public StatusBaseItem(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.mContext = context;
    }

    @OOXIXo
    public final Context getMContext() {
        return this.mContext;
    }

    public abstract void update(T t);

    public abstract void updateOtherData();
}
