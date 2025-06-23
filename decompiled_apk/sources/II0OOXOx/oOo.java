package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface oOo<E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oOo f181oIX0oI = new oOo() { // from class: II0OOXOx.XIXIX
        @Override // II0OOXOx.oOo
        public final void accept(int i) {
            oXIO0o0XI.I0Io(i);
        }

        @Override // II0OOXOx.oOo
        public /* synthetic */ oOo oIX0oI(oOo ooo) {
            return oXIO0o0XI.oIX0oI(this, ooo);
        }
    };

    void accept(int i) throws Throwable;

    oOo<E> oIX0oI(oOo<E> ooo);
}
