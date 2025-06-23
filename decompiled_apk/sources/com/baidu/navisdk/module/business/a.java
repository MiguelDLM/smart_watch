package com.baidu.navisdk.module.business;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.android.exoplayer2.C;

/* loaded from: classes7.dex */
public class a {
    private static final String c = "a";
    private static a d;
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f7051a;
    private final com.baidu.navisdk.util.worker.loop.a b;

    /* renamed from: com.baidu.navisdk.module.business.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0230a implements IBNTTSPlayerListener.a {
        public C0230a(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            Object obj;
            Object obj2;
            int i = message.what;
            if (100 == i && (obj2 = message.obj) != null && (obj2 instanceof String)) {
                if (message.arg1 != 2 || com.baidu.navisdk.framework.b.J()) {
                    a.this.a((String) message.obj);
                    return;
                } else {
                    LogUtil.e(a.c, "handleMessage()1 return for background.");
                    return;
                }
            }
            if (101 == i && (obj = message.obj) != null && (obj instanceof String)) {
                if (message.arg1 != 2 || com.baidu.navisdk.framework.b.J()) {
                    a.this.a((String) message.obj, message.arg1);
                    return;
                } else {
                    LogUtil.e(a.c, "handleMessage()2 return for background.");
                    return;
                }
            }
            if (102 == i) {
                a.this.f7051a = false;
                a.this.a();
            } else if (5556 == i) {
                int i2 = message.arg1;
                if (i2 == 1 || i2 == 2) {
                    a.this.a();
                }
            }
        }
    }

    private a() {
        b bVar = new b("BAPM");
        this.b = bVar;
        com.baidu.navisdk.util.listener.a.a(bVar);
    }

    public static a e() {
        if (d == null) {
            synchronized (e) {
                try {
                    if (d == null) {
                        d = new a();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public void b() {
        if (!TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().t) && !TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().u)) {
            a(com.baidu.navisdk.module.a.h().a().u, 3);
            LogUtil.e(c, "playContentWhenShowActivity() play audio");
        } else if (!TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().s)) {
            a(com.baidu.navisdk.module.a.h().a().s);
            LogUtil.e(c, "playContentWhenShowActivity() play text");
        }
    }

    public void c() {
        if (!TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().f) && !TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().g)) {
            Message obtainMessage = this.b.obtainMessage(101);
            obtainMessage.arg1 = 1;
            obtainMessage.obj = com.baidu.navisdk.module.a.h().a().g;
            this.b.sendMessageDelayed(obtainMessage, 1200L);
            LogUtil.e(c, "playNaviStartContent() play audio");
            return;
        }
        if (!TextUtils.isEmpty(com.baidu.navisdk.module.a.h().a().e)) {
            Message obtainMessage2 = this.b.obtainMessage(100);
            obtainMessage2.obj = com.baidu.navisdk.module.a.h().a().e;
            this.b.sendMessageDelayed(obtainMessage2, 1200L);
            LogUtil.e(c, "playNaviStartContent() play text");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        a();
        if (TTSPlayerControl.getTTSState() == 1) {
            String str2 = c;
            LogUtil.e(str2, "playAudio() audio play true 1");
            try {
                TTSPlayerControl.stopVoiceTTSOutput();
                TTSPlayerControl.playAudio(str, new C0230a(this));
                LogUtil.e(str2, "playAudio() audio play true 2");
                if (this.b.hasMessages(102)) {
                    this.b.removeMessages(102);
                }
                this.b.sendEmptyMessageDelayed(102, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Message obtainMessage = this.b.obtainMessage(101);
        obtainMessage.arg1 = i;
        obtainMessage.obj = str;
        this.b.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void a() {
        LogUtil.e(c, "cancelPlayAudio");
        if (this.b.hasMessages(102)) {
            this.b.removeMessages(102);
        }
        TTSPlayerControl.cancelAudio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TTSPlayerControl.getTTSState() == 1) {
            TTSPlayerControl.playTTS(str, 0);
            return;
        }
        Message obtainMessage = this.b.obtainMessage(100);
        obtainMessage.obj = str;
        this.b.sendMessageDelayed(obtainMessage, 1000L);
    }
}
