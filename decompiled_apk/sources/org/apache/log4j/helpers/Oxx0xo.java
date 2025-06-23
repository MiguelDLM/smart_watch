package org.apache.log4j.helpers;

import java.util.Hashtable;

/* loaded from: classes6.dex */
public final class Oxx0xo extends InheritableThreadLocal {
    @Override // java.lang.InheritableThreadLocal
    public final Object childValue(Object obj) {
        Hashtable hashtable = (Hashtable) obj;
        if (hashtable != null) {
            return hashtable.clone();
        }
        return null;
    }
}
