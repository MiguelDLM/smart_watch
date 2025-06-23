package com.baidu.navisdk.lightnavi.asr;

import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a {
    private static a b;

    /* renamed from: a, reason: collision with root package name */
    private EnumC0203a f6869a = EnumC0203a.INVALID;

    /* renamed from: com.baidu.navisdk.lightnavi.asr.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public enum EnumC0203a {
        INVALID,
        PREFER,
        ADD_VIA,
        ETA_QUERY,
        MODIFY_DES,
        DELETE_ALL_VIA
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void a(EnumC0203a enumC0203a) {
        g.ASR.e("XDVoice", "setCalByVoice() curVoiceType is" + enumC0203a);
        this.f6869a = enumC0203a;
    }
}
