package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class I0oOoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final ArrayList<Object> f29276oIX0oI;

    public I0oOoX(int i) {
        this.f29276oIX0oI = new ArrayList<>(i);
    }

    public int I0Io() {
        return this.f29276oIX0oI.size();
    }

    public void II0xO0(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f29276oIX0oI;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f29276oIX0oI, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f29276oIX0oI.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f29276oIX0oI.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f29276oIX0oI.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public void oIX0oI(Object obj) {
        this.f29276oIX0oI.add(obj);
    }

    public Object[] oxoX(Object[] objArr) {
        return this.f29276oIX0oI.toArray(objArr);
    }
}
