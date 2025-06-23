package com.garmin.fit;

import java.io.InputStream;

/* loaded from: classes9.dex */
public class oX0I0O {
    public oX0ooo0I0 II0xO0(InputStream inputStream, XxI xxI) {
        Decode decode = new Decode();
        x00IOx x00iox = new x00IOx();
        ooXIXxIX ooxixxix = new ooXIXxIX(decode);
        ooxixxix.XoOOx0IX(xxI);
        ooxixxix.oIX0oI(x00iox);
        try {
            ooxixxix.I0OO(inputStream);
            ooxixxix.IxO0Oxo();
        } catch (FitRuntimeException e) {
            if (decode.II0XooXoX()) {
                decode.oOoXoXO();
                ooxixxix.I0OO(inputStream);
                ooxixxix.IxO0Oxo();
            } else {
                throw e;
            }
        }
        return x00iox.oxoX();
    }

    public oX0ooo0I0 oIX0oI(InputStream inputStream) {
        Decode decode = new Decode();
        x00IOx x00iox = new x00IOx();
        try {
            decode.Oo(inputStream, x00iox, null);
        } catch (FitRuntimeException e) {
            if (decode.II0XooXoX()) {
                decode.oOoXoXO();
                decode.Oo(inputStream, x00iox, null);
            } else {
                throw e;
            }
        }
        return x00iox.oxoX();
    }
}
