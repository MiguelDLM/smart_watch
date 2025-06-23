package com.github.doyaaaaaken.kotlincsv.parser;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes9.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final char f15795I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final char f15796II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final char f15797oIX0oI;

    public oIX0oI(char c, char c2, char c3) {
        this.f15797oIX0oI = c;
        this.f15796II0xO0 = c2;
        this.f15795I0Io = c3;
    }

    public static /* synthetic */ List II0xO0(oIX0oI oix0oi, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 1;
        }
        return oix0oi.oIX0oI(str, j);
    }

    @oOoXoXO
    public final List<String> oIX0oI(@OOXIXo String line, long j) {
        long j2;
        IIX0o.x0xO0oo(line, "line");
        II0xO0 iI0xO0 = new II0xO0(this.f15797oIX0oI, this.f15796II0xO0, this.f15795I0Io);
        Character OXXxXoO = StringsKt___StringsKt.OXXxXoO(line);
        int length = line.length() - 1;
        if (length < 1) {
            CollectionsKt__CollectionsKt.ooXIXxIX();
            j2 = 0;
        } else {
            ArrayList arrayList = new ArrayList(length);
            int i = 0;
            j2 = 0;
            while (i < length) {
                char charAt = line.charAt(i);
                i++;
                char charAt2 = line.charAt(i);
                if (j2 > 0) {
                    j2--;
                } else {
                    j2 = iI0xO0.I0Io(charAt, Character.valueOf(charAt2), j) - 1;
                }
                OXXxXoO = Character.valueOf(charAt2);
                arrayList.add(oXIO0o0XI.f29392oIX0oI);
            }
        }
        if (OXXxXoO != null && j2 == 0) {
            iI0xO0.I0Io(OXXxXoO.charValue(), null, j);
        }
        return iI0xO0.II0xO0();
    }
}
