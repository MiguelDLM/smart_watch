package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

public final class WorkGenerationalId {
    private final int generation;
    @OOXIXo
    private final String workSpecId;

    public WorkGenerationalId(@OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "workSpecId");
        this.workSpecId = str;
        this.generation = i;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId workGenerationalId, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = workGenerationalId.workSpecId;
        }
        if ((i2 & 2) != 0) {
            i = workGenerationalId.generation;
        }
        return workGenerationalId.copy(str, i);
    }

    @OOXIXo
    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    @OOXIXo
    public final WorkGenerationalId copy(@OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "workSpecId");
        return new WorkGenerationalId(str, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return IIX0o.Oxx0IOOO(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    @OOXIXo
    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.generation;
    }

    @OOXIXo
    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.workSpecId + ", generation=" + this.generation + HexStringBuilder.COMMENT_END_CHAR;
    }
}
