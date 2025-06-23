package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.IIX0o;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"}), @ForeignKey(childColumns = {"prerequisite_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"}), @Index({"prerequisite_id"})}, primaryKeys = {"work_spec_id", "prerequisite_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class Dependency {

    @OOXIXo
    @ColumnInfo(name = "prerequisite_id")
    private final String prerequisiteId;

    @OOXIXo
    @ColumnInfo(name = "work_spec_id")
    private final String workSpecId;

    public Dependency(@OOXIXo String workSpecId, @OOXIXo String prerequisiteId) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        IIX0o.x0xO0oo(prerequisiteId, "prerequisiteId");
        this.workSpecId = workSpecId;
        this.prerequisiteId = prerequisiteId;
    }

    @OOXIXo
    public final String getPrerequisiteId() {
        return this.prerequisiteId;
    }

    @OOXIXo
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
