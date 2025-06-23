package com.vtrump.vtble.b;

import com.vtrump.vtble.Oxx0xo;

/* loaded from: classes13.dex */
public class a extends RuntimeException {
    public a(String str) {
        super(str);
        Oxx0xo.II0xO0("NullListenerException", "NullListenerException: " + str + " is null ,you may not register the listener");
    }
}
