package com.baidu.navisdk.util.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.debug.BNDebugUtils;
import com.baidu.nplatform.comjni.engine.JNIEngine;
import com.huawei.openalliance.ad.constant.bn;
import com.jieli.jl_audio_decode.constant.ErrorCode;

/* loaded from: classes8.dex */
public class DebugReceiver extends BroadcastReceiver {
    private boolean a(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtil.d("DebugReceiver", "action=" + action);
        if ("com.baidu.BaiduMap.VMsgDispatcher".equals(action)) {
            String stringExtra = intent.getStringExtra("msgId");
            String stringExtra2 = intent.getStringExtra("arg1");
            String stringExtra3 = intent.getStringExtra("arg2");
            if (a(stringExtra) && a(stringExtra2) && a(stringExtra3)) {
                com.baidu.navisdk.vi.b.a(Integer.valueOf(stringExtra).intValue(), Integer.valueOf(stringExtra2).intValue(), Integer.valueOf(stringExtra3).intValue());
                TipTool.onCreateToastDialog(context, "msgId=" + stringExtra + ", arg1=" + stringExtra2 + ", arg2=" + stringExtra3);
                return;
            }
            return;
        }
        if ("com.baidu.BaiduMap.LogSwitcher".equals(action)) {
            String stringExtra4 = intent.getStringExtra("javaLog");
            if ("true".equals(stringExtra4) || "false".equals(stringExtra4)) {
                LogUtil.setLoggable(Boolean.valueOf(stringExtra4).booleanValue());
                g.b(Boolean.valueOf(stringExtra4).booleanValue());
                BNSettingManager.setShowJavaLog(LogUtil.LOGGABLE);
                if (LogUtil.LOGGABLE) {
                    TipTool.onCreateToastDialog(context, "Java日志开关已打开");
                } else {
                    TipTool.onCreateToastDialog(context, "Java日志开关已关闭");
                }
            }
            String stringExtra5 = intent.getStringExtra("nativeLog");
            if ("true".equals(stringExtra5) || "false".equals(stringExtra5)) {
                boolean booleanValue = Boolean.valueOf(stringExtra5).booleanValue();
                JNIEngine.setOpenLog(booleanValue);
                BNSettingManager.setShowNativeLog(booleanValue);
                if (booleanValue) {
                    TipTool.onCreateToastDialog(context, "Native日志开关已打开");
                    return;
                } else {
                    TipTool.onCreateToastDialog(context, "Native日志开关已关闭");
                    return;
                }
            }
            return;
        }
        if ("com.baidu.BaiduMap.VdrLocation".equals(action)) {
            String stringExtra6 = intent.getStringExtra("command");
            String stringExtra7 = intent.getStringExtra("roadType");
            if ("1".equals(stringExtra6)) {
                if (!com.baidu.navisdk.framework.b.a(com.baidu.navisdk.module.vdr.a.a(Integer.parseInt(stringExtra7)))) {
                    JNIGuidanceControl.getInstance().setStartVDRFailed();
                    return;
                }
                return;
            } else {
                if ("0".equals(stringExtra6)) {
                    com.baidu.navisdk.framework.b.b0();
                    return;
                }
                return;
            }
        }
        if ("com.baidu.BaiduMap.PlayTTS".equals(action)) {
            TTSPlayerControl.playTTS(intent.getStringExtra("speech"), Integer.valueOf(intent.getStringExtra("preempt")).intValue());
            return;
        }
        if ("com.baidu.BaiduMap.EngMode".equals(action)) {
            BNDebugUtils.checkFactoryMode(intent.getStringExtra("type"));
            return;
        }
        if ("com.baidu.BaiduMap.UI".equals(action)) {
            intent.getStringExtra(bn.f.F);
            return;
        }
        if ("com.baidu.BaiduMap.LocationShare".equals(action)) {
            String stringExtra8 = intent.getStringExtra("type");
            com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
            if (j != null) {
                if ("0".equals(stringExtra8)) {
                    j.c();
                    return;
                }
                if ("2".equals(stringExtra8)) {
                    j.m();
                    return;
                }
                if ("7".equals(stringExtra8)) {
                    j.i();
                    return;
                }
                if ("8".equals(stringExtra8)) {
                    j.e();
                    return;
                } else if ("9".equals(stringExtra8)) {
                    j.d();
                    return;
                } else {
                    if ("10".equals(stringExtra8)) {
                        j.b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("com.baidu.BaiduMap.setting".equals(action)) {
            String stringExtra9 = intent.getStringExtra("keyS");
            if (!TextUtils.isEmpty(stringExtra9)) {
                if (intent.hasExtra("valB")) {
                    BNSettingManager.putBoolean(stringExtra9, intent.getBooleanExtra("valB", false));
                }
                if (intent.hasExtra("valS")) {
                    BNSettingManager.putString(stringExtra9, intent.getStringExtra("valS"));
                }
                if (intent.hasExtra("valI")) {
                    BNSettingManager.putInt(stringExtra9, intent.getIntExtra("valI", ErrorCode.ERR_UNKNOWN_EXCEPTION));
                }
                if (intent.hasExtra("valL")) {
                    BNSettingManager.putLong(stringExtra9, intent.getLongExtra("valL", 0L));
                }
                if (intent.hasExtra("valF")) {
                    BNSettingManager.putFloat(stringExtra9, intent.getFloatExtra("valF", 0.0f));
                }
            }
        }
    }
}
