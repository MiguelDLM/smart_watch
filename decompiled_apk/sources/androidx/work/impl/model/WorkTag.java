package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.IIX0o;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"tag", "work_spec_id"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkTag {

    @OOXIXo
    @ColumnInfo(name = "tag")
    private final String tag;

    @OOXIXo
    @ColumnInfo(name = "work_spec_id")
    private final String workSpecId;

    public WorkTag(@OOXIXo String tag, @OOXIXo String workSpecId) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        this.tag = tag;
        this.workSpecId = workSpecId;
    }

    @OOXIXo
    public final String getTag() {
        return this.tag;
    }

    @OOXIXo
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
