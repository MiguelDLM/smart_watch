package II0OOXOx;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface oxxXoxO<E extends Throwable> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final oxxXoxO f199oIX0oI = new oxxXoxO() { // from class: II0OOXOx.o0
        @Override // II0OOXOx.oxxXoxO
        public final void accept(double d) {
            I0oOoX.I0Io(d);
        }

        @Override // II0OOXOx.oxxXoxO
        public /* synthetic */ oxxXoxO oIX0oI(oxxXoxO oxxxoxo) {
            return I0oOoX.oIX0oI(this, oxxxoxo);
        }
    };

    void accept(double d) throws Throwable;

    oxxXoxO<E> oIX0oI(oxxXoxO<E> oxxxoxo);
}
