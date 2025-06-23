package androidx.work.impl.model;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"tag", "work_spec_id"})
public final class WorkTag {
    @ColumnInfo(name = "tag")
    @OOXIXo
    private final String tag;
    @ColumnInfo(name = "work_spec_id")
    @OOXIXo
    private final String workSpecId;

    public WorkTag(@OOXIXo String str, @OOXIXo String str2) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(str2, "workSpecId");
        this.tag = str;
        this.workSpecId = str2;
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
