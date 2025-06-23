package IxO0Oxo;

import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.text.OOXIXo;
import kotlin.text.ooOOo0oXI;

@xxIXOIIO(name = "RegexExtensionsJDK8Kt")
/* loaded from: classes6.dex */
public final class oIX0oI {
    @oxxXoxO(version = "1.2")
    @oOoXoXO
    public static final OOXIXo oIX0oI(@OXOo.OOXIXo kotlin.text.oOoXoXO oooxoxo, @OXOo.OOXIXo String name) {
        ooOOo0oXI ooooo0oxi;
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(name, "name");
        if (oooxoxo instanceof ooOOo0oXI) {
            ooooo0oxi = (ooOOo0oXI) oooxoxo;
        } else {
            ooooo0oxi = null;
        }
        if (ooooo0oxi != null) {
            return ooooo0oxi.get(name);
        }
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
