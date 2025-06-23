package XIOOI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* loaded from: classes6.dex */
public class II0xO0<T> extends BaseAdapter {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oox000IX.II0xO0 f3737IXxxXO = new oox000IX.II0xO0();

    /* renamed from: Oo, reason: collision with root package name */
    public List<T> f3738Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Context f3739XO;

    public II0xO0(Context context, List<T> list) {
        this.f3739XO = context;
        this.f3738Oo = list;
    }

    public void II0xO0(I0Io i0Io, T t, int i) {
        this.f3737IXxxXO.I0Io(i0Io, t, i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3738Oo.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.f3738Oo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (oxoX()) {
            return this.f3737IXxxXO.II0XooXoX(this.f3738Oo.get(i), i);
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        I0Io i0Io;
        int II0xO02 = this.f3737IXxxXO.oxoX(this.f3738Oo.get(i), i).II0xO0();
        if (view == null) {
            i0Io = new I0Io(this.f3739XO, LayoutInflater.from(this.f3739XO).inflate(II0xO02, viewGroup, false), viewGroup, i);
            i0Io.f3734X0o0xo = II0xO02;
            I0Io(i0Io, i0Io.II0xO0());
        } else {
            i0Io = (I0Io) view.getTag();
            i0Io.f3733II0xO0 = i;
        }
        II0xO0(i0Io, getItem(i), i);
        return i0Io.II0xO0();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (oxoX()) {
            return this.f3737IXxxXO.X0o0xo();
        }
        return super.getViewTypeCount();
    }

    public II0xO0 oIX0oI(oox000IX.oIX0oI<T> oix0oi) {
        this.f3737IXxxXO.II0xO0(oix0oi);
        return this;
    }

    public final boolean oxoX() {
        if (this.f3737IXxxXO.X0o0xo() > 0) {
            return true;
        }
        return false;
    }

    public void I0Io(I0Io i0Io, View view) {
    }
}
