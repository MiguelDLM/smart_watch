package xx0;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes13.dex */
public class IXxxXO implements Iterable<String> {

    /* renamed from: Oo, reason: collision with root package name */
    public AtomicInteger f35199Oo;

    /* renamed from: XO, reason: collision with root package name */
    public ConcurrentLinkedQueue<String> f35200XO;

    public IXxxXO() {
        this.f35200XO = null;
        this.f35199Oo = null;
        this.f35200XO = new ConcurrentLinkedQueue<>();
        this.f35199Oo = new AtomicInteger(0);
    }

    public void I0Io(Writer[] writerArr, char[] cArr) throws IOException {
        int i;
        if (writerArr != null && cArr != null && cArr.length != 0 && writerArr.length >= 2) {
            Writer writer = writerArr[0];
            Writer writer2 = writerArr[1];
            int length = cArr.length;
            Iterator<String> it = iterator();
            int i2 = length;
            int i3 = 0;
            while (it.hasNext()) {
                String next = it.next();
                int length2 = next.length();
                int i4 = 0;
                while (length2 > 0) {
                    if (i2 > length2) {
                        i = length2;
                    } else {
                        i = i2;
                    }
                    int i5 = i4 + i;
                    next.getChars(i4, i5, cArr, i3);
                    i2 -= i;
                    i3 += i;
                    length2 -= i;
                    if (i2 == 0) {
                        if (writer != null) {
                            try {
                                writer.write(cArr, 0, length);
                            } catch (Exception unused) {
                            }
                        }
                        if (writer2 != null) {
                            try {
                                writer2.write(cArr, 0, length);
                            } catch (Exception unused2) {
                            }
                        }
                        i2 = length;
                        i4 = i5;
                        i3 = 0;
                    } else {
                        i4 = i5;
                    }
                }
            }
            if (i3 > 0) {
                if (writer != null) {
                    try {
                        writer.write(cArr, 0, i3);
                    } catch (Exception unused3) {
                    }
                }
                if (writer2 != null) {
                    try {
                        writer2.write(cArr, 0, i3);
                    } catch (Exception unused4) {
                    }
                }
            }
            if (writer != null) {
                try {
                    writer.flush();
                } catch (Exception unused5) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.flush();
                } catch (Exception unused6) {
                }
            }
        }
    }

    public int II0xO0(String str) {
        int length = str.length();
        this.f35200XO.add(str);
        return this.f35199Oo.addAndGet(length);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f35200XO.iterator();
    }

    public int oIX0oI() {
        return this.f35199Oo.get();
    }

    public void oxoX() {
        this.f35200XO.clear();
        this.f35199Oo.set(0);
    }
}
