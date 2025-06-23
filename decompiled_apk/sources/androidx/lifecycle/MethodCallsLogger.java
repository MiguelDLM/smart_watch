package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MethodCallsLogger {

    @OXOo.OOXIXo
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(@OXOo.OOXIXo String name, int i) {
        int i2;
        IIX0o.x0xO0oo(name, "name");
        Integer num = this.calledMethods.get(name);
        boolean z = false;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            z = true;
        }
        this.calledMethods.put(name, Integer.valueOf(i | i2));
        return !z;
    }
}
