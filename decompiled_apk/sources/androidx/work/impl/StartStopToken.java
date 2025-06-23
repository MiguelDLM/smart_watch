package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class StartStopToken {

    @OXOo.OOXIXo
    private final WorkGenerationalId id;

    public StartStopToken(@OXOo.OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        this.id = id;
    }

    @OXOo.OOXIXo
    public final WorkGenerationalId getId() {
        return this.id;
    }
}
