package androidx.work.impl.model;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

public final class WorkSpecKt {
    private static final long NOT_ENQUEUED = -1;

    @OOXIXo
    public static final WorkGenerationalId generationalId(@OOXIXo WorkSpec workSpec) {
        IIX0o.x0xO0oo(workSpec, "<this>");
        return new WorkGenerationalId(workSpec.id, workSpec.getGeneration());
    }
}
