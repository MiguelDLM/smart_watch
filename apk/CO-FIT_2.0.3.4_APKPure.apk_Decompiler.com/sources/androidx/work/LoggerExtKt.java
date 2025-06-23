package androidx.work;

import OXOo.OOXIXo;
import Oox.oIX0oI;
import kotlin.jvm.internal.IIX0o;

public final class LoggerExtKt {
    public static final void logd(@OOXIXo String str, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().debug(str, oix0oi.invoke());
    }

    public static final void loge(@OOXIXo String str, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().error(str, oix0oi.invoke());
    }

    public static final void logi(@OOXIXo String str, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().info(str, oix0oi.invoke());
    }

    public static final void logd(@OOXIXo String str, @OOXIXo Throwable th, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(th, "t");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().debug(str, oix0oi.invoke(), th);
    }

    public static final void loge(@OOXIXo String str, @OOXIXo Throwable th, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(th, "t");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().error(str, oix0oi.invoke(), th);
    }

    public static final void logi(@OOXIXo String str, @OOXIXo Throwable th, @OOXIXo oIX0oI<String> oix0oi) {
        IIX0o.x0xO0oo(str, "tag");
        IIX0o.x0xO0oo(th, "t");
        IIX0o.x0xO0oo(oix0oi, "block");
        Logger.get().info(str, oix0oi.invoke(), th);
    }
}
