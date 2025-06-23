package com.kwad.sdk.core.diskcache.a;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.kwad.sdk.utils.q;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: classes11.dex */
public final class a implements Closeable {
    static final Pattern auP = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream ave = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private final File auQ;
    private final File auR;
    private final File auS;
    private final File auT;
    private final int auU;
    private int auV;
    private final int auW;
    private Writer auY;
    private int ava;
    private long maxSize;
    private long size = 0;
    private int auX = 0;
    private final LinkedHashMap<String, b> auZ = new LinkedHashMap<>(0, 0.75f, true);
    private long avb = 0;
    final ThreadPoolExecutor avc = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> avd = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: DC, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.auY != null) {
                        a.this.trimToSize();
                        a.this.DI();
                        if (a.this.DH()) {
                            a.this.DF();
                            a.a(a.this, 0);
                        }
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public final class C0848a {
        private final b avg;
        private final boolean[] avh;
        private boolean avi;
        private boolean avj;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0849a extends FilterOutputStream {
            public /* synthetic */ C0849a(C0848a c0848a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0848a.b(C0848a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0848a.b(C0848a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0848a.b(C0848a.this, true);
                }
            }

            private C0849a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0848a.b(C0848a.this, true);
                }
            }
        }

        public /* synthetic */ C0848a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C0848a c0848a, boolean z) {
            c0848a.avi = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final OutputStream cZ(int i) {
            FileOutputStream fileOutputStream;
            C0849a c0849a;
            synchronized (a.this) {
                try {
                    if (this.avg.avn == this) {
                        byte b = 0;
                        if (!this.avg.avm) {
                            this.avh[0] = true;
                        }
                        File db = this.avg.db(0);
                        try {
                            fileOutputStream = new FileOutputStream(db);
                        } catch (FileNotFoundException unused) {
                            a.this.auQ.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(db);
                            } catch (FileNotFoundException unused2) {
                                return a.ave;
                            }
                        }
                        c0849a = new C0849a(this, fileOutputStream, b);
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0849a;
        }

        public final void commit() {
            if (this.avi) {
                a.this.a(this, false);
                a.this.remove(this.avg.key);
            } else {
                a.this.a(this, true);
            }
            this.avj = true;
        }

        private C0848a(b bVar) {
            this.avg = bVar;
            this.avh = bVar.avm ? null : new boolean[a.this.auW];
        }
    }

    /* loaded from: classes11.dex */
    public final class b {
        private final long[] avl;
        private boolean avm;
        private C0848a avn;
        private long avo;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        public final String DK() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.avl) {
                sb.append(TokenParser.SP);
                sb.append(j);
            }
            return sb.toString();
        }

        public final File da(int i) {
            return new File(a.this.auQ, this.key + i);
        }

        public final File db(int i) {
            return new File(a.this.auQ, this.key + i + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.avl = new long[a.this.auW];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length == a.this.auW) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.avl[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw c(strArr);
                    }
                }
                return;
            }
            throw c(strArr);
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.avm = true;
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public final class c implements Closeable {
        private final long[] avl;
        private final long avo;
        private File[] avp;
        private final InputStream[] avq;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.avq) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dc(int i) {
            return this.avp[0];
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.avo = j;
            this.avp = fileArr;
            this.avq = inputStreamArr;
            this.avl = jArr;
        }
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.auQ = file;
        this.auU = i;
        this.auR = new File(file, "journal");
        this.auS = new File(file, "journal.tmp");
        this.auT = new File(file, "journal.bkp");
        this.auW = i2;
        this.maxSize = j;
        this.auV = i3;
    }

    private void DD() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.auR), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.auU).equals(readLine3) && Integer.toString(this.auW).equals(readLine4) && "".equals(readLine5)) {
                int i = 0;
                while (true) {
                    try {
                        dx(bVar.readLine());
                        i++;
                    } catch (EOFException unused) {
                        this.ava = i - this.auZ.size();
                        com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void DE() {
        p(this.auS);
        Iterator<b> it = this.auZ.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.avn != null) {
                next.avn = null;
                while (i < this.auW) {
                    p(next.da(i));
                    p(next.db(i));
                    i++;
                }
                it.remove();
            } else {
                while (i < this.auW) {
                    this.size += next.avl[i];
                    this.auX++;
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void DF() {
        try {
            Writer writer = this.auY;
            if (writer != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.auS), com.kwad.sdk.crash.utils.a.US_ASCII));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.auU));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.auW));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.auZ.values()) {
                    if (bVar.avn != null) {
                        bufferedWriter.write("DIRTY " + bVar.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.key + bVar.DK() + '\n');
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                if (this.auR.exists()) {
                    a(this.auR, this.auT, true);
                }
                a(this.auS, this.auR, false);
                this.auT.delete();
                this.auY = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.auR, true), com.kwad.sdk.crash.utils.a.US_ASCII));
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DH() {
        int i = this.ava;
        if (i >= 2000 && i >= this.auZ.size()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DI() {
        while (this.auX > this.auV) {
            remove(this.auZ.entrySet().iterator().next().getKey());
        }
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.ava = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.auY != null) {
        } else {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void dA(String str) {
        if (auP.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private void dx(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.auZ.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            b bVar = this.auZ.get(substring);
            byte b2 = 0;
            if (bVar == null) {
                bVar = new b(this, substring, b2);
                this.auZ.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                b.a(bVar, true);
                bVar.avn = null;
                bVar.b(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.avn = new C0848a(this, bVar, b2);
                return;
            } else {
                if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                }
                throw new IOException("unexpected journal line: " + str);
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.auZ.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int DG() {
        return this.auV;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.auY == null) {
                return;
            }
            Iterator it = new ArrayList(this.auZ.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.avn != null) {
                    bVar.avn.abort();
                }
            }
            trimToSize();
            DI();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.auY);
            this.auY = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void delete() {
        close();
        q.deleteContents(this.auQ);
    }

    public final synchronized c dy(String str) {
        InputStream inputStream;
        if (this.auY == null) {
            return null;
        }
        dA(str);
        b bVar = this.auZ.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.avm) {
            return null;
        }
        int i = this.auW;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.auW; i2++) {
            try {
                File da = bVar.da(i2);
                fileArr[i2] = da;
                inputStreamArr[i2] = new FileInputStream(da);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.auW && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.ava++;
        this.auY.append((CharSequence) ("READ " + str + '\n'));
        if (DH()) {
            this.avc.submit(this.avd);
        }
        return new c(this, str, bVar.avo, fileArr, inputStreamArr, bVar.avl, (byte) 0);
    }

    public final C0848a dz(String str) {
        return e(str, -1L);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        DI();
        this.auY.flush();
    }

    public final File getDirectory() {
        return this.auQ;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        try {
            checkNotClosed();
            dA(str);
            b bVar = this.auZ.get(str);
            if (bVar != null && bVar.avn == null) {
                for (int i = 0; i < this.auW; i++) {
                    File da = bVar.da(i);
                    if (da.exists() && !da.delete()) {
                        throw new IOException("failed to delete " + da);
                    }
                    this.size -= bVar.avl[i];
                    this.auX--;
                    bVar.avl[i] = 0;
                }
                this.ava++;
                this.auY.append((CharSequence) ("REMOVE " + str + '\n'));
                this.auZ.remove(str);
                if (DH()) {
                    this.avc.submit(this.avd);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    private synchronized C0848a e(String str, long j) {
        try {
            checkNotClosed();
            dA(str);
            b bVar = this.auZ.get(str);
            byte b2 = 0;
            if (bVar != null) {
                if (bVar.avn != null) {
                    return null;
                }
            } else {
                bVar = new b(this, str, b2);
                this.auZ.put(str, bVar);
            }
            C0848a c0848a = new C0848a(this, bVar, b2);
            bVar.avn = c0848a;
            this.auY.write("DIRTY " + str + '\n');
            this.auY.flush();
            return c0848a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j, i3);
            if (aVar.auR.exists()) {
                try {
                    aVar.DD();
                    aVar.DE();
                    aVar.auY = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.auR, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j, i3);
            aVar2.DF();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0848a c0848a, boolean z) {
        b bVar = c0848a.avg;
        if (bVar.avn == c0848a) {
            if (z && !bVar.avm) {
                for (int i = 0; i < this.auW; i++) {
                    if (c0848a.avh[i]) {
                        if (!bVar.db(i).exists()) {
                            c0848a.abort();
                            return;
                        }
                    } else {
                        c0848a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.auW; i2++) {
                File db = bVar.db(i2);
                if (z) {
                    if (db.exists()) {
                        File da = bVar.da(i2);
                        db.renameTo(da);
                        long j = bVar.avl[i2];
                        long length = da.length();
                        bVar.avl[i2] = length;
                        this.size = (this.size - j) + length;
                        this.auX++;
                    }
                } else {
                    p(db);
                }
            }
            this.ava++;
            bVar.avn = null;
            if (!(bVar.avm | z)) {
                this.auZ.remove(bVar.key);
                this.auY.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.auY.write("CLEAN " + bVar.key + bVar.DK() + '\n');
                if (z) {
                    long j2 = this.avb;
                    this.avb = 1 + j2;
                    bVar.avo = j2;
                }
            }
            this.auY.flush();
            if (this.size > this.maxSize || this.auX > this.auV || DH()) {
                this.avc.submit(this.avd);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
