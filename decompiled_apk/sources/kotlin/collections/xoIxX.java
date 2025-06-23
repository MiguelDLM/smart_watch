package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.IIX0;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.OX00O0xII;
import kotlin.XI0oooXX;
import kotlin.XX0xXo;
import kotlin.x0xO;
import kotlin.xX0IIXIx0;
import kotlin.xxIO;

/* loaded from: classes6.dex */
public class xoIxX {
    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.oxxXoxO(version = "1.5")
    public static final long I0Io(@OXOo.OOXIXo Iterable<XI0oooXX> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<XI0oooXX> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = XI0oooXX.oOoXoXO(j + it.next().OO());
        }
        return j;
    }

    @OXOo.OOXIXo
    @kotlin.oI0IIXIo
    @kotlin.oxxXoxO(version = "1.3")
    public static final short[] II0XooXoX(@OXOo.OOXIXo Collection<OX00O0xII> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        short[] oxoX2 = xX0IIXIx0.oxoX(collection.size());
        Iterator<OX00O0xII> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            xX0IIXIx0.IXxxXO(oxoX2, i, it.next().I0oOIX());
            i++;
        }
        return oxoX2;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.oxxXoxO(version = "1.5")
    public static final int II0xO0(@OXOo.OOXIXo Iterable<xxIO> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<xxIO> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + it.next().OO());
        }
        return i;
    }

    @OXOo.OOXIXo
    @kotlin.oI0IIXIo
    @kotlin.oxxXoxO(version = "1.3")
    public static final long[] Oxx0IOOO(@OXOo.OOXIXo Collection<XI0oooXX> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        long[] oxoX2 = OOXIxO0.oxoX(collection.size());
        Iterator<XI0oooXX> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            OOXIxO0.IXxxXO(oxoX2, i, it.next().OO());
            i++;
        }
        return oxoX2;
    }

    @OXOo.OOXIXo
    @kotlin.oI0IIXIo
    @kotlin.oxxXoxO(version = "1.3")
    public static final byte[] X0o0xo(@OXOo.OOXIXo Collection<x0xO> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        byte[] oxoX2 = OO0x0xX.oxoX(collection.size());
        Iterator<x0xO> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            OO0x0xX.IXxxXO(oxoX2, i, it.next().I0oOIX());
            i++;
        }
        return oxoX2;
    }

    @OXOo.OOXIXo
    @kotlin.oI0IIXIo
    @kotlin.oxxXoxO(version = "1.3")
    public static final int[] XO(@OXOo.OOXIXo Collection<xxIO> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        int[] oxoX2 = XX0xXo.oxoX(collection.size());
        Iterator<xxIO> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            XX0xXo.IXxxXO(oxoX2, i, it.next().OO());
            i++;
        }
        return oxoX2;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUByte")
    @kotlin.oxxXoxO(version = "1.5")
    public static final int oIX0oI(@OXOo.OOXIXo Iterable<x0xO> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<x0xO> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(it.next().I0oOIX() & 255));
        }
        return i;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUShort")
    @kotlin.oxxXoxO(version = "1.5")
    public static final int oxoX(@OXOo.OOXIXo Iterable<OX00O0xII> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<OX00O0xII> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(it.next().I0oOIX() & OX00O0xII.f29066Oxx0xo));
        }
        return i;
    }
}
