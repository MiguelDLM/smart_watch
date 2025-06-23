package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.work.Data;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})})
public final class WorkProgress {
    @ColumnInfo(name = "progress")
    @OOXIXo
    private final Data progress;
    @ColumnInfo(name = "work_spec_id")
    @OOXIXo
    @PrimaryKey
    private final String workSpecId;

    public WorkProgress(@OOXIXo String str, @OOXIXo Data data) {
        IIX0o.x0xO0oo(str, "workSpecId");
        IIX0o.x0xO0oo(data, "progress");
        this.workSpecId = str;
        this.progress = data;
    }

    @OOXIXo
    public final Data getProgress() {
        return this.progress;
    }

    @OOXIXo
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
