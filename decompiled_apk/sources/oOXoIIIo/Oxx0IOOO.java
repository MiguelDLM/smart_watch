package oOXoIIIo;

import OXOo.OOXIXo;
import android.view.View;
import android.widget.CompoundButton;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class Oxx0IOOO {
    @OOXIXo
    public static final XIOOI.I0Io I0Io(@OOXIXo XIOOI.I0Io i0Io, int i, @OOXIXo CompoundButton.OnCheckedChangeListener listener) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        IIX0o.x0xO0oo(listener, "listener");
        ((CompoundButton) i0Io.X0o0xo(i)).setOnCheckedChangeListener(listener);
        return i0Io;
    }

    @OOXIXo
    public static final XIOOI.I0Io II0xO0(@OOXIXo XIOOI.I0Io i0Io, int i, boolean z) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        i0Io.X0o0xo(i).setEnabled(z);
        return i0Io;
    }

    @OOXIXo
    public static final XIOOI.I0Io oIX0oI(@OOXIXo XIOOI.I0Io i0Io, int i, @OOXIXo View.OnClickListener listener) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        IIX0o.x0xO0oo(listener, "listener");
        i0Io.X0o0xo(i).setOnClickListener(listener);
        return i0Io;
    }

    @OOXIXo
    public static final XIOOI.I0Io oxoX(@OOXIXo XIOOI.I0Io i0Io, int i, int i2) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        i0Io.o00(i, i0Io.X0o0xo(i).getContext().getString(i2));
        return i0Io;
    }
}
