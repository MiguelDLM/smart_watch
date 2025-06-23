package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class ooOOo0oXI implements kotlin.sequences.ooOOo0oXI<String> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final BufferedReader f29234oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<String>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f29236Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public String f29237XO;

        public oIX0oI() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29237XO == null && !this.f29236Oo) {
                String readLine = ooOOo0oXI.this.f29234oIX0oI.readLine();
                this.f29237XO = readLine;
                if (readLine == null) {
                    this.f29236Oo = true;
                }
            }
            if (this.f29237XO != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        @OXOo.OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (hasNext()) {
                String str = this.f29237XO;
                this.f29237XO = null;
                IIX0o.ooOOo0oXI(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ooOOo0oXI(@OXOo.OOXIXo BufferedReader reader) {
        IIX0o.x0xO0oo(reader, "reader");
        this.f29234oIX0oI = reader;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<String> iterator() {
        return new oIX0oI();
    }
}
