package org.apache.commons.lang3.time;

import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes6.dex */
class GmtTimeZone extends TimeZone {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    public GmtTimeZone(boolean z, int i, int i2) {
        char c;
        if (i < 24) {
            if (i2 < 60) {
                int i3 = ((i * 60) + i2) * 60000;
                this.offset = z ? -i3 : i3;
                StringBuilder sb = new StringBuilder(9);
                sb.append(xoIox.f32917oIX0oI);
                if (z) {
                    c = '-';
                } else {
                    c = '+';
                }
                sb.append(c);
                StringBuilder twoDigits = twoDigits(sb, i);
                twoDigits.append(':');
                this.zoneId = twoDigits(twoDigits, i2).toString();
                return;
            }
            throw new IllegalArgumentException(i2 + " minutes out of range");
        }
        throw new IllegalArgumentException(i + " hours out of range");
    }

    private static StringBuilder twoDigits(StringBuilder sb, int i) {
        sb.append((char) ((i / 10) + 48));
        sb.append((char) ((i % 10) + 48));
        return sb;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GmtTimeZone) || this.zoneId != ((GmtTimeZone) obj).zoneId) {
            return false;
        }
        return true;
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
