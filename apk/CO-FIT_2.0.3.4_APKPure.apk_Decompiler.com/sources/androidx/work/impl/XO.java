package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import XO0OX.xoIox;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import kotlin.jvm.internal.IIX0o;

public final /* synthetic */ class XO {
    static {
        StartStopTokens.Companion companion = StartStopTokens.Companion;
    }

    @xoIox
    @x0XOIxOo
    @OOXIXo
    public static StartStopTokens I0Io() {
        return StartStopTokens.Companion.create();
    }

    @OOXIXo
    public static StartStopToken II0xO0(StartStopTokens startStopTokens, @OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "spec");
        return startStopTokens.tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    @oOoXoXO
    public static StartStopToken oIX0oI(StartStopTokens startStopTokens, @OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "spec");
        return startStopTokens.remove(WorkSpecKt.generationalId(workSpec));
    }

    @xoIox
    @x0XOIxOo
    @OOXIXo
    public static StartStopTokens oxoX(boolean z) {
        return StartStopTokens.Companion.create(z);
    }
}
