package com.baidu.navisdk.util.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes8.dex */
public class i0 {
    private static i0 c;

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f9232a;
    private Handler b;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BufferedWriter bufferedWriter;
            if (message.what == 1) {
                int i = message.arg1;
                BufferedWriter bufferedWriter2 = null;
                try {
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(i0.this.a("error_code.txt"), true));
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bufferedWriter.write(i0.this.b(i));
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter2 = bufferedWriter;
                        LogUtil.e("SDKDebugUtil", "e:" + e.getMessage());
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    private i0() {
        HandlerThread handlerThread = new HandlerThread("sdkDebug");
        this.f9232a = handlerThread;
        this.b = null;
        if (!handlerThread.isAlive()) {
            this.f9232a.start();
        }
        this.b = new a(this.f9232a.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        return new SimpleDateFormat("yyyyMMdd_HH:mm:ss_").format(new Date()) + String.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(String str) {
        File file = new File(m0.j().b() + "/" + str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static i0 a() {
        if (c == null) {
            synchronized (i0.class) {
                try {
                    if (c == null) {
                        c = new i0();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(int i) {
        Handler handler = this.b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(1);
            obtainMessage.arg1 = i;
            obtainMessage.sendToTarget();
        }
    }
}
