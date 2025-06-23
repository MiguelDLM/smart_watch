package com.garmin.fit;

import com.garmin.fit.Fit;

/* loaded from: classes9.dex */
public class IOOXOOOOo {

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f11613oIX0oI;

        static {
            int[] iArr = new int[Fit.ProtocolVersion.values().length];
            f11613oIX0oI = iArr;
            try {
                iArr[Fit.ProtocolVersion.V1_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static OxIxx0 oIX0oI(Fit.ProtocolVersion protocolVersion) {
        if (oIX0oI.f11613oIX0oI[protocolVersion.ordinal()] != 1) {
            return new XOoxOOO();
        }
        return new Xox0o();
    }
}
