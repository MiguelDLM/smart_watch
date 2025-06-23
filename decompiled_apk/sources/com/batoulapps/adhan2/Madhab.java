package com.batoulapps.adhan2;

import OXOo.OOXIXo;
import com.batoulapps.adhan2.internal.ShadowLength;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Madhab {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ Madhab[] $VALUES;
    public static final Madhab SHAFI = new Madhab("SHAFI", 0);
    public static final Madhab HANAFI = new Madhab("HANAFI", 1);

    /* loaded from: classes8.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f10302oIX0oI;

        static {
            int[] iArr = new int[Madhab.values().length];
            try {
                iArr[Madhab.SHAFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Madhab.HANAFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f10302oIX0oI = iArr;
        }
    }

    private static final /* synthetic */ Madhab[] $values() {
        return new Madhab[]{SHAFI, HANAFI};
    }

    static {
        Madhab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Madhab(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<Madhab> getEntries() {
        return $ENTRIES;
    }

    public static Madhab valueOf(String str) {
        return (Madhab) Enum.valueOf(Madhab.class, str);
    }

    public static Madhab[] values() {
        return (Madhab[]) $VALUES.clone();
    }

    @OOXIXo
    public final ShadowLength getShadowLength() {
        int i = oIX0oI.f10302oIX0oI[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ShadowLength.DOUBLE;
            }
            throw new NoWhenBranchMatchedException();
        }
        return ShadowLength.SINGLE;
    }
}
