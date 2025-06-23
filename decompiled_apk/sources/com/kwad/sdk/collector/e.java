package com.kwad.sdk.collector;

import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;

/* loaded from: classes11.dex */
public final class e {
    public static String cx(String str) {
        try {
            return new String(com.kwad.sdk.core.a.c.Ec().encode(m.k(q.U(new File(str)))));
        } catch (IOException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return null;
        }
    }
}
