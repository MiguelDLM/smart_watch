package com.jd.ad.sdk.jad_fq;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jd.ad.sdk.jad_ep.jad_ly;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

/* loaded from: classes10.dex */
public final class jad_an implements Closeable {
    public final File jad_an;
    public final File jad_bo;
    public final File jad_cp;
    public final File jad_dq;
    public final int jad_er;
    public long jad_fs;
    public Writer jad_iv;
    public final int jad_jt;
    public int jad_kx;
    public long jad_hu = 0;
    public final LinkedHashMap<String, jad_dq> jad_jw = new LinkedHashMap<>(0, 0.75f, true);
    public long jad_ly = 0;
    public final ThreadPoolExecutor jad_mz = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jad_bo(null));
    public final Callable<Void> jad_na = new CallableC0683jad_an();

    /* renamed from: com.jd.ad.sdk.jad_fq.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class CallableC0683jad_an implements Callable<Void> {
        public CallableC0683jad_an() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (jad_an.this) {
                try {
                    jad_an jad_anVar = jad_an.this;
                    if (jad_anVar.jad_iv != null) {
                        jad_anVar.jad_jt();
                        if (jad_an.this.jad_cp()) {
                            jad_an.this.jad_fs();
                            jad_an.this.jad_kx = 0;
                        }
                    }
                } finally {
                }
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo implements ThreadFactory {
        public jad_bo() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ jad_bo(CallableC0683jad_an callableC0683jad_an) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public final class jad_cp {
        public final jad_dq jad_an;
        public final boolean[] jad_bo;
        public boolean jad_cp;

        public jad_cp(jad_dq jad_dqVar) {
            this.jad_an = jad_dqVar;
            this.jad_bo = jad_dqVar.jad_er ? null : new boolean[jad_an.this.jad_jt];
        }

        public void jad_an() {
            jad_an.jad_an(jad_an.this, this, false);
        }

        public File jad_an(int i) {
            File jad_bo;
            synchronized (jad_an.this) {
                try {
                    jad_dq jad_dqVar = this.jad_an;
                    if (jad_dqVar.jad_fs != this) {
                        throw new IllegalStateException();
                    }
                    if (!jad_dqVar.jad_er) {
                        this.jad_bo[i] = true;
                    }
                    jad_bo = jad_dqVar.jad_bo(i);
                    jad_an.this.jad_an.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return jad_bo;
        }
    }

    /* loaded from: classes10.dex */
    public final class jad_dq {
        public final String jad_an;
        public final long[] jad_bo;
        public File[] jad_cp;
        public File[] jad_dq;
        public boolean jad_er;
        public jad_cp jad_fs;
        public long jad_jt;

        public jad_dq(String str) {
            this.jad_an = str;
            this.jad_bo = new long[jad_an.this.jad_jt];
            this.jad_cp = new File[jad_an.this.jad_jt];
            this.jad_dq = new File[jad_an.this.jad_jt];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < jad_an.this.jad_jt; i++) {
                sb.append(i);
                this.jad_cp[i] = new File(jad_an.this.jad_an, sb.toString());
                sb.append(".tmp");
                this.jad_dq[i] = new File(jad_an.this.jad_an, sb.toString());
                sb.setLength(length);
            }
        }

        public File jad_an(int i) {
            return this.jad_cp[i];
        }

        public File jad_bo(int i) {
            return this.jad_dq[i];
        }

        public String jad_an() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.jad_bo) {
                sb.append(TokenParser.SP);
                sb.append(j);
            }
            return sb.toString();
        }
    }

    /* loaded from: classes10.dex */
    public final class jad_er {
        public final File[] jad_an;

        public jad_er(jad_an jad_anVar, String str, long j, File[] fileArr, long[] jArr) {
            this.jad_an = fileArr;
        }

        public File jad_an(int i) {
            return this.jad_an[i];
        }
    }

    public jad_an(File file, int i, int i2, long j) {
        this.jad_an = file;
        this.jad_er = i;
        this.jad_bo = new File(file, "journal");
        this.jad_cp = new File(file, "journal.tmp");
        this.jad_dq = new File(file, "journal.bkp");
        this.jad_jt = i2;
        this.jad_fs = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.jad_iv == null) {
                return;
            }
            Iterator it = new ArrayList(this.jad_jw.values()).iterator();
            while (it.hasNext()) {
                jad_cp jad_cpVar = ((jad_dq) it.next()).jad_fs;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an();
                }
            }
            jad_jt();
            jad_an(this.jad_iv);
            this.jad_iv = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean jad_cp() {
        int i = this.jad_kx;
        return i >= 2000 && i >= this.jad_jw.size();
    }

    public final void jad_dq() {
        jad_an(this.jad_cp);
        Iterator<jad_dq> it = this.jad_jw.values().iterator();
        while (it.hasNext()) {
            jad_dq next = it.next();
            int i = 0;
            if (next.jad_fs == null) {
                while (i < this.jad_jt) {
                    this.jad_hu += next.jad_bo[i];
                    i++;
                }
            } else {
                next.jad_fs = null;
                while (i < this.jad_jt) {
                    jad_an(next.jad_an(i));
                    jad_an(next.jad_bo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void jad_er() {
        com.jd.ad.sdk.jad_fq.jad_bo jad_boVar = new com.jd.ad.sdk.jad_fq.jad_bo(new FileInputStream(this.jad_bo), 8192, com.jd.ad.sdk.jad_fq.jad_cp.jad_an);
        try {
            String jad_cp2 = jad_boVar.jad_cp();
            String jad_cp3 = jad_boVar.jad_cp();
            String jad_cp4 = jad_boVar.jad_cp();
            String jad_cp5 = jad_boVar.jad_cp();
            String jad_cp6 = jad_boVar.jad_cp();
            if ("libcore.io.DiskLruCache".equals(jad_cp2) && "1".equals(jad_cp3) && Integer.toString(this.jad_er).equals(jad_cp4) && Integer.toString(this.jad_jt).equals(jad_cp5) && "".equals(jad_cp6)) {
                int i = 0;
                while (true) {
                    try {
                        jad_cp(jad_boVar.jad_cp());
                        i++;
                    } catch (EOFException unused) {
                        this.jad_kx = i - this.jad_jw.size();
                        if (jad_boVar.jad_er == -1) {
                            jad_fs();
                        } else {
                            this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_fq.jad_cp.jad_an));
                        }
                        try {
                            jad_boVar.close();
                            return;
                        } catch (RuntimeException e) {
                            throw e;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + jad_cp2 + ", " + jad_cp3 + ", " + jad_cp5 + ", " + jad_cp6 + "]");
            }
        } catch (Throwable th) {
            try {
                jad_boVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void jad_fs() {
        StringBuilder sb;
        try {
            Writer writer = this.jad_iv;
            if (writer != null) {
                jad_an(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_cp), com.jd.ad.sdk.jad_fq.jad_cp.jad_an));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.jad_er));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.jad_jt));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (jad_dq jad_dqVar : this.jad_jw.values()) {
                    if (jad_dqVar.jad_fs != null) {
                        sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(jad_dqVar.jad_an);
                        sb.append('\n');
                    } else {
                        sb = new StringBuilder();
                        sb.append("CLEAN ");
                        sb.append(jad_dqVar.jad_an);
                        sb.append(jad_dqVar.jad_an());
                        sb.append('\n');
                    }
                    bufferedWriter.write(sb.toString());
                }
                jad_an(bufferedWriter);
                if (this.jad_bo.exists()) {
                    jad_an(this.jad_bo, this.jad_dq, true);
                }
                jad_an(this.jad_cp, this.jad_bo, false);
                this.jad_dq.delete();
                this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_fq.jad_cp.jad_an));
            } catch (Throwable th) {
                jad_an(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void jad_jt() {
        while (this.jad_hu > this.jad_fs) {
            String key = this.jad_jw.entrySet().iterator().next().getKey();
            synchronized (this) {
                try {
                    jad_bo();
                    jad_dq jad_dqVar = this.jad_jw.get(key);
                    if (jad_dqVar != null && jad_dqVar.jad_fs == null) {
                        for (int i = 0; i < this.jad_jt; i++) {
                            File jad_an = jad_dqVar.jad_an(i);
                            if (jad_an.exists() && !jad_an.delete()) {
                                throw new IOException("failed to delete " + jad_an);
                            }
                            long j = this.jad_hu;
                            long[] jArr = jad_dqVar.jad_bo;
                            this.jad_hu = j - jArr[i];
                            jArr[i] = 0;
                        }
                        this.jad_kx++;
                        this.jad_iv.append((CharSequence) "REMOVE");
                        this.jad_iv.append(TokenParser.SP);
                        this.jad_iv.append((CharSequence) key);
                        this.jad_iv.append('\n');
                        this.jad_jw.remove(key);
                        if (jad_cp()) {
                            this.jad_mz.submit(this.jad_na);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void jad_an(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final void jad_bo() {
        if (this.jad_iv == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void jad_cp(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.jad_jw.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        jad_dq jad_dqVar = this.jad_jw.get(substring);
        if (jad_dqVar == null) {
            jad_dqVar = new jad_dq(substring);
            this.jad_jw.put(substring, jad_dqVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            jad_dqVar.jad_er = true;
            jad_dqVar.jad_fs = null;
            if (split.length != jad_an.this.jad_jt) {
                StringBuilder jad_an = jad_ly.jad_an("unexpected journal line: ");
                jad_an.append(Arrays.toString(split));
                throw new IOException(jad_an.toString());
            }
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    jad_dqVar.jad_bo[i2] = Long.parseLong(split[i2]);
                } catch (NumberFormatException unused) {
                    StringBuilder jad_an2 = jad_ly.jad_an("unexpected journal line: ");
                    jad_an2.append(Arrays.toString(split));
                    throw new IOException(jad_an2.toString());
                }
            }
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            jad_dqVar.jad_fs = new jad_cp(jad_dqVar);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public static void jad_an(File file, File file2, boolean z) {
        if (z) {
            jad_an(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void jad_bo(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @TargetApi(26)
    public static void jad_an(Writer writer) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized jad_er jad_bo(String str) {
        jad_bo();
        jad_dq jad_dqVar = this.jad_jw.get(str);
        if (jad_dqVar == null) {
            return null;
        }
        if (!jad_dqVar.jad_er) {
            return null;
        }
        for (File file : jad_dqVar.jad_cp) {
            if (!file.exists()) {
                return null;
            }
        }
        this.jad_kx++;
        this.jad_iv.append((CharSequence) "READ");
        this.jad_iv.append(TokenParser.SP);
        this.jad_iv.append((CharSequence) str);
        this.jad_iv.append('\n');
        if (jad_cp()) {
            this.jad_mz.submit(this.jad_na);
        }
        return new jad_er(this, str, jad_dqVar.jad_jt, jad_dqVar.jad_cp, jad_dqVar.jad_bo);
    }

    public static void jad_an(jad_an jad_anVar, jad_cp jad_cpVar, boolean z) {
        synchronized (jad_anVar) {
            jad_dq jad_dqVar = jad_cpVar.jad_an;
            if (jad_dqVar.jad_fs != jad_cpVar) {
                throw new IllegalStateException();
            }
            if (z && !jad_dqVar.jad_er) {
                for (int i = 0; i < jad_anVar.jad_jt; i++) {
                    if (!jad_cpVar.jad_bo[i]) {
                        jad_cpVar.jad_an();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!jad_dqVar.jad_bo(i).exists()) {
                        jad_cpVar.jad_an();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < jad_anVar.jad_jt; i2++) {
                File jad_bo2 = jad_dqVar.jad_bo(i2);
                if (!z) {
                    jad_an(jad_bo2);
                } else if (jad_bo2.exists()) {
                    File jad_an = jad_dqVar.jad_an(i2);
                    jad_bo2.renameTo(jad_an);
                    long j = jad_dqVar.jad_bo[i2];
                    long length = jad_an.length();
                    jad_dqVar.jad_bo[i2] = length;
                    jad_anVar.jad_hu = (jad_anVar.jad_hu - j) + length;
                }
            }
            jad_anVar.jad_kx++;
            jad_dqVar.jad_fs = null;
            if (jad_dqVar.jad_er | z) {
                jad_dqVar.jad_er = true;
                jad_anVar.jad_iv.append((CharSequence) "CLEAN");
                jad_anVar.jad_iv.append(TokenParser.SP);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an());
                jad_anVar.jad_iv.append('\n');
                if (z) {
                    long j2 = jad_anVar.jad_ly;
                    jad_anVar.jad_ly = 1 + j2;
                    jad_dqVar.jad_jt = j2;
                }
            } else {
                jad_anVar.jad_jw.remove(jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) "REMOVE");
                jad_anVar.jad_iv.append(TokenParser.SP);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append('\n');
            }
            jad_bo(jad_anVar.jad_iv);
            if (jad_anVar.jad_hu > jad_anVar.jad_fs || jad_anVar.jad_cp()) {
                jad_anVar.jad_mz.submit(jad_anVar.jad_na);
            }
        }
    }

    public jad_cp jad_an(String str) {
        synchronized (this) {
            try {
                jad_bo();
                jad_dq jad_dqVar = this.jad_jw.get(str);
                if (jad_dqVar == null) {
                    jad_dqVar = new jad_dq(str);
                    this.jad_jw.put(str, jad_dqVar);
                } else if (jad_dqVar.jad_fs != null) {
                    return null;
                }
                jad_cp jad_cpVar = new jad_cp(jad_dqVar);
                jad_dqVar.jad_fs = jad_cpVar;
                this.jad_iv.append((CharSequence) "DIRTY");
                this.jad_iv.append(TokenParser.SP);
                this.jad_iv.append((CharSequence) str);
                this.jad_iv.append('\n');
                jad_bo(this.jad_iv);
                return jad_cpVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
