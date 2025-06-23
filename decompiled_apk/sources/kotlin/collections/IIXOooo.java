package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class IIXOooo extends OxxIIOOXO {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Enumeration<T> f29120XO;

        public oIX0oI(Enumeration<T> enumeration) {
            this.f29120XO = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29120XO.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f29120XO.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @OXOo.OOXIXo
    public static <T> Iterator<T> oX(@OXOo.OOXIXo Enumeration<T> enumeration) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(enumeration, "<this>");
        return new oIX0oI(enumeration);
    }
}
