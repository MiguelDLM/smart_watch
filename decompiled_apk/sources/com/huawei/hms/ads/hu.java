package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: classes10.dex */
public class hu implements hh {
    private static boolean Code = gw.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final ht B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private hu(float f, boolean z, ht htVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = htVar;
        this.Z = vastProperties;
    }

    public static hu Code(float f, boolean z, ht htVar) {
        Position Code2;
        return new hu(f, z, htVar, (htVar == null || !Code() || (Code2 = ht.Code(htVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, Code2));
    }

    public VastProperties V() {
        return this.Z;
    }

    private hu(boolean z, ht htVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = htVar;
        this.Z = vastProperties;
    }

    public static hu Code(boolean z, ht htVar) {
        Position Code2;
        VastProperties vastProperties = null;
        if (!Code) {
            return null;
        }
        if (htVar != null && ht.Code() && (Code2 = ht.Code(htVar)) != null) {
            vastProperties = VastProperties.createVastPropertiesForNonSkippableMedia(z, Code2);
        }
        return new hu(z, htVar, vastProperties);
    }

    public static boolean Code() {
        return Code;
    }
}
