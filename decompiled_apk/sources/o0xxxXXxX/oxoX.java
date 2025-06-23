package o0xxxXXxX;

import android.graphics.Color;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

/* loaded from: classes9.dex */
public abstract class oxoX<T extends Entry> extends DataSet<T> implements IIxOXoOo0.II0xO0<T> {

    /* renamed from: o00, reason: collision with root package name */
    public int f31295o00;

    public oxoX(List<T> list, String str) {
        super(list, str);
        this.f31295o00 = Color.rgb(255, 187, 115);
    }

    public void OOOI(int i) {
        this.f31295o00 = i;
    }

    public void OxXXx0X(oxoX oxox) {
        super.x00IOx(oxox);
        oxox.f31295o00 = this.f31295o00;
    }

    @Override // IIxOXoOo0.II0xO0
    public int X0xII0I() {
        return this.f31295o00;
    }
}
