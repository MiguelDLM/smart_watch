package IxOXOxO;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class oIX0oI implements II0xO0 {
    public final void II0xO0(List<XO0.I0Io> list, Class<?> cls, String str) {
        if (cls == null) {
            return;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (!list.contains(cls2)) {
                list.add(new XO0.I0Io(cls2, str));
                II0xO0(list, cls2, str);
            }
        }
    }

    @Override // IxOXOxO.II0xO0
    public List<XO0.I0Io> oIX0oI(XO0.I0Io i0Io, Object obj) {
        LinkedList linkedList = new LinkedList();
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            linkedList.add(new XO0.I0Io(cls, i0Io.f3833II0xO0));
            II0xO0(linkedList, cls, i0Io.f3833II0xO0);
        }
        return linkedList;
    }
}
