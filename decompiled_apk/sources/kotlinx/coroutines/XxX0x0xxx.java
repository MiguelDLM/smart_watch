package kotlinx.coroutines;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes6.dex */
public final class XxX0x0xxx {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> f29788II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Object f29789oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public XxX0x0xxx(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        this.f29789oIX0oI = obj;
        this.f29788II0xO0 = oooxoxo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XxX0x0xxx oxoX(XxX0x0xxx xxX0x0xxx, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = xxX0x0xxx.f29789oIX0oI;
        }
        if ((i & 2) != 0) {
            oooxoxo = xxX0x0xxx.f29788II0xO0;
        }
        return xxX0x0xxx.I0Io(obj, oooxoxo);
    }

    @OXOo.OOXIXo
    public final XxX0x0xxx I0Io(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        return new XxX0x0xxx(obj, oooxoxo);
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> II0xO0() {
        return this.f29788II0xO0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XxX0x0xxx)) {
            return false;
        }
        XxX0x0xxx xxX0x0xxx = (XxX0x0xxx) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29789oIX0oI, xxX0x0xxx.f29789oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29788II0xO0, xxX0x0xxx.f29788II0xO0);
    }

    public int hashCode() {
        Object obj = this.f29789oIX0oI;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f29788II0xO0.hashCode();
    }

    @OXOo.oOoXoXO
    public final Object oIX0oI() {
        return this.f29789oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f29789oIX0oI + ", onCancellation=" + this.f29788II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
