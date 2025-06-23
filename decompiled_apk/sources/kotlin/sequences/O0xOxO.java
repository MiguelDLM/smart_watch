package kotlin.sequences;

import java.util.Iterator;
import kotlin.IIX0;
import kotlin.OX00O0xII;
import kotlin.XI0oooXX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.x0xO;
import kotlin.xxIO;

/* loaded from: classes6.dex */
public class O0xOxO {
    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @oxxXoxO(version = "1.5")
    public static final long I0Io(@OXOo.OOXIXo ooOOo0oXI<XI0oooXX> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<XI0oooXX> it = ooooo0oxi.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = XI0oooXX.oOoXoXO(j + it.next().OO());
        }
        return j;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @oxxXoxO(version = "1.5")
    public static final int II0xO0(@OXOo.OOXIXo ooOOo0oXI<xxIO> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<xxIO> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + it.next().OO());
        }
        return i;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUByte")
    @oxxXoxO(version = "1.5")
    public static final int oIX0oI(@OXOo.OOXIXo ooOOo0oXI<x0xO> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<x0xO> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(it.next().I0oOIX() & 255));
        }
        return i;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @XO0OX.xxIXOIIO(name = "sumOfUShort")
    @oxxXoxO(version = "1.5")
    public static final int oxoX(@OXOo.OOXIXo ooOOo0oXI<OX00O0xII> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<OX00O0xII> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(it.next().I0oOIX() & OX00O0xII.f29066Oxx0xo));
        }
        return i;
    }
}
