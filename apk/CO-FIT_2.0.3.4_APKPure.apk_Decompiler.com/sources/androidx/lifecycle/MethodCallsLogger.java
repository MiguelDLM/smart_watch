package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    @OOXIXo
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(@OOXIXo String str, int i) {
        int i2;
        IIX0o.x0xO0oo(str, "name");
        Integer num = this.calledMethods.get(str);
        boolean z = false;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        if ((i2 & i) != 0) {
            z = true;
        }
        this.calledMethods.put(str, Integer.valueOf(i | i2));
        return !z;
    }
}
