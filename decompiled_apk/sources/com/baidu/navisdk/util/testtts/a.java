package com.baidu.navisdk.util.testtts;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a {
    public static final String j = "a";
    private static a k;
    private static Object l = new Object();
    public static final String[] m = {"tts_const.txt", "tts_var.txt", "tts_var_poi.txt", "tts_var_road.txt", "tts_var_dist.txt"};

    /* renamed from: a, reason: collision with root package name */
    private boolean f9390a = false;
    private boolean b = false;
    private List<String> c = new ArrayList();
    private List<String> d = new ArrayList();
    private List<String> e = new ArrayList();
    private List<String> f = new ArrayList();
    private List<String> g = new ArrayList();
    private List<String> h = new ArrayList();
    private Handler i = new HandlerC0510a("TTSTC");

    /* renamed from: com.baidu.navisdk.util.testtts.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0510a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0510a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i;
            a.a("what=" + message.what + ", arg1=" + message.arg1 + ", stop=" + a.this.b);
            if (a.this.b) {
                return;
            }
            if (1 == TTSPlayerControl.getTTSState()) {
                int i2 = message.what;
                if (100 == i2) {
                    int i3 = message.arg1;
                    if (i3 >= 0 && i3 < a.this.h.size()) {
                        TTSPlayerControl.playTTS((String) a.this.h.get(message.arg1), 1);
                        a.a("play=" + ((String) a.this.h.get(message.arg1)));
                        if (message.arg1 + 1 < a.this.h.size()) {
                            Message obtainMessage = a.this.i.obtainMessage(100);
                            obtainMessage.what = 100;
                            obtainMessage.arg1 = message.arg1 + 1;
                            a.this.i.sendMessageDelayed(obtainMessage, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 == 0 && (i = message.arg1) >= 0 && i < a.this.c.size()) {
                    TTSPlayerControl.playTTS((String) a.this.c.get(message.arg1), 1);
                    if (message.arg1 + 1 < a.this.c.size()) {
                        Message obtainMessage2 = a.this.i.obtainMessage(0);
                        obtainMessage2.what = 0;
                        obtainMessage2.arg1 = message.arg1 + 1;
                        a.this.i.sendMessageDelayed(obtainMessage2, 1000L);
                        return;
                    }
                    Message obtainMessage3 = a.this.i.obtainMessage(1);
                    obtainMessage3.what = 1;
                    obtainMessage3.arg1 = 0;
                    a.this.i.sendMessageDelayed(obtainMessage3, 1000L);
                    return;
                }
                return;
            }
            Message obtainMessage4 = a.this.i.obtainMessage(message.what);
            obtainMessage4.what = message.what;
            obtainMessage4.arg1 = message.arg1;
            a.this.i.sendMessageDelayed(obtainMessage4, 1000L);
        }
    }

    private a() {
    }

    private static void e() {
        File file = new File(m0.j().c() + "/log/tts");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private boolean f() {
        int i = 0;
        while (true) {
            String[] strArr = m;
            if (i < strArr.length) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(m0.j().c() + "/log/tts" + File.separator + strArr[i]);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        a("loadTXT=" + readLine);
                        a(i, readLine);
                    }
                    fileInputStream.close();
                    bufferedReader.close();
                    a("success to load txt file. txt=" + m[i]);
                    i++;
                } catch (Exception unused) {
                    a("failed to load txt file. txt=" + m[i]);
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    private void g() {
        Message obtainMessage = this.i.obtainMessage(100);
        obtainMessage.what = 100;
        obtainMessage.arg1 = 0;
        this.i.sendMessageDelayed(obtainMessage, 1000L);
    }

    private boolean c() {
        this.h.clear();
        this.h.addAll(this.c);
        for (int i = 0; i < this.d.size(); i++) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    for (int i4 = 0; i4 < this.g.size(); i4++) {
                        String replaceAll = this.d.get(i).replaceAll("poi", this.e.get(i2)).replaceAll("road", this.f.get(i3)).replaceAll("dist", this.g.get(i4));
                        if (!this.h.contains(replaceAll)) {
                            a("generatePlayTexts() newS=" + replaceAll);
                            this.h.add(replaceAll);
                        }
                    }
                }
            }
        }
        this.h.add("tts测试模式已经完成");
        return true;
    }

    public static a d() {
        if (k == null) {
            synchronized (l) {
                try {
                    if (k == null) {
                        k = new a();
                    }
                } finally {
                }
            }
        }
        return k;
    }

    public void a() {
        if (this.f9390a) {
            return;
        }
        e();
        boolean f = f();
        this.f9390a = f;
        this.f9390a = f & c();
    }

    public boolean b() {
        if (!this.f9390a) {
            return false;
        }
        this.b = false;
        g();
        return true;
    }

    private void a(int i, String str) {
        if (i < 0 || i > 4 || str == null || str.length() == 0) {
            return;
        }
        if (i == 0) {
            this.c.add(str);
            return;
        }
        if (i == 1) {
            this.d.add(str);
            return;
        }
        if (i == 2) {
            this.e.add(str);
        } else if (i == 3) {
            this.f.add(str);
        } else {
            if (i != 4) {
                return;
            }
            this.g.add(str);
        }
    }

    public static void a(String str) {
        LogUtil.e(j, str);
    }
}
