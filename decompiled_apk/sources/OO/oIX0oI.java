package OO;

import OXOo.OOXIXo;
import com.github.doyaaaaaken.kotlincsv.dsl.context.WriteQuoteMode;
import kotlin.jvm.internal.IIX0o;

@IoOoo.II0xO0
/* loaded from: classes9.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public char f1709oIX0oI = '\"';

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public WriteQuoteMode f1708II0xO0 = WriteQuoteMode.CANONICAL;

    public final void I0Io(char c) {
        this.f1709oIX0oI = c;
    }

    @OOXIXo
    public final WriteQuoteMode II0xO0() {
        return this.f1708II0xO0;
    }

    public final char oIX0oI() {
        return this.f1709oIX0oI;
    }

    public final void oxoX(@OOXIXo WriteQuoteMode writeQuoteMode) {
        IIX0o.x0xO0oo(writeQuoteMode, "<set-?>");
        this.f1708II0xO0 = writeQuoteMode;
    }
}
