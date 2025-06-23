package com.baidu.ar;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class gj implements gg {
    private String mBaseUrl;
    private String mDirectory;
    private long mMaxSize;
    private File uA;
    private File uB;
    private long uC;
    private Writer uD;
    private int uE;
    private File uz;
    private boolean isDebug = false;
    private final LinkedHashMap<String, a> uF = new LinkedHashMap<>(0, 0.75f, true);
    final ThreadPoolExecutor uG = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> uH = new Callable<Void>() { // from class: com.baidu.ar.gj.1
        @Override // java.util.concurrent.Callable
        /* renamed from: eE, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (gj.this) {
                try {
                    if (gj.this.uD == null) {
                        return null;
                    }
                    gj.this.trimToSize();
                    if (gj.this.eC()) {
                        gj.this.eB();
                        gj.this.uE = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public static class a {
        String key;
        String uJ;
        String uK;
        long uL;
    }

    private void aR(String str) {
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
                this.uF.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        a aVar = this.uF.get(substring);
        if (aVar == null) {
            aVar = new a();
            this.uF.put(substring, aVar);
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        if (split.length == 3) {
            aVar.uL = Long.parseLong(split[0]);
            aVar.uK = split[1];
            aVar.uJ = split[2];
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private String aS(String str) {
        return kp.cp(str);
    }

    private static void c(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private void eA() {
        c(this.uA);
        Iterator<a> it = this.uF.values().iterator();
        while (it.hasNext()) {
            this.uC += it.next().uL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eB() {
        try {
            if (this.isDebug) {
                Log.d("OBRModule", "rebuild journal file");
            }
            Writer writer = this.uD;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.uA), go.UTF_8));
            try {
                bufferedWriter.write("baidu.ar.obr.cache");
                bufferedWriter.write("\n");
                for (a aVar : this.uF.values()) {
                    bufferedWriter.write("ADD " + aVar.key + TokenParser.SP + aVar.uL + TokenParser.SP + aVar.uK + TokenParser.SP + aVar.uJ + "\n");
                }
                bufferedWriter.close();
                if (this.uz.exists()) {
                    a(this.uz, this.uB, true);
                }
                a(this.uA, this.uz, false);
                this.uB.delete();
                this.uD = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.uz, true), go.UTF_8));
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eC() {
        int i = this.uE;
        return i >= 100 && i >= this.uF.size();
    }

    private void eD() {
        if (this.uD == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void ez() {
        gn gnVar = new gn(new FileInputStream(this.uz), go.UTF_8);
        try {
            try {
                String readLine = gnVar.readLine();
                if (!TextUtils.equals(readLine, "baidu.ar.obr.cache")) {
                    throw new IOException("unexpected journal header: [" + readLine + "]");
                }
                int i = 0;
                while (true) {
                    try {
                        aR(gnVar.readLine());
                        i++;
                    } catch (EOFException unused) {
                        this.uE = i - this.uF.size();
                        if (gnVar.eN()) {
                            eB();
                        } else {
                            this.uD = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.uz, true), go.UTF_8));
                        }
                        return;
                    }
                }
            } catch (Exception e) {
                throw new IOException(e);
            }
        } finally {
            go.closeQuietly(gnVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.uC > this.mMaxSize) {
            aO(this.uF.entrySet().iterator().next().getKey());
        }
    }

    @Override // com.baidu.ar.gg
    public boolean aL(String str) {
        return new File(this.mDirectory, str).exists();
    }

    @Override // com.baidu.ar.gg
    public boolean aM(String str) {
        a aVar = this.uF.get(aS(str));
        if (aVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long parseLong = Long.parseLong(aVar.uK) + 86400000;
        aVar.uK = String.valueOf(currentTimeMillis);
        return parseLong < currentTimeMillis;
    }

    @Override // com.baidu.ar.gg
    public void aN(String str) {
        String aS = aS(str);
        a aVar = this.uF.get(aS);
        if (aVar == null) {
            aVar = new a();
        }
        File file = new File(this.mDirectory, str);
        long j = aVar.uL;
        long length = file.length();
        this.uC = (this.uC - j) + length;
        aVar.uL = length;
        aVar.uK = String.valueOf(System.currentTimeMillis());
        aVar.key = aS;
        this.uF.put(aS, aVar);
        try {
            Writer writer = this.uD;
            if (writer != null) {
                writer.write("ADD " + aVar.key + TokenParser.SP + aVar.uL + TokenParser.SP + aVar.uK + TokenParser.SP + aVar.uJ + "\n");
                this.uD.flush();
                if (this.isDebug) {
                    Log.d("OBRModule", "OBRCache write ADD " + aVar.key + TokenParser.SP + aVar.uL + TokenParser.SP + aVar.uK + TokenParser.SP + aVar.uJ);
                }
            }
        } catch (IOException e) {
            if (this.isDebug) {
                Log.d("OBRModule", "OBRCache update info mistake : " + e.getMessage());
            }
        }
        this.uE++;
        if (this.uC <= this.mMaxSize || !eC()) {
            return;
        }
        this.uG.submit(this.uH);
    }

    @Override // com.baidu.ar.gg
    public boolean aO(String str) {
        eD();
        String aS = aS(str);
        a aVar = this.uF.get(aS);
        if (aVar == null) {
            return false;
        }
        File file = new File(this.mDirectory, str);
        if (file.exists() && !file.delete()) {
            if (this.isDebug) {
                Log.d("OBRModule", "failed to delete " + file);
            }
            return false;
        }
        this.uC -= aVar.uL;
        aVar.uL = 0L;
        this.uE++;
        this.uF.remove(aS);
        try {
            Writer writer = this.uD;
            if (writer != null) {
                writer.write("REMOVE " + aS + "\n");
                this.uD.flush();
                if (this.isDebug) {
                    Log.d("OBRModule", "OBRCache write REMOVE " + aS);
                }
            }
        } catch (IOException e) {
            if (this.isDebug) {
                Log.d("OBRModule", "OBRCache remove info mistake : " + e.getMessage());
            }
        }
        if (eC()) {
            this.uG.submit(this.uH);
        }
        return true;
    }

    @Override // com.baidu.ar.gg
    public boolean o(String str, String str2) {
        String aS = aS(str2);
        a aVar = this.uF.get(aS);
        if (aVar != null && !TextUtils.equals(aVar.uJ, "")) {
            if (TextUtils.equals(str, aVar.uJ)) {
                return false;
            }
            aVar.uJ = str;
            this.uF.put(aS, aVar);
        }
        return true;
    }

    @Override // com.baidu.ar.gg
    public void release() {
        Writer writer = this.uD;
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                if (this.isDebug) {
                    Log.d("OBRModule", "OBRCache close writer mistake : " + e.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.ar.gg
    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @Override // com.baidu.ar.gg
    public void a(String str, String str2, long j) {
        File file = new File(str2, "obr_journal.bkp");
        if (file.exists()) {
            File file2 = new File(str2, "obr_journal");
            if (file2.exists()) {
                file.delete();
            } else {
                a(file, file2, false);
            }
        }
        this.mBaseUrl = str;
        this.mDirectory = str2;
        this.mMaxSize = j;
        this.uz = new File(str2, "obr_journal");
        this.uA = new File(str2, "obr_journal.temp");
        this.uB = new File(str2, "obr_journal.bkp");
        if (this.uz.exists()) {
            ez();
            eA();
        } else {
            new File(str2).mkdirs();
            eB();
        }
    }
}
