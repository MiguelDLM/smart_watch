package xI0OXooO;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public final class I0Io {
    public static Map<CharSequence, Integer> oIX0oI(CharSequence[] charSequenceArr) {
        HashMap hashMap = new HashMap();
        for (CharSequence charSequence : charSequenceArr) {
            if (hashMap.containsKey(charSequence)) {
                hashMap.put(charSequence, Integer.valueOf(((Integer) hashMap.get(charSequence)).intValue() + 1));
            } else {
                hashMap.put(charSequence, 1);
            }
        }
        return hashMap;
    }
}
