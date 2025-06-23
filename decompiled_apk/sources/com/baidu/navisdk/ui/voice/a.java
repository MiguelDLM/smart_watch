package com.baidu.navisdk.ui.voice;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.y;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f9208a = new a();

    /* renamed from: com.baidu.navisdk.ui.voice.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0491a extends com.baidu.navisdk.util.worker.loop.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9209a;

        public HandlerC0491a(String str) {
            this.f9209a = str;
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i == 4) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BNVoiceAutoDownload", "taskId download success!");
                    }
                    a.this.b(this.f9209a);
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNVoiceAutoDownload", "taskId download failed!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        VoiceInterfaceImplProxy o;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVoiceAutoDownload", "handleVoiceDownloadSuccess" + str);
        }
        if (str.equals(f.c().c.V) && (o = c.p().o()) != null) {
            o.setLowPerfVoicePath(o.getVoiceSetPath(str, true));
        }
    }

    private boolean c(String str) {
        boolean z;
        VoiceInterfaceImplProxy o = c.p().o();
        if (o != null) {
            z = o.isTaskDownloadFinish(str);
        } else {
            z = false;
        }
        boolean e = y.e(com.baidu.navisdk.framework.a.c().a());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVoiceAutoDownload", "isSatisfy isExist" + z + ", isWifiConnected = " + e);
        }
        if (z || !e) {
            return false;
        }
        return true;
    }

    private void d(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVoiceAutoDownload", "startDownload() ID = " + str);
        }
        VoiceInterfaceImplProxy o = c.p().o();
        if (o != null) {
            o.registDownloadCallback(new HandlerC0491a(str));
            o.downloadVoice(str);
        }
    }

    public boolean a(String str) {
        VoiceInterfaceImplProxy o = c.p().o();
        if (o == null) {
            return false;
        }
        String currentVoice = o.getCurrentVoice();
        boolean isTaskDownloadFinish = o.isTaskDownloadFinish(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVoiceAutoDownload", "getVoiceName， ttsId=" + currentVoice + ", isExist=" + isTaskDownloadFinish);
        }
        if (!isTaskDownloadFinish) {
            a();
        }
        if (currentVoice != null && !"putonghua99".equals(currentVoice)) {
            return false;
        }
        int a2 = com.baidu.navisdk.module.cloudconfig.a.b().a("device_perf_level", -1);
        int i = f.c().c.W;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNVoiceAutoDownload", "checkAndDownload()" + str + ", level=" + a2 + ",maxLevel=" + i);
        }
        if (a2 == -1 || a2 > i || TextUtils.isEmpty(str)) {
            a();
            return false;
        }
        if (isTaskDownloadFinish) {
            b(str);
            return true;
        }
        boolean c = c(str);
        if (c) {
            d(str);
        }
        return c;
    }

    private void a() {
        VoiceInterfaceImplProxy o = c.p().o();
        if (o != null) {
            o.setLowPerfVoicePath("");
        }
    }
}
