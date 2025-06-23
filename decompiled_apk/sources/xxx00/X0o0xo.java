package xxx00;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.blankj.utilcode.util.TimeUtils;
import com.sma.smartv3.util.xoIox;
import kotlin.jvm.internal.IIX0o;
import ox.x0xO0oo;

/* loaded from: classes12.dex */
public final class X0o0xo extends x0xO0oo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final Context f35572oIX0oI;

    public X0o0xo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.f35572oIX0oI = context;
    }

    @Override // ox.x0xO0oo
    @OOXIXo
    public String I0Io(float f, @oOoXoXO XX0xXo.oIX0oI oix0oi) {
        String I0Io2 = super.I0Io(f, oix0oi);
        IIX0o.oO(I0Io2, "getAxisLabel(...)");
        return I0Io2;
    }

    @Override // ox.x0xO0oo
    @OOXIXo
    public String II0XooXoX(float f) {
        String millis2String = TimeUtils.millis2String(f * 60000, xoIox.Xo0(false, 1, null));
        IIX0o.oO(millis2String, "millis2String(...)");
        return millis2String;
    }
}
