package Oxxo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* loaded from: classes6.dex */
public class OOXIXo extends MouseAdapter {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ Oxx0xo f3130oIX0oI;

    public OOXIXo(Oxx0xo oxx0xo) {
        this.f3130oIX0oI = oxx0xo;
    }

    public void oIX0oI(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & 4) != 0) {
            Oxx0xo oxx0xo = this.f3130oIX0oI;
            oxx0xo.XIxXXX0x0(oxx0xo.f3134Oxx0IOOO, mouseEvent.getX(), mouseEvent.getY());
        }
        this.f3130oIX0oI.oO();
    }
}
