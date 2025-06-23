package androidx.work.impl.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

public final class SystemIdInfoKt {
    @OOXIXo
    public static final SystemIdInfo systemIdInfo(@OOXIXo WorkGenerationalId workGenerationalId, int i) {
        IIX0o.x0xO0oo(workGenerationalId, "generationalId");
        return new SystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration(), i);
    }
}
