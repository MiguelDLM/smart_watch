package androidx.work.impl.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SystemIdInfoKt {
    @OOXIXo
    public static final SystemIdInfo systemIdInfo(@OOXIXo WorkGenerationalId generationalId, int i) {
        IIX0o.x0xO0oo(generationalId, "generationalId");
        return new SystemIdInfo(generationalId.getWorkSpecId(), generationalId.getGeneration(), i);
    }
}
