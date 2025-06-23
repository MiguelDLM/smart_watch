package xx0O;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class oxoX implements LayoutInflater.Factory2 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public List<WeakReference<xxoXO.Oxx0IOOO>> f35285IXxxXO = new CopyOnWriteArrayList();

    /* renamed from: Oo, reason: collision with root package name */
    public X0o0xo f35286Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final Context f35287XO;

    public oxoX(Context context) {
        this.f35287XO = context;
    }

    public static oxoX II0xO0(Context context) {
        return new oxoX(context);
    }

    public View I0Io(View view, String str, @IXo.XO Context context, @IXo.XO AttributeSet attributeSet) {
        if (this.f35286Oo == null) {
            this.f35286Oo = new X0o0xo();
        }
        Iterator<Oxx0IOOO> it = IIXOxIxOo.I0Io.IXxxXO().IIXOooo().iterator();
        while (it.hasNext()) {
            Context II0xO02 = it.next().II0xO0(this.f35287XO, view, attributeSet);
            if (II0xO02 != null) {
                context = II0xO02;
            }
        }
        return this.f35286Oo.I0Io(view, str, context, attributeSet);
    }

    public void oIX0oI() {
        List<WeakReference<xxoXO.Oxx0IOOO>> list = this.f35285IXxxXO;
        if (list != null && !list.isEmpty()) {
            for (WeakReference<xxoXO.Oxx0IOOO> weakReference : this.f35285IXxxXO) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().applySkin();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View I0Io2 = I0Io(view, str, context, attributeSet);
        if (I0Io2 == 0) {
            return null;
        }
        if (I0Io2 instanceof xxoXO.Oxx0IOOO) {
            this.f35285IXxxXO.add(new WeakReference<>((xxoXO.Oxx0IOOO) I0Io2));
        }
        return I0Io2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View I0Io2 = I0Io(null, str, context, attributeSet);
        if (I0Io2 == 0) {
            return null;
        }
        if (I0Io2 instanceof xxoXO.Oxx0IOOO) {
            this.f35285IXxxXO.add(new WeakReference<>((xxoXO.Oxx0IOOO) I0Io2));
        }
        return I0Io2;
    }
}
