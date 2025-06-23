package com.facebook.internal;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class InternalSettings {

    @OXOo.OOXIXo
    public static final InternalSettings INSTANCE = new InternalSettings();

    @OXOo.OOXIXo
    private static final String UNITY_PREFIX = "Unity.";

    @OXOo.oOoXoXO
    private static volatile String customUserAgent;

    private InternalSettings() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        Boolean bool = null;
        if (str != null) {
            bool = Boolean.valueOf(kotlin.text.OxI.IOOoXo0Ix(str, UNITY_PREFIX, false, 2, null));
        }
        return IIX0o.Oxx0IOOO(bool, Boolean.TRUE);
    }

    @XO0OX.x0XOIxOo
    public static /* synthetic */ void isUnityApp$annotations() {
    }

    @XO0OX.x0XOIxOo
    public static final void setCustomUserAgent(@OXOo.OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        customUserAgent = value;
    }
}
