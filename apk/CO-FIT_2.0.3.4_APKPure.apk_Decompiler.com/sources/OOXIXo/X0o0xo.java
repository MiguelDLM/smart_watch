package OOXIXo;

import android.location.GpsSatellite;

public class X0o0xo implements Comparable {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public boolean f80IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public float f81Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public GpsSatellite f82Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public int f83XO;

    public X0o0xo(GpsSatellite gpsSatellite) {
        this.f82Oxx0xo = gpsSatellite;
        this.f83XO = gpsSatellite.getPrn();
        this.f81Oo = gpsSatellite.getSnr();
        this.f80IXxxXO = gpsSatellite.usedInFix();
    }

    public int I0Io() {
        return this.f83XO;
    }

    public boolean Oxx0IOOO() {
        return this.f80IXxxXO;
    }

    public float XO() {
        return this.f81Oo;
    }

    public int compareTo(Object obj) {
        X0o0xo x0o0xo = (X0o0xo) obj;
        if (this.f83XO < x0o0xo.I0Io()) {
            return 1;
        }
        if (this.f83XO == x0o0xo.I0Io()) {
            return 0;
        }
        return -1;
    }

    public GpsSatellite oxoX() {
        return this.f82Oxx0xo;
    }
}
