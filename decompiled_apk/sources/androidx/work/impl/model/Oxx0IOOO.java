package androidx.work.impl.model;

import OXOo.OOXIXo;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final /* synthetic */ class Oxx0IOOO {
    public static void oIX0oI(WorkTagDao workTagDao, @OOXIXo String id, @OOXIXo Set tags) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(tags, "tags");
        Iterator it = tags.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), id));
        }
    }
}
