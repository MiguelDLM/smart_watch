package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ProgressMarkers extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String courseId;

    @OOXIXo
    private final String coverUrl;

    @OOXIXo
    private final String describe;

    @OOXIXo
    private final String id;
    private final boolean isCustomized;

    @OOXIXo
    private final String offset;
    private int time;

    @OOXIXo
    private final String title;

    public ProgressMarkers() {
        this(null, null, null, 0, null, null, null, false, 255, null);
    }

    @OOXIXo
    public final String component1() {
        return this.id;
    }

    @OOXIXo
    public final String component2() {
        return this.courseId;
    }

    @OOXIXo
    public final String component3() {
        return this.offset;
    }

    public final int component4() {
        return this.time;
    }

    @OOXIXo
    public final String component5() {
        return this.coverUrl;
    }

    @OOXIXo
    public final String component6() {
        return this.title;
    }

    @OOXIXo
    public final String component7() {
        return this.describe;
    }

    public final boolean component8() {
        return this.isCustomized;
    }

    @OOXIXo
    public final ProgressMarkers copy(@OOXIXo String id, @OOXIXo String courseId, @OOXIXo String offset, int i, @OOXIXo String coverUrl, @OOXIXo String title, @OOXIXo String describe, boolean z) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(courseId, "courseId");
        IIX0o.x0xO0oo(offset, "offset");
        IIX0o.x0xO0oo(coverUrl, "coverUrl");
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(describe, "describe");
        return new ProgressMarkers(id, courseId, offset, i, coverUrl, title, describe, z);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressMarkers)) {
            return false;
        }
        ProgressMarkers progressMarkers = (ProgressMarkers) obj;
        return IIX0o.Oxx0IOOO(this.id, progressMarkers.id) && IIX0o.Oxx0IOOO(this.courseId, progressMarkers.courseId) && IIX0o.Oxx0IOOO(this.offset, progressMarkers.offset) && this.time == progressMarkers.time && IIX0o.Oxx0IOOO(this.coverUrl, progressMarkers.coverUrl) && IIX0o.Oxx0IOOO(this.title, progressMarkers.title) && IIX0o.Oxx0IOOO(this.describe, progressMarkers.describe) && this.isCustomized == progressMarkers.isCustomized;
    }

    @OOXIXo
    public final String getCourseId() {
        return this.courseId;
    }

    @OOXIXo
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @OOXIXo
    public final String getDescribe() {
        return this.describe;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final String getOffset() {
        return this.offset;
    }

    public final int getTime() {
        return this.time;
    }

    @OOXIXo
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.courseId.hashCode()) * 31) + this.offset.hashCode()) * 31) + this.time) * 31) + this.coverUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.describe.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isCustomized);
    }

    public final boolean isCustomized() {
        return this.isCustomized;
    }

    public final void setTime(int i) {
        this.time = i;
    }

    @OOXIXo
    public String toString() {
        return "ProgressMarkers(id=" + this.id + ", courseId=" + this.courseId + ", offset=" + this.offset + ", time=" + this.time + ", coverUrl=" + this.coverUrl + ", title=" + this.title + ", describe=" + this.describe + ", isCustomized=" + this.isCustomized + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ ProgressMarkers(String str, String str2, String str3, int i, String str4, String str5, String str6, boolean z, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "0" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) == 0 ? str6 : "", (i2 & 128) == 0 ? z : false);
    }

    public ProgressMarkers(@OOXIXo String id, @OOXIXo String courseId, @OOXIXo String offset, int i, @OOXIXo String coverUrl, @OOXIXo String title, @OOXIXo String describe, boolean z) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(courseId, "courseId");
        IIX0o.x0xO0oo(offset, "offset");
        IIX0o.x0xO0oo(coverUrl, "coverUrl");
        IIX0o.x0xO0oo(title, "title");
        IIX0o.x0xO0oo(describe, "describe");
        this.id = id;
        this.courseId = courseId;
        this.offset = offset;
        this.time = i;
        this.coverUrl = coverUrl;
        this.title = title;
        this.describe = describe;
        this.isCustomized = z;
    }
}
