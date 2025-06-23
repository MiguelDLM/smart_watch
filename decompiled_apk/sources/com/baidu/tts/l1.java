package com.baidu.tts;

import XIXIX.OOXIXo;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.FileUtil;
import com.baidu.tts.tools.PropUtil;
import com.baidu.tts.tools.ResourceTools;
import com.realsil.sdk.dfu.DfuConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class l1 {
    public static volatile l1 n;

    /* renamed from: a, reason: collision with root package name */
    public SpeechDecoder f10126a;
    public p i;
    public Thread l;
    public String b = null;
    public x4 c = null;
    public LinkedBlockingQueue<x4> d = new LinkedBlockingQueue<>();
    public volatile int e = 0;
    public volatile boolean f = true;
    public Object g = new Object();
    public b h = null;
    public volatile boolean j = false;
    public Semaphore k = new Semaphore(0);
    public volatile boolean m = false;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int a2;
            l1 l1Var;
            x4 x4Var;
            LoggerProxy.i("StreamDecoder", "stream decoder thread begin runs.");
            while (!l1.this.j) {
                try {
                    l1 l1Var2 = l1.this;
                    l1Var2.c = l1Var2.d.poll(1L, TimeUnit.SECONDS);
                    x4 x4Var2 = l1.this.c;
                    if (x4Var2 != null) {
                        String str = x4Var2.d;
                        if (str != null && !str.isEmpty()) {
                            String str2 = l1.this.b;
                            try {
                                if (str2 != null && str2.equalsIgnoreCase(str)) {
                                    l1 l1Var3 = l1.this;
                                    l1Var3.h.a(l1Var3.c);
                                    LoggerProxy.d("StreamDecoder", "+++ decode sn=" + str + ", " + l1.this.h.a());
                                    l1 l1Var4 = l1.this;
                                    b bVar = l1Var4.h;
                                    x4 x4Var3 = l1Var4.c;
                                    a2 = bVar.a(x4Var3.g, x4Var3.e);
                                    if (a2 != 0 && a2 != 31415926) {
                                        c3 a3 = c3.a();
                                        x2 x2Var = x2.m;
                                        Throwable th = new Throwable("Audio decode failed.");
                                        TtsError a4 = a3.a(x2Var);
                                        a4.setThrowable(th);
                                        a4.setSN(l1.this.c.d);
                                        i2.a().a(a4, l1.this.c.d);
                                    }
                                    l1Var = l1.this;
                                    x4Var = l1Var.c;
                                    if (x4Var.e < 0 && a2 != 31415926 && x4Var.c == 0) {
                                        l1.a(l1Var);
                                    }
                                    LoggerProxy.d("StreamDecoder", "--- decode sn=" + str + ", ret=" + a2 + ", " + l1.this.h.b());
                                }
                                LoggerProxy.d("StreamDecoder", "+++ decode sn=" + str + ", " + l1.this.h.a());
                                l1 l1Var42 = l1.this;
                                b bVar2 = l1Var42.h;
                                x4 x4Var32 = l1Var42.c;
                                a2 = bVar2.a(x4Var32.g, x4Var32.e);
                                if (a2 != 0) {
                                    c3 a32 = c3.a();
                                    x2 x2Var2 = x2.m;
                                    Throwable th2 = new Throwable("Audio decode failed.");
                                    TtsError a42 = a32.a(x2Var2);
                                    a42.setThrowable(th2);
                                    a42.setSN(l1.this.c.d);
                                    i2.a().a(a42, l1.this.c.d);
                                }
                                l1Var = l1.this;
                                x4Var = l1Var.c;
                                if (x4Var.e < 0) {
                                    l1.a(l1Var);
                                }
                                LoggerProxy.d("StreamDecoder", "--- decode sn=" + str + ", ret=" + a2 + ", " + l1.this.h.b());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            synchronized (l1.this.g) {
                                try {
                                    if (l1.this.e > 0) {
                                        l1 l1Var5 = l1.this;
                                        l1Var5.e--;
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                    break;
                                }
                            }
                            l1 l1Var6 = l1.this;
                            l1Var6.h = new b(l1Var6.c);
                            SpeechDecoder.setOnDecodedDataListener(l1.this.h);
                            l1 l1Var7 = l1.this;
                            l1Var7.b = l1Var7.c.d;
                        }
                        LoggerProxy.d("StreamDecoder", "bag will drop for empty.");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            LoggerProxy.i("StreamDecoder", "notify thread exit+++");
            l1.this.k.release();
            LoggerProxy.i("StreamDecoder", "notify thread exit---");
            LoggerProxy.i("StreamDecoder", "stream decoder thread end runs.");
        }
    }

    public l1() {
        this.f10126a = null;
        this.l = null;
        this.f10126a = new SpeechDecoder();
        this.l = new Thread(new a());
    }

    public static l1 a() {
        if (n == null) {
            synchronized (c3.class) {
                try {
                    if (n == null) {
                        n = new l1();
                    }
                } finally {
                }
            }
        }
        return n;
    }

    public boolean b() {
        boolean z;
        synchronized (this.g) {
            if (this.e >= 5) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* loaded from: classes8.dex */
    public class b implements SpeechDecoder.OnDecodedDataListener {
        public byte[] b;
        public File i;

        /* renamed from: a, reason: collision with root package name */
        public double f10128a = OOXIXo.f3760XO;
        public int c = 1;
        public int d = 0;
        public int e = 0;
        public boolean f = false;
        public ArrayList g = new ArrayList();
        public FileOutputStream h = null;

        public b(x4 x4Var) {
            this.b = null;
            this.i = null;
            this.b = new byte[0];
            a(x4Var);
            LoggerProxy.d("StreamDecoder", "create new DCB");
            if (LoggerProxy.needPrint(2) && PropUtil.needSaveAudio()) {
                String str = ResourceTools.getAppExtDir() + "audio_dump/" + x4Var.b();
                FileUtil.createDir(str);
                this.i = new File(str);
                LoggerProxy.d("StreamDecoder", "AudioDumpDir: " + str);
            }
        }

        public String a() {
            byte[] bArr = l1.this.c.g;
            return "ChunkIndex=" + l1.this.c.e + ", audio_len=" + (bArr == null ? 0 : bArr.length) + ", playtime=" + this.f10128a + "ms, last_pcm_index=" + this.c + ", last_word_pos=" + this.e;
        }

        public String b() {
            return "ChunkIndex=" + l1.this.c.e + ", last_pcm_index=" + this.c + ", last_word_pos=" + this.e + ", output timestamp=" + Arrays.toString(this.g.toArray());
        }

        @Override // com.baidu.speechsynthesizer.utility.SpeechDecoder.OnDecodedDataListener
        public void onDecodedData(byte[] bArr) {
            x4 x4Var;
            int length;
            if (bArr != null && !this.f) {
                b bVar = l1.this.h;
                bVar.getClass();
                try {
                    FileOutputStream fileOutputStream = bVar.h;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.write(bArr);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    byte[] bArr2 = bVar.b;
                    length = bArr2.length + bArr.length;
                    byte[] bArr3 = new byte[length];
                    System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                    System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
                    bVar.b = bArr3;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (length >= 3200) {
                    x4 x4Var2 = l1.this.c;
                    int length2 = x4Var2.g.length;
                    int i = x4Var2.f;
                    double d = (length / 32000.0d) / ((length2 * 8) / x4Var2.l);
                    int i2 = (int) (bVar.d + (d * (i - r2) * bVar.c));
                    x4Var = x4Var2.a();
                    x4Var.g = bVar.b;
                    x4Var.b = 0;
                    x4Var.h = k2.PCM;
                    int i3 = bVar.c;
                    x4Var.f = i2;
                    bVar.c = i3 + 1;
                    bVar.b = new byte[0];
                } else {
                    if (bArr.length == 0) {
                        x4 x4Var3 = l1.this.c;
                        int i4 = x4Var3.f;
                        bVar.d = i4;
                        bVar.c = 1;
                        if (x4Var3.e < 0) {
                            bVar.d = 0;
                        }
                        if (length < 3200) {
                            x4Var = x4Var3.a();
                            x4Var.g = bVar.b;
                            x4Var.b = 0;
                            x4Var.h = k2.PCM;
                            x4Var.f = i4;
                            bVar.b = new byte[0];
                        }
                    }
                    x4Var = null;
                }
                if (x4Var != null) {
                    this.g.add(Long.valueOf(System.currentTimeMillis()));
                    if (l1.a(l1.this, x4Var) == 31415926) {
                        this.f = true;
                    }
                }
            }
        }

        public int a(byte[] bArr, int i) {
            x4 x4Var = l1.this.c;
            int i2 = 0;
            if (x4Var.h == k2.PCM) {
                if (x4Var.g != null) {
                    this.g.add(Long.valueOf(System.currentTimeMillis()));
                    if ((x4Var.e >= 0 || x4Var.b != 1) && (i2 = l1.a(l1.this, x4Var)) == 31415926) {
                        this.f = true;
                    }
                }
            } else if (bArr.length == 0) {
                onDecodedData(bArr);
            } else {
                try {
                    if (this.i != null) {
                        String str = this.i.getPath() + "/" + x4Var.e + ".pcm";
                        LoggerProxy.d("StreamDecoder", "create file " + str);
                        this.h = new FileOutputStream(str, true);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                i2 = l1.this.f10126a.decodeWithCallback(bArr, i);
                try {
                    FileOutputStream fileOutputStream = this.h;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        this.h = null;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            this.e = l1.this.c.f;
            if (this.f) {
                return 31415926;
            }
            return i2;
        }

        public void a(x4 x4Var) {
            byte[] bArr;
            this.f = false;
            this.g.clear();
            if (x4Var.h == k2.PCM) {
                return;
            }
            this.f10128a = (x4Var.k.f10176a == 0 || (bArr = x4Var.g) == null) ? OOXIXo.f3760XO : (bArr.length / x4Var.l) * ((r0 * 2) / DfuConstants.MAX_CONNECTION_LOCK_TIMEOUT) * 1000.0d;
        }
    }

    public static void a(l1 l1Var) {
        p pVar;
        synchronized (l1Var) {
            pVar = l1Var.i;
        }
        if (pVar != null) {
            x4 a2 = l1Var.c.a();
            a2.g = null;
            a2.f = l1Var.c.f;
            LoggerProxy.d("StreamDecoder", "send decode finish message.");
            l1Var.i.onSynthesizeFinished(a2);
            if (Thread.currentThread().isInterrupted()) {
                Thread.interrupted();
            }
        }
    }

    public int a(x4 x4Var) {
        if (this.j) {
            return -1;
        }
        try {
            boolean offer = this.d.offer(x4Var, 1L, TimeUnit.SECONDS);
            if (offer) {
                int i = x4Var.e;
                synchronized (this.g) {
                    try {
                        if (this.f) {
                            this.e++;
                            this.f = false;
                        }
                        if (i < 0) {
                            this.f = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                LoggerProxy.d("StreamDecoder", "new bag accepted sn=" + x4Var.d + ", index=" + x4Var.e);
            }
            return offer ? 0 : -3;
        } catch (InterruptedException unused) {
            return -2;
        }
    }

    public static int a(l1 l1Var, x4 x4Var) {
        p pVar;
        synchronized (l1Var) {
            pVar = l1Var.i;
        }
        if (pVar != null) {
            pVar.onSynthesizeDataArrived(x4Var);
            if (Thread.currentThread().isInterrupted()) {
                Thread.interrupted();
                return 31415926;
            }
        }
        return 0;
    }
}
