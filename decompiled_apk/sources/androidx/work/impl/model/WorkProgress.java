package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.work.Data;
import kotlin.jvm.internal.IIX0o;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkProgress {

    @OOXIXo
    @ColumnInfo(name = "progress")
    private final Data progress;

    @OOXIXo
    @PrimaryKey
    @ColumnInfo(name = "work_spec_id")
    private final String workSpecId;

    public WorkProgress(@OOXIXo String workSpecId, @OOXIXo Data progress) {
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        IIX0o.x0xO0oo(progress, "progress");
        this.workSpecId = workSpecId;
        this.progress = progress;
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
