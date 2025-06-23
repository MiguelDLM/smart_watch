package com.kwad.components.offline.api.tk.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes11.dex */
public @interface TKSource {
    public static final int CACHE = 2;
    public static final int MEM = 4;
    public static final int ONLINE = 3;
    public static final int UNKONW = 0;
}
