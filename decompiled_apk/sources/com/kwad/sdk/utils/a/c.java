package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.kwad.sdk.utils.a.a;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes11.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int aSA;
    private static final int[] aSw = {0, 1, 4, 4, 8, 8};
    private static final byte[] aSx = new byte[0];
    private static final int aSy;
    private static final int aSz;
    private final String Wx;
    private final Map<String, b> aSB;
    private FileChannel aSD;
    private FileChannel aSE;
    private RandomAccessFile aSF;
    private RandomAccessFile aSG;
    private MappedByteBuffer aSH;
    private MappedByteBuffer aSI;
    private com.kwad.sdk.utils.a.b aSJ;
    private int aSK;
    private long aSL;
    private int aSO;
    private int aSP;
    private int aSQ;
    private boolean aSR;
    private String aSS;
    private int aST;
    private int aSV;
    private final String name;
    private final d aSC = com.kwad.sdk.utils.a.d.aTg;
    private final Map<String, a.b> aSM = new HashMap();
    private boolean aSN = false;
    private final ArrayList<e> aSU = new ArrayList<>();
    private boolean aSW = true;
    private final Executor aSX = new f();

    /* loaded from: classes11.dex */
    public static class a {
        static int aSZ = 11;
        static final C0875c aTa = new C0875c(11);
        private final String Wx;
        private int aSV = 0;
        private b[] aTb;
        private final String name;

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + IOUtils.DIR_SEPARATOR_UNIX;
                    }
                    this.Wx = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public final c Oy() {
            String str = this.Wx + this.name;
            c hs = C0875c.hs(str);
            if (hs == null) {
                synchronized (a.class) {
                    try {
                        hs = C0875c.hs(str);
                        if (hs == null) {
                            hs = new c(this.Wx, this.name, this.aTb, this.aSV);
                            C0875c.b(str, hs);
                        }
                    } finally {
                    }
                }
            }
            Integer num = C0875c.aTf.get(str);
            if (num != null) {
                C0875c.aTf.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0875c.aTf.put(str, 1);
            }
            return hs;
        }
    }

    /* loaded from: classes11.dex */
    public interface b<T> {
        String Oz();

        T g(byte[] bArr, int i, int i2);

        byte[] m(T t);
    }

    /* renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0875c {
        private static Map<String, c> aTc;
        private static List<String> aTd;
        private static int aTe;
        public static Map<String, Integer> aTf;

        public C0875c(int i) {
            int size = getSize(i);
            aTc = new ConcurrentHashMap(size);
            aTf = new HashMap(size);
            aTd = new CopyOnWriteArrayList();
            aTe = i;
        }

        public static void b(String str, c cVar) {
            if (aTc == null) {
                aTc = new ConcurrentHashMap(getSize(aTe));
            }
            if (aTd == null) {
                aTd = new CopyOnWriteArrayList();
            }
            if (aTc.containsKey(str)) {
                aTd.remove(str);
                aTd.add(str);
            } else {
                aTd.add(str);
            }
            aTc.put(str, cVar);
            if (aTc.size() > aTe) {
                Integer num = aTf.get(aTd.get(0));
                if (num != null && num.intValue() != 2) {
                    et(aTe + 1);
                    return;
                }
                c cVar2 = aTc.get(aTd.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aTc.remove(aTd.get(0));
                aTd.remove(0);
            }
        }

        private static void et(int i) {
            com.kwad.sdk.utils.a.d.aTg.i("Ks_UnionKv", "reSize:" + i);
            aTe = i;
        }

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public static c hs(String str) {
            if (aTc == null) {
                aTc = new ConcurrentHashMap(getSize(aTe));
            }
            if (aTd == null) {
                aTd = new CopyOnWriteArrayList();
            }
            c cVar = aTc.get(str);
            if (cVar != null) {
                aTd.remove(str);
                aTd.add(str);
                return cVar;
            }
            return null;
        }

        public static void remove(String str) {
            List<String> list = aTd;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aTc;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* loaded from: classes11.dex */
    public static class e implements Comparable<e> {
        int end;
        int start;

        public e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int OC = h.OC();
        PAGE_SIZE = OC;
        aSy = OC - 192;
        int max = Math.max(OC << 1, 16384);
        aSz = max;
        aSA = max << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i) {
        this.Wx = str;
        this.name = str2;
        this.aSV = i;
        HashMap hashMap = new HashMap();
        g gVar = g.aTn;
        hashMap.put(gVar.Oz(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String Oz = bVar.Oz();
                if (hashMap.containsKey(Oz)) {
                    hr("duplicate encoder tag:" + Oz);
                } else {
                    hashMap.put(Oz, bVar);
                }
            }
        }
        this.aSB = hashMap;
        synchronized (this.aSM) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Og();
                }
            });
            while (!this.aSN) {
                try {
                    this.aSM.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private int E(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (!com.kwad.library.a.a.md.booleanValue()) {
                u(illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = aSz;
            if (i <= i4) {
                i <<= 1;
            } else {
                i += i4;
            }
        }
        return i;
    }

    private void F(int i, int i2) {
        this.aST += i2 - i;
        ArrayList<e> arrayList = this.aSU;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Og() {
        try {
            synchronized (this.aSM) {
                this.aSN = true;
                this.aSM.notify();
            }
            long nanoTime = System.nanoTime();
            if (!Oj() && this.aSV == 0) {
                Oh();
            }
            if (this.aSJ == null) {
                this.aSJ = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
            }
            if (this.aSC != null) {
                info("loading finish, data len:" + this.aSK + ", get keys:" + this.aSM.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void Oh() {
        long j;
        long j2;
        c cVar = this;
        File file = new File(cVar.Wx, cVar.name + ".kva");
        File file2 = new File(cVar.Wx, cVar.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                cVar.aSF = new RandomAccessFile(file, "rw");
                cVar.aSG = new RandomAccessFile(file2, "rw");
                long length = cVar.aSF.length();
                long length2 = cVar.aSG.length();
                cVar.aSD = cVar.aSF.getChannel();
                cVar.aSE = cVar.aSG.getChannel();
                try {
                    FileChannel fileChannel = cVar.aSD;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    if (length > 0) {
                        j = length;
                    } else {
                        j = PAGE_SIZE;
                    }
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
                    cVar.aSH = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    FileChannel fileChannel2 = cVar.aSE;
                    if (length2 > 0) {
                        j2 = length2;
                    } else {
                        j2 = PAGE_SIZE;
                    }
                    MappedByteBuffer map2 = fileChannel2.map(mapMode, 0L, j2);
                    cVar.aSI = map2;
                    map2.order(byteOrder);
                    cVar.aSJ = new com.kwad.sdk.utils.a.b(cVar.aSH.capacity());
                    if (length == 0 && length2 == 0) {
                        cVar.aSK = 12;
                        return;
                    }
                    int i = cVar.aSH.getInt();
                    long j3 = cVar.aSH.getLong();
                    int i2 = cVar.aSI.getInt();
                    long j4 = cVar.aSI.getLong();
                    if (i >= 0) {
                        if (i <= length - 12) {
                            cVar = this;
                            cVar.aSK = i + 12;
                            cVar.aSH.rewind();
                            cVar.aSH.get(cVar.aSJ.aSv, 0, cVar.aSK);
                            if (j3 == cVar.aSJ.D(12, i) && Ok() == 0) {
                                cVar.aSL = j3;
                                if (length != length2 || !Oi()) {
                                    cVar.g(new Exception("B file error"));
                                    cVar.a(cVar.aSH, cVar.aSI, cVar.aSK);
                                    return;
                                }
                                return;
                            }
                        } else {
                            cVar = this;
                        }
                    }
                    if (i2 >= 0 && i2 <= length2 - 12) {
                        cVar.aSM.clear();
                        Ox();
                        cVar.aSK = i2 + 12;
                        if (cVar.aSJ.aSv.length != cVar.aSI.capacity()) {
                            cVar.aSJ = new com.kwad.sdk.utils.a.b(cVar.aSI.capacity());
                        }
                        cVar.aSI.rewind();
                        cVar.aSI.get(cVar.aSJ.aSv, 0, cVar.aSK);
                        if (j4 == cVar.aSJ.D(12, i2) && Ok() == 0) {
                            cVar.g(new Exception("A file error"));
                            cVar.a(cVar.aSI, cVar.aSH, cVar.aSK);
                            cVar.aSL = j4;
                            return;
                        }
                    }
                    cVar.hr("both files error");
                    Oq();
                    return;
                } catch (IOException e2) {
                    cVar.u(e2);
                    Op();
                    cVar.h(file, file2);
                    return;
                }
            }
            cVar.u(new Exception("open file failed"));
            Op();
        } catch (Throwable th) {
            cVar.u(th);
            Or();
            Op();
        }
    }

    private boolean Oi() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.aSK);
        MappedByteBuffer mappedByteBuffer = this.aSI;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aSI.get(bVar.aSv, 0, this.aSK);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        if (bVar2 != null) {
            byte[] bArr = bVar2.aSv;
            byte[] bArr2 = bVar.aSv;
            for (int i = 0; i < this.aSK; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private boolean Oj() {
        File file = new File(this.Wx, this.name + ".kvc");
        File file2 = new File(this.Wx, this.name + ".tmp");
        boolean z = false;
        try {
            if (!file.exists()) {
                if (file2.exists()) {
                    file = file2;
                } else {
                    file = null;
                }
            }
            if (file != null) {
                if (ad(file)) {
                    if (this.aSV != 0) {
                        return false;
                    }
                    if (a(this.aSJ)) {
                        info("recover from c file");
                        try {
                            Oo();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            z = true;
                            u(e);
                            return z;
                        }
                    }
                    this.aSV = 1;
                    return false;
                }
                Or();
                Oo();
                return false;
            }
            if (this.aSV == 0) {
                return false;
            }
            File file3 = new File(this.Wx, this.name + ".kva");
            File file4 = new File(this.Wx, this.name + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            h(file3, file4);
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0175, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int Ok() {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.a.c.Ok():int");
    }

    private void Ol() {
        if (this.aSV != 0 && this.aSW) {
            Om();
        }
    }

    private boolean Om() {
        int i = this.aSV;
        if (i == 1) {
            Executor executor = this.aSX;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.On();
                    }
                });
            }
        } else if (i == 2) {
            return On();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean On() {
        try {
            try {
                File file = new File(this.Wx, this.name + ".tmp");
                if (h.ae(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.aSK);
                    randomAccessFile.write(this.aSJ.aSv, 0, this.aSK);
                    randomAccessFile.close();
                    File file2 = new File(this.Wx, this.name + ".kvc");
                    if (file2.exists()) {
                        if (file2.delete()) {
                        }
                    }
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            } catch (Exception e2) {
                u(e2);
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void Oo() {
        try {
            h.h(new File(this.Wx, this.name + ".kvc"));
            h.h(new File(this.Wx, this.name + ".tmp"));
        } catch (Exception e2) {
            u(e2);
        }
    }

    private void Op() {
        this.aSV = 1;
        h.closeQuietly(this.aSD);
        h.closeQuietly(this.aSE);
        this.aSD = null;
        this.aSE = null;
        this.aSH = null;
        this.aSI = null;
    }

    private void Oq() {
        if (this.aSV == 0) {
            try {
                a(this.aSH);
                a(this.aSI);
            } catch (Throwable unused) {
                Op();
            }
        }
        Or();
        h.h(new File(this.Wx + this.name));
    }

    private void Or() {
        this.aSK = 12;
        this.aSL = 0L;
        Ox();
        this.aSM.clear();
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null && bVar.aSv.length == PAGE_SIZE) {
            bVar.B(0, 0);
            this.aSJ.f(4, 0L);
        } else {
            this.aSJ = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
    }

    private void Os() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        if (bVar2 != null) {
            this.aSL ^= bVar2.D(this.aSO, this.aSP);
        }
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aSH);
                this.aSH.putInt(0, this.aSK - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aSR && (bVar = this.aSJ) != null) {
                bVar.B(0, this.aSK - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.aSJ;
            if (bVar3 != null) {
                bVar3.f(4, this.aSL);
            }
        }
        this.aSR = false;
        this.aSQ = 0;
        this.aSP = 0;
    }

    private int Ot() {
        int i = this.aSK;
        if (i <= 16384) {
            return 4096;
        }
        if (i > 65536) {
            return 16384;
        }
        return 8192;
    }

    private void Ou() {
        eq(this.aSP);
        int i = this.aSK;
        this.aSO = i;
        this.aSK = this.aSP + i;
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null) {
            bVar.position = i;
        }
        this.aSR = true;
    }

    private void Ov() {
        int i;
        if (this.aST < (Ot() << 1)) {
            int size = this.aSU.size();
            if (this.aSK < 16384) {
                i = 80;
            } else {
                i = 160;
            }
            if (size < i) {
                return;
            }
        }
        er(0);
    }

    private void Ow() {
        ArrayList<e> arrayList = this.aSU;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aSU.get(size);
        while (size > 0) {
            int i = size - 1;
            e eVar2 = this.aSU.get(i);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aSU.remove(size);
            }
            eVar = eVar2;
            size = i;
        }
    }

    private void Ox() {
        this.aST = 0;
        ArrayList<e> arrayList = this.aSU;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= O0Xx.f12382xxX) {
            int i = (int) length;
            int E = E(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar = this.aSJ;
            if (bVar != null && bVar.aSv.length == E) {
                bVar.position = 0;
            } else {
                bVar = new com.kwad.sdk.utils.a.b(new byte[E]);
                this.aSJ = bVar;
            }
            h.a(file, bVar.aSv, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.aSK = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.D(12, i2) && Ok() == 0) {
                this.aSL = j;
                return true;
            }
        }
        return false;
    }

    private static long e(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private static void ep(int i) {
        if (i <= 255) {
        } else {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void eq(int i) {
        if (this.aSJ == null) {
            this.aSJ = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.aSJ.aSv.length;
        int i2 = this.aSK + i;
        if (i2 >= length) {
            int i3 = this.aST;
            if (i3 > i && i3 > Ot()) {
                er(i);
                return;
            }
            int E = E(length, i2);
            byte[] bArr = new byte[E];
            System.arraycopy(this.aSJ.aSv, 0, bArr, 0, this.aSK);
            this.aSJ.aSv = bArr;
            if (this.aSV == 0) {
                try {
                    FileChannel fileChannel = this.aSD;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j = E;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
                    this.aSH = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.aSE.map(mapMode, 0L, j);
                    this.aSI = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    u(new Exception("map failed", th));
                    this.aSJ.B(0, this.aSK - 12);
                    this.aSJ.f(4, this.aSL);
                    Op();
                }
            }
        }
    }

    private void er(int i) {
        boolean z;
        int i2;
        int i3;
        ArrayList<e> arrayList = this.aSU;
        if (arrayList == null || this.aSJ == null) {
            return;
        }
        Collections.sort(arrayList);
        Ow();
        e eVar = this.aSU.get(0);
        int i4 = eVar.start;
        int i5 = this.aSK;
        int i6 = i5 - this.aST;
        int i7 = i6 - 12;
        int i8 = i6 - i4;
        int i9 = i5 - i4;
        if (i7 < i9 + i8) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.aSL ^= this.aSJ.D(i4, i9);
        }
        int size = this.aSU.size();
        int i10 = size - 1;
        int i11 = this.aSK - this.aSU.get(i10).end;
        if (i11 > 0) {
            i2 = size;
        } else {
            i2 = i10;
        }
        int[] iArr = new int[i2 << 1];
        int i12 = eVar.start;
        int i13 = eVar.end;
        for (int i14 = 1; i14 < size; i14++) {
            e eVar2 = this.aSU.get(i14);
            int i15 = eVar2.start - i13;
            byte[] bArr = this.aSJ.aSv;
            System.arraycopy(bArr, i13, bArr, i12, i15);
            int i16 = (i14 - 1) << 1;
            iArr[i16] = i13;
            iArr[i16 + 1] = i13 - i12;
            i12 += i15;
            i13 = eVar2.end;
        }
        if (i11 > 0) {
            byte[] bArr2 = this.aSJ.aSv;
            System.arraycopy(bArr2, i13, bArr2, i12, i11);
            int i17 = i10 << 1;
            iArr[i17] = i13;
            iArr[i17 + 1] = i13 - i12;
        }
        Ox();
        if (z) {
            this.aSL = this.aSJ.D(12, i7);
        } else {
            this.aSL ^= this.aSJ.D(i4, i8);
        }
        this.aSK = i6;
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                i3 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aSH.putLong(4, this.aSL);
                this.aSH.position(i4);
                this.aSH.put(this.aSJ.aSv, i4, i8);
                this.aSH.putInt(0, i7);
            } else {
                i3 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i3, i7);
                this.aSI.putLong(4, this.aSL);
                this.aSI.position(i4);
                this.aSI.put(this.aSJ.aSv, i4, i8);
            }
        } else {
            this.aSJ.B(0, i7);
            this.aSJ.f(4, this.aSL);
        }
        a(i4, iArr);
        int i18 = i6 + i;
        if (this.aSJ.aSv.length - i18 > aSA) {
            es(i18);
        }
        info("gc finish");
    }

    private void es(int i) {
        int i2 = PAGE_SIZE;
        int E = E(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null) {
            byte[] bArr = bVar.aSv;
            if (E >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[E];
            System.arraycopy(bArr, 0, bArr2, 0, this.aSK);
            this.aSJ.aSv = bArr2;
        }
        if (this.aSV == 0) {
            try {
                long j = E;
                this.aSD.truncate(j);
                FileChannel fileChannel = this.aSD;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
                this.aSH = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.aSE.truncate(j);
                MappedByteBuffer map2 = this.aSE.map(mapMode, 0L, j);
                this.aSI = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                u(new Exception("map failed", th));
                Op();
            }
        }
        info("truncate finish");
    }

    private void g(Exception exc) {
        d dVar = this.aSC;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        Or();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e3) {
            g(e3);
        }
        Or();
    }

    private static void hq(String str) {
        if (str != null && !str.isEmpty()) {
        } else {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hr(String str) {
        d dVar = this.aSC;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.aSC;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d2) {
        try {
            hq(str);
            a.d dVar = (a.d) this.aSM.get(str);
            if (dVar == null) {
                a(str, (byte) 5);
                com.kwad.sdk.utils.a.b bVar = this.aSJ;
                if (bVar != null) {
                    int i = bVar.position;
                    bVar.aO(Double.doubleToRawLongBits(d2));
                    Os();
                    Map<String, a.b> map = this.aSM;
                    if (map != null) {
                        map.put(str, new a.d(i, d2));
                    }
                }
                Ol();
                return;
            }
            if (dVar.value != d2) {
                long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits;
                dVar.value = d2;
                b(doubleToRawLongBits, doubleToRawLongBits2, dVar.offset);
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void putFloat(String str, float f) {
        try {
            hq(str);
            a.e eVar = (a.e) this.aSM.get(str);
            if (eVar == null) {
                a(str, (byte) 3);
                com.kwad.sdk.utils.a.b bVar = this.aSJ;
                if (bVar != null) {
                    int i = bVar.position;
                    bVar.ei(Float.floatToRawIntBits(f));
                    Os();
                    Map<String, a.b> map = this.aSM;
                    if (map != null) {
                        map.put(str, new a.e(i, f));
                    }
                }
                Ol();
                return;
            }
            if (eVar.value != f) {
                int floatToRawIntBits = Float.floatToRawIntBits(f);
                long floatToRawIntBits2 = (Float.floatToRawIntBits(eVar.value) ^ floatToRawIntBits) & BleWatchFaceId.WATCHFACE_ID_INVALID;
                eVar.value = f;
                a(floatToRawIntBits, floatToRawIntBits2, eVar.offset);
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aTn);
        }
    }

    private void t(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
            a(str, 0, i, bVar2.aSv, bVar2.position);
            this.aSJ.position += i;
            return;
        }
        this.aSJ.hm(str);
    }

    private void u(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
            a(str, 0, i, bVar2.aSv, bVar2.position);
        } else {
            this.aSJ.hm(str);
        }
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null) {
            this.aSL ^= bVar.D(i, length);
            com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
            bVar2.position = i;
            bVar2.n(bArr);
            this.aSL ^= this.aSJ.D(i, length);
        }
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aSH.putLong(4, this.aSL);
                this.aSH.position(i);
                this.aSH.put(bArr);
                this.aSH.putInt(0, this.aSK - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aSL);
                this.aSI.position(i);
                this.aSI.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar3 = this.aSJ;
        if (bVar3 != null) {
            bVar3.f(4, this.aSL);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aSM.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.aSM.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.aSM.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            switch (value.Oe()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.aSt) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0874a c0874a = (a.C0874a) value;
                    if (c0874a.aSt) {
                        valueOf = a(c0874a);
                        break;
                    } else {
                        valueOf = c0874a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aSt) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.aSM.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.aSM.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.aSM.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aSM.get(str);
        if (iVar != null) {
            if (iVar.aSt) {
                return a(iVar);
            }
            return (String) iVar.value;
        }
        return str2;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        try {
            hq(str);
            a.c cVar = (a.c) this.aSM.get(str);
            if (cVar == null) {
                a(str, (byte) 1);
                com.kwad.sdk.utils.a.b bVar = this.aSJ;
                if (bVar != null) {
                    int i = bVar.position;
                    bVar.e(z ? (byte) 1 : (byte) 0);
                    Os();
                    Map<String, a.b> map = this.aSM;
                    if (map != null) {
                        map.put(str, new a.c(i, z));
                    }
                }
                Ol();
                return;
            }
            if (cVar.value != z) {
                cVar.value = z;
                a(z ? (byte) 1 : (byte) 0, cVar.offset);
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void putInt(String str, int i) {
        try {
            hq(str);
            a.f fVar = (a.f) this.aSM.get(str);
            if (fVar == null) {
                a(str, (byte) 2);
                com.kwad.sdk.utils.a.b bVar = this.aSJ;
                if (bVar != null) {
                    int i2 = bVar.position;
                    bVar.ei(i);
                    Os();
                    Map<String, a.b> map = this.aSM;
                    if (map != null) {
                        map.put(str, new a.f(i2, i));
                    }
                }
                Ol();
                return;
            }
            if (fVar.value != i) {
                long j = (r6 ^ i) & BleWatchFaceId.WATCHFACE_ID_INVALID;
                fVar.value = i;
                a(i, j, fVar.offset);
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void putLong(String str, long j) {
        try {
            hq(str);
            a.g gVar = (a.g) this.aSM.get(str);
            if (gVar == null) {
                a(str, (byte) 4);
                com.kwad.sdk.utils.a.b bVar = this.aSJ;
                if (bVar != null) {
                    int i = bVar.position;
                    bVar.aO(j);
                    Os();
                    Map<String, a.b> map = this.aSM;
                    if (map != null) {
                        map.put(str, new a.g(i, j));
                    }
                }
                Ol();
                return;
            }
            long j2 = gVar.value;
            if (j2 != j) {
                gVar.value = j;
                b(j, j ^ j2, gVar.offset);
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] hp;
        byte[] bArr;
        byte[] bArr2;
        hq(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aSM.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            hp = aSx;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int hn = com.kwad.sdk.utils.a.b.hn(str2);
                bArr = new byte[hn];
                if (hn == str2.length()) {
                    a(str2, 0, hn, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hp = com.kwad.sdk.utils.a.b.hp(str2);
                }
            } else if (iVar != null && !iVar.aSt) {
                int hn2 = com.kwad.sdk.utils.a.b.hn(str2);
                bArr = new byte[hn2];
                if (hn2 == str2.length()) {
                    a(str2, 0, hn2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    hp = com.kwad.sdk.utils.a.b.hp(str2);
                }
            } else {
                hp = com.kwad.sdk.utils.a.b.hp(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = hp;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.aSF);
        h.closeQuietly(this.aSG);
        h.closeQuietly(this.aSD);
        h.closeQuietly(this.aSE);
        this.aSD = null;
        this.aSE = null;
        this.aSH = null;
        this.aSI = null;
        String str = this.Wx + this.name;
        C0875c c0875c = a.aTa;
        C0875c.remove(str);
    }

    public final synchronized void remove(String str) {
        try {
            a.b bVar = this.aSM.get(str);
            if (bVar != null) {
                this.aSM.remove(str);
                byte Oe = bVar.Oe();
                String str2 = null;
                if (Oe <= 5) {
                    int hn = com.kwad.sdk.utils.a.b.hn(str);
                    int i = bVar.offset;
                    a(Oe, i - (hn + 2), i + aSw[Oe]);
                } else {
                    a.j jVar = (a.j) bVar;
                    a(Oe, jVar.start, jVar.offset + jVar.aSs);
                    if (jVar.aSt) {
                        str2 = (String) jVar.value;
                    }
                }
                byte b2 = (byte) (Oe | Byte.MIN_VALUE);
                if (this.aSV == 0) {
                    MappedByteBuffer mappedByteBuffer = this.aSH;
                    if (mappedByteBuffer != null) {
                        mappedByteBuffer.putLong(4, this.aSL);
                        this.aSH.put(this.aSQ, b2);
                    }
                    MappedByteBuffer mappedByteBuffer2 = this.aSI;
                    if (mappedByteBuffer2 != null) {
                        mappedByteBuffer2.putLong(4, this.aSL);
                        this.aSI.put(this.aSQ, b2);
                    }
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
                    if (bVar2 != null) {
                        bVar2.f(4, this.aSL);
                    }
                }
                this.aSQ = 0;
                if (str2 != null) {
                    h.h(new File(this.Wx + this.name, str2));
                }
                Ov();
                Ol();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.Wx + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.aSv.length;
        File file = new File(this.Wx, this.name + ".kva");
        File file2 = new File(this.Wx, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.aSD = randomAccessFile.getChannel();
                this.aSE = randomAccessFile2.getChannel();
                FileChannel fileChannel = this.aSD;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
                this.aSH = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.aSE.map(mapMode, 0L, j);
                this.aSI = map2;
                map2.order(byteOrder);
                this.aSH.put(bVar.aSv, 0, this.aSK);
                this.aSI.put(bVar.aSv, 0, this.aSK);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e2) {
            u(e2);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        hq(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0874a) this.aSM.get(str), (byte) 7);
        }
    }

    private static void e(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void u(Throwable th) {
        d dVar = this.aSC;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aSR && mappedByteBuffer != this.aSH) {
            mappedByteBuffer.putInt(0, this.aSK - 12);
        }
        mappedByteBuffer.putLong(4, this.aSL);
        int i = this.aSQ;
        if (i != 0) {
            mappedByteBuffer.put(i, this.aSJ.aSv[i]);
        }
        if (this.aSP != 0) {
            mappedByteBuffer.position(this.aSO);
            mappedByteBuffer.put(this.aSJ.aSv, this.aSO, this.aSP);
        }
    }

    private void b(long j, long j2, int i) {
        long e2 = e(j2, i) ^ this.aSL;
        this.aSL = e2;
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aSH.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aSL);
                this.aSI.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aSJ;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        if (bVar2 != null) {
            bVar2.f(i, j);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aSI ? this.aSE : this.aSD).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aSI) {
                    this.aSI = map;
                } else {
                    this.aSH = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                u(e2);
                Op();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        int i = bVar2.position;
        bVar2.n(bArr);
        return i;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] af = h.af(new File(this.Wx + this.name, (String) iVar.value));
            String str = new String(af);
            return (af == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(af, com.kwad.sdk.utils.a.b.hn(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            u(e2);
        }
        return "";
    }

    private byte[] a(a.C0874a c0874a) {
        try {
            byte[] af = h.af(new File(this.Wx + this.name, (String) c0874a.value));
            return af != null ? af : aSx;
        } catch (Exception e2) {
            u(e2);
            return aSx;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] af = h.af(new File(this.Wx + this.name, (String) hVar.value));
            if (af != null) {
                int i = af[0] & 255;
                String str = new String(af, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.aSB.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.g(af, i2, af.length - i2);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            u(e2);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        byte[] bArr;
        hq(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.md.booleanValue()) {
                u(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String Oz = bVar.Oz();
        if (!Oz.isEmpty() && Oz.length() <= 50) {
            if (!this.aSB.containsKey(Oz)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.md.booleanValue()) {
                    u(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            }
            if (t == null) {
                remove(str);
                return;
            }
            try {
                bArr = bVar.m(t);
            } catch (Exception e2) {
                u(e2);
                bArr = null;
            }
            if (bArr == null) {
                remove(str);
                return;
            }
            int hn = com.kwad.sdk.utils.a.b.hn(Oz);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(hn + 1 + bArr.length);
            bVar2.e((byte) hn);
            bVar2.hm(Oz);
            bVar2.n(bArr);
            a(str, t, bVar2.aSv, (a.h) this.aSM.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + Oz);
        if (!com.kwad.library.a.a.md.booleanValue()) {
            u(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        b(key, (byte[]) value);
                    } else {
                        g(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        int capacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (capacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aSH ? this.aSD : this.aSE;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aSH) {
                this.aSH = map;
            } else {
                this.aSI = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b2) {
        a(str, b2, aSw[b2]);
    }

    private void a(String str, byte b2, int i) {
        int hn = com.kwad.sdk.utils.a.b.hn(str);
        ep(hn);
        this.aSP = hn + 2 + i;
        Ou();
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null) {
            bVar.e(b2);
        }
        t(str, hn);
    }

    private void a(byte b2, int i) {
        long e2 = this.aSL ^ e(1L, i);
        this.aSL = e2;
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aSH.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aSL);
                this.aSI.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aSJ;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        if (bVar2 != null) {
            bVar2.aSv[i] = b2;
        }
    }

    private void a(int i, long j, int i2) {
        long e2 = e(j, i2) ^ this.aSL;
        this.aSL = e2;
        if (this.aSV == 0) {
            MappedByteBuffer mappedByteBuffer = this.aSH;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aSH.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aSI;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aSL);
                this.aSI.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aSJ;
            if (bVar != null) {
                bVar.f(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
        if (bVar2 != null) {
            bVar2.B(i2, i);
        }
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int hn = com.kwad.sdk.utils.a.b.hn(str2);
        if (iVar == null) {
            int hn2 = com.kwad.sdk.utils.a.b.hn(str);
            ep(hn2);
            int i = hn2 + 4;
            this.aSP = i + hn;
            Ou();
            com.kwad.sdk.utils.a.b bVar = this.aSJ;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            t(str, hn2);
            u(str2, hn);
            Map<String, a.b> map = this.aSM;
            int i2 = this.aSO;
            map.put(str, new a.i(i2, i2 + i, str2, hn, false));
            Os();
        } else {
            int i3 = iVar.offset;
            int i4 = i3 - iVar.start;
            int i5 = iVar.aSs;
            boolean z = false;
            if (i5 == hn) {
                this.aSL ^= this.aSJ.D(i3, i5);
                if (hn == str2.length()) {
                    a(str2, 0, hn, this.aSJ.aSv, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aSJ;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hm(str2);
                    }
                }
                this.aSO = iVar.offset;
                this.aSP = hn;
            } else {
                this.aSP = i4 + hn;
                Ou();
                com.kwad.sdk.utils.a.b bVar3 = this.aSJ;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i6 = i4 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.aSJ;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aSv;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i6);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.aSJ;
                if (bVar5 != null) {
                    bVar5.position += i6;
                }
                u(str2, hn);
                a((byte) 6, iVar.start, iVar.offset + iVar.aSs);
                r5 = iVar.aSt ? (String) iVar.value : null;
                iVar.aSt = false;
                int i7 = this.aSO;
                iVar.start = i7;
                iVar.offset = i7 + i4;
                iVar.aSs = hn;
                z = true;
            }
            iVar.value = str2;
            Os();
            if (z) {
                Ov();
            }
            if (r5 != null) {
                h.h(new File(this.Wx + this.name, r5));
            }
        }
        Ol();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (!jVar.aSt && jVar.aSs == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Ol();
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        a.b hVar;
        int a2 = a(str, bArr, b2);
        if (a2 != 0) {
            String str2 = this.aSS;
            boolean z = str2 != null;
            if (z) {
                this.aSS = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new a.i(this.aSO, a2, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new a.C0874a(this.aSO, a2, obj2, length, z);
            } else {
                hVar = new a.h(this.aSO, a2, obj2, length, z);
            }
            this.aSM.put(str, hVar);
            Os();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int a2 = a(str, bArr, jVar.Oe());
        if (a2 != 0) {
            String str2 = jVar.aSt ? (String) jVar.value : null;
            a(jVar.Oe(), jVar.start, jVar.offset + jVar.aSs);
            String str3 = this.aSS;
            boolean z = str3 != null;
            jVar.start = this.aSO;
            jVar.offset = a2;
            jVar.aSt = z;
            if (z) {
                jVar.value = str3;
                jVar.aSs = 32;
                this.aSS = null;
            } else {
                jVar.value = obj;
                jVar.aSs = bArr.length;
            }
            Os();
            Ov();
            if (str2 != null) {
                h.h(new File(this.Wx + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.aSS = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String OB = h.OB();
        if (h.a(new File(this.Wx + this.name, OB), bArr)) {
            this.aSS = OB;
            byte[] bArr2 = new byte[32];
            OB.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | 64));
        }
        hr("save large value failed");
        return 0;
    }

    private void a(byte b2, int i, int i2) {
        byte[] bArr;
        F(i, i2);
        byte b3 = (byte) (b2 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.aSJ;
        if (bVar != null && (bArr = bVar.aSv) != null) {
            this.aSL = (((bArr[i] ^ b3) & 255) << ((i & 7) << 3)) ^ this.aSL;
            bArr[i] = b3;
        }
        this.aSQ = i;
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.aSM;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i2 = bVar.offset;
            if (i2 > i) {
                int i3 = iArr[(h.binarySearch(iArr, i2) << 1) + 1];
                bVar.offset -= i3;
                if (bVar.Oe() >= 6) {
                    ((a.j) bVar).start -= i3;
                }
            }
        }
    }
}
