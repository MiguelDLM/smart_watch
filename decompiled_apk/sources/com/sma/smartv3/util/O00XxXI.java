package com.sma.smartv3.util;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class O00XxXI {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f24311II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f24312oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public O00XxXI() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ O00XxXI oxoX(O00XxXI o00XxXI, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = o00XxXI.f24312oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = o00XxXI.f24311II0xO0;
        }
        return o00XxXI.I0Io(str, str2);
    }

    @OXOo.OOXIXo
    public final O00XxXI I0Io(@OXOo.OOXIXo String week, @OXOo.OOXIXo String day) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(week, "week");
        kotlin.jvm.internal.IIX0o.x0xO0oo(day, "day");
        return new O00XxXI(week, day);
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        return this.f24311II0xO0;
    }

    @OXOo.OOXIXo
    public final String X0o0xo() {
        return this.f24311II0xO0;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f24312oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O00XxXI)) {
            return false;
        }
        O00XxXI o00XxXI = (O00XxXI) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24312oIX0oI, o00XxXI.f24312oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24311II0xO0, o00XxXI.f24311II0xO0);
    }

    public int hashCode() {
        return (this.f24312oIX0oI.hashCode() * 31) + this.f24311II0xO0.hashCode();
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return this.f24312oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "WeekDay(week=" + this.f24312oIX0oI + ", day=" + this.f24311II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }

    public O00XxXI(@OXOo.OOXIXo String week, @OXOo.OOXIXo String day) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(week, "week");
        kotlin.jvm.internal.IIX0o.x0xO0oo(day, "day");
        this.f24312oIX0oI = week;
        this.f24311II0xO0 = day;
    }

    public /* synthetic */ O00XxXI(String str, String str2, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
