package kotlinx.coroutines;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@kotlin.o0
@IgnoreJRERequirement
/* loaded from: classes6.dex */
public final class X00IoxXI extends kotlin.coroutines.oIX0oI implements X0xII0I<String> {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29749Oo = new oIX0oI(null);

    /* renamed from: XO, reason: collision with root package name */
    public final long f29750XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements CoroutineContext.II0xO0<X00IoxXI> {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public X00IoxXI(long j) {
        super(f29749Oo);
        this.f29750XO = j;
    }

    public static /* synthetic */ X00IoxXI o00(X00IoxXI x00IoxXI, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = x00IoxXI.f29750XO;
        }
        return x00IoxXI.xoXoI(j);
    }

    public final long IIXOooo() {
        return this.f29750XO;
    }

    public final long X0IIOO() {
        return this.f29750XO;
    }

    @Override // kotlinx.coroutines.X0xII0I
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public void x0XOIxOo(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo String str) {
        Thread.currentThread().setName(str);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof X00IoxXI) && this.f29750XO == ((X00IoxXI) obj).f29750XO;
    }

    public int hashCode() {
        return androidx.collection.oIX0oI.oIX0oI(this.f29750XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CoroutineId(" + this.f29750XO + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    public final X00IoxXI xoXoI(long j) {
        return new X00IoxXI(j);
    }

    @Override // kotlinx.coroutines.X0xII0I
    @OXOo.OOXIXo
    /* renamed from: xxX, reason: merged with bridge method [inline-methods] */
    public String Io(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        String str;
        IO io2 = (IO) coroutineContext.get(IO.f29691Oo);
        if (io2 == null || (str = io2.getName()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int xxxoo0XI2 = StringsKt__StringsKt.xxxoo0XI(name, CoroutineContextKt.f29679oIX0oI, 0, false, 6, null);
        if (xxxoo0XI2 < 0) {
            xxxoo0XI2 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + xxxoo0XI2 + 10);
        String substring = name.substring(0, xxxoo0XI2);
        kotlin.jvm.internal.IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(CoroutineContextKt.f29679oIX0oI);
        sb.append(str);
        sb.append('#');
        sb.append(this.f29750XO);
        String sb2 = sb.toString();
        kotlin.jvm.internal.IIX0o.oO(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }
}
