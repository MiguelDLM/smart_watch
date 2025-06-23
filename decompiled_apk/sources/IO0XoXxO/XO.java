package IO0XoXxO;

import android.content.Context;

/* loaded from: classes11.dex */
public class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XO f411I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Oxx0IOOO f412II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f413oIX0oI = "OnLineState";

    public XO(Context context) {
        if (context == null) {
            o0IXXIx.II0XooXoX.I0Io("OnLineState", "OnLineState init failed,because context cann't be null ");
            return;
        }
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO();
        this.f412II0xO0 = oxx0IOOO;
        oxx0IOOO.X0o0xo(context);
    }

    public static XO oIX0oI(Context context) {
        if (f411I0Io == null) {
            synchronized (XO.class) {
                try {
                    if (f411I0Io == null) {
                        f411I0Io = new XO(context);
                    }
                } finally {
                }
            }
        }
        return f411I0Io;
    }

    public void II0xO0(X0o0xo x0o0xo) {
        Oxx0IOOO oxx0IOOO = this.f412II0xO0;
        if (oxx0IOOO != null) {
            oxx0IOOO.oxoX(x0o0xo);
        } else {
            o0IXXIx.II0XooXoX.oIX0oI(this.f413oIX0oI, "please init OnLineState first ,you can init it with 'OnLineState.init(context);' in you BaseApplication ");
        }
    }
}
