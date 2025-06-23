package xI0OXooO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class II0xO0 {
    public final Set<CharSequence> I0Io(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2) {
        HashSet hashSet = new HashSet(map.keySet());
        hashSet.retainAll(map2.keySet());
        return hashSet;
    }

    public final double II0xO0(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2, Set<CharSequence> set) {
        long j = 0;
        for (CharSequence charSequence : set) {
            j += map.get(charSequence).intValue() * map2.get(charSequence).intValue();
        }
        return j;
    }

    public Double oIX0oI(Map<CharSequence, Integer> map, Map<CharSequence, Integer> map2) {
        if (map != null && map2 != null) {
            double II0xO02 = II0xO0(map, map2, I0Io(map, map2));
            Iterator<Integer> it = map.values().iterator();
            double d = XIXIX.OOXIXo.f3760XO;
            double d2 = 0.0d;
            while (it.hasNext()) {
                d2 += Math.pow(it.next().intValue(), 2.0d);
            }
            Iterator<Integer> it2 = map2.values().iterator();
            double d3 = 0.0d;
            while (it2.hasNext()) {
                d3 += Math.pow(it2.next().intValue(), 2.0d);
            }
            if (d2 > XIXIX.OOXIXo.f3760XO && d3 > XIXIX.OOXIXo.f3760XO) {
                d = II0xO02 / (Math.sqrt(d2) * Math.sqrt(d3));
            }
            return Double.valueOf(d);
        }
        throw new IllegalArgumentException("Vectors must not be null");
    }
}
