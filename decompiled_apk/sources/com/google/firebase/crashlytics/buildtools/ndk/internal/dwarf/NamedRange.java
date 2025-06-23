package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Objects;

/* loaded from: classes10.dex */
public class NamedRange implements Comparable<NamedRange> {
    public final Long end;
    public final String name;
    public final Long start;

    public NamedRange(String str, Long l, Long l2) {
        this.name = str;
        this.start = l;
        this.end = l2;
    }

    public boolean contains(NamedRange namedRange) {
        return namedRange.start.longValue() >= this.start.longValue() && namedRange.end.longValue() <= this.end.longValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NamedRange namedRange = (NamedRange) obj;
        if (Objects.equal(this.start, namedRange.start) && Objects.equal(this.end, namedRange.end)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.start, this.end);
    }

    @Override // java.lang.Comparable
    public int compareTo(NamedRange namedRange) {
        return this.start.compareTo(namedRange.start);
    }

    public boolean contains(long j) {
        return j >= this.start.longValue() && j <= this.end.longValue();
    }
}
