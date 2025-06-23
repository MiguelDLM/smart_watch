package com.baidu.tts;

import androidx.core.text.util.LocalePreferences;
import com.sma.smartv3.ui.device.DeviceFileManager;

/* loaded from: classes8.dex */
public enum r2 {
    ZH(LocalePreferences.CalendarType.CHINESE, "ZH"),
    EN("english", DeviceFileManager.f21752xxIXOIIO);


    /* renamed from: a, reason: collision with root package name */
    public final String f10160a;

    r2(String str, String str2) {
        this.f10160a = str2;
    }

    public String a() {
        return this.f10160a;
    }
}
