package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.IIX0o;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"name", "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkName {

    @OOXIXo
    @ColumnInfo(name = "name")
    private final String name;

    @OOXIXo
    @ColumnInfo(name = "work_spec_id")
    private final String workSpecId;

    public WorkName(@OOXIXo String name, @OOXIXo String workSpecId) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        this.name = name;
        this.workSpecId = workSpecId;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
