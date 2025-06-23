package X0xOO;

/* loaded from: classes6.dex */
public final class XIxXXX0x0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3429oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static XIxXXX0x0[] f3414II0xO0 = new XIxXXX0x0[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public static final XIxXXX0x0 f3412I0Io = new XIxXXX0x0(0);

    /* renamed from: oxoX, reason: collision with root package name */
    public static final XIxXXX0x0 f3424oxoX = new XIxXXX0x0(61440);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final XIxXXX0x0 f3419X0o0xo = new XIxXXX0x0(61441);

    /* renamed from: XO, reason: collision with root package name */
    public static final XIxXXX0x0 f3420XO = new XIxXXX0x0(61442);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final XIxXXX0x0 f3418Oxx0IOOO = new XIxXXX0x0(61443);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final XIxXXX0x0 f3413II0XooXoX = new XIxXXX0x0(61444);

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final XIxXXX0x0 f3428xxIXOIIO = new XIxXXX0x0(61446);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final XIxXXX0x0 f3427xoIox = new XIxXXX0x0(61447);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final XIxXXX0x0 f3416OOXIXo = new XIxXXX0x0(61448);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final XIxXXX0x0 f3422oOoXoXO = new XIxXXX0x0(61449);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final XIxXXX0x0 f3423ooOOo0oXI = new XIxXXX0x0(61450);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final XIxXXX0x0 f3425x0XOIxOo = new XIxXXX0x0(61451);

    /* renamed from: oO, reason: collision with root package name */
    public static final XIxXXX0x0 f3421oO = new XIxXXX0x0(61456);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final XIxXXX0x0 f3426x0xO0oo = new XIxXXX0x0(61457);

    /* renamed from: Oo, reason: collision with root package name */
    public static final XIxXXX0x0 f3417Oo = new XIxXXX0x0(61453);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final XIxXXX0x0 f3415IXxxXO = new XIxXXX0x0(61726);

    public XIxXXX0x0(int i) {
        this.f3429oIX0oI = i;
        XIxXXX0x0[] xIxXXX0x0Arr = f3414II0xO0;
        XIxXXX0x0[] xIxXXX0x0Arr2 = new XIxXXX0x0[xIxXXX0x0Arr.length + 1];
        System.arraycopy(xIxXXX0x0Arr, 0, xIxXXX0x0Arr2, 0, xIxXXX0x0Arr.length);
        xIxXXX0x0Arr2[f3414II0xO0.length] = this;
        f3414II0xO0 = xIxXXX0x0Arr2;
    }

    public static XIxXXX0x0 oIX0oI(int i) {
        XIxXXX0x0 xIxXXX0x0 = f3412I0Io;
        int i2 = 0;
        while (true) {
            XIxXXX0x0[] xIxXXX0x0Arr = f3414II0xO0;
            if (i2 < xIxXXX0x0Arr.length) {
                XIxXXX0x0 xIxXXX0x02 = xIxXXX0x0Arr[i2];
                if (i == xIxXXX0x02.f3429oIX0oI) {
                    return xIxXXX0x02;
                }
                i2++;
            } else {
                return xIxXXX0x0;
            }
        }
    }

    public int II0xO0() {
        return this.f3429oIX0oI;
    }
}
