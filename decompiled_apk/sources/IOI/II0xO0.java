package IOI;

import kotlin.DeprecationLevel;
import kotlin.time.IXxxXO;

/* loaded from: classes6.dex */
public final class II0xO0 {

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements IXxxXO.I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ IOI.oIX0oI f473II0xO0;

        public oIX0oI(IOI.oIX0oI oix0oi) {
            this.f473II0xO0 = oix0oi;
        }

        @Override // kotlin.time.IXxxXO
        @OXOo.OOXIXo
        public kotlin.time.I0Io oIX0oI() {
            return new XX(this.f473II0xO0.oIX0oI(), this.f473II0xO0);
        }
    }

    @OXOo.OOXIXo
    public static final xoxXI I0Io(@OXOo.OOXIXo IOI.oIX0oI oix0oi, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return IO0XoXxO.XO(oix0oi.oIX0oI(), timeZone).Oxx0IOOO();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "Use Clock.todayIn instead", replaceWith = @kotlin.XX(expression = "this.todayIn(timeZone)", imports = {}))
    @OXOo.OOXIXo
    public static final xoxXI II0xO0(@OXOo.OOXIXo IOI.oIX0oI oix0oi, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return I0Io(oix0oi, timeZone);
    }

    @kotlin.time.xoIox
    @OXOo.OOXIXo
    public static final IXxxXO.I0Io oIX0oI(@OXOo.OOXIXo IOI.oIX0oI oix0oi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "<this>");
        return new oIX0oI(oix0oi);
    }
}
