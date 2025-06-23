package xXxxox0I;

import XIXIX.OOXIXo;
import com.app.sicbiaalg.BiaAlgInInfJClass;
import com.app.sicbiaalg.BiaAlgJCLinker;
import com.app.sicbiaalg.BiaAlgOutInfJClass;

/* loaded from: classes7.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f34829oIX0oI = 0;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f34825II0xO0 = 1;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f34823I0Io = 2;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f34830oxoX = 3;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f34827X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public int f34828XO = 5;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f34826Oxx0IOOO = 6;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f34824II0XooXoX = 7;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f34832xxIXOIIO = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f34831xoIox = 9;

    public static double[] II0xO0(short[] sArr, int i) {
        double[] dArr = new double[sArr.length + 2];
        int i2 = 0;
        dArr[0] = 0.0d;
        while (i2 < sArr.length) {
            int i3 = i2 + 1;
            dArr[i3] = sArr[i2] / Math.pow(10.0d, i);
            i2 = i3;
        }
        dArr[sArr.length + 1] = (sArr[sArr.length - 1] / Math.pow(10.0d, i)) * 1.5d;
        return dArr;
    }

    public static oIX0oI oIX0oI(BiaAlgInInfJClass biaAlgInInfJClass) {
        BiaAlgOutInfJClass BiaAlgJCLink = BiaAlgJCLinker.BiaAlgJCLink(biaAlgInInfJClass);
        return new oIX0oI().I0Io(BiaAlgJCLink.ooOOo0oXI()).Oxx0IOOO(BiaAlgJCLink.II0XooXoX()).O0xOxO(BiaAlgJCLink.II0xO0() / 10.0d).IIXOooo(BiaAlgJCLink.oIX0oI() / 10.0d).xxX(BiaAlgJCLink.OxI() / 100.0d).IXxxXO(BiaAlgJCLink.I0Io() / 100.0d).oo0xXOI0I(BiaAlgJCLink.XO() / 10.0d).oOXoIIIo(BiaAlgJCLink.Oxx0IOOO() / 10.0d).ooXIXxIX(BiaAlgJCLink.XI0IXoo() / 10.0d).XO(BiaAlgJCLink.oxoX() / 10.0d).X00IoxXI(BiaAlgJCLink.o00() / 10.0d).xoIox(BiaAlgJCLink.X0o0xo()).II0xO0(BiaAlgJCLink.xoXoI()).oo(BiaAlgJCLink.xxIXOIIO()).xoXoI(BiaAlgJCLink.OOXIXo()).X0IIOO(BiaAlgJCLink.O0xOxO()).Oxx0xo(BiaAlgJCLink.x0XOIxOo()).xI(BiaAlgJCLink.OxxIIOOXO()).XxX0x0xxx(BiaAlgJCLink.XIxXXX0x0()).OOXIXo(BiaAlgJCLink.x0xO0oo()).oO(BiaAlgJCLink.IXxxXO()).x0XOIxOo(BiaAlgJCLink.oI0IIXIo()).x0xO0oo(II0xO0(BiaAlgJCLink.oOoXoXO(), 1)).xXxxox0I(II0xO0(BiaAlgJCLink.xoIox(), 2)).oI0IIXIo(II0xO0(BiaAlgJCLink.X0IIOO(), 2)).oOoXoXO(II0xO0(BiaAlgJCLink.oO(), 2)).XI0IXoo(II0xO0(BiaAlgJCLink.IIXOooo(), 1)).o00(II0xO0(BiaAlgJCLink.xxX(), 1)).oxoX(II0xO0(BiaAlgJCLink.Oo(), 1)).II0XooXoX(new double[]{OOXIXo.f3760XO, BiaAlgJCLink.Oxx0xo(), BiaAlgJCLink.Oxx0xo() * 1.5d});
    }
}
