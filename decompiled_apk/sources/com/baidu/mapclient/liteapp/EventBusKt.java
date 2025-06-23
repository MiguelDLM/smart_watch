package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class EventBusKt {

    @OOXIXo
    private static final Object EMPTY_DATA = new Object();

    @OOXIXo
    public static final String STAT_NAV = "STAT_NAV";

    public static final void postEvent(@OOXIXo String tag, @OOXIXo Object data) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(data, "data");
        XO0.II0xO0.oxoX().OOXIXo(data, tag);
    }

    public static /* synthetic */ void postEvent$default(String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = EMPTY_DATA;
        }
        postEvent(str, obj);
    }
}
