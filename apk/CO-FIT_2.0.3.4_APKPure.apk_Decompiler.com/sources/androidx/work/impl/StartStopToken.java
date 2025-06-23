package androidx.work.impl;

import OXOo.OOXIXo;
import androidx.work.impl.model.WorkGenerationalId;
import kotlin.jvm.internal.IIX0o;

public final class StartStopToken {
    @OOXIXo
    private final WorkGenerationalId id;

    public StartStopToken(@OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        this.id = workGenerationalId;
    }

    @OOXIXo
    public final WorkGenerationalId getId() {
        return this.id;
    }
}
