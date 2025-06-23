package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"}), @ForeignKey(childColumns = {"prerequisite_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"}), @Index({"prerequisite_id"})}, primaryKeys = {"work_spec_id", "prerequisite_id"})
public final class Dependency {
    @ColumnInfo(name = "prerequisite_id")
    @OOXIXo
    private final String prerequisiteId;
    @ColumnInfo(name = "work_spec_id")
    @OOXIXo
    private final String workSpecId;

    public Dependency(@OOXIXo String str, @OOXIXo String str2) {
        IIX0o.x0xO0oo(str, "workSpecId");
        IIX0o.x0xO0oo(str2, "prerequisiteId");
        this.workSpecId = str;
        this.prerequisiteId = str2;
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
