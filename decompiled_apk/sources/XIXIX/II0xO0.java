package XIXIX;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

/* loaded from: classes9.dex */
public class II0xO0 implements Comparator<Entry> {
    @Override // java.util.Comparator
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public int compare(Entry entry, Entry entry2) {
        float xxIXOIIO2 = entry.xxIXOIIO() - entry2.xxIXOIIO();
        if (xxIXOIIO2 == 0.0f) {
            return 0;
        }
        if (xxIXOIIO2 > 0.0f) {
            return 1;
        }
        return -1;
    }
}
