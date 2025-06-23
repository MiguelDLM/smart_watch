package com.baidu.navcore.tts;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.IBNTTSManager;
import com.baidu.navisdk.adapter.struct.BNTTsInitConfig;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.tts.BNTTS;
import com.baidu.navisdk.tts.BNTTSPlayer;
import com.baidu.navisdk.tts.BNTTSUtils;
import com.baidu.navisdk.tts.ITTSInitListener;
import com.baidu.navisdk.tts.OnTTSStateChangedListener;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class BaseTTSPlayer implements IBNTTSManager {
    private static volatile BaseTTSPlayer o;
    private Handler g;
    private boolean i;
    private boolean j;
    private a k;
    private Method l;

    /* renamed from: a, reason: collision with root package name */
    private final ConditionVariable f6466a = new ConditionVariable();
    private b b = null;
    private b c = null;
    private b d = null;
    private b e = null;
    private b f = null;
    private int h = -99;
    private IBNTTSPlayerListener m = null;
    private IBNTTSManager.IOnTTSPlayStateChangedListener n = null;

    public static BaseTTSPlayer j() {
        if (o == null) {
            synchronized (BaseTTSPlayer.class) {
                try {
                    if (o == null) {
                        o = new BaseTTSPlayer();
                    }
                } finally {
                }
            }
        }
        return o;
    }

    private void k() {
        IBNTTSPlayerListener iBNTTSPlayerListener = this.m;
        if (iBNTTSPlayerListener != null) {
            TTSPlayerControl.setTTSPlayerListener(iBNTTSPlayerListener);
        } else {
            TTSPlayerControl.setTTSPlayerListener(new IBNTTSPlayerListener() { // from class: com.baidu.navcore.tts.BaseTTSPlayer.5
                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int cancelAudio() {
                    return -1;
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int getCurrentVolume() {
                    return BaseTTSPlayer.j().a();
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int getTTSState() {
                    return BaseTTSPlayer.j().d();
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public boolean hasInitialized() {
                    if (BaseTTSPlayer.j().b() == 2) {
                        return true;
                    }
                    return false;
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void initTTSPlayer() {
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void pauseTTS() {
                    BaseTTSPlayer.j().f();
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void phoneCalling() {
                    BaseTTSPlayer.j().i();
                    BaseTTSPlayer.j().h();
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void phoneHangUp() {
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int playAudio(String str, IBNTTSPlayerListener.a aVar) {
                    return -1;
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int playTTSText(int i, String str, String str2, int i2, String str3, String str4, boolean z) {
                    boolean z2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("tts -- playTTSText = ");
                    sb.append(str);
                    sb.append(", bPreempt = ");
                    boolean z3 = false;
                    if (i2 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sb.append(z2);
                    LogUtil.out("BaseTTSPlayer", sb.toString());
                    BaseTTSPlayer j = BaseTTSPlayer.j();
                    if (i2 == 1) {
                        z3 = true;
                    }
                    return j.a(str, str2, str3, z3);
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public int playXDTTSText(int i, String str, String str2, int i2, String str3, String str4) {
                    boolean z;
                    StringBuilder sb = new StringBuilder();
                    sb.append("tts -- playTTSText = ");
                    sb.append(str);
                    sb.append(", bPreempt = ");
                    boolean z2 = false;
                    if (i2 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    LogUtil.out("BaseTTSPlayer", sb.toString());
                    BaseTTSPlayer j = BaseTTSPlayer.j();
                    if (i2 == 1) {
                        z2 = true;
                    }
                    return j.a(str, str2, str3, z2);
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void releaseTTSPlayer() {
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void resumeTTS() {
                    if (!com.baidu.navisdk.module.init.a.a()) {
                        LogUtil.out("BaseTTSPlayer", "resumeTTS --> init is failed.");
                    } else {
                        BaseTTSPlayer.j().g();
                        JNIGuidanceControl.getInstance().setTTSPlayEnd();
                    }
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void setEnableTimeOut(boolean z) {
                    BaseTTSPlayer.j().a(z);
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void setTTSVolume(int i) {
                    LogUtil.out("BaseTTSPlayer", "setTTSVolume: " + i);
                    BaseTTSPlayer.j().a(i);
                }

                @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
                public void stopTTS() {
                    BaseTTSPlayer.j().i();
                }
            });
        }
        TTSPlayerControl.init();
    }

    private void l() {
        try {
            Method declaredMethod = BNTTSPlayer.class.getDeclaredMethod("playTTSText", String.class, String.class, Boolean.TYPE);
            this.l = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m() {
    }

    public synchronized int d() {
        int i;
        this.h = -99;
        this.g.post(new Runnable() { // from class: com.baidu.navcore.tts.BaseTTSPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                BaseTTSPlayer.this.h = BNTTS.getTTSState();
                BaseTTSPlayer.this.f6466a.open();
            }
        });
        this.f6466a.block(1000L);
        this.f6466a.close();
        i = this.h;
        if (i == -99) {
            i = 0;
        }
        return i;
    }

    public boolean e() {
        return this.j;
    }

    public void f() {
        this.i = true;
        BNTTS.pauseTTS();
    }

    public void g() {
        this.i = false;
        BNTTS.resumeTTS();
    }

    public void h() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
        b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.b();
        }
        b bVar3 = this.d;
        if (bVar3 != null) {
            bVar3.b();
        }
        b bVar4 = this.e;
        if (bVar4 != null) {
            bVar4.b();
        }
        b bVar5 = this.f;
        if (bVar5 != null) {
            bVar5.b();
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void i() {
        BNTTS.stopTTS();
    }

    @Override // com.baidu.navisdk.adapter.IBNTTSManager
    public void initTTS(BNTTsInitConfig bNTTsInitConfig) {
        HandlerThread handlerThread = new HandlerThread("BNTTSPlayer");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
        a(bNTTsInitConfig.context);
        try {
            a(bNTTsInitConfig);
        } catch (Throwable th) {
            LogUtil.out("BaseTTSPlayer", th.getMessage());
        }
    }

    @Override // com.baidu.navisdk.adapter.IBNTTSManager
    public void setOnTTSStateChangedListener(IBNTTSManager.IOnTTSPlayStateChangedListener iOnTTSPlayStateChangedListener) {
        this.n = iOnTTSPlayStateChangedListener;
    }

    @Override // com.baidu.navisdk.adapter.IBNTTSManager
    public void setRemovePolyphonicPinyin(boolean z) {
        this.j = z;
    }

    public int b() {
        return BNTTS.getInitState();
    }

    public IBNTTSPlayerListener c() {
        return this.m;
    }

    private void a(final BNTTsInitConfig bNTTsInitConfig) {
        BNTTS.setTTSLogEnable(LogUtil.OUT_LOGGABLE);
        BNTTS.init(bNTTsInitConfig.context, bNTTsInitConfig.appKey, bNTTsInitConfig.secretKey, bNTTsInitConfig.authsn, new ITTSInitListener() { // from class: com.baidu.navcore.tts.BaseTTSPlayer.1
            @Override // com.baidu.navisdk.tts.ITTSInitListener
            public void onFail(int i) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("4.0.20.1684", "0", String.valueOf(i));
                ITTSInitListener iTTSInitListener = bNTTsInitConfig.initListener;
                if (iTTSInitListener != null) {
                    iTTSInitListener.onFail(i);
                }
            }

            @Override // com.baidu.navisdk.tts.ITTSInitListener
            public void onSuccess() {
                com.baidu.navisdk.util.statistic.userop.b.r().d("4.0.20.1684", "1");
                ITTSInitListener iTTSInitListener = bNTTsInitConfig.initListener;
                if (iTTSInitListener != null) {
                    iTTSInitListener.onSuccess();
                }
            }
        });
        l();
        BNTTS.setOnTTSStateChangedListener(new OnTTSStateChangedListener() { // from class: com.baidu.navcore.tts.BaseTTSPlayer.2
            @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
            public void onPlayEnd(String str) {
                TTSPlayerControl.setTTSPlayStatus(false);
                ArrayList<TTSPlayerControl.e> tTSPlayStateListener = TTSPlayerControl.getTTSPlayStateListener();
                if (tTSPlayStateListener != null && tTSPlayStateListener.size() > 0) {
                    Iterator it = new ArrayList(tTSPlayStateListener).iterator();
                    while (it.hasNext()) {
                        ((TTSPlayerControl.e) it.next()).onPlayEnd(str);
                    }
                }
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                if (a2 != null) {
                    BNTTSUtils.releaseAudioFocus(a2);
                }
                if (BaseTTSPlayer.this.n != null) {
                    BaseTTSPlayer.this.n.onPlayEnd(str);
                }
            }

            @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
            public void onPlayError(int i, String str) {
                TTSPlayerControl.setTTSPlayStatus(false);
                if (BaseTTSPlayer.this.n != null) {
                    BaseTTSPlayer.this.n.onPlayError(i, str);
                }
            }

            @Override // com.baidu.navisdk.tts.OnTTSStateChangedListener
            public void onPlayStart() {
                TTSPlayerControl.setTTSPlayStatus(true);
                ArrayList<TTSPlayerControl.e> tTSPlayStateListener = TTSPlayerControl.getTTSPlayStateListener();
                if (tTSPlayStateListener != null && tTSPlayStateListener.size() > 0) {
                    Iterator it = new ArrayList(tTSPlayStateListener).iterator();
                    while (it.hasNext()) {
                        ((TTSPlayerControl.e) it.next()).a("1234556");
                    }
                }
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                if (a2 != null) {
                    if (BNSettingManager.getPlayTTsVoiceMode() == 1) {
                        BNTTSUtils.requestAudioFocusToStopMusic(a2);
                    } else {
                        BNTTSUtils.requestAudioFocus(a2);
                    }
                }
                if (BaseTTSPlayer.this.n != null) {
                    BaseTTSPlayer.this.n.onPlayStart();
                }
            }
        });
        k();
    }

    @Override // com.baidu.navisdk.adapter.IBNTTSManager
    public void initTTS(IBNTTSManager.IBNOuterTTSPlayerCallback iBNOuterTTSPlayerCallback) {
        this.m = iBNOuterTTSPlayerCallback;
        k();
    }

    private void a(Context context) {
        this.b = new b(context, R.raw.ding);
        this.c = new b(context, R.raw.dididi);
        this.d = new b(context, R.raw.cruiser_pass);
        this.e = new b(context, R.raw.overspeed);
        this.f = new b(context, R.raw.multi_route);
        a aVar = new a();
        this.k = aVar;
        aVar.a(context);
    }

    public int a(String str, final String str2, final String str3, final boolean z) {
        if (BNSettingManager.getVoiceMode() == 2 && com.baidu.navisdk.ui.routeguide.b.W()) {
            return 0;
        }
        if (b() == 0) {
            LogUtil.out("BaseTTSPlayer", "tts not init");
            return 0;
        }
        if (str != null && str.length() != 0) {
            if (!this.i) {
                if (str.startsWith("叮")) {
                    b bVar = this.b;
                    if (bVar != null) {
                        bVar.a();
                    }
                    m();
                    return 1;
                }
                if (str.startsWith("嗒嗒嗒")) {
                    b bVar2 = this.d;
                    if (bVar2 != null) {
                        bVar2.a();
                    }
                    m();
                    return 1;
                }
                if (str.startsWith("嘀嘀嘀")) {
                    b bVar3 = this.c;
                    if (bVar3 != null) {
                        bVar3.a();
                    }
                    str = str.substring(3);
                    if (TextUtils.isEmpty(str)) {
                        m();
                        return 1;
                    }
                } else {
                    if (str.startsWith("当当")) {
                        b bVar4 = this.e;
                        if (bVar4 != null) {
                            bVar4.a();
                        }
                        m();
                        return 1;
                    }
                    if (str.startsWith("嘀咕")) {
                        b bVar5 = this.f;
                        if (bVar5 != null) {
                            bVar5.a();
                        }
                        m();
                        return 1;
                    }
                    if (this.k != null && !TextUtils.isEmpty(str)) {
                        str = this.k.a(str);
                        if (TextUtils.isEmpty(str)) {
                            m();
                            return 1;
                        }
                    }
                }
                final String str4 = str;
                com.baidu.navisdk.framework.interfaces.pronavi.b h = c.p().h();
                boolean x02 = h != null ? h.x0() : false;
                if (BNCommSettingManager.getInstance().getVoiceMode() == 3 && x02) {
                    return 0;
                }
                this.g.postDelayed(new Runnable() { // from class: com.baidu.navcore.tts.BaseTTSPlayer.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtil.out("BaseTTSPlayer", "playTTSText > " + str4);
                        try {
                            BaseTTSPlayer.this.l.invoke(BNTTSPlayer.getInstance(), str4, str3, Boolean.valueOf(z));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        TTSPlayerControl.setTTSTextPlayResult(str2);
                    }
                }, 200L);
                return 0;
            }
            LogUtil.out("BaseTTSPlayer", " BaseTTSPlayer playTTSText bStopVoiceOutput " + this.i);
        }
        return 0;
    }

    public void a(boolean z) {
        BNTTS.setEnableTimeOut(z);
    }

    public int a() {
        return BNTTS.getCurrentVolume();
    }

    public void a(int i) {
        if (i > 15) {
            i = 15;
        }
        if (i < 0) {
            i = 0;
        }
        BNTTS.setCurrentVolume(i);
    }
}
