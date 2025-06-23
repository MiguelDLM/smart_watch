package X0xOO;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes6.dex */
public final class I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f3290II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3291oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static I0Io[] f3279I0Io = new I0Io[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final I0Io f3287oxoX = new I0Io(0, "Error");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final I0Io f3283X0o0xo = new I0Io(1, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);

    /* renamed from: XO, reason: collision with root package name */
    public static final I0Io f3284XO = new I0Io(2, "EMF");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final I0Io f3282Oxx0IOOO = new I0Io(3, "WMF");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final I0Io f3280II0XooXoX = new I0Io(4, "PICT");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final I0Io f3289xxIXOIIO = new I0Io(5, "JPEG");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final I0Io f3288xoIox = new I0Io(6, "PNG");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final I0Io f3281OOXIXo = new I0Io(7, "DIB");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final I0Io f3285oOoXoXO = new I0Io(32, "FIRST");

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final I0Io f3286ooOOo0oXI = new I0Io(255, "LAST");

    public I0Io(int i, String str) {
        this.f3291oIX0oI = i;
        this.f3290II0xO0 = str;
        I0Io[] i0IoArr = f3279I0Io;
        I0Io[] i0IoArr2 = new I0Io[i0IoArr.length + 1];
        System.arraycopy(i0IoArr, 0, i0IoArr2, 0, i0IoArr.length);
        i0IoArr2[f3279I0Io.length] = this;
        f3279I0Io = i0IoArr2;
    }

    public static I0Io II0xO0(int i) {
        I0Io i0Io = f3283X0o0xo;
        int i2 = 0;
        while (true) {
            I0Io[] i0IoArr = f3279I0Io;
            if (i2 < i0IoArr.length) {
                I0Io i0Io2 = i0IoArr[i2];
                if (i0Io2.f3291oIX0oI == i) {
                    return i0Io2;
                }
                i2++;
            } else {
                return i0Io;
            }
        }
    }

    public int I0Io() {
        return this.f3291oIX0oI;
    }

    public String oIX0oI() {
        return this.f3290II0xO0;
    }
}
