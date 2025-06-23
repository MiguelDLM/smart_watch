package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* loaded from: classes10.dex */
public class hp implements hh {
    private static boolean Code = gw.Code("com.iab.omid.library.huawei.adsession.media.VastProperties");
    private final ho B;
    private Float C;
    private final boolean I;
    private final boolean V;
    private final VastProperties Z;

    private hp(float f, boolean z, ho hoVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.C = Float.valueOf(f);
        this.I = z;
        this.B = hoVar;
        this.Z = vastProperties;
    }

    public static hp Code(float f, boolean z, ho hoVar) {
        Position Code2;
        return new hp(f, z, hoVar, (hoVar == null || !Code() || (Code2 = ho.Code(hoVar)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f, z, Code2));
    }

    public ho B() {
        return this.B;
    }

    public VastProperties C() {
        return this.Z;
    }

    public Float I() {
        return this.C;
    }

    public boolean V() {
        return false;
    }

    public boolean Z() {
        return this.I;
    }

    private hp(boolean z, ho hoVar, VastProperties vastProperties) {
        this.V = false;
        this.C = Float.valueOf(0.0f);
        this.I = z;
        this.B = hoVar;
        this.Z = vastProperties;
    }

    public static hp Code(boolean z, ho hoVar) {
        Position Code2;
        return new hp(z, hoVar, (hoVar == null || !Code() || (Code2 = ho.Code(hoVar)) == null) ? null : VastProperties.createVastPropertiesForNonSkippableMedia(z, Code2));
    }

    public static boolean Code() {
        return Code;
    }
}
