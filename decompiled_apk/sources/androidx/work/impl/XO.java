package androidx.work.impl;

import androidx.work.impl.StartStopTokens;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final /* synthetic */ class XO {
    static {
        StartStopTokens.Companion companion = StartStopTokens.Companion;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static StartStopTokens I0Io() {
        return StartStopTokens.Companion.create();
    }

    @OXOo.OOXIXo
    public static StartStopToken II0xO0(StartStopTokens startStopTokens, @OXOo.OOXIXo WorkSpec spec) {
        IIX0o.x0xO0oo(spec, "spec");
        return startStopTokens.tokenFor(WorkSpecKt.generationalId(spec));
    }

    @OXOo.oOoXoXO
    public static StartStopToken oIX0oI(StartStopTokens startStopTokens, @OXOo.OOXIXo WorkSpec spec) {
        IIX0o.x0xO0oo(spec, "spec");
        return startStopTokens.remove(WorkSpecKt.generationalId(spec));
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @XO0OX.xoIox
    public static StartStopTokens oxoX(boolean z) {
        return StartStopTokens.Companion.create(z);
    }
}
