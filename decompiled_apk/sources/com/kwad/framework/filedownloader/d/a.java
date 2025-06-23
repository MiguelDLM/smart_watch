package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private long agE;
    private long agF;
    private long agG;
    private int id;
    private int index;

    public static long r(List<a> list) {
        long j = 0;
        for (a aVar : list) {
            j += aVar.wL() - aVar.getStartOffset();
        }
        return j;
    }

    public final void Q(long j) {
        this.agF = j;
    }

    public final void R(long j) {
        this.agG = j;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.agE;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setStartOffset(long j) {
        this.agE = j;
    }

    public final String toString() {
        return f.b("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.agE), Long.valueOf(this.agG), Long.valueOf(this.agF));
    }

    public final long wL() {
        return this.agF;
    }

    public final long wM() {
        return this.agG;
    }

    public final ContentValues wN() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.agE));
        contentValues.put("currentOffset", Long.valueOf(this.agF));
        contentValues.put("endOffset", Long.valueOf(this.agG));
        return contentValues;
    }
}
