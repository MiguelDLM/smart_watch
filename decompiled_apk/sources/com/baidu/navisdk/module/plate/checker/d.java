package com.baidu.navisdk.module.plate.checker;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, String> f7389a;

    public d() {
        this.f7389a = null;
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.f7389a = hashMap;
        hashMap.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY), "");
        this.f7389a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST), "");
        this.f7389a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REPLY), "首位应为字母");
        this.f7389a.put(65540, "禁用字母");
        this.f7389a.put(Integer.valueOf(NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY), "");
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST;
        }
        if (str.length() >= 2) {
            char charAt = str.charAt(1);
            if (charAt >= 'A' && charAt <= 'Z') {
                if (charAt == 'I') {
                    return 65540;
                }
            } else {
                return NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REPLY;
            }
        }
        if (str.length() != 7) {
            return NativeProtocol.MESSAGE_GET_INSTALL_DATA_REPLY;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.module.plate.checker.c
    public final f a(String str, String str2, String str3) {
        f fVar = new f();
        fVar.b(str3);
        fVar.a(b(str3));
        fVar.a(this.f7389a.get(Integer.valueOf(fVar.b())));
        return fVar;
    }
}
