package kotlinx.coroutines;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class IO extends kotlin.coroutines.oIX0oI {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29691Oo = new oIX0oI(null);

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f29692XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements CoroutineContext.II0xO0<IO> {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public IO(@OXOo.OOXIXo String str) {
        super(f29691Oo);
        this.f29692XO = str;
    }

    public static /* synthetic */ IO o00(IO io2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = io2.f29692XO;
        }
        return io2.xoXoI(str);
    }

    @OXOo.OOXIXo
    public final String IIXOooo() {
        return this.f29692XO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IO) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29692XO, ((IO) obj).f29692XO);
    }

    @OXOo.OOXIXo
    public final String getName() {
        return this.f29692XO;
    }

    public int hashCode() {
        return this.f29692XO.hashCode();
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CoroutineName(" + this.f29692XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    public final IO xoXoI(@OXOo.OOXIXo String str) {
        return new IO(str);
    }
}
