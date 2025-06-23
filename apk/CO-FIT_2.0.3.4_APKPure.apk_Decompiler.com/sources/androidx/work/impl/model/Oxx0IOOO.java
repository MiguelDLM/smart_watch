package androidx.work.impl.model;

import OXOo.OOXIXo;
import com.baidu.mobads.sdk.internal.bn;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

public final /* synthetic */ class Oxx0IOOO {
    public static void oIX0oI(WorkTagDao workTagDao, @OOXIXo String str, @OOXIXo Set set) {
        IIX0o.x0xO0oo(str, "id");
        IIX0o.x0xO0oo(set, bn.l);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), str));
        }
    }
}
