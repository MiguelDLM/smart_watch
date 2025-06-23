package androidx.work;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class LoggerExtKt {
    public static final void logd(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().debug(tag, block.invoke());
    }

    public static final void loge(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().error(tag, block.invoke());
    }

    public static final void logi(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().info(tag, block.invoke());
    }

    public static final void logd(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Throwable t, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(t, "t");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().debug(tag, block.invoke(), t);
    }

    public static final void loge(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Throwable t, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(t, "t");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().error(tag, block.invoke(), t);
    }

    public static final void logi(@OXOo.OOXIXo String tag, @OXOo.OOXIXo Throwable t, @OXOo.OOXIXo Oox.oIX0oI<String> block) {
        IIX0o.x0xO0oo(tag, "tag");
        IIX0o.x0xO0oo(t, "t");
        IIX0o.x0xO0oo(block, "block");
        Logger.get().info(tag, block.invoke(), t);
    }
}
