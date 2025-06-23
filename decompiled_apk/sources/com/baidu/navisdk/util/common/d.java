package com.baidu.navisdk.util.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Message;
import android.provider.Settings;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;

/* loaded from: classes8.dex */
public class d {
    public static final String f = "d";
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f9223a;
    private Context b;
    private boolean c = false;
    private int d = 3;

    @SuppressLint({"HandlerLeak"})
    private final com.baidu.navisdk.util.worker.loop.a e = new a(f);

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            int i2 = message.what;
            boolean z = false;
            if (i2 != 5556) {
                switch (i2) {
                    case 1001:
                        LogUtil.e(d.f, "mHander MSG_TYPE_OPEN_BT_SCO");
                        return;
                    case 1002:
                        LogUtil.e(d.f, "mHander MSG_TYPE_CLOSE_BT_SCO");
                        return;
                    case 1003:
                        LogUtil.e(d.f, "mHander MSG_TYPE_REFRESH_BLUETOOTH_MODE");
                        int bluetoothChannelMode = BNCommSettingManager.getInstance().getBluetoothChannelMode();
                        if (bluetoothChannelMode != 0) {
                            com.baidu.navisdk.bluetooth.b.i().a(bluetoothChannelMode);
                            if (d.this.d > 0) {
                                sendEmptyMessageDelayed(1003, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                d.e(d.this);
                            }
                        }
                        try {
                            int streamVolume = ((AudioManager) d.this.b.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3);
                            com.baidu.navisdk.framework.interfaces.pronavi.n n = x.n();
                            if (n != null) {
                                if (streamVolume <= 0) {
                                    z = true;
                                }
                                n.a(z);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            LogUtil.e(d.f, "AudioUtil getStreamVolume Exception: " + e.getMessage());
                            return;
                        }
                    default:
                        return;
                }
            }
            if (i != 1) {
                if (i != 3) {
                    if (i == 4) {
                        LogUtil.e(d.f, "CALL_STATE_IDLE");
                        if (d.h) {
                            d.this.d = 3;
                            d.this.e.sendEmptyMessageDelayed(1003, 1000L);
                        }
                        if (BNCommSettingManager.getInstance().isPlayVoiceWhenCalling()) {
                            com.baidu.navisdk.framework.b.l(3);
                        }
                        d.h = false;
                        return;
                    }
                    return;
                }
                LogUtil.e(d.f, "CALL_STATE_OFFHOOK");
                d.h = true;
                if (d.g) {
                    d.this.e.removeMessages(1001);
                    d.this.e.removeMessages(1002);
                    if (d.this.f9223a != null && d.this.b != null && d.this.a()) {
                        d.i = true;
                    }
                    d.this.e.sendEmptyMessageDelayed(1002, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
                if (BNCommSettingManager.getInstance().isPlayVoiceWhenCalling()) {
                    com.baidu.navisdk.framework.b.l(0);
                    return;
                }
                return;
            }
            LogUtil.e(d.f, "CALL_STATE_RINGING");
            d.h = true;
            if (d.g) {
                d.this.e.removeMessages(1001);
                d.this.e.removeMessages(1002);
                d.this.e.removeMessages(1003);
                if (d.this.f9223a != null && d.this.b != null && d.this.a()) {
                    d.i = true;
                }
                d.this.e.sendEmptyMessage(1002);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    }

    static {
        new b();
    }

    public d(Context context) {
        a(context);
    }

    public static /* synthetic */ int e(d dVar) {
        int i2 = dVar.d;
        dVar.d = i2 - 1;
        return i2;
    }

    public static AudioManager b(Context context) {
        return (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static int c(Context context) {
        if (context != null) {
            try {
                return b(context).getStreamVolume(3);
            } catch (Exception unused) {
            }
        }
        return 11;
    }

    public static boolean d() {
        if (!a0.l()) {
            return false;
        }
        try {
            return Settings.System.getInt(com.baidu.navisdk.framework.a.c().a().getContentResolver(), "volume_panel_mute_enable") == 1;
        } catch (Exception e) {
            LogUtil.e(f, "isSmartisanPanelMute exception:" + e.getMessage());
            return false;
        }
    }

    private void c() {
        LogUtil.e(f, "handleOpenSCOFail");
        TipTool.onCreateToastDialog(this.b, JarUtils.getResources().getString(R.string.nsdk_string_blue_tooth_open_sco_fail));
    }

    public synchronized boolean a() {
        return this.c;
    }

    public void b() {
        LogUtil.e(f, "unInitAudio");
        this.e.removeMessages(1001);
        this.e.removeMessages(1002);
        this.e.removeMessages(1003);
        com.baidu.navisdk.util.listener.a.b(this.e);
        this.f9223a = null;
        this.b = null;
    }

    public void a(Context context) {
        this.f9223a = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.b = context;
        LogUtil.e(f, "initAudioUtils mAudioManager = " + this.f9223a + ", mContext = " + this.b + ", sIsPhoneUsing = " + h);
        com.baidu.navisdk.util.listener.a.a(this.e);
    }

    public void a(int i2) {
        LogUtil.e(f, "openSCO fromType = " + i2);
        if (this.f9223a == null || this.b == null || h) {
            c();
        }
    }
}
