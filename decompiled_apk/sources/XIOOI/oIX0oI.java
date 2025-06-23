package XIOOI;

import android.content.Context;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class oIX0oI<T> extends II0xO0<T> {

    /* renamed from: XIOOI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0058oIX0oI implements oox000IX.oIX0oI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f3741oIX0oI;

        public C0058oIX0oI(int i) {
            this.f3741oIX0oI = i;
        }

        @Override // oox000IX.oIX0oI
        public void I0Io(I0Io i0Io, T t, int i) {
            oIX0oI.this.II0xO0(i0Io, t, i);
        }

        @Override // oox000IX.oIX0oI
        public int II0xO0() {
            return this.f3741oIX0oI;
        }

        @Override // oox000IX.oIX0oI
        public boolean oIX0oI(T t, int i) {
            return true;
        }
    }

    public oIX0oI(Context context, int i, List<T> list) {
        super(context, list);
        oIX0oI(new C0058oIX0oI(i));
    }

    @Override // XIOOI.II0xO0
    public abstract void II0xO0(I0Io i0Io, T t, int i);
}
