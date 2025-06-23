package x0xO0oo;

import IXxxXO.xxIXOIIO;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final double f34072I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final char f34073II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final String f34074X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final String f34075XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<xxIXOIIO> f34076oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final double f34077oxoX;

    public I0Io(List<xxIXOIIO> list, char c, double d, double d2, String str, String str2) {
        this.f34076oIX0oI = list;
        this.f34073II0xO0 = c;
        this.f34072I0Io = d;
        this.f34077oxoX = d2;
        this.f34074X0o0xo = str;
        this.f34075XO = str2;
    }

    public static int X0o0xo(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public String I0Io() {
        return this.f34074X0o0xo;
    }

    public double II0xO0() {
        return this.f34072I0Io;
    }

    public int hashCode() {
        return X0o0xo(this.f34073II0xO0, this.f34075XO, this.f34074X0o0xo);
    }

    public List<xxIXOIIO> oIX0oI() {
        return this.f34076oIX0oI;
    }

    public double oxoX() {
        return this.f34077oxoX;
    }
}
