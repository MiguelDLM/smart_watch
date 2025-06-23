package OOXIXo;

import android.location.GpsSatellite;

/* loaded from: classes.dex */
public class X0o0xo implements Comparable {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f1752IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public float f1753Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public GpsSatellite f1754Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f1755XO;

    public X0o0xo(GpsSatellite gpsSatellite) {
        this.f1754Oxx0xo = gpsSatellite;
        this.f1755XO = gpsSatellite.getPrn();
        this.f1753Oo = gpsSatellite.getSnr();
        this.f1752IXxxXO = gpsSatellite.usedInFix();
    }

    public int I0Io() {
        return this.f1755XO;
    }

    public boolean Oxx0IOOO() {
        return this.f1752IXxxXO;
    }

    public float XO() {
        return this.f1753Oo;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        X0o0xo x0o0xo = (X0o0xo) obj;
        if (this.f1755XO < x0o0xo.I0Io()) {
            return 1;
        }
        if (this.f1755XO == x0o0xo.I0Io()) {
            return 0;
        }
        return -1;
    }

    public GpsSatellite oxoX() {
        return this.f1754Oxx0xo;
    }
}
