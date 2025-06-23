package XX0xXo;

import XIXIX.OOXIXo;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.components.LimitLine;
import java.util.ArrayList;
import java.util.List;
import ox.XO;
import ox.x0xO0oo;

/* loaded from: classes9.dex */
public abstract class oIX0oI extends II0xO0 {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public List<LimitLine> f4009O0xOxO;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public x0xO0oo f4013Oxx0IOOO;

    /* renamed from: oO, reason: collision with root package name */
    public int f4022oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f4026x0XOIxOo;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f4005II0XooXoX = -7829368;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f4032xxIXOIIO = 1.0f;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f4030xoIox = -7829368;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public float f4010OOXIXo = 1.0f;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public float[] f4023oOoXoXO = new float[0];

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public float[] f4024ooOOo0oXI = new float[0];

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f4027x0xO0oo = 6;

    /* renamed from: Oo, reason: collision with root package name */
    public float f4011Oo = 1.0f;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f4008IXxxXO = false;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f4014Oxx0xo = false;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f4021oI0IIXIo = true;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f4015OxxIIOOXO = true;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f4007IIXOooo = true;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f4031xoXoI = false;

    /* renamed from: o00, reason: collision with root package name */
    public DashPathEffect f4020o00 = null;

    /* renamed from: OxI, reason: collision with root package name */
    public DashPathEffect f4012OxI = null;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public boolean f4016X0IIOO = false;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public boolean f4017XI0IXoo = true;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public float f4018XIxXXX0x0 = 0.0f;

    /* renamed from: xxX, reason: collision with root package name */
    public float f4033xxX = 0.0f;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public boolean f4019XxX0x0xxx = false;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f4029xXxxox0I = false;

    /* renamed from: IIX0o, reason: collision with root package name */
    public float f4006IIX0o = 0.0f;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public float f4025ooXIXxIX = 0.0f;

    /* renamed from: xI, reason: collision with root package name */
    public float f4028xI = 0.0f;

    public oIX0oI() {
        this.f3994X0o0xo = OOXIXo.X0o0xo(10.0f);
        this.f3993II0xO0 = OOXIXo.X0o0xo(5.0f);
        this.f3992I0Io = OOXIXo.X0o0xo(5.0f);
        this.f4009O0xOxO = new ArrayList();
    }

    public void I0X0x0oIo(float f) {
        this.f4019XxX0x0xxx = true;
        this.f4025ooXIXxIX = f;
        this.f4028xI = Math.abs(this.f4006IIX0o - f);
    }

    public void I0oOIX(boolean z) {
        this.f4007IIXOooo = z;
    }

    public void I0oOoX() {
        this.f4019XxX0x0xxx = false;
    }

    public float IIX0o() {
        return this.f4018XIxXXX0x0;
    }

    public float IIXOooo() {
        return this.f4006IIX0o;
    }

    public boolean IO() {
        return this.f4007IIXOooo;
    }

    public void IXxxXO(float f, float f2, float f3) {
        this.f4012OxI = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public void Io() {
        this.f4009O0xOxO.clear();
    }

    public boolean IoOoX() {
        if (this.f4031xoXoI && this.f4026x0XOIxOo > 0) {
            return true;
        }
        return false;
    }

    public void IoOoo(boolean z) {
        this.f4008IXxxXO = z;
    }

    public void Ioxxx(int i, boolean z) {
        XIo0oOXIx(i);
        this.f4014Oxx0xo = z;
    }

    public void O0Xx(boolean z) {
        this.f4017XI0IXoo = z;
    }

    public int O0xOxO() {
        return this.f4005II0XooXoX;
    }

    public boolean OI0() {
        if (this.f4012OxI == null) {
            return false;
        }
        return true;
    }

    public void OO(float f) {
        this.f4011Oo = f;
        this.f4008IXxxXO = true;
    }

    public void OO0x0xX(float f) {
        this.f4032xxIXOIIO = OOXIXo.X0o0xo(f);
    }

    public void Oo(float f, float f2, float f3) {
        this.f4020o00 = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public float OxI() {
        return this.f4011Oo;
    }

    public int Oxx0xo() {
        return this.f4030xoIox;
    }

    public float OxxIIOOXO() {
        return this.f4010OOXIXo;
    }

    public boolean X00IoxXI() {
        return this.f4021oI0IIXIo;
    }

    public DashPathEffect X0IIOO() {
        return this.f4012OxI;
    }

    public float XI0IXoo() {
        return this.f4032xxIXOIIO;
    }

    public void XIo0oOXIx(int i) {
        if (i > 25) {
            i = 25;
        }
        if (i < 2) {
            i = 2;
        }
        this.f4027x0xO0oo = i;
        this.f4014Oxx0xo = false;
    }

    public int XIxXXX0x0() {
        return this.f4027x0xO0oo;
    }

    public boolean XOxIOxOx() {
        return this.f4008IXxxXO;
    }

    public void XX() {
        this.f4029xXxxox0I = false;
    }

    @Deprecated
    public void XX0(float f) {
        I0X0x0oIo(f);
    }

    public void XX0xXo(float f) {
        this.f4018XIxXXX0x0 = f;
    }

    public void Xo0(boolean z) {
        this.f4015OxxIIOOXO = z;
    }

    public void XoI0Ixx0(boolean z) {
        this.f4021oI0IIXIo = z;
    }

    public void XoX(DashPathEffect dashPathEffect) {
        this.f4020o00 = dashPathEffect;
    }

    public boolean Xx000oIo() {
        return this.f4017XI0IXoo;
    }

    public String XxX0x0xxx() {
        String str = "";
        for (int i = 0; i < this.f4023oOoXoXO.length; i++) {
            String o002 = o00(i);
            if (o002 != null && str.length() < o002.length()) {
                str = o002;
            }
        }
        return str;
    }

    public void o0(LimitLine limitLine) {
        this.f4009O0xOxO.remove(limitLine);
    }

    public String o00(int i) {
        if (i >= 0 && i < this.f4023oOoXoXO.length) {
            return ooXIXxIX().I0Io(this.f4023oOoXoXO[i], this);
        }
        return "";
    }

    public void o0xxxXXxX(x0xO0oo x0xo0oo) {
        if (x0xo0oo == null) {
            this.f4013Oxx0IOOO = new XO(this.f4022oO);
        } else {
            this.f4013Oxx0IOOO = x0xo0oo;
        }
    }

    public DashPathEffect oI0IIXIo() {
        return this.f4020o00;
    }

    public void oO() {
        this.f4020o00 = null;
    }

    public boolean oOXoIIIo() {
        return this.f4015OxxIIOOXO;
    }

    public void oX(boolean z) {
        this.f4031xoXoI = z;
    }

    public boolean oo() {
        return this.f4019XxX0x0xxx;
    }

    public boolean oo0xXOI0I() {
        return this.f4029xXxxox0I;
    }

    public void ooOOo0oXI(LimitLine limitLine) {
        this.f4009O0xOxO.add(limitLine);
        if (this.f4009O0xOxO.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public x0xO0oo ooXIXxIX() {
        x0xO0oo x0xo0oo = this.f4013Oxx0IOOO;
        if (x0xo0oo == null || ((x0xo0oo instanceof XO) && ((XO) x0xo0oo).oOoXoXO() != this.f4022oO)) {
            this.f4013Oxx0IOOO = new XO(this.f4022oO);
        }
        return this.f4013Oxx0IOOO;
    }

    public void oxXx0IX(float f) {
        this.f4010OOXIXo = OOXIXo.X0o0xo(f);
    }

    public void oxxXoxO(int i) {
        this.f4030xoIox = i;
    }

    public void x0XOIxOo(float f, float f2) {
        float f3;
        float f4;
        if (this.f4019XxX0x0xxx) {
            f3 = this.f4025ooXIXxIX;
        } else {
            f3 = f - this.f4018XIxXXX0x0;
        }
        if (this.f4029xXxxox0I) {
            f4 = this.f4006IIX0o;
        } else {
            f4 = f2 + this.f4033xxX;
        }
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.f4025ooXIXxIX = f3;
        this.f4006IIX0o = f4;
        this.f4028xI = Math.abs(f4 - f3);
    }

    public boolean x0o() {
        return this.f4014Oxx0xo;
    }

    public void x0xO(DashPathEffect dashPathEffect) {
        this.f4012OxI = dashPathEffect;
    }

    public void x0xO0oo() {
        this.f4012OxI = null;
    }

    public boolean xI() {
        if (this.f4020o00 == null) {
            return false;
        }
        return true;
    }

    public boolean xII() {
        return this.f4016X0IIOO;
    }

    public void xXOx(float f) {
        this.f4029xXxxox0I = true;
        this.f4006IIX0o = f;
        this.f4028xI = Math.abs(f - this.f4025ooXIXxIX);
    }

    public float xXxxox0I() {
        return this.f4033xxX;
    }

    @Deprecated
    public void xo0x(float f) {
        xXOx(f);
    }

    public void xoIxX(int i) {
        this.f4005II0XooXoX = i;
    }

    public float xoXoI() {
        return this.f4025ooXIXxIX;
    }

    public void xoxXI(boolean z) {
        this.f4016X0IIOO = z;
    }

    public void xxIO(float f) {
        this.f4033xxX = f;
    }

    public List<LimitLine> xxX() {
        return this.f4009O0xOxO;
    }
}
