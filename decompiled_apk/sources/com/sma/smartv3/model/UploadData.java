package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class UploadData<T> {

    @oOoXoXO
    private List<? extends T> data;

    @OOXIXo
    private String identity = "";

    @oOoXoXO
    public final List<T> getData() {
        return this.data;
    }

    @OOXIXo
    public final String getIdentity() {
        return this.identity;
    }

    public final void setData(@oOoXoXO List<? extends T> list) {
        this.data = list;
    }

    public final void setIdentity(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.identity = str;
    }
}
